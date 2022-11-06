use FUNDACAQUETA;
select * from actividad;
insert into actividad values(2, "construccion", "construir edificio", "2022-12-12");
create table actividad(
id_actividad int not null primary key,
nombre_actividad varchar(45) not null,
actividad varchar(500) not null,
fecha_activida date not null
);
select * from proyecto;
insert into proyecto values (333, 2022-12-12, 2023-06-06, "bogota", "zonas verdes del futuro",2);
create table proyecto(
id_contracto varchar(20) not null primary key,
fecha_inico date not null,
fecha_finalizacion date not null,
lugar_ejecucion varchar(45) not null,
actividades_proyectadas varchar(500) not null,
actividad_proyecto int not null,
foreign key(actividad_proyecto) references actividad(id_actividad)
);
select * from profesional;

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
select * from proyecto;
select * from profesional;
select identificacion, nombre, apellido, telefono, direccion, email , valor_contrato, duraccion, proyecto.actividades_proyectadas from profesional inner join proyecto on profesional.profesional_proyecto = proyecto.id_contracto;

update profesional set identificacion = '14123',nombre = 'mafe', apellido = 'silva aguas', telefono ='3005007400',direccion = 'calle 123',email = 'lszondas@gmail.com',valor_contrato = '30000',duraccion = '4.0',profesional_proyecto = '333' where identificacion = '14123';


update profesional set identificacion = '14123',nombre = 'mafe', apellido = 'silva aguas', telefono ='3005007400',direccion = 'avenida',email = 'lszondas@gmail.com',valor_contrato = '30000',duraccion = '2.0',profesional_proyecto = '333' where identificacion = '14123'