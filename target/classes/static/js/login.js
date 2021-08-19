$(document).ready(function() {
   // on ready
});


async function login() {
  let datos = {};
  datos.email = document.getElementById('email').value;
  datos.password = document.getElementById('password').value;
  console.log(datos);

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const response = await request.text();
  console.log(response);

}