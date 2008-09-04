@echo off
echo "recursively removing .svn folders from"
for /f “tokens=* delims=” %%i in (‘dir /s /b /a:d *svn’) do (
  rd /s /q “%%i”
)
pause