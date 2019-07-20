<?php
require_once '../../../base.php';
include_once("$BASE_SHARE/topo.php");
?>
<form id="formCadastro" name="formCadastro" class="form-horizontal" role="form">
<div class="row">
	<div class="col-12">
		<input type="hidden" id="ID" name="ID"/>
		<input type="hidden" id="FormacaoID" name="FormacaoID"/>
		<input type="hidden" id="ExperienciaID" name="ExperienciaID"/>
		<input type="hidden" id="QualificacaoID" name="QualificacaoID"/>
		<input type="hidden" id="InfoAddID" name="InfoAddID"/>
		<h1>Gerador de Curr�culo Online</h1>
		<p>
			<strong>Aten��o:</strong> Todos os campos em vermelho, devem obrigatoriamente preenchidos.
		</p>
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Qual � a sua situa��o atual?</label>
		<select id="Situacao" name="Situacao" class="form-control" required="required">
			<option value="">-- Selecione --</option>
			<option value="1">Primeiro emprego</option>
			<option value="2">Desempregado</option>
			<option value="3">Empregado, cumprindo aviso</option>
			<option value="4">Empregado, mudar de emprego</option>
			<option value="5">Procurando est&aacute;gio</option>
		</select>
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Dados Cadastrais</label>
	</div>
</div>
<div class="row">
	<div class="col-6">
		<label>Nome</label>
		<input type="text" id="Nome" name="Nome" class="form-control" placeholder="Informe seu nome" required="required"/>
	</div>
	<div class="col-6">
		<label>Nacionalidade</label>
		<input type="text" id="Nacionalidade" name="Nacionalidade" class="form-control" placeholder="Informe sua nacionalidade" />
	</div>
</div>	
<div class="row">
	<div class="col-4">
		<label>Sexo</label>
		<select id="Sexo" name="Sexo" class="form-control" required="required">
			<option value="">-- Selecione --</option>
			<option value="F">Feminino</option>
			<option value="M">Masculino</option>
		</select>
	</div>
	<div class="col-4">
		<label>Idade</label>
		<input type="text" id="Idade" name="Idade" class="form-control" placeholder="Informe sua idade"  required="required" />
	</div>
	<div class="col-4">
		<label>Estado Civil</label>
		<select id="EstadoCivil" name="EstadoCivil" class="form-control" required="required">
			<option value="">-- Selecione --</option>
			<option value="1">Solteiro(a)</option>
			<option value="2">Casado(a)</option>
			<option value="3">Uni�o Est�vel</option>
			<option value="4">Separado(a)</option>
			<option value="5">Divorciado(a)</option>
			<option value="6">Vi�vo(a)</option>
		</select>
	</div>
	<div class="col-4">
		<label>Tem Filho(s)</label>
		<select id="TemFilhos" name="TemFilhos" class="form-control" required="required">
			<option value="">-- Selecione --</option>
			<option value="S">Sim</option>
			<option value="N">N�o</option>
		</select>
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Endere�o</label>
		<input type="text" id="Endereco" name="Endereco" class="form-control" placeholder="Informe seu endere�o"  required="required"/>
	</div>
</div>
<div class="row">
	<div class="col-6">
		<label>Estado</label>
		<select id="Estado" name="Estado" class="form-control" required="required">
			<option value="">-- Selecione --</option>
			<option value="AC">Acre</option>
			<option value="AL">Alagoas</option>
			<option value="AP">Amap�</option>
			<option value="AM">Amazonas</option>
			<option value="BH">Bahia</option>
			<option value="CE">Cear�</option>
			<option value="DF">Distrito Federal</option>
			<option value="ES">Esp�rito Santo</option>
			<option value="GO">Goi�s</option>
			<option value="MA">Maranh�o</option>
			<option value="MT">Mato Grosso</option>
			<option value="MS">Mato Grosso do Sul</option>
			<option value="MG">Minas Gerais</option>
			<option value="PA">Par�</option>
			<option value="PB">Para�ba</option>
			<option value="PR">Paran�</option>
			<option value="PE">Pernanbuco</option>
			<option value="PI">Piau�</option>
			<option value="RJ">Rio de Janeiro</option>
			<option value="RN">Rio Grande do Norte</option>
			<option value="RS">Rio Grande do Sul</option>
			<option value="RO">Rond�nia</option>
			<option value="RR">Roraima</option>
			<option value="SC">Santa Catarina</option>
			<option value="SP">S�o Paulo</option>
			<option value="SE">Sergipe</option>
			<option value="TO">Tocantins</option>
		</select>
	</div>
	<div class="col-6">
		<label>Cidade</label>
		<input type="text" id="Cidade" name="Cidade" class="form-control" placeholder="Informe sua cidade" required="required" />
	</div>
</div>
<div class="row">
	<div class="col-6">
		<label>Telefone 1</label>
		<input type="text" id="Telefone1" name="Telefone1" class="form-control" placeholder="Informe seu telefone" />
	</div>
	<div class="col-6">
		<label>Telefone 2</label>
		<input type="text" id="Telefone2" name="Telefone2" class="form-control" placeholder="Informe seu telefone" />
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>E-mail</label>
		<input type="text" id="Email" name="Email" required="required" class="form-control" placeholder="Informe seu e-mail" />
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Objetivo</label>
		<textarea id="Objetivo" name="Objetivo" class="form-control" placeholder="Informe seu objetivo" rows="3"></textarea>
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Forma��o Acad�mica</label>
	</div>
</div>
<div class="item-group" id="formacaoAcademicaItems"></div>
<div class="row">
	<div class="col-12">
		<a href="#" id="adicionarOutroCursoClick" class=" hideImpressao">Adicionar outro curso</a>	
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Experi�ncia Profissional</label>
	</div>
</div>
<div class="item-group" id="experiencia"></div>
<div class="row">
	<div class="col-12">
		<a href="#" id="adicionarExprienciaClick" class=" hideImpressao">Adicionar outra experi�ncia</a>	
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Qualifica��es e Atividades Complementares</label>
	</div>
</div>
<div class="item-group" id="qualificacoes"></div>
<div class="row">
	<div class="col-12">
		<a href="#" id="adicionarQualificacaoClick" class=" hideImpressao" >Adicionar outra qualifica��o</a>	
	</div>
</div>
<div class="row">
	<div class="col-12">
		<label>Informa��es Adicionais</label>
	</div>
</div>
<div class="item-group" id="infoAdd"></div>
<div class="row">
	<div class="col-12">
		<a href="#" id="adicionarInfoAddClick" class=" hideImpressao" >Adicionar outra informa��o</a>	
	</div>
</div>
<div class="row">
	<div class="col-12">
		<button class="btn btn-default hideImpressao" type="submit">Gerar Meu Curr�culo</button>
		<button id="impressao" class="btn btn-default hideImpressao buttonImprimir" type="button">Imprimir Curr�culo</button>
	</div>
</div>
</form>
<?php
$scriptList= array(
    "site.js",
    "curriculo-crud.js"
);
require ("../shared/rodape.php");
?>