<?php
devolverCambio(373);
devolverCambio(23);
devolverCambio(166);
devolverCambio(43);
devolverCambio(6);
function devolverCambio($importe){
    $monedas = [100,50,20,10,5,1];
    $cambio = [0,0,0,0,0,0];
    $cantidad = $importe;
    $contador = 0;
    while($cantidad>0){
        if($cantidad-$monedas[$contador]>=0){
            $cambio[$contador]++;
            $cantidad-=$monedas[$contador];
        }else{
            $contador++;
        }
    }
    echo $importe."</br>El cambio será de:</br>".$cambio[0]." monedas de 1€</br>".$cambio[1]." monedas de 50 cts</br>".$cambio[2]." monedas de 20 cts</br>";
    echo $cambio[3]." monedas de 10 cts</br>".$cambio[4]." monedas de 5 cts</br>".$cambio[5]." monedas de 1 cts</br>";
}

echo "<a href='index.php'><button>Volver</button></a>";