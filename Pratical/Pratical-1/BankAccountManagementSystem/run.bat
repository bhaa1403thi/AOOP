@echo off
cd /d "%~dp0"
if not exist out mkdir out
echo Compiling Java files...
javac -d out src\*.java
if errorlevel 1 (
    echo.
    echo Compilation failed. Check the error messages above.
    pause
    exit /b 1
)
echo.
echo Running Bank Account Management System...
java -cp out Main
echo.
pause
