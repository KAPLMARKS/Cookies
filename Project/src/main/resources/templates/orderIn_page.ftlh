<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Cookie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Header -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal">

            <p class="m-auto">Cookie</p>

        </h5>

        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="/main">Home</a>
            <a class="p-2 text-dark" href="/account">Account</a>
        </nav>
    </div>

    <style type="text/css">
        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }
        .lead{
            font-size: 17px;
        }
    </style>

    <!-- End Header -->
<body>
<div class="main">
    <div class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Заказ №=${orderInfo.getOrderID()}</h1>

        <table>
            <tr>
                <th>Заказанные Продукты</th>
            </tr>
            <#list orders as order>
                <tr>
                    <p class="lead"><td>${order.getProductName()}</td></p>
                </tr>
            </#list>
        </table>
        <#if role??>
            <p class="lead"><td>Кабинет = ${orderInfo.cabinet}</td></p>
            <form action="/order/decline" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <p class="m-auto"><button class="btn btn-primary" name="orderId" value="${orderInfo.getOrderID()}">Отказать</button></p>
            </form>
            <form action="/order/delivered" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <p class="m-auto"><button class="btn btn-primary" name="orderId" value="${orderInfo.getOrderID()}">Доставлено</button></p>
            </form>
        </#if>
    </div>
</div>
</body>
</html>