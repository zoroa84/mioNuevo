var endpoint = 'http://localhost:8080/formacion/api/';
var li = '<li class="list-group-item">'+
			'<span class="badge badge-primary badge-pill">##id##</span> '+
			'<input type="text" id="##id##" onFocusOut="modificarArtista(this.id, this.value, \'##nombre##\')" value="##nombre##"> '+
			'<i onClick="eliminarArtista(##id##)" class="fa fa-trash" aria-hidden="true"></i>'+
		 '</li>';


$(function() {	
  console.log('Ready'); 
  refrescarLista();  
  crearArtista();
 
});

function refrescarLista(){
	  $.get( endpoint + "artistas/" , function(data){
		  console.debug('peticion OK %o', data );
		  var lis = "";  
		  
		  if ( data == undefined ){
			  lis = '<li class="list-group-item">No existen Artistas</li>';	
		  }else{
			  $.each( data, function(i,v){
					 lis += li.replace("##nombre##", v.nombre)
					 		  .replace("##nombre##", v.nombre)
					          .replace("##id##", v.id)
					          .replace("##id##", v.id)
					          .replace("##id##", v.id);		  
				  });  
		  }		  
		  $("#lista").html(lis);	  
	  });
}

function crearArtista(){
	
	$("#btn_nuevo").click(function(){
		var nombre = $("#input_nombre").val();
		console.log('pulsado boton, nombre %s' ,  nombre );
		
		if ( nombre == "" ){
			$("#error").text("Escribe el nombre");
		}else{
			console.log("llamda Ajax POST");			
			var dataForm = { "id": -1, "nombre": nombre };			
			$.ajax({
				  type: "POST",
				  url: endpoint + "artistas/",
				  data: JSON.stringify(dataForm),
				  contentType: 'application/json; charset=utf-8',				  
				  success: function(data){
					  console.log("data %o", data);
					  refrescarLista();
					  $("#error").text("");
					  $("#input_nombre").val("");
				  }
			});//Ajax			
		}//else
		
	});
}

function eliminarArtista( id ){
		
		console.log('eliminarArtista id=%s', id);
		$.ajax({
			  type: "DELETE",
			  url: endpoint + "artistas/"+ id + "/",			  
			  contentType: 'application/json; charset=utf-8',				  
			  success: function(data){
				  console.log("data %o", data);
				  refrescarLista();
				  $("#error").text("");
				  $("#input_nombre").val("");
			  }
		});//Ajax		
	
}


function modificarArtista(id, value, oldValue ){
	
	console.log('modificarArtista id=%s value=%s ', id, value);
	var dataForm = { "id": id, "nombre": value };	
	
	if ( oldValue != value ){
	
		$.ajax({
			  type: "PUT",
			  url: endpoint + "artistas/"+ id + "/",
			  data: JSON.stringify(dataForm),
			  contentType: 'application/json; charset=utf-8',				  
			  success: function(data){
				  console.log("data %o", data);
				  refrescarLista();
				  $("#error").text("");
				  $("#input_nombre").val("");
			  }
		});//Ajax	
	}else{
		console.log('No ha cambiado el valor');
	}	
}

