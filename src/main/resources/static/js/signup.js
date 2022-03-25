
$(document).ready(function () {
    //usercheck();
})

function usercheck() {
    $.ajax({
        type: "GET",
        url: "/api/usercheck",
        success: function (response) {
            let usercheck = response;
            if (usercheck != "") {
                window.location.replace("/")
                alert("이미 로그인되었습니다'-')/")
            }
        }
    });
}

function check_pw() {
    var pw = document.getElementById('pw').value;
    var pw2 = document.getElementById('pw2').value;
    if (pw.length < 4) {
        document.getElementById('check').innerHTML = '비밀번호는 4자리 이상입니다.'
        document.getElementById('check').style.color = 'red';
        document.getElementById('login-id-submit').disabled = 'disabled';
        document.getElementById('login-id-submit').style.color = 'gray';
    } else if (pw != '' && pw2 != '') {
        if (pw == pw2) {





            document.getElementById('check').innerHTML = '비밀번호가 일치합니다.'
            document.getElementById('check').style.color = 'blue';
            document.getElementById('login-id-submit').disabled = false;
            document.getElementById('login-id-submit').style.color = 'white';
        } else {
            document.getElementById('check').innerHTML = '비밀번호가 일치하지 않습니다.';
            document.getElementById('check').style.color = 'red';
            document.getElementById('login-id-submit').disabled = 'disabled';
            document.getElementById('login-id-submit').style.color = 'gray';
        }
    }
}