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

    <!-- End Header -->

    <style type="text/css">
        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: 10px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="username"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
        .h3{
            text-align: center;
        }
        .blog-posts{
            max-width: 500px;
            width: 100%;
            margin: auto;
        }
    </style>

</head>

<body>
<div class="main">
    <#if role??>
    <div class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Profile</h1>
        <p class="form-control">${user.name}</p>
        <p class="form-control">${user.email}</p>
        <p class="form-control">${user.cabinet}</p>
    </div>
    </#if>
    <div class="container mt-4 p-4">
        <div class="row">
            <div class="blog-posts">
                <h3 class="mb-3 font-weight-normal">Orders</h3>
                <#if orders??>
                <ul class="list-group">
                    <#list orders as order>
<#--                    <a href="order/in" name="order" value="${order.getOrderID()}" style="text-decoration: none;"><li class="list-group-item">Заказ №=${order.orderID}, Статус ${order.status}</li></a>-->
                        <form action="/order/in" method="post" >
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <button type="submit" name="order" value="${order.getOrderID()}" style="text-decoration: none;><li class="list-group-item">Заказ №=${order.orderID}, Статус ${order.status}</li></button>
                        </form>
                    </#list>
                </ul>
                <#else>
                <p>Don't have any orders</p>
                </#if>
            </div>
        </div>
    </div>
</div>

    <!-- Footer -->
<br>
<div class="d-flex flex-row align-items-center footer  bg-white border-top shadow-lg">
    <p class="m-auto">~~~~~~~ | 2021</p>
</div>
<!-- End Footer -->


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>