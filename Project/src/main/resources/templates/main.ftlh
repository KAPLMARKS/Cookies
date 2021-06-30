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
                <td>
                <form action="/cart/add" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button type="submit" name="add" value="${product.id}">В корзину</button>
                </form>
                </td>
            </tr>
        </#list>
    </table>
    <table>
        <tr>
            <h3>Cart</h3>
        </tr>
        <#list productsInCart as productInCart>
            <tr>
                <td>${productInCart.getProductName()}</td>
<#--                <td>-->
<#--                    <form action="/cart/add" method="post">-->
<#--                        <button type="submit" name="add" value="${product.id}">В корзину</button>-->
<#--                    </form>-->
<#--                </td>-->
            </tr>
        </#list>
    </table>
</div>
</body>
</html>