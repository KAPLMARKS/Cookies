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
<body>
<#--<h1>Sign In</h1>-->
<#--<form action="/signIn" method="post">-->
<#--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
<#--    <label>-->
<#--        <input name="name" type="text" placeholder="USERNAME">-->
<#--        <input name="password" type="password" placeholder="PASSWORD">-->
<#--        <input type="checkbox" name="remember-me">Rememcer me-->
<#--    </label>-->
<#--    <input type="submit" value="Sign In">-->
<#--</form>-->
<#--</body>-->
<#--</html>-->

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
    .form-signin input[type="name"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
    .h3{
        text-align: center;
    }
</style>

<form class="form-signin" action="/signIn" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <div class="d-flex flex-column pb-3">
        <#--        <img class="img-fluid mx-auto d-block" src="{% static 'logo.png' %}" alt="new cookie logo" width="72" weight=""72>-->
    </div>

    <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>

    <input type="text"  name="name" class="form-control" placeholder="USERNAME" required autofocus>

    <input type="password" name="password" class="form-control" placeholder="Password" required>

    <input type="checkbox" name="remember-me">Remember me


    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>

    <div class="d-flex flex-column">
        <a class="m-auto" href="/signUp">Sign Up</a>
    </div>
</form>

</body>
</html>


