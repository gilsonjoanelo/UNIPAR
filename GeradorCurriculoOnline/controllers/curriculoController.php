<?php
require_once '../base.php';
include_once '../models/curriculoVM.php';

$idSessaoDB="DADOS_DB3";
if($_GET["acao"]=== "GET") {
    
    $listaTemp = array();
    if(isset($_SESSION[$idSessaoDB])) {
        $listaTemp = $_SESSION[$idSessaoDB];
    }
    
    $retorno=array(
        "Sucesso" => true,
        "Mensagem" => "",
        "Dados" => $listaTemp
    );
    
    http_response_code(200);
    header('Content-Type: application/json');
    echo json_encode($retorno);
} else if($_GET["acao"]=== "SAVE") {
    $rawData = file_get_contents('php://input');
    $data = json_decode($rawData);
    
    $dados = new CurriculoVM();
    
    $dadosArray = array();    
    $dados = $dados->loadFromJson($data, 1);
    $json = json_encode($dados);
    array_push($dadosArray, $data);
    $_SESSION[$idSessaoDB] = $dadosArray;
    
    $retorno=array(
        "Sucesso" => true,
        "Mensagem" => "Dados persistidos com sucesso."
    );
    
    http_response_code(200);
    header('Content-Type: application/json');
    echo json_encode($retorno);
} else {
    http_response_code(403);
}