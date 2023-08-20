function validateEmail(email) {
    var regex = /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/;
    console.log(regex.test(email)+" email");
    return regex.test(email);
}
document.getElementById('submit-btn').addEventListener('click', (e) => {

    e.preventDefault()


    user_email = document.getElementById('email').value
    user_password = document.getElementById('password').value


    window.localStorage.setItem("myemail", user_email)
    console.log(user_email);
    console.log(user_password);

    if (validateEmail(user_email) && user_password != "") {
        const xhr = new XMLHttpRequest()
        url = `http://localhost:8082/users`
        xhr.open('GET', url)
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*')
        xhr.setRequestHeader('Content-Type', 'application/json')

        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4 && xhr.status == 200) {
                res = JSON.parse(xhr.responseText)
                console.log(res);
                for (let i = 0; i < res.length; i++) {
                    if (res[i].email == user_email && res[i].password == user_password) {
                        window.location.href = "./home.html"
                    }
                    if (res[i].email != user_email && res[i].password != user_password) {
                        document.getElementById('message').innerHTML = "incorrect password or email"

                    }


                }

            }
        }

        xhr.send()
    }else{
        document.getElementById("message").innerHTML="put correct details"
    }
})





