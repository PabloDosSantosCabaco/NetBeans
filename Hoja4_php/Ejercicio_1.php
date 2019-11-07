<?php
$libreria[];
class Libro{
    private $autor;
    private $titulo;
    private $paginas;
    private $refLibro;
    private $prestado;
    private $contieneCD;
    
    public function __construct($autor, $titulo, $prestado, $cd){
        $this->autor = $autor;
        $this->titulo = $titulo;
        $this->refLibro = "";     
        $this->setRefLibro(strlen($libreria)+1);
        $this->prestado = 0;
    }
    
    public function getAutor(){
        return $this->autor;
    }
    public function getCD(){
        if(contieneCD){
            return true;
        }else{
            return false;
        }
    }
    public function getTitulo(){
        return $this->titulo;
    }
    public function getPaginas(){
        return $this->paginas;
    }
    public function getRefLibro(){
        return $this->refLibro;
    }
    public function getPrestado(){
        return $this->prestado;
    }
    public function setPrestado(){
        $this->prestado++;
    }
    public function setRefLibro($cadena){
        if(strlen(trim($cadena))>3){
           $this->refLibro = $cadena; 
        }else{
            echo "ERROR. Esta referencia no es válida.<br>";
        }
    }
    public function printAutor(){
        echo "Autor: ".getAutor()."<br>";
    }
    public function printTitulo(){
        echo "Titulo: ".getTitulo()."<br>";
    }
    public function printLibro(){
        $this->printAutor();
        $this->printTitulo();
        if(strlen($this->getRefLibro())>0){
            echo "Nº veces prestado: ".$this->getRefLibro()."<br>";
        }
    }
    
}