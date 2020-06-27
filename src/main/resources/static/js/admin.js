async function getAllUser() {
    const uri = "/api/user/info/all";
    let tmp = "";
    fetch(uri, {
        method: 'GET',
    }).then(res => {
        if (res.status == 200) {
            return res.json();
        }
    }).then(result => {
        for (var index in result) {
            tmp += "<div class='card my-2' id='user-" + index + "'><div class='card-header'>"
                + result[index]["name"] + "</div><div class='card-body'><table><tbody><tr><th>學校: </th><th>"
                + result[index]["school"] + "</th></tr><tr><th>科系: </th><th>"
                + result[index]["department"] + "</th></tr><tr><th>年級: </th><th>"
                + result[index]["phone"] + "</th></tr><tr><th>email: </th><th>"
                + result[index]["email"] + "</th></tr><tr><th>臉書連結: </th><th>"
                + result[index]["facebook"] + "</tbody></table></div>"
                + "<button class='btn btn-primary' onclick=\"checkReply('" + result[index]["userName"] + "')\">查看書審資料</button>"
                + "<button class='btn btn-danger' onclick=\"deleteUser('" + result[index]["userName"] + "')\">刪除使用者</button></div>";

            //document.getElementById("card"+key).innerHTML = result[key];
        }
        document.getElementById("user-container").innerHTML = tmp;
    });
}

async function deleteUser(userName) {
    const uri = "/api/user/delete/" + userName;
    fetch(uri, {
        method: 'DELETE',
    }).then(res => {
        if (res.status == 204) {
        }
    });
    const uri_delete_reply = "/api/reply/" + userName;
    fetch(uri_delete_reply, {
        method: 'DELETE',
    }).then(res => {
        if (res.status == 204) {
            alert("Delete " + userName + " Success!");
            window.location.reload();
        }
    });
}

async function checkReply(userName) {
    const uri = "/api/reply/" + userName;
    fetch(uri, {
        method: 'GET',
    }).then(res => {
        if (res.status == 200) {
            return res.json();
        }
    }).then(result => {
        document.getElementById("reply-container").style.display = "";
        for (var index in result["replies"]) {
            //console.log(index);
            document.getElementById("a" + index).innerHTML = result['replies'][index];
        }
        console.log(result["replies"]);
    });

}

async function getQuestions() {
    const uri = "/api/question";
    fetch(uri, {
        method: 'GET',
    }).then(res => {
        if (res.status == 200) {
            return res.json();
        }
    }).then(result => {
        for (var key in result) {
            document.getElementById("q" + key).innerHTML = result[key];
        }
    });
}

$(document).ready(function () {
    getAllUser();
    getQuestions();
})