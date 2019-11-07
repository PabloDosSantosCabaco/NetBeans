<?php

class Calentador{
    private $temperatura;
    private $min;
    private $max;
    private $incremento;
    
    public function __construct($min, $max){
        $this->min = $min;
        $this->max = max;
        $this->incremento = 5;
        $this->temperatura = 15;
    }
    public function calentar(){
        if(getTemperatura()<getMax()){
            $this->incremento = 0.5;
            modTemp($incremento);
        }
    }
    public function enfriar(){
        if(getTemperatura()>getMin()){
            $this->incremento = -0.5;
            modTemp($incremento);
        }
    }
    public function modTemp($incremento){
        setTemperatura(getTemperatura()+$incremento);
    }
    public function getMin(){
        return $this->min;
    }
    public function setMin($min){
        $this->min = $min;
    }
    public function getMax(){
        return $this->max;
    }
    public function setMax($max){
        $this->max= $max;
    }
    public function getIncremento(){
        return $this->incremento;
    }
    public function setIncremento($inc){
        $this->inc = $inc;
    }
    public function setTemperatura($temperatura){
        $this->temperatura = $temperatura;
    }
    public function getTemperatura(){
        return $this->temperatura;
    }
}