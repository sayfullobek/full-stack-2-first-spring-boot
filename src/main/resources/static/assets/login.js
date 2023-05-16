$(document).ready(function () {
    $('#login').click(function () {
        let phoneNumber = document.getElementById("phoneNumber").value
        let password = document.getElementById("password").value
        if (phoneNumber.trim().length !== 9) {
            return alert("telefon raqamingiz xato qayta urinib ko'ring")
        }
        if (password.trim().length < 6 || password.trim().length > 16) {
            return alert("parolingiz 6ta belgidan ko'p va 16ta belgidan kam bo" +
                "lishi shart")
        }
        let obj = {phoneNumber, password}
        $.ajax({
            url: '/auth/login',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj),
            dataSrc: '',
            success: function (result) {
                if (result.result.success === true) {
                    localStorage.setItem("name", result.user.name)
                    localStorage.setItem("surname", result.user.surname)
                    localStorage.setItem("email", result.user.email)
                    localStorage.setItem("phoneNumber", result.user.phoneNumber)
                    localStorage.setItem("password", result.user.password)
                    if (result.user.role === "USER") {
                        document.getElementById("login").href = "http://localhost:8080/auth/user"
                    } else {
                        document.getElementById("login").href = "http://localhost:8080/country"
                    }
                } else {
                    alert(result.result.message)
                }
            },
            error: function (result) {
                alert("oops");
            }
        })
    })
})