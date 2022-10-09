use FUNDACAQUETA;
create table actividad(
id_actividad int not null primary key,
nombre_actividad varchar(45) not null,
actividad varchar(500) not null,
fecha_activida date not null
);
create table proyecto(
id_contracto varchar(20) not null primary key,
fecha_inico date not null,
fecha_finalizacion date not null,
lugar_ejecucion varchar(45) not null,
actividades_proyectadas varchar(500) not null,
actividad_proyecto int not null,
foreign key(actividad_proyecto) references actividad(id_actividad)
);
create table profesional(
identificacion varchar(16) not null primary key,
nombre varchar(45) not null,
apellido varchar(45) not null,
telefono varchar(16) not null,
direccion varchar(16) not null,
email varchar(45) not null,
valor_contrato int not null,
duraccion double not null,
profesional_proyecto varchar(20) not null,
foreign key(profesional_proyecto) references proyecto(id_contracto)
);
create table usuario(
id_user int not null primary key,
user_name varchar(45) not null,
tipo varchar(45) not null,
profesional_usuario varchar(16) not null,
foreign key(profesional_usuario) references profesional(identificacion)
);