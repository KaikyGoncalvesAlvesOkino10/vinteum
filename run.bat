@echo off
rem ------------------------------------------------------------
rem Simple batch script to build and run the Vinteum (Jogo de 21) project
rem ------------------------------------------------------------

rem If Maven is not in the PATH, try to locate it via the MAVEN_HOME env var
if not defined MAVEN_HOME (
    echo MAVEN_HOME not set. Ensure Maven is installed and added to PATH.
    echo Trying to call "mvn" from current PATH...
    mvn clean javafx:run
) else (
    "%MAVEN_HOME%\bin\mvn.cmd" clean javafx:run
)

pause

