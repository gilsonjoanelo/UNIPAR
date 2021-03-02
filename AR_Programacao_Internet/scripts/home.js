$(document).ready(function(){
	$("#formCadastro").submit(function(e) {
		console.log('trigger form cadastro');
		
		event.preventDefault();
	});
	$("#formLogin").submit(function(e) {
		console.log('trigger form login');
		
		event.preventDefault();
	});
});