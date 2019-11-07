<?php
$vector = array(8,13,2,5,10,4566,34,2);
foreach(ordenarVector($vector) as $valor){
    echo $valor."</br>";
}
function ordenarVector($vectorOriginal){
    $max = 0;
    foreach($vectorOriginal as $valor){
        if($valor>=$max){
            $max = $valor;
        }
    }
} 
echo "<a href='index.php'><button>Volver</button></a>";