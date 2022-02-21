<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <fieldset>
            <legend>
                Login
            </legend>
            <form action="/produto-app/controladora?acao=login" method="post">
                <label>Nome</label> <input type="nome" name="nome"/>
                <label>Senha</label> <input type="senha" name="senha"/>
                <button>Cadastrar</button>
            </form>
        </fieldset>
    </body>
</html>