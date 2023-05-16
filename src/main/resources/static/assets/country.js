$(document).ready(function () {
    let id = '';
    let countryTable = $('#countryTable').DataTable({
        ajax: {
            url: '/country/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'tr'},
            {title: 'Name', data: 'name'},
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

    $('#saveCountry').click(function () {
        let name = document.getElementById('name').value;
        if (name.trim().length === 0) {
            return alert("malumot bo'sh bolmasligi kerak")
        }
        let obj = {name};
        let res = $.ajax({
            url: '/country/add',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        // if (res.status === 200 || res.status === 201 || res.status === 204) {
        //     alert(res.statusText)
        // } else {
        //     alert(res.statusText)
        // }
        alert("ma'lumot saqlandi")
        window.location.reload()
    })

    $(countryTable.table().body).on('click', '#edit', function () {
        let data = countryTable.row($(this).parents("tr")).data()
        id = data.id;
    })

    $('#editCountry').click(function () {
        let name = document.getElementById("editName").value;
        if (name.trim().length === 0) {
            return alert("davlat nomi bo'lishi shart")
        }
        let obj = {name}
        $.ajax({
            url: `/country/${id}`,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify(obj)
        })
        alert("malumot taxrirlandi")
        window.location.reload()
    })

    $(countryTable.table().body).on('click', '#delete', function () {
        let data = countryTable.row($(this).parents("tr")).data()
        id = data.id;
    })

    $('#deleteCountry').click(function () {
        $.ajax({
            url: `/country/${id}`,
            method: 'DELETE',
        })
        alert("o'chirildi")
        window.location.reload()
    })
})