<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/signUp.css">
    <link rel="stylesheet" href="/css/style.css">
    <title>Hello, world!</title>
</head>
<body>
<div class="signUp-page">
    <div class="form">
        <!--Форма регистрации-->
        <form action="/signUp" method="post" class="form-signUp" id="form-signUp">
            <h1 class="h3 mb-3 font-weight-normal">Регистрация cотрудника</h1>
            <div class="form-group">
                <label>Имя:</label>
                <input type="text" name="name" class="form-control" >
            </div>
            <div class="form-group">
                <label>Пароль:</label>
                <input type="password" name="password" class="form-control" >
            </div>
            <div>
                <input type="submit" class="btn btn-primary" value="Сохранить">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script>
    document.getElementById('role').onclick = function() {
        document.getElementById('choose-role').hidden = true;
        document.getElementById('form-signUp-student').style.display = "block"
    };
</script>
</body>
</html>