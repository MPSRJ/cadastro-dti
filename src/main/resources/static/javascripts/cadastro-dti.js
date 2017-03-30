var App = App || {};

App.CaixaAlta = (function() {

	function CaixaAlta() {
		this.nomeGuerraInput = $('#nomeGuerra');
		this.nomeCompletoInput = $('#nomeCompleto');
	}

	CaixaAlta.prototype.iniciar = function() {
		this.nomeGuerraInput.on('keyup', onNomeGuerraKeyUp.bind(this));
		this.nomeCompletoInput.on('keyup', onNomeCompletoKeyUp.bind(this));
	}

	function onNomeGuerraKeyUp() {
		this.nomeGuerraInput.val(this.nomeGuerraInput.val().toUpperCase());

	}
	
	function onNomeCompletoKeyUp() {
		this.nomeCompletoInput.val(this.nomeCompletoInput.val().toUpperCase());
	}

	return CaixaAlta;

}());

$(function() {

	var caixaAlta = new App.CaixaAlta();

	caixaAlta.iniciar();

});