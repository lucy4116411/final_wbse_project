async function register() {
    const uri = "/api/register";
    fetch(uri, {
        method: 'POST',
        body: JSON.stringify({
            userName: document.getElementById("userName").value,
            password: document.getElementById("password").value,
            name: document.getElementById("name").value,
            school: document.getElementById("school").value,
            department: document.getElementById("department").value,
            grade: document.getElementById("grade").value,
            gender: document.getElementById("gender").value,
            phone: document.getElementById("phone").value,
            email: document.getElementById("email").value,
            facebook: document.getElementById("facebook").value,
            howToKnow: "臉書廣告",
            auth: "user"
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => {
        console.log(res.status);
        if (res.status == 201) {
            alert("Success!!!");
            document.location.href = "index.html";
        } else if (res.status == 404) {
            alert("帳號已有人使用");
        }
    });
}