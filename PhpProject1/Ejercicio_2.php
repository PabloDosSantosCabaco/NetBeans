<?php
writeCube(5);
writeCube(3);
writeCube(5);
function writeCube($range){
    for($i=0; $i<$range; $i++){
        for($j=0; $j<$range; $j++){
            echo "* ";
        }
        echo "</br>";
    }
}
echo "<a href='index.php'><button>Volver</button></a>";
