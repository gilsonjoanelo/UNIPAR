echo off
set fontes=%CD%
set htdocs=C:\xampp\htdocs\arfaculdade
set js=C:\xampp\htdocs\arfaculdade\content
set content=C:\xampp\htdocs\arfaculdade\scripts
c:
if not exist %htdocs% md %htdocs%
if not exist %js% md %js%
if not exist %content% md %content%

robocopy %fontes% %htdocs% /E /Z /R:5 /W:5 /TBD /NP /V /XF "%fontes%\debug.bat" /XF "%fontes%\workspace.code-workspace" /XD "%fontes%\.vscode" /XD "%fontes%\node_modules"

:: xcopy /y "%fontes%\node_modules/bootstrap/dist/css/*.min.css" "%content%*" 


del /s /q "%htdocs%\*.json"

exit 0