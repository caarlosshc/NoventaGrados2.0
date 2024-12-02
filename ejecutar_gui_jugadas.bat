@echo off

REM Crear directorios de salida si no existen
if not exist bin mkdir bin
if not exist doc mkdir doc

REM Ejecutar la GUI
java -cp "bin;lib\noventagrados-gui-lib-2.0.2.jar" noventagrados.gui.NoventaGrados jugadas
pause
