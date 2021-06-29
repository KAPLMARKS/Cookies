<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cookies</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>Product Name</th>
        </tr>
        <#list products as product>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>