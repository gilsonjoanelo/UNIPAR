<?php
class CurriculoVM {
    public $ID = 0;
    public $Situacao = 0;
    public $Nome="";
    public $Nacionalidade="";
    public $Sexo = "";
    public $Idade=0;
    public $EstadoCivil =0;
    public $TemFilhos="";
    public $Endereco="";
    public $Estado = "";
    public $Cidade="";
    public $Telefone1="";
    public $Telefone2="";
    public $Email="";
    public $Objetivo="";
    
    function loadFromJson($data, $id) {
        $this->ID = $id;
        $this->Nome = $data->Nome;
        $this->Situacao = $data->Situacao;
        $this->Nacionalidade = $data->Nacionalidade;
        $this->Sexo = $data->Sexo;
        $this->Idade= $data->Idade;
        $this->EstadoCivil= $data->EstadoCivil;
        $this->Estado= $data->Estado;
        $this->TemFilhos= $data->TemFilhos;
        $this->Endereco= $data->Endereco;
        $this->Cidade= $data->Cidade;
        $this->Telefone1= $data->Telefone1;
        $this->Telefone2= $data->Telefone2;
        $this->Email= $data->Email;
        $this->Objetivo= $data->Objetivo;
        
        return $this;
    }
}