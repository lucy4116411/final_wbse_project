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
            document.getElementById("card" + key).innerHTML = result[key];
        }
    });
}

async function getReplies() {
    const uri = "/api/reply";
    fetch(uri, {
        method: 'GET',
    }).then(res => {
        if (res.status == 200) {
            return res.json();
        }
    }).then(result => {
        for (var index = 0; index < result['replies'].length; index++) {
            document.getElementById("question-reply-" + index).value = result['replies'][index];
        }
    });
}

async function saveReplies() {
    const uri = "/api/reply";
    fetch(uri, {
        method: 'PUT',
        body: JSON.stringify({
            repliesToSave: [
                document.getElementById("question-reply-0").value,
                document.getElementById("question-reply-1").value,
                document.getElementById("question-reply-2").value,
                document.getElementById("question-reply-3").value,
                document.getElementById("question-reply-4").value
            ]
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => {
        if (res.status == 200) {
            alert("Success!!");
            return res.json();
        }
    }).then(result => {
        for (var index = 0; index < result['replies'].length; index++) {
            document.getElementById("question-reply-" + index).value = result['replies'][index];
        }
    });
}

$(document).ready(function () {
    getQuestions();
    getReplies();
})