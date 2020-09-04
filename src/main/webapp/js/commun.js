$(function(){
	
	$(".supp").on("click", function(){
		var att = $(this).attr("id");
		var	att2 = attr("var");
		var rep = confirm("Voulez-vous supprimer l'élément ?");
		if (rep)
			window.location="supprimer" + att2 + "?index=" + att;
	});
	
	$(".modif").on("click", function(){
		var att = $(this).attr("id");
		var	att2 = $(this).attr("var");
		window.location="editer" + att2 + "?index=" + att;
	});
	
});

$(document).ready( function() {
   $("#control_1, #control_2, #control_3, #control_4").multiSelect();
});

$('salarie').on('click', function (e) {
  e.preventDefault()
  $(this).tab('show')
})

$('client').on('click', function (e) {
  e.preventDefault()
  $(this).tab('show')
})