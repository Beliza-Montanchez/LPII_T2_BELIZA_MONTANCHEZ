
CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO clientes (nombre, email) VALUES 
('Carlos Pérez', 'carlos.perez@example.com'),
('Ana López', 'ana.lopez@example.com'),
('Luis Torres', 'luis.torres@example.com');

-- Tabla: peliculas
CREATE TABLE IF NOT EXISTS peliculas (
    id_pelicula INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    stock INT NOT NULL
);

INSERT INTO peliculas (titulo, genero, stock) VALUES 
('Inception', 'Ciencia Ficción', 10),
('Titanic', 'Romance', 5),
('Avengers: Endgame', 'Acción', 7);

-- Tabla: alquileres
CREATE TABLE IF NOT EXISTS alquileres (
    id_alquiler INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    id_cliente INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    CONSTRAINT fk_alquiler_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla: detalle_alquiler
CREATE TABLE IF NOT EXISTS detalle_alquiler (
    id_alquiler INT NOT NULL,
    id_pelicula INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (id_alquiler, id_pelicula),
    CONSTRAINT fk_detalle_alquiler FOREIGN KEY (id_alquiler) REFERENCES alquileres(id_alquiler),
    CONSTRAINT fk_detalle_pelicula FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula)
);
