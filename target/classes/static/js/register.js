// Call the dataTables jQuery plugin
$(document).ready(function() {
    alert("Hola mundo")
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
        alert("La cuenta fue creada con exito!");
        console.log(datos);
       //location.reload();
    }else{
        alert("Las contraseñas no coinciden!")
    }
}
