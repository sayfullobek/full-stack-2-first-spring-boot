$(document).ready(function () {
    let id = '';
    let regionTable = $('#regionTable').DataTable({
        ajax: {
            url: '/region/list',
            method: 'GET',
            dataSrc: ''
        },
        columns: [
            {title: 'T/r', data: 'id'},
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

    $('#saveRegion').click(function () {
        let name = document.getElementById('name').value;
        let countryId = document.getElementById('countryId').value;
        console.log(countryId)
        if (name.trim().length === 0) {
            return alert("malumot bo'sh bolmasligi kerak")
        }
        let obj = {name, countryId: countryId};
        console.log(obj)
        let res = $.ajax({
            url: '/region/add',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj)
        })
        alert("ma'lumot saqlandi")
        window.location.reload()
    })

    $(regionTable.table().body).on('click', '#edit', function () {
        let data = regionTable.row($(this).parents("tr")).data()
        id = data.id;
    })

    $('#editRegion').click(function () {
        let name = document.getElementById("editName").value;
        if (name.trim().length === 0) {
            return alert("davlat nomi bo'lishi shart")
        }
        let countryId = document.getElementById('editCountryId').value;
        let obj = {name,countryId}
        $.ajax({
            url: `/region/${id}`,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify(obj)
        })
        alert("malumot taxrirlandi")
        window.location.reload()
    })

    $(regionTable.table().body).on('click', '#delete', function () {
        let data = regionTable.row($(this).parents("tr")).data()
        id = data.id;
    })

    $('#deleteRegion').click(function () {
        $.ajax({
            url: `/region/${id}`,
            method: 'DELETE',
        })
        alert("o'chirildi")
        window.location.reload()
    })
})