$(document).ready(function() {
   // on ready
});


async function registerUser() {
  let datos = {};
  datos.name = document.getElementById('txtNombre').value;
  datos.lastName = document.getElementById('txtApellido').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  let repetirPassword = document.getElementById('txtRepeatPassword').value;

  if (repetirPassword != datos.password) {
    alert('La contraseña que escribiste es diferente.');
    return;
  }

  const request = await fetch('api/users', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("La cuenta fue creada con exito!");
  //window.location.href = 'login.html'

}