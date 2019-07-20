<?php 
	date_default_timezone_set('America/Sao_Paulo');
	
	if (strpos ( $_SERVER ["SERVER_NAME"], 'localhost' ) !== false) {
	    ini_set('display_errors', 1);
	    ini_set('display_startup_errors', 1);
	    error_reporting(E_ALL);
	} else {
	    ini_set('display_errors', 0);
	    ini_set('display_startup_errors', 0);
	    error_reporting(E_ALL & ~E_DEPRECATED & ~E_STRICT);
	}
	ini_set('html_errors', 1);
	ini_set('log_errors', 1);
	ini_set('max_input_time', 60);
	ini_set('output_buffering', 4096);
	ini_set('register_argc_argv', 0);
	ini_set('request_order', "GP");
	ini_set('session.gc_divisor', 1000);
	ini_set('session.sid_bits_per_character', 5);
	ini_set('short_open_tag', 0);
	ini_set('variables_order', "GPCS");
	ini_set('default_charset', 'iso-8859-1');
	
	
	//http://br.phptherightway.com/
	//https://canaltech.com.br/software/Blinde-sua-aplicacao-web-PHP-com-estas-15-dicas-de-seguranca/

	$sessionName=md5('seg' . $_SERVER["REMOTE_ADDR"].$_SERVER["HTTP_USER_AGENT"]);
	session_name($sessionName);

	//tempo definido em minutos
	session_cache_expire(10);

	session_start();

	/*
	$docRoot=$_SERVER["DOCUMENT_ROOT"];
	if (strpos ( $_SERVER ["SERVER_NAME"], 'localhost' ) !== false) {
		$docRoot .= "/AtividadeReflexiva";
	}
	*/
	$BASE_CSS= "../../content";
	$BASE_IMAGES = "../../public/images";
	$BASE_SCRIPTS = "../../scripts";
	$BASE_SHARE = "../shared";
?>