@echo off
title M4 INFORENSE
color 3
:inicio
cls
echo *************************************************************
echo                          MENU
echo                    1. Comprovar la versió del sistema operatiu
echo                    2. Començar analisis forense
echo                    3. Sortir
echo *************************************************************
set /p menu=Escull una opció del menu=
if "%menu%"=="1" goto op1
if "%menu%"=="2" goto op2
if "%menu%"=="3" goto op3
:op1
    systeminfo | findstr /C:"Nombre del sistema operativo"
    echo prem qualsevol tecla per continuar...
    pause>nul
    goto inicio
:op2
    :iniciDirectori
    set /p lloc=on vols guardar els resultats?=
    if not exist %lloc% (
      echo prova amb un directori existent
      goto iniciDirectori
    )
    cd %lloc%
   set mydate=%DATE%
   set mytime=%TIME%
   echo data inici del informe %mydate% %mytime%>>%lloc%\datarecollida.txt
   :inicioForense
   echo *************************************************************
   echo                          MENU FORENSE
   echo                    1. Recollir dades de la xarxa
   echo                    2. Programes instalats
   echo                    3. Informació del sistema
   echo                    4. Usuaris del sistema
   echo                    5. Llistar processos
   echo                    6. Guardar historial web
   echo                    7. Tornar enrere
   echo                    8. Sortir
   echo *************************************************************
   set /p menu=Escull una opció del menu=
   if "%menu%"=="1" goto forense1
   if "%menu%"=="2" goto forense2
   if "%menu%"=="3" goto forense3
   if "%menu%"=="4" goto forense4
   if "%menu%"=="5" goto forense5
   if "%menu%"=="6" goto forense6
   if "%menu%"=="7" goto inicio ::permet a l'usuari tornar a l'anterior menu
   if "%menu%"=="8" goto op3
   :forense1
      ipconfig /all>%lloc%\infored.txt
      netsh wlan show all>>%lloc%\infored.txt ::informacio sobre l'adaptador wifi i les xarxes WLAN
      cls
      goto inicioForense
   :forense2
      wmic /output:%lloc%\programes.txt product get name, version
      cls
      goto inicioForense
   :forense3
      systeminfo>%lloc%\infosistema.txt
      cls
      goto inicioForense
   :forense4
      net user>%lloc%\usuarisistema.txt
      cls
      goto inicioForense
   :forense5
      tasklist>%lloc%\procesos.txt
      cls
      goto inicioForense
   :forense6
      ipconfig /displaydns>%lloc%\historialweb.txt
      cls
      goto inicioForense
:op3
    set mydate=%DATE%
    set mytime=%TIME%
    echo data finalització del informe %mydate% %mytime%>>%lloc%\datarecollida.txt
    cls
    exit

