import webbrowser
import cgitb
cgitb.enable()

f = open('newpage.html','w')

message = '''<!DOCTYPE html>
        <html>
        <head>
        <meta charset = utf-8">
        <link rel= "stylesheet"
            type = "text/css"
            href = "finalmystyle.css">
        <title> Sign Up for PoliFix</title>
        </head>
        <body>
        You got:<br>

<p> xd </p>

  </body>
        </html>
'''
f.write(message)
f.close()


webbrowser.open_new_tab("newpage.html")
