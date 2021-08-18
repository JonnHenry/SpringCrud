// Call the dataTables jQuery plugin
$(document).ready(function() {

});


async function registerUsers(){
    const request = await fetch'/api/users', {
      method: 'POST',
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
                    <a href="#" onclick='deleteUser(${user.id})' class="btn btn-danger btn-circle btn-sm">
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
    if(confirm('Desea eliminar este usuario?'){
        const request = await fetch'/api/users/'+id, {
                  method: 'DELETE',
                  headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                  },
            });
    }
    location.reload();

}
