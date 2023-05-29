
$(document).ready(function (){
    let id ='';
    let PhoneTable =$('#PhoneTable').DataTable({
        ajax: {
            url: '/phone\list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'tr'},
            {title: 'Name', data: 'name'},
            {title: 'model',data: 'model'},
            {title: 'memory',data: 'memory'},
            {title: 'ram',data: 'ram'},
            {title: 'priice',data: 'price'},
            {
                title: 'action', data: 'id',
                render: function () {
                    return "<div class='row'><div class='col-4'><button class='btn btn-warning' id='edit' type=\"button\" data-bs-toggle=\"offcanvas\" data-bs-target=\"#editCanvas\"\n" +
                        "                aria-controls=\"editCanvas\">edit</button></div>" +
                        "<div class='col-4'><button class='btn btn-danger' id='delete'  data-bs-toggle=\"modal\" data-bs-target=\"#staticBackdrop\">delete</button></div>" +
                        "<div class='col-4'><button class='btn btn-info'>see</button></div></div>"
                }
            }
        ]
    })
     })