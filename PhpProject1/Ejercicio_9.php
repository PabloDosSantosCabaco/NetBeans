<?php
$nombres =["ana","berto","carlos","claudia"];
$letra = "c";
$nombresConC = buscarNombres($nombres,$letra);
foreach($nombresConC as $nombre){
    echo $nombre."</br>";
}
function buscarNombres($lista,$letra){
    $nuevaLista = array();
    foreach ($lista as $nombre) {
        if(substr($nombre, 0, 1)==$letra){
            array_push($nuevaLista,$nombre);
        }
    }
    return $nuevaLista;
}
echo "<a href='index.php'><button>Volver</button></a>";