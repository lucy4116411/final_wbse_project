let auth = "";

function getSessionData() {
    const uri = "/session";
    fetch(uri, {
        method: 'GET',
    }).then(res => {
        if (res.status == 200) {
            return res.json();
        } else {
            window.location.href = "index.html";
        }
    }).then(result => {
        console.log(result);
        auth = result['auth'];
        document.getElementById("user-hello").innerText = "Hi! " + result['userName'];
        if (auth == "ROLE_ADMIN") {
            document.getElementById("admin").style.display = "";
        } else {
            document.getElementById("user").style.display = "";
        }
    });
}

$(document).ready(function () {
    getSessionData();
})