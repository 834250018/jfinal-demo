@echo off
title sdc-open-8050

setlocal & pushd

set SD_PROP="sd_sign.md"
set MAIN_CLASS=com.ywy.jfinal.DemoConfig

if "%1"=="start" goto normal
if "%1"=="stop" goto normal
if "%1"=="restart" goto normal
if "%1"=="" goto normal
goto error


:error
echo Usage: sd.bat start | stop | restart
goto :eof


:normal
if "%1"=="start" goto start
if "%1"=="stop" goto stop
if "%1"=="restart" goto restart
if "%1"=="" goto start
goto :eof



:start
set APP_BASE_PATH=%~dp0
set CP=%APP_BASE_PATH%config;%APP_BASE_PATH%lib\*
echo starting sds-open
java -Xverify:none %JAVA_OPTS% -cp %CP% %MAIN_CLASS% %SD_PROP%
goto :eof


:stop
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo stopping sds-open
for /f "tokens=1" %%i in ('jps -l ^| find "%MAIN_CLASS%"') do ( taskkill /F /PID %%i )
goto :eof


:restart
call :stop
call :start
goto :eof

endlocal & popd
pause
