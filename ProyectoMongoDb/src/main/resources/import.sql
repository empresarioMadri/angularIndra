INSERT INTO comerciales (id,dni)VALUES (1,'1234');

INSERT INTO ventas (id,descripcion) VALUES (1,'venta de un seat');

INSERT INTO coches (id,color,marca,venta_id) VALUES (1,'rojo','seat',1);
INSERT INTO coches (id,color,marca) VALUES (3,'azul','mercedes');

INSERT INTO indraspringboot.venta_comercial (comercial_id,venta_id,fecha)VALUES (1,1,'2021-11-17');