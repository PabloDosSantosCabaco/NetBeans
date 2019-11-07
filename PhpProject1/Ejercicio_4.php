<?php
createPyramid(10);
function createPyramid($base){
    for($i=0; $i<=$base; $i++){
        for($espacios=$base; $espacios>$i; $espacios--){
            echo "&nbsp";
        }
        for($j=0; $j<$i; $j++){
            if($i>2 && $i!=$base){
                if($j==0 || $j==$i-1){         
                    echo "*";
                }else{
                   echo "&nbsp;&nbsp"; 
                }
            }else{
               echo "*";
            }
        }
        echo "</br>";
    }
}
echo "<a href='index.php'><button>Volver</button></a>";
