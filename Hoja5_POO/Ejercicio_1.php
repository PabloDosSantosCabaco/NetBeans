<?php

class Vehiculo{
    private $color;
    private $peso;
    
    public function __construct($color,$peso){
        $this->color = $color;
        $this->peso = $peso;
    }
    public function circula(){
        echo "El vehículo circula.<br>";
    }
    
    public function añadir_persona($peso_persona){
        $this->peso += $peso_persona;
    }
}
class Cuatro_Ruedas extends Vehiculo{
    private $numero_puertas;
   
    public function repintar($color){
        
    }
}
class Coche extends Cuatro_Ruedas{
    private $numero_cadenas_nieve;
    
    public function añadir_cadenas_nieve($num){
    
    }
    public function quitar_cadenas_nieve($num){
        
    }
}
class Camion extends Cuatro_Ruedas{
    private $longitud;
    
    public function añadir_remolque($longitud_remolque){
        
    }
}
class Dos_Ruedas extends Vehiculo{
    private $cilindrada;
   
    public function poner_gasolina($litros){
        
    }
}