<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cookies</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<#--<body>-->
<#--<div class="signUp-page">-->
<#--    <div class="form">-->
<#--        <!--Форма регистрации&ndash;&gt;-->
<#--        <form action="/signUp" method="post" class="form-signUp" id="form-signUp">-->
<#--            <h1 class="h3 mb-3 font-weight-normal">Регистрация cотрудника</h1>-->
<#--            <div class="form-group">-->
<#--                <label>Имя:</label>-->
<#--                <input type="text" name="name" class="form-control" >-->
<#--            </div>-->
<#--            <div class="form-group">-->
<#--                <label>Пароль:</label>-->
<#--                <input type="password" name="password" class="form-control" >-->
<#--            </div>-->
<#--            <div>-->
<#--                <input type="submit" class="btn btn-primary" value="Сохранить">-->
<#--            </div>-->
<#--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
<#--        </form>-->
<#--    </div>-->
<#--</div>-->

<#--<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>-->
<#--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>-->
<#--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>-->
<#--</body>-->

<body>

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
    .text{
        margin-bottom: 10px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: -1px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
    .h3{
        text-align: center;
    }
</style>

<form class="form-signin" action="/signUp" method="post" id="form-signUp">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <div class="d-flex flex-column pb-3">
        <img class="img-fluid mx-auto d-block" src="{% static 'logo.png' %}" alt="new Cookie logo" width="72" weight=""72>
    </div>

    <h1 class="h3 mb-3 font-weight-normal">Sign Up</h1>

<#--    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>-->

    <input type="text" id="inputUsername" name="name" class="form-control" placeholder="Username" required>

    <input type="password" id="inputPassword1" name="password" class="form-control" placeholder="Password" required>

<#--    <input type="password" id="inputPassword2" name="password2" class="form-control" placeholder="Confirm Password" required>-->


    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>

    <div class="d-flex flex-column">
        <a class="m-auto" href="/signIn">Sign In</a>
    </div>

</form>
</html>