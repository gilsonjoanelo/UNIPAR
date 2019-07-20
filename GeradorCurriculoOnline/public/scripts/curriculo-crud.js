$("#formCadastro").validate({
	debug: true,
	rules:{
		Situacao: {
			required: true
		},
		Nome: {
			required: true
		},
		Sexo: {
			required: true
		},
		Idade: {
			required: true,
			digits: true
		},
		EstadoCivil: {
			required: true
		},
		TemFilhos: {
			required: true
		},
		Endereco: {
			required: true
		},
		Cidade: {
			required: true
		},
		Estado: {
			required: true
		},
		Email: {
			required: true,
			email: true
		}
	}
});

$( "#adicionarOutroCursoClick" ).click(function(e) {
	e.preventDefault();
	adicionarFormacaoAcademica();
});

$( "#adicionarExprienciaClick" ).click(function(e) {
	e.preventDefault();
	adicionarExpriencia();
});

$( "#adicionarQualificacaoClick" ).click(function(e) {
	e.preventDefault();
	adicionarQualificacao();
});

$( "#adicionarInfoAddClick" ).click(function(e) {
	e.preventDefault();
	adicionarInfoAdd();
});

$("#impressao").click(function(){
	window.print();
});

$('form[name="formCadastro"').submit(function(e) {
	 e.preventDefault();

	if(!$("#impressao").hasClass("buttonImprimir")) {
	 	$("#impressao").addClass("buttonImprimir");
	}
	 
	 if ($(this).valid()){
		 var formData = $(this).serializeObject();
		 
		 $.ajax({
			  url: "../../../controllers/curriculoController.php?acao=SAVE",
			  type: 'POST',
			  dataType: "json",
			  data: JSON.stringify(formData)
			}).done(function(res) {
				console.log(res);
				if(res.Sucesso === true) {
					alert(res.Mensagem);
					window.location = "index.php";
				} else {
					var mensagem = res.Mensagem;
					if(!mensagem || mensagem === "") {
						mensagem = "Falha na tentativa de salvar os dados.";
					}
					alert(mensagem);
				}
			}).fail(function(error) {
				alert("Falha na tentativa de gerar o curriculo");
			});
	 } else {
		 alert("Alguns campos nao foram preenchidos, verifique");
	 }
});

$(document).ready(function(){

	var id = 0;
	if($.urlParam("id")) {
		id= $.urlParam("id");
	}
	
	$('input[name="ID"]').val(id);
	
	$.ajax({
		  url: "../../../controllers/curriculoController.php",
		  type: 'GET',
		  dataType: "json",
		  data: { "acao" : "GET", "id" : id }
		}).done(function(res) {
			if(res.Sucesso === true) {
				if(res.Dados.length){
					var data = res.Dados[0];

					if(!data.FormacaoID || data.FormacaoID === "") {
						adicionarFormacaoAcademica();
					} else {
						var id = parseInt(data.FormacaoID);
						for(var i = 0; i <= id; i++){
							adicionarFormacaoAcademica();	
						}
					}

					if(!data.ExperienciaID || data.ExperienciaID === "") {
						adicionarExpriencia();
					} else {
						var id = parseInt(data.ExperienciaID);
						for(var i = 0; i <= id; i++){
							adicionarExpriencia();	
						}
					}

					if(!data.QualificacaoID || data.QualificacaoID === "") {
						adicionarQualificacao();
					} else {
						var id = parseInt(data.QualificacaoID);
						for(var i = 0; i <= id; i++){
							adicionarQualificacao();	
						}
					}

					if(!data.InfoAddID || data.InfoAddID === "") {
						adicionarInfoAdd();
					} else {
						var id = parseInt(data.InfoAddID);
						for(var i = 0; i <= id; i++){
							adicionarInfoAdd();	
						}
					}

					$.each(data, function(k, v) {
						var id = '#' + k;
						$(id).val(v);
					});

					if(data.Nome !== undefined && data.Nome !== "") {
						$("#impressao").removeClass("buttonImprimir");
					}
				} else {
					adicionarFormacaoAcademica();
					adicionarExpriencia();
					adicionarQualificacao();
					adicionarInfoAdd();
				}
			} else {
				var mensagem = res.Mensagem;
				if(!mensagem || mensagem === "") {
					mensagem = "Falha na tentativa de obter os curr&iacute;culos cadastrados.";
				}
				alert(mensagem);
			}
		}).fail(function(error) {
			alert("Falha na tentativa de retornar os dados.");
		});
});

var formacaoIndex=-1;
function adicionarFormacaoAcademica() {
	formacaoIndex++;

	$('input[name="FormacaoID"]').val(formacaoIndex);

	var item=
		"<div class='row'>" +
		"	<div class='col-12'>" +
		"		<label>Curso</label>"	+
		"		<input type='text' id='Curso_"+formacaoIndex+"' name='Curso_"+formacaoIndex+"' class='form-control' placeholder='Informe o nome do curso' />"+
		"	</div>" +
		"</div>"+
		"<div class='row'>" +
		"	<div class='col-6'>" +
		"		<label>Institui&ccedil;&atilde;o</label>"	+
		"		<input type='text' id='Instituicao_"+formacaoIndex+"' name='Instituicao_"+formacaoIndex+"' class='form-control' placeholder='Informe o nome da institui&ccedil;&atilde;o' />"+
		"	</div>" +
		"	<div class='col-3' style='width: 22.33333333%'>" +
		"		<label>Ano Conclus&atilde;o</label>"	+
		"		<select id='ConcluidoEm_"+formacaoIndex+"' name='ConcluidoEm_"+formacaoIndex+"' class='form-control'>"+
		"			<option value=''>-- Selecione --</option>"+
		"			<option value='S'>Conclu&iacute;do Em</option>"+
		"			<option value='N'>Previs&atilde;o de Conclus&atilde;o</option>"+
		"		</select>"+
		"	</div>" +
		"	<div class='col-3' style='width: 22.33333333%'>" +
		"		<label>&nbsp;</label>"	+
		"		<input type='text' id='AnoConclusao_"+formacaoIndex+"' name='AnoConclusao_"+formacaoIndex+"' class='form-control' placeholder='Informe o ano de conclus&atilde;o' />"+
		"	</div>" +
		"</div>";
		$("#formacaoAcademicaItems").append(item);
};

var experienciaIndex=-1;
function adicionarExpriencia() {
	experienciaIndex++;

	$('input[name="ExperienciaID"]').val(experienciaIndex);

	var item = 
		"<div class='row'>" +
		"	<div class='col-6'>" +
		"		<label>Empresa</label>"	+
		"		<input type='text' id='Empresa_"+experienciaIndex+"' name='Empresa_"+experienciaIndex+"' class='form-control' placeholder='Informe o nome da empresa' />"+
		"	</div>" +
		"	<div class='col-6'>" +
		"		<label>Cargo</label>"	+
		"		<input type='text' id='Cargo_"+experienciaIndex+"' name='Cargo_"+experienciaIndex+"' class='form-control' placeholder='Informe o nome do cargo' />"+
		"	</div>" +
		"</div>"+
		"<div class='row'>" +
		"	<div class='col-6'>" +
		"		<label>Ano de Entrada</label>"	+
		"		<input type='text' id='AnoEntrada_"+experienciaIndex+"' name='AnoEntrada_"+experienciaIndex+"' class='form-control' placeholder='Informe o ano de entrada' />"+
		"	</div>" +
		"	<div class='col-6'>" +
		"		<label>Ano de Sa&iacute;da</label>"	+
		"		<input type='text' id='AnoSaida_"+experienciaIndex+"' name='AnoSaida_"+experienciaIndex+"' class='form-control' placeholder='Informe o ano de sa&iacute;da' />"+
		"	</div>" +
		"</div>" +
		"<div class='row'>" +
		"	<div class='col-12'>" +
		"		<label>Principais Atividades</label>"	+
		"		<textarea id='Atividades_"+experienciaIndex+"' name='Atividades_"+experienciaIndex+"' class='form-control' placeholder='Informe suas atividades'></textarea>"+
		"	</div>" +
		"</div>";

	$("#experiencia").append(item);
};

var qualificacaoIndex=-1;
function adicionarQualificacao() {
	qualificacaoIndex++;

	$('input[name="QualificacaoID"]').val(qualificacaoIndex);

	var item = 
		"<div class='row'>" +
		"	<div class='col-12'>" +
		"		<input type='text' class='form-control' id='AtividadeComplementar_"+ qualificacaoIndex+"' name='AtividadeComplementar_"+
					qualificacaoIndex+"' placeholder='Informe suas atividades complementares' />"+
		"	</div>" +
		"</div>";

	$("#qualificacoes").append(item);
};

var infoAddIndex=-1;
function adicionarInfoAdd() {
	infoAddIndex++;

	$('input[name="InfoAddID"]').val(infoAddIndex);

	var item = 
		"<div class='row'>" +
		"	<div class='col-12'>" +
		"		<input type='text' class='form-control' id='InfoAdd_"+infoAddIndex+
					"' name='InfoAdd_"+infoAddIndex+
					"' placeholder='Informe as outras atividades' />"+
		"	</div>" +
		"</div>";

	$("#infoAdd").append(item);
};