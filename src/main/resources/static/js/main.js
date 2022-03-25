
$(document).ready(function () {
    getMessages();
})

function getMessages() {
    $('#cards-box').empty();
    $.ajax({
        type: "GET",
        url: "/api/contents",
        data: {},
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let post = response[i];
                let id = post.id;
                let name = post.name;
                let title = post.title;
                let contents = post.contents;
                let modifiedAt = post.modifiedAt;
                addHTML(id, name, title, contents, modifiedAt);
            }
        }
    });
}

function addHTML(id, name, title, contents, modifiedAt) {
    let tempHtml = makeMessage(id, name, title, contents, modifiedAt);
    $('#cards-box').append(tempHtml);
}

function makeMessage(id, name, title, contents, modifiedAt) {
    return `<a href="detail.html?id=${id}">
                        <div class="card">
                            <div class="metadata">
                               <div id="${id}-name" class="name">
                                   ${name}
                               </div>
                               <div class="date">
                                   ${modifiedAt}
                               </div>
                            </div>
                            <h2 class='title' id="${id}-title">"${title}"</h2>
                            <div class="contents" id="${id}-contents" >
                               ${contents}
                            </div>
                         </a>

                        </div>`;
}