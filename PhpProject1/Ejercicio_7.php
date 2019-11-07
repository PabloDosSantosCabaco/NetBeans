<?php
echo "Factorial de 5: ".sumatorio(5)."</br>";
echo "Factorial de 2: ".sumatorio(2)."</br>";
echo "Factorial de 8: ".sumatorio(8)."</br>";
echo "Factorial de 15: ".sumatorio(15)."</br>";
function randomNumber(){
    $max = 30;
    $min = 1;
    return rand($min,$max);
}
function sumatorio($number){
    $resul = 0;
    if($number<=0){
        return 0;
    }
    for($i=0; $i<=$number; $i++){
        $resul += $i; 
    }
    return $resul;
}

echo "<a href='index.php'><button>Volver</button></a>";
