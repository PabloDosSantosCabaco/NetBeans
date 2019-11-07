<?php
createPyramid(10);
function createPyramid($base){
    $blanco = " ";
    for($i=0; $i<=$base; $i++){
        for($espacios=$base; $espacios>$i; $espacios--){
            echo "&nbsp";
        }
        for($j=0; $j<$i; $j++){
            echo "*";
        }
        echo "</br>";
    }
}
echo "<a href='index.php'><button>Volver</button></a>";
