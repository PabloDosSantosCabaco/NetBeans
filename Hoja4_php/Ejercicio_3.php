<?php

class TicketMachine{
    //precio de un billete vendido por esta máquina
    private $precio;
    //Cantidad de dinero insertada hasta el momento por el cliente
    private $balance;
    //Cantidad de dinero acumulada por esta máquina
    private $total;

    public function __construct($coste) {
    $this->precio=$coste;
    $this->balance=0;
    $this->total=0;
    }

    //devuelve el precio de un billete
    public function getPrecio(){
        return $this->precio;
    }

    //devuelve la canridad de dinero introducida por el cliente
    public function getBalance(){
        return $this->balance;
    }

    //Recibe una cantidad de dinero. Comprueba que sea lógica
    public function insertaMonedas($monedas){
        if($monedas>=0){
            $this->balance = getBalance()+$monedas;
            if(getBalance()>=getPrecio()){
                imprimeTicket();
                balanceCero();
            }
        }else{
            return false;
        }
    }

    //Imprime el billete si se ha introducido el dinero suficiente y resta el precio del billete del balance actual.
    //Imprime un mensaje de error si hace falta más dinero

    public function imprimeTicket(){
    //Aquí se puede ser creativo con el ticket que se imprime
        
    }

    //resetea el dinero introducido por el cliente
    public function balanceCero(){
        $this->balance = 0;
    }
}