@echo off
REM Genera la documentacion Javadoc en la carpeta docs/
javadoc -d docs -sourcepath src -encoding UTF-8 src/Main.java src/modelo/*.java src/excepciones/*.java
echo Documentacion generada en docs/
