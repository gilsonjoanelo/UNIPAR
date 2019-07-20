function exibirFalha(div, mensagem) {
	$(div).append(mensagem);
};

$.urlParam = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^&#]*)')
                      .exec(window.location.search);

    return (results !== null) ? results[1] || 0 : false;
}

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

jQuery.extend(jQuery.validator.messages, {
     required: "Campo obrigat&oacute;rio!",
     remote: "Por favor, corrija este campo.",
     email: "Por favor, forne&ccedil;a um endere&ccedil;o eletr&ocirc;nico v&aacute;lido.",
     url: "Por favor, forne&ccedil;a uma URL v&aacute;lida.",
     date: "Por favor, forne&ccedil;a uma data v&aacute;lida.",
     dateISO: "Por favor, forne&ccedil;a uma data v&aacute;lida (ISO).",
     number: "Por favor, forne&ccedil;a um n&ucute;mero v&aacute;lido.",
     digits: "Por favor, forne&ccedil;a somente d&iacute;gitos.",
     creditcard: "Por favor, forne&ccedil;a um cart&atilde;o de cr&eacute;dito v&aacute;lido.",
     equalTo: "Por favor, forne&ccedil;a o mesmo valor novamente.",
     accept: "Por favor, forne&ccedil;a um valor com uma extens&atilde;o v&aacute;lida.",
     maxlength: jQuery.validator.format("Por favor, forne&ccedil;a n&atilde;o mais que {0} caracteres."),
     minlength: jQuery.validator.format("Por favor, forne&ccedil;a ao menos {0} caracteres."),
     rangelength: jQuery.validator.format("Por favor, forne&ccedil;a um valor entre {0} e {1} caracteres de comprimento."),
     range: jQuery.validator.format("Por favor, forne&ccedil;a um valor entre {0} e {1}."),
     max: jQuery.validator.format("Por favor, forne&ccedil;a um valor menor ou igual a {0}."),
     min: jQuery.validator.format("Por favor, forne&ccedil;a um valor maior ou igual a {0}.")
 });