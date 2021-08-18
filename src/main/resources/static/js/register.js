// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registerUser(){
    datos={
        "name": document.getElementById("txtNombre").value,
        "lastName": document.getElementById("txtApellido").value,
        "email": document.getElementById("txtEmail").value,
        "password": document.getElementById("txtPassword").value,
    }
    if (document.getElementById("txtPassword").value===document.getElementById("txtRepeatPassword").value){
        const request = await fetch'/api/users/', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
        const usuarios = await request.json();
        console.log(datos);
       //location.reload();
    }else{
        alert("Las contraseñas no coinciden!")
    }
}
