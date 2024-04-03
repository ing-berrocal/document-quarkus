create table empresa(
    id serial not null,
    nit varchar(100) not null,
    razon_social varchar(100) not null,
    correo_electronico varchar(100) not null,
    fecha_registro timestamp without time zone not null,
    CONSTRAINT PK_EMPRESA primary key(id)
);

create table tercero(
    id serial not null,
    tipo_documento varchar(10) not null,
    numero_documento varchar(100) not null,
    apellidos varchar(100) not null,
    nombres varchar(100) not null,
    CONSTRAINT PK_TERCERO primary key(id)
);

create table repositorio_titulo(
	id serial not null,
    empresa_id integer not null,
    codigo varchar(10) not null,
    titulo varchar(100) not null,
    descripcion varchar(100) not null,
    tiene_fecha_vencimiento boolean not null default false,
    fecha_registro timestamp without time zone not null,
    CONSTRAINT PK_REPOSITORIO_TITULO primary key(id),
    constraint FK_EMPRESA_REPO_TITULO foreign key (empresa_id) references empresa(id)
);

create table proceso_ciclo_repositorio_titulo(
	id serial not null,
	proceso_ciclo_id not null,
	repositorio_titulo_id not null,
	fecha_registro timestamp without time zone not null,	
	constraint PK_proceso_ciclo_repositorio_titulo primary key(id)
	--constraint fk_repositorio_titulo_codigo foreign key (repositorio_titulo_codigo) references repositorio_titulo(codigo)
);

create table repositorio(
	id serial not null,
	repositorio_titulo_codigo varchar(10) not null,
	fecha_registro timestamp without time zone not null,
	formato varchar(10) not null,
	fecha_vencimiento date,
	repositorio_titulo_id int not null,
	constraint PK_repositorio primary key(id)
	--constraint fk_repositorio_titulo_codigo foreign key (repositorio_titulo_codigo) references repositorio_titulo(codigo)
);

create table repositorio_data(
	repositorio_id int4 not null,
	fecha_registro timestamp without time zone not null,
	formato varchar(10) not null,
	file_data bytea not null,
	constraint PK_repositorio_data primary key(repositorio_id),
	constraint fk_repositorio_data foreign key (repositorio_id) references repositorio(id)
);

CREATE TABLE public.proceso (
	id serial not null,
	empresa_id integer not null,
	titulo varchar(50) NOT null,
	asigna_tercero boolean not null default false,
	CONSTRAINT pk_proceso PRIMARY KEY (id),
	constraint FK_EMPRESA_proceso foreign key (empresa_id) references empresa(id)
);

create table repositorio_titulo_proceso(
    repositorio_titulo_id integer not null,
    proceso_id integer not null,
    fecha_registro timestamp without time zone not null,
    es_obligatorio boolean not null,
    constraint PK_repositorio_titulo_proceso primary key(repositorio_titulo_id,proceso_id),
	constraint fk_repositorio_titulo_proceso_repositorio_titulo foreign key (repositorio_titulo_id) references repositorio_titulo(id),
	constraint fk_repositorio_titulo_proceso_proceso foreign key (proceso_id) references proceso(id)
);

create or replace view view_repositorio_titulo_proceso as
select rt.empresa_id, rtp.proceso_id, rtp.repositorio_titulo_id , rt.codigo,rt.titulo ,rtp.fecha_registro, rtp.es_obligatorio from public.repositorio_titulo_proceso rtp
join public.repositorio_titulo rt on rt.id = rtp.repositorio_titulo_id 
where rt.empresa_id = 1 --and rtp.proceso_id = 4
;

INSERT INTO tercero(tipo_documento,numero_documento,apellidos,nombres)
VALUES('CC','1067874099','Berrocal Anaya','Daniel Antonio');

drop TABLE public.proceso_ciclo;
CREATE TABLE public.proceso_ciclo (
	id serial not null,	
	proceso_id integer not null,
	fecha_registro timestamp without time zone not null,
	fecha_valido_hasta date,
	esta_terminado boolean not null,
	CONSTRAINT pk_proceso_ciclo PRIMARY KEY (id),
	constraint FK_proceso_ciclo_proceso foreign key (proceso_id) references proceso(id)
);

/*OBSOLETA, se termina debido a que primero se crea el ciclo y despues se asigna el repo*/
drop TABLE public.proceso_repositorio_ciclo;
create table proceso_repositorio_ciclo(
	proceso_ciclo_id integer not null,
    repositorio_id integer not null,
    fecha_registro timestamp without time zone not null,
    constraint PK_proceso_repositorio_ciclo primary key(proceso_ciclo_id,repositorio_id),    
	constraint fk_proceso_repositorio_ciclo_repositorio foreign key (repositorio_id) references repositorio(id),
	constraint fk_fk_proceso_repositorio_ciclo_proceso_ciclo foreign key (proceso_ciclo_id) references proceso_ciclo(id)
);
drop table public.proceso_ciclo_repositorio;
create table public.proceso_ciclo_repositorio(
	id serial not null primary key,
	proceso_ciclo_id int not null,
	repositorio_titulo_id int not null,
	repositorio_id int,
	fecha_registro timestamp without time zone not null default current_timestamp,
	constraint FK_proceso_ciclo_repositorio_proceso_ciclo foreign key (proceso_ciclo_id) references proceso_ciclo(id),
	constraint FK_proceso_ciclo_repositorio_repositorio foreign key (repositorio_titulo_id) references repositorio_titulo(id)
);

CREATE TABLE public.proceso_ciclo_tercero (
	proceso_ciclo_id serial not null,
	fecha_registro timestamp without time zone not null,
	proceso_id integer not null,
	fecha_valido_hasta date without time zone not null,
	CONSTRAINT pk_proceso_ciclo PRIMARY KEY (id),
	constraint FK_proceso_ciclo_proceso foreign key (proceso_id) references proceso(id)
);


CREATE TABLE public.usuario (
	id serial not null,
	fecha_registro timestamp without time zone not null,
	email integer not null,
	usuario_password varchar(200) not null,
	usuario_rol varchar(100) not null,
	empresa_id integer not null,
	CONSTRAINT pk_usuario PRIMARY KEY (id),
	constraint FK_EMPRESA_usuario foreign key (empresa_id) references empresa(id)
);

-- PROCESO CICLOS

create or replace view view_proceso_ciclo as (
select pc.id, p.id as proceso_id, p.empresa_id, p.titulo, pc.fecha_registro, pc.fecha_valido_hasta from public.proceso p
join public.proceso_ciclo pc on pc.proceso_id = p.id
);

-- CICLO REPOSITORIO

drop view view_proceso_ciclo_repositorio;
create or replace view view_proceso_ciclo_repositorio as 
select pcr.id,pcr.proceso_ciclo_id ,pcr.repositorio_titulo_id ,rt.codigo,rt.titulo ,rt.tiene_fecha_vencimiento
,pcr.repositorio_id,r.formato,r.fecha_vencimiento 
from public.proceso_ciclo_repositorio pcr 
join public.repositorio_titulo rt on rt.id = pcr.id 
left join public.repositorio r on r.id = pcr.repositorio_id