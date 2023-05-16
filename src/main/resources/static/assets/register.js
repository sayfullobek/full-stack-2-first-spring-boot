$(document).ready(function () {
    $('#register').click(function () {
        let name = document.getElementById("name").value
        let surname = document.getElementById("surname").value
        let email = document.getElementById("email").value
        let phoneNumber = document.getElementById("phoneNumber").value
        let password = document.getElementById("password").value
        let prePassword = document.getElementById("prePassword").value
        if (name.trim().length === 0 || surname.trim().length === 0) {
            return alert("ism va familiya bo'lishi shart")
        }
        if (!email.trim().endsWith("@gmail.com")) {
            return alert("emailingiz xato qayta urinib ko'ring")
        }
        if (phoneNumber.trim().length !== 9) {
            return alert("telefon raqamingiz xato qayta urinib ko'ring")
        }
        if (password.trim().length < 6 || password.trim().length > 16) {
            return alert("parolingiz 6ta belgidan ko'p va 16ta belgidan kam bo" +
                "lishi shart")
        }
        if (password !== prePassword) {
            return alert("parol va tasdiqlash paroli teng bo'lishi shart")
        }
        let obj = {name, surname, email, phoneNumber, password}
        const res = $.ajax({
            url: '/auth/register',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj),
            dataSrc: ''
        })
        localStorage.setItem("name", name)
        localStorage.setItem("surname", surname)
        localStorage.setItem("email", email)
        localStorage.setItem("phoneNumber", phoneNumber)
        localStorage.setItem("password", password)
        document.getElementById("register").href = "http://localhost:8080/auth/register/code"
    })


    $('#codeYubor').click(function () {
        let code = document.getElementById("code").value
        if (code.trim().length !== 5) {
            return alert("codingiz xato qayta kiriting")
        }
        let name = localStorage.getItem("name")
        let surname = localStorage.getItem("surname")
        let email = localStorage.getItem("email")
        let phoneNumber = localStorage.getItem("phoneNumber")
        let password = localStorage.getItem("password")
        let obj = {name, surname, email, phoneNumber, password, code}
        const res = $.ajax({
            url: '/auth/register/code',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(obj),
            dataSrc: ''
        })
        document.getElementById("register").href = "http://localhost:8080/auth/user"
    })
})