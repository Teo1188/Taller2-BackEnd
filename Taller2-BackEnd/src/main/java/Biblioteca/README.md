## EJERCICIO #2

### Sistema de Gestion de Biblioteca

Por: Tadeo Gaviria
Este es un ejercicio de Java enfocado a explorar las funcionalidades del modulo 2 y 3 y con el desarrollamos un sistema de gestión de una biblioteca en Java conectándolo a una librería en Mysql workbench.
En este ejercicio podras, crear, eliminar, modificar y listar tanto usuarios como libros.

## Tecnologías utilizadas

- **Java**: Lenguaje principal.
- **MySQL**: Base de datos relacional para almacenar la información de libros y usuarios.
- **JDBC**: Para la conexión y manejo de la base de datos.
- **IntelliJ IDEA**: IDE usado para el desarrollo.

## Funcionamiento

1. La carpeta principal contenedora del proyecto es llamada Biblioteca.
2. la primer sub-carpeta es llamada **Conexion** aqui se encuentran 2 Clases llamadas **DatabaseConfig** y **DatabaseConnection.**
    en databaseConfig se configuran los parametros que establecen la conexion a la base de datos por medio del JDBC, definiendo el nombre
    de la BD el usuario administrador su ruta y su contraseña. La carpeta DatabaseConection establece la conexion.
3. la segunda sub-carpeta es llamada **Data** esta carpeta tiene como objetivo contener cada modelo de uso en la base de datos.

**_Bibliotecario:_** Clase donde se define Bibliotecario con cada uno de sus valores y tiene herencia de la clase persona.

**_Libro:_** Clase donde se define Libro y cada uno de sus items getters y setters.

**_Persona:_** Clase con superHerencia, define los valores de id, nombre, apellido y tipo.

**_Prestamo:_** Clase que define los prestamos realizados de los libros en la base de datos.

**_Usuario:_** Clase que define sus campos getters and setters.

4. la tercera sub-carpeta es llamada **Transactions** en ella encontraremos los archivos de servicios que realiza la biblioteca, en este caso
    **LibreriaServicio** que se encarga de realizar el CRUD relacionado a la parte de libros y la clase **UsuarioServicio**
    la cual se encarga de realizar el CRUD y manejo de los usuarios.
5. la clase principal Main, en ella podremos encontrar la importacion de bibliotecas y la conexion con la base de datos, a su vez tambien encontraremos
    la creacion de instancias de los servicios y las pruebas de cada uno de los metodos CRUD.


### Indicaciones para crear la base de datos en MySQL WorkBench

```bash
-- Crear la base de datos

CREATE DATABASE jdbc_taller2;
USE jdbc_taller2;


-- Crear el usuario y brindarle los permisos sobre la base de datos


CREATE USER 'aduser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON jdbc_taller2.* TO 'aduser'@'localhost';
FLUSH PRIVILEGES;

-- Consultas

SELECT * from bibliotecario;
SELECT * from libro;
SELECT * from persona;
SELECT * from prestamo;
SELECT * from usuario;
SELECT user, host FROM mysql.user WHERE user = 'aduser';
SHOW DATABASES LIKE 'jdbc_taller2';
SHOW TABLES;

  -- Crear Tablas

CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(100),
	apellido VARCHAR(100),
    email VARCHAR(100),
    telefono int,
    CONSTRAINT fk_persona_usuario FOREIGN KEY (id) REFERENCES Persona(id)
);

-- Crear tabla Persona

                CREATE TABLE Persona (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nombre VARCHAR(100),
                    apellido VARCHAR(100),
                    tipo VARCHAR(50)
                );


-- Crear tabla Bibliotecario

                CREATE TABLE Bibliotecario (
                    id_bibliotecario INT PRIMARY KEY,
                    CONSTRAINT fk_persona_bibliotecario FOREIGN KEY (id_bibliotecario) REFERENCES Persona(id)
                );

-- Crear tabla Libro

                CREATE TABLE Libro (
                    id_libro INT PRIMARY KEY AUTO_INCREMENT,
                    titulo VARCHAR(200),
                    autor VARCHAR(100),
                    isbn VARCHAR(20),
                    disponible BOOLEAN
                );

-- Crear tabla Prestamo

                CREATE TABLE Prestamo (
                    id_prestamo INT PRIMARY KEY AUTO_INCREMENT,
                    libro_id INT,
                    usuario_id INT,
                    fecha_prestamo DATE,
                    fecha_devolucion DATE,
                    CONSTRAINT fk_libro_prestamo FOREIGN KEY (libro_id) REFERENCES Libro(id_libro),
                    CONSTRAINT fk_usuario_prestamo FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
                );
                
   -- Insertar datos en las tablas: Libro, Usuario, Bibliotecario.

INSERT INTO Libro (titulo, autor, isbn, disponible) VALUES 
('La Metamorfosis', 'Franz Kafka', '111-3-16-148410-0', true),
('Demian', 'Herman Hesse', '331-3-16-148410-1', true),
('La Trilogia de New York', 'Paul Auster', '978-3-16-378410-2', true),
('Harry Potter y el Cáliz de Fuego', 'J. K. Rowling', '972-3-16-148410-3', true),
('Tokio Blues', 'Haruki Murakami', '444-3-16-148410-4', true);

INSERT INTO Usuario (nombre, apellido, email, telefono) VALUES 
('Cristian', 'Londono', 'cris.londono@example.com', '1234567890'),
('María', 'Teresa', 'maria.tere@example.com', '1234567891'),
('Andre', 'Gaviria', 'andre.gaviria@example.com', '1234567892'),
('Ana', 'Palacio', 'ana.palacio@example.com', '1234567893'),
('Teo', 'Gaviria', 'teo.gaviria@example.com', '1234567894');

INSERT INTO Bibliotecario (nombre, apellido, email, telefono, puesto) VALUES 
('Adriana', 'Florez', 'adri.florez@example.com', '9876543210', 'Jefe de Biblioteca'),
('Daniela', 'Mira', 'dani.mira@example.com', '9876543211', 'Asistente de Biblioteca'),
('Luisa', 'Sierra', 'luisa.sierra@example.com', '9876543212', 'Coordinador de Servicios'),
('Jorge', 'Mendoza', 'jorge.mendoza@example.com', '9876543213', 'Encargado de Catálogo'),
('Helena', 'Celeste', 'helena.celeste@example.com', '9876543214', 'Auxiliar de Biblioteca');
```

### Ultimo paso

El ultimo paso para ejecutar el ejercicio seria darle clic derecho a la clase principal **Main** y seleccionar Run 'Main.main()' para ejecutar.


Muchas gracias cualquier retroalimentacion estaré agradecido.

**_Teo Gaviria_**