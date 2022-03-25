
$(document).ready(function () {
    usercheck();
})

function usercheck() {
    $.ajax({
        type: "GET",
        url: "/api/usercheck",
        success: function (response) {
            let usercheck = response;
            if (usercheck != ""){
                window.location.replace("/")
                alert("이미 로그인되었습니다'-')/")
            }
        }
    });
}