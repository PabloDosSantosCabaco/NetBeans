<?php

abstract class Vehiculo{
    private $color;
    private $peso;
    CONST SALTO_DE_LINEA = "<br />";
    protected static $numero_cambio_color = 0;
    public function __construct($color,$peso){
        $this->color = $color;
        $this->peso = $peso;
    }
    public function getPeso(){
        return $this->peso;
    }
    public function setPeso($peso){
        if($peso>=2100){
            return;
        }
        $this->peso = $peso;
    }
    public function getColor(){
        return $this->color;
    }
    public function setColor($color){
        $this->color = $color;
        $this->numero_cambio_color++;
    }
    public function circula(){
        echo "El vehículo circula.<br>";
    }
    
    abstract function añadir_persona($peso_persona);

    public function repintar($color){
        setColor($color);
    }
    public static function ver_atributo(){
        
    }
}
class Cuatro_Ruedas extends Vehiculo{
    private $numero_puertas;
   
    public function __construct($color, $peso, $numero_puertas) {
        parent::__construct($color, $peso);
        $this->numero_puertas = $numero_puertas;
    }
    public function repintar($color){
        $this->color = $color;
    }
    public function añadir_persona($peso_persona){
        parent::setPeso(parent::getPeso()+$peso_persona);
    }
}
class Coche extends Cuatro_Ruedas{
    private $numero_cadenas_nieve;
    
    
    public function añadir_cadenas_nieve($num){
        $this->numero_cadenas_nieve++;
    }
    public function quitar_cadenas_nieve($num){
        $this->numero_cadenas_nieve--;
    }
    public function añadir_persona($peso_persona) {
        parent::añadir_persona($peso_persona);
        if($this->getPeso()>=1500 && $this->numero_cadenas_nieve<=2){
            echo  "Atención, ponga 4 cadenas para la nieve.";
        }
    }
}
class Camion extends Cuatro_Ruedas{
    private $longitud;
    
    public function __construct($color, $peso, $longitud) {
        parent::__construct($color, $peso);
        $this->longitud = $longitud;
    }
    public function añadir_remolque($longitud_remolque){
        $this->longitud += $longitud_remolque;
    }
}
class Dos_Ruedas extends Vehiculo{
    private $cilindrada;
   
    public function poner_gasolina($litros){
        parent::setPeso(parent::getPeso()+$litros);
    }
    public function añadir_persona($peso_persona){
        parent::setPeso(parent::getPeso()+$peso_persona+2);
    }
}