async function login() {
    const uri = "/api/login";
    fetch(uri, {
        method: 'POST',
        body: JSON.stringify({
            userName: document.getElementById("username").value,
            password: document.getElementById("password").value
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => {
        if (res.status == 200) {
            document.location.href = "home.html";
        } else {
            document.getElementById("err-msg").innerText = "帳密無效，登入失敗";
        }
    });
}
