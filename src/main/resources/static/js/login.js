$(document).ready(function() {
   // on ready
});


async function login() {
  let datos = {};
  datos.email = document.getElementById('email').value;
  datos.password = document.getElementById('password').value;

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const response = await request.text();
  if(response){
    window.location.href = 'users.html'
  }else{
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }
  console.log(response);

}