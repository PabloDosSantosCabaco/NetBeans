<?php
echo validarCadena("1rtgerf")."<br>";
echo validarCadena("asdbche")."<br>";
echo validarCadena("ll")."<br>";
echo validarCadena("aaaaaaaaaaaaaaaaaa")."<br>";
function validarCadena($cadena){
    if(strlen($cadena)<6||strlen($cadena)>10){
        return false;
    }
    if(is_numeric(substr($cadena, 0, 1))){
        return false;
    }
    return true;
}
echo "<a href='index.php'><button>Volver</button></a>";