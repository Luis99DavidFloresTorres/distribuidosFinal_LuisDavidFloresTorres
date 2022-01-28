var tokenGlobal ;
function llamadaLogin(pagina) {
    var ajax = new XMLHttpRequest() 
    var usuario = document.getElementById('usuario').value;
    var admin = document.getElementById('contrasena').value;
    
    //var parametros ="usuario=" + encodeURI(carnet) +"&password=" + encodeURI(nombre) + "&Nocache=" + Math.random();
    var json = '{"usuario":"'+usuario+'", "password":"'+admin+'"}';
    ajax.open("post", pagina, true);
    ajax.onreadystatechange = function() { 

        if (ajax.readyState == 4) {
            console.log(JSON.parse(ajax.responseText));
            var token = JSON.parse(ajax.responseText).token;
            var rol = JSON.parse(ajax.responseText).rol;
            var usuario = JSON.parse(ajax.responseText).name;
            this.tokenGlobal = JSON.parse(ajax.responseText).token;
            console.log(this.tokenGlobal)
            document.getElementById("respuesta").innerHTML = token;
            document.getElementById("inv").value=token;
            document.getElementById("rol").innerHTML = rol;
            document.getElementById("usuario").innerHTML = usuario;
        }
    }
    ajax.setRequestHeader("Content-Type", "application/json"); 
   // ajax.setRequestHeader("Authorization", "Ws6jvuJAY89zZh2QrTnKpkLYXz8JfhsgJzXnbyrw5UakrWHV4QrYxy7Kk339wtHE"); 
    ajax.send(json); 
}

function llamadaAgregar(pagina) {
    var ajax = new XMLHttpRequest() 
    var titulo = document.getElementById('titulo').value;
    var id = document.getElementById('id').value;
    var autor = document.getElementById('autor').value;
    var anopublicacion = document.getElementById('anopublicacion').value;
    var univco = document.getElementById('univco').value;
    
    //var parametros ="usuario=" + encodeURI(carnet) +"&password=" + encodeURI(nombre) + "&Nocache=" + Math.random();
    var json = '{"titulo":"'+titulo+'", "autor":"'+autor+'","aniopublicacion":"'+anopublicacion+'","univco":"'+univco+'"}';
    console.log(json);
    var token = document.getElementById("inv").value;
    
    ajax.open("post", pagina, true);
    ajax.setRequestHeader("Content-Type", "application/json"); 
    ajax.setRequestHeader('CSRF-TOKEN', token);
    ajax.setRequestHeader("Authorization",'Bearer '+token); 
  //  ajax.setRequestHeader('Authorization', 'Bearer ' + token);
    ajax.onreadystatechange = function() { 

        if (ajax.readyState == 4) {
           /* console.log(JSON.parse(ajax.responseText));
            var token = JSON.parse(ajax.responseText).token;
            console.log(token)
            document.getElementById("tareas").innerHTML = token;*/
        }
    }
    

    
    ajax.send(json); 
}
function llamadaObtener(pagina) {
    var ajax = new XMLHttpRequest() 
    //var parametros ="usuario=" + encodeURI(carnet) +"&password=" + encodeURI(nombre) + "&Nocache=" + Math.random();
  
    ajax.open("get", pagina, true);
    var token = document.getElementById("inv").value;
    console.log("token");
    console.log(token)
    ajax.setRequestHeader("Content-Type", "application/json"); 
    ajax.setRequestHeader('CSRF-TOKEN', token);
    ajax.setRequestHeader("Authorization",'Bearer '+token); 
    ajax.onreadystatechange = function() { 
        token = document.getElementById("inv").value;
        if (ajax.readyState == 4) {
            console.log("entra");
            console.log(ajax.responseText);
            var token = JSON.parse(ajax.responseText);
            //console.log(token)
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
    
   

    ajax.send(); 
}
function llamadaEliminar(pagina) {
    var ajax = new XMLHttpRequest() 
    
    var id = document.getElementById('id').value;
    var url =pagina;
    var json='{"id":'+id+'}';
    ajax.open("post", url, true);
    var token = document.getElementById("respuesta").innerHTML;
    ajax.setRequestHeader("Content-Type", "application/json"); 
    ajax.setRequestHeader('CSRF-TOKEN', token);
    ajax.setRequestHeader("Authorization",'Bearer '+token);  
    ajax.send(json); 
    ajax.onreadystatechange = function() { 

        if (ajax.readyState == 4) {
           /* console.log(JSON.parse(ajax.responseText));
            var token = JSON.parse(ajax.responseText).token;
            console.log(token)
            document.getElementById("tareas").innerHTML = token;*/
        }
    }
   
    console.log("valor", token);
    console.log(token);
   
}