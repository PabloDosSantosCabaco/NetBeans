<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form action="Ejercicio2.php" method="post">
            <p>Rellena el siguiente formulario</p>
            <p>Nombre:<input type="text" name="nombre"/></p>
            <p>Email:<input type="text" name="correo"/></p>
            <p>Contraseña:<input type="password" name="password"/></p>
            <p>Repetir contraseña:<input type="password" name="password2"/></p>
            <button name="submit">Enviar</button>
        </form>
        <a href="index.php"><button>Volver</button></a>
        <?php
        $completo = true;
        $correoValido = false;
        if(!empty($_POST['nombre'])&&!empty($_POST['correo'])&&!empty($_POST['password'])&&!empty($_POST['password2'])){
            for($i=0; $i<strlen($_POST['correo']); $i++){
                if($_POST['correo'][$i]=='@'){
                    $correoValido = true;
                }
            }
            if(!$correoValido){
                echo "El correo electrónico debe contener un @<br>";
            }
            $completo = $correoValido;
            if(strlen($_POST['password'])<3||strlen($_POST['password'])>6||$_POST['password']!=$_POST['password2']){
                echo "Las contraseñas deben ser iguales y tener una longitud de entre 3 y 6 caracteres<br>";
                $completo = false;
            }
        }else{
            $completo = false;
        }
        if($completo){
            echo "Resgitro realizado correctamente para el correo ".$_POST['correo'];
        }
        ?>
    </body>
</html>
<?php