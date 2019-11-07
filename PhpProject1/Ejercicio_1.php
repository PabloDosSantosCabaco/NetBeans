<?php

$valor = 5;
$max = 10;
$min = 0;
createTable($valor,$min,$max);
echo "<a href='index.php'><button>Volver</button></a>";
function createTable($valor,$min,$max){
    for($i=$min; $i<$max; $i++){
        $resultado = $i*$valor;
        echo "{$valor} * {$i} = {$resultado}</br>";
    }
}

