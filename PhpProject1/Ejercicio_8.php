<?php
$nombres =["ana","berto","carlos","claudia"];
$letra = "c";
echo buscarNombres($nombres, $letra)."<br>";
echo buscarNombres($nombres, "a")."<br>";
echo buscarNombres($nombres, "b")."<br>";
function buscarNombres($lista,$letra){
    $contador = 0;
    foreach ($lista as $nombre) {
        if(substr($nombre, 0, 1)==$letra){
            $contador++;
        }
    }
    return $contador;
}
echo "<a href='index.php'><button>Volver</button></a>";