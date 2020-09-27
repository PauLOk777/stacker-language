@echo off
echo Input file for executing:
set /p file=
java -jar stacker-language.jar %file% port
pause