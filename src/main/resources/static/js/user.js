async function getUserInfo() {
    let tbody = "";
    const uri = "/api/user/info";
    fetch(uri, {
        method: 'GET',
    }).then(res => {
        if (res.status == 200) {
            console.log(res);
            return res.json();
        }
    }).then(result => {
        console.log(result);
        for (var key in result) {
            tbody += "<tr><td>" + key + "</td><td>" + result[key] + "</td></tr>";
        }
        document.getElementById('tbody').innerHTML = tbody;
    });
}

$(document).ready(function () {
    getUserInfo();
})