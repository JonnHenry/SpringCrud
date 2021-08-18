// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
});


async function loadUsers(){
    const request = await fetch('/api/users', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });

    const users = await request.json();
    var listUser = '';
    users.forEach((user)=>{
        var stringTemplate = `
        <tr>
                <td>${user.id}</td>
                <td>${user.name} ${user.lastName} </td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>
                    <a href="#" onclick="deleteUser(${user.id})" class="btn btn-danger btn-circle btn-sm">
                        <i class="fas fa-trash"></i>
                    </a>
                </td>
        </tr>`;
        listUser+= stringTemplate;
    })
    //console.log(listUser)
    document.querySelector('#users tbody').outerHTML = listUser;
}


async function deleteUser(id){
    console.log(id)
    if(confirm('Desea eliminar este usuario?')){
        const request = await fetch('/api/users/delete/'+id, {
                  method: 'DELETE',
                  headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                  },
            });
    }
    console.log()
    location.reload();
}