<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form action="" method="post">
            <p>Número de unidades <input name="unidades" type="text"/></p>
            <p>precio unidad <input name="precio" type="text"/></p>
            <p>Tipo de IVA aplicable: 10%<input name="iva" type="radio" value="0.1" checked="checked"/>
                15%<input name="iva" type="radio" value="0.15"/>
                20%<input name="iva" type="radio" value="0.2"/>
                <button name="calcular">Calcular</button></p>
        </form>
        <a href="index.php"><button>Volver</button></a>
        <?php
            if(!empty($_POST['unidades'])&&!empty($_POST['precio'])){
                $coste = $_POST['unidades']*$_POST['precio']*$_POST['iva'];
                echo "El coste total es de ".$coste;
            }
        ?>
    </body>
</html>
<?php