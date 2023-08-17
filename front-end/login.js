

document.getElementById('submit-btn').addEventListener('click', (e) => {

    e.preventDefault()

   
    user_email = document.getElementById('email').value
    user_password = document.getElementById('password').value


// ===================isko add event listner ke ander daal server on karna ===================================
    window.localStorage.setItem("myemail",user_email)
//    ===============================================================
    console.log(user_email);
    console.log(user_password);
  
    
    const xhr = new XMLHttpRequest()
    url = `http://localhost:8082/users`
    xhr.open('GET', url)
    xhr.setRequestHeader('Access-Control-Allow-Origin','*')
    xhr.setRequestHeader('Content-Type', 'application/json')

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
           res=JSON.parse(xhr.responseText)
           console.log(res);
           for (let i = 0; i < res.length; i++)
           {
                if (res[i].email==user_email && res[i].password==user_password)
                {
                    window.location.href="http://127.0.0.1:5500/home.html"            }
                if (res[i].email!=user_email && res[i].password!=user_password)
                {
                   document.getElementById('messages').innerHTML="incorrect"

                }

           
           }

        }
    }
 
    xhr.send()
    
})





