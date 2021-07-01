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

    <style type="text/css">
        html {
            font-size: 14px;
        }
        @media (min-width: 768px) {
            html {
                font-size: 16px;
            }
        }

        .card-deck .card {
            min-width: 220px;
        }

        .search-bar{
            max-width: 500px;
            width: 100%;
        }
        form{
            width: 100%;
        }
        .footer{
            min-height: 100px;
        }
        .main{
            min-height: 100vh;
            height: 100%;
        }
        @media (max-width: 768px) {
            .right-column{
                margin-left: 0px;
            }
        }

        @media (min-width: 768px) {
            .right-column{
                margin-left: 20px;
            }
        }

        .blog-post-container{
            margin-bottom: 20px;
            width: 100%;
        }
        .create-post-bar{
            background-color: #fff;
            margin-bottom:20px;
        }

        .left-column{
            padding:0px;
        }

        .right-column{
            padding:0px;
        }
        .lead{
            font-size: 17px;
        }
        .card{
            max-width: 700px;
            width: 100%;
        }
        .card-body{
            padding: 20px;
        }
    </style>

    <!-- Header -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal">

            <p class="m-auto">Hello, ${username}</p>

        </h5>

        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="/main">Home</a>
            <a class="p-2 text-dark" href="/account">Account</a>
        </nav>
    </div>

    <!-- End Header -->


</head>
<body>
<#--<div class="main">-->
<#--    <table>-->
<#--        <tr>-->
<#--            <th>id</th>-->
<#--            <th>Product Name</th>-->
<#--        </tr>-->
<#--        <#list products as product>-->
<#--            <tr>-->
<#--                <td>${product.id}</td>-->
<#--                <td>${product.name}</td>-->
<#--                <td>-->
<#--                <form action="/cart/add" method="post">-->
<#--                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
<#--                    <button type="submit" name="add" value="${product.id}">В корзину</button>-->
<#--                </form>-->
<#--                </td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
<#--    <table>-->
<#--        <tr>-->
<#--            <h3>Cart</h3>-->
<#--        </tr>-->
<#--        <#list productsInCart as productInCart>-->
<#--            <tr>-->
<#--                <td>${productInCart.getProductName()}</td>-->

<#--            </tr>-->
<#--        </#list>-->
<#--        <form action="/order" method="get">-->
<#--                    <button class="btn btn-success" >Оформить</button>-->
<#--        </form>-->
<#--    </table>-->
<#--</div>-->
<div class="main">
    <!-- main content -->
    <div class="container">
        <div class="row">

            <!-- blog feed -->
            <div class="left-column col-lg-7 offset-lg-1">


                <!-- Blog posts-->
                <#list products as product>
                <div class="blog-post-container">
                    <div class="container">
                        <div class="row">
                            <!-- Blog Post -->
                            <div class="card m-auto">
                                <img class="card-img-top" src="">
                                <div class="card-body mt-2 mb-2">

                                        <h2 class="card-title">${product.name}</h2>


                                                    <form action="/cart/add" method="post">
                                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                                        <button class="btn btn-primary" type="submit" name="add" value="${product.id}">В корзину</button>
                                                    </form>

                                </div>
                                <div class="card-footer text-muted">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </#list>

                <!-- End Blog posts-->

            </div>
            <!-- end blog feed -->

            <!-- Right 'create post' column  -->

            <div class="right-column col-lg-3 d-lg-flex d-none flex-column">
                <p class="lead">Корзина</p>
                <div class="card create-post-bar d-flex flex-column p-3">
                    <#if productsInCart??>
                    <form action="/order" method="get">

                        <#list productsInCart as productInCart>
                            <tr>
                                <p class="lead"><td>${productInCart.getProductName()}</td></p>
                            </tr>
                        </#list>
                    <p class="m-auto"><button class="btn btn-primary">Оформить</button></p>
                    </form>
                    <#else>
                        <p class="lead" align="center">Empty</p>
                    </#if>
                </div>

            </div>

            <!-- end Right 'create post' column  -->
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


</html>