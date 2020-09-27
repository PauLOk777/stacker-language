#!/bin/bash
echo Input file for executing:
read file
java -jar stacker-language.jar $file port
read -p "Press [Enter] to exit from a program ..."