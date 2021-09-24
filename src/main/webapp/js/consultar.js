$(document).ready(function(){
	consultadocumento();
 function consultarusuarios(){
	alert("en la funcion");	
	//let consultar;
	
$.ajax({
  type:"post",
  url: "ServletGestionusuario",
  dataType:'json',
  data:{dat:"consultar"
	
    },
  success: function(result){
	 console.log(result);
    let datos=document.querySelector('#tabla');
     //console.log(datos);
      datos.innerHTML='';
      datos.innerHTML+=` <tr><th>Documento</th>
	    <th>Usuario</th>
	    <th>Clave</th>
	    <th>Rol</th>
	    <th>Estado</th>
</tr>`;
     for(let i of result ){
	   datos.innerHTML+=`<tr><td>${i.documneto}</td> 
                             <td>${i.nomusuario}</td>
                             <td>${i.clave}</td>
                             <td>${i.rol}</td>
                             <td>${i.estado}</td>

      </tr>`;
     }

  }
});

}



function consultadocumento(){
	alert("documento");
$.ajax({
  type:"post",
  url: "ServletGestionusuario",
  dataType:'json',
  data:{
	x:"documento"
   },
  success: function(result){
	 console.log(result);
    let datos=document.querySelector('#lista');
     console.log(datos);
      datos.innerHTML='';
      
     for(let i of result ){
	   datos.innerHTML+=`<option>${i.documneto}</option>`; 
                             

      
     }

  }
});
	
	
	
	
}











$('.con').on('click',function(){
	consultarusuarios();
});	
	
	
	
});