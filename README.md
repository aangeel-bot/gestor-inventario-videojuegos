# Gestor de Inventario - Tienda de Videojuegos

Aplicacion de consola en Java para gestionar el inventario de una tienda de videojuegos. Permite listar productos, agregar articulos y registrar ventas con control de stock.

## Requisitos

- Java JDK 17 o superior

## Compilacion

```bash
javac -d out -encoding UTF-8 src/excepciones/StockAgotadoException.java src/modelo/*.java src/Main.java
```

## Ejecucion

```bash
java -cp out Main
```

## Documentacion Javadoc

La documentacion HTML se encuentra en la carpeta `docs/`. Para regenerarla:

```bash
generar-javadoc.bat
```

Tambien esta publicada en GitHub Pages:

**https://aangeel-bot.github.io/gestor-inventario-videojuegos/**

(Reemplaza el usuario y nombre del repo si usas otros distintos.)

## Estructura del proyecto

```
src/
  Main.java                 # Menu de consola
  modelo/                   # Clases de dominio
  excepciones/              # Excepciones personalizadas
docs/                       # Javadoc generado
```

## Autor

Angel - Proyecto de Mejora ESPE
