<?php 
   
   // $usuario = $_POST['usuario'];
   // $contrasena = $_POST['contrasena'];
    $ch = curl_init();
    echo('hola');
    curl_setopt($ch, CURLOPT_URL,"http://localhost:8080/login");
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS,"usuario=$usuario&password=$contrasena");

    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

   $server_output = curl_exec($ch);

    curl_close ($ch);

    echo($server_output);
       
?>
