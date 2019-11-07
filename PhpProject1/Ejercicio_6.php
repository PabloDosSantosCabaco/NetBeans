<?php

echo "El número 0 es primo: ".comprobarPrimos(0)."</br>";
echo "El número 1 es primo: ".comprobarPrimos(1)."</br>";
echo "El número 2 es primo: ".comprobarPrimos(2)."</br>";
echo "El número 3 es primo: ".comprobarPrimos(3)."</br>";
echo "El número 7 es primo: ".comprobarPrimos(7)."</br>";
echo "El número 8 es primo: ".comprobarPrimos(8)."</br>";
echo "El número 14 es primo: ".comprobarPrimos(14)."</br>";
echo "El número 17 es primo: ".comprobarPrimos(17)."</br>";
echo "<a href='index.php'><button>Volver</button></a>";
function comprobarPrimos($number){
    if($number<=2){
        return true;
    }else{
        for($i=2; $i<$number; $i++){
            if($number%$i==0){
                return false;
            }
        }
        return true;
    }
}

