<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Kotlin Journal</title>
    </head>
    <body style="text-align: center; font-family: sans-serif">
    <div>
        <h3>Weather for City</h3>
        <form action="/" method="post">
            <p>
                <label>City:</label><br>
                <label><input type="text" name="city"></label>
            </p>
            <p>
                <label>From:</label><br>
                <label><input type="text" name="from"></label>
            </p>
            <p>
                <label>To:</label><br>
                <label><input type="text" name="to"></label>
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
    <#nested>
    </body>
    </html>
</#macro>
