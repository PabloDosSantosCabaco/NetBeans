<?php
print("0: ".conversorBinario(0));
echo "</br>";
print("8: ".conversorBinario(8));
echo "</br>";
print("40: ".conversorBinario(40));
echo "</br>";
print("101: ".conversorBinario(101));
echo "</br>";
function conversorBinario($number){
    $binNum = "";
    if($number<1){
        return 0;
    }
    while($number>=1){
        $binNum = $binNum.($number%2);
        $number = $number/2;
    }
    $result = "";
    for($i=0; $i<strlen($binNum); $i++){
        $result = "".$result.$binNum[strlen($binNum)-$i-1];
    }
    return $result;
}
echo "<a href='index.php'><button>Volver</button></a>";