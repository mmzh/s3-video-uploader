function generateTab(str) {
    var strArray = str.split("||");
    var s;
    for (s in strArray) {
        if (strArray[s].trim() != "") $("#video-info-box").append("<button  type='button' class='btn btn-success btn-xs'>" + strArray[s].replace("=", ":").replace("_", " ") + "</button>");
    }
}
function loadPlayer(url) {
    var myPlayer = videojs('my-video');
    myPlayer.src(url);
    myPlayer.ready(function() {});

}
var v;
window.URL = window.URL || window.webkitURL;
function setFileInfo(files) {
    var submit = document.getElementById('submit-button');
    v = files[0];

    if (getExtension(v.name) != "mp4") {
        document.getElementById("file").value = "";
        document.getElementById("file-fmt-warning").style.display = "inline";
        document.querySelector('#vinfo').innerHTML = "";
        submit.disabled = true;
        return;
    }
    var video = document.createElement('video');
    video.preload = 'metadata';
    video.onloadedmetadata = function() {
        window.URL.revokeObjectURL(this.src)
        var duration = video.duration;
        v.duration = duration;
        updateVinfo();
    }

    video.src = URL.createObjectURL(v);
}
function updateVinfo() {
    var submit = document.getElementById('submit-button');
    document.getElementById("file-fmt-warning").style.display = "none";
    document.querySelector('#vinfo').innerHTML = "";
    document.querySelector('#vinfo').innerHTML += "<div><p>video name: <b>" + v.name + "</b>  duration: <b>" + fmtMSS(Math.round(v.duration)) + '</b> file size: <b>' + fmtSize(v.size) + '</b></p></div>';
    if ((v.duration / 60) > 10 || v.size > 25500000) {
        submit.disabled = true;
        document.getElementById("alert").style.display = "block";
    } else {
        submit.disabled = false;
        document.getElementById("alert").style.display = "none";
    }
}
function fmtMSS(s) {
    return (s - (s %= 60)) / 60 + (9 < s ? ':' : ':0') + s
}
function fmtSize(s) {
    return Math.floor(s / (1024 * 1024)) + "Mb";
}
function getExtension(filename) {
    var parts = filename.split('.');
    return parts[parts.length - 1].toLowerCase();
}
$(function() {
    $('button[type=submit]').click(function(e) {
        e.preventDefault();
        //Disable submit button
        $(this).prop('disabled', true);
        var form = document.forms[0];
        var formData = new FormData(form);
        var hash = $("#page-hash-id").val();
        // Ajax call for file uploaling
        var ajaxReq = $.ajax({
            url: 'uploader?' + hash,
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            xhr: function() {
                //Get XmlHttpRequest object
                var xhr = $.ajaxSettings.xhr();
                //Set onprogress event handler 
                xhr.upload.onprogress = function(event) {
                    var perc = Math.round((event.loaded / event.total) * 100);
                    $('#progressBar').text(perc + '%');
                    $('#progressBar').css('width', perc + '%');
                    if (perc >= 99) $('#progressBar').html("<i class=\"fa fa-refresh fa-spin\" style=\"font-size: 15px;margin-right: 10;\"></i>Retrieving video info . . .");
                };
                return xhr;
            },
            beforeSend: function(xhr) {
                //Reset alert message and progress bar
                $('.progress').removeClass("hidden");
                $('#alertMsg').text('');
                $('#progressBar').text('');
                $('#progressBar').css('width', '0%');

            }
        });

        // Called on success of file upload
        ajaxReq.done(function(msg) {
            var t;
            t = $.parseJSON(msg);
            $(".success").addClass("hidden");
            $(".player-box").removeClass("hidden");
            $("#a-video-link").attr("href", t.url);
            $("#a-hls-video-link").attr("href",t.hlsurl);
            generateTab(t.videoinfo);
            loadPlayer(t.url);
            $('#alertMsg').text(msg);
            $('input[type=file]').val('');
            $('button[type=submit]').prop('disabled', false);
        });

        // Called on failure of file upload
        ajaxReq.fail(function(jqXHR) {
            $('#alertMsg').text(jqXHR.responseText + '(' + jqXHR.status +
                ' - ' + jqXHR.statusText + ')');
            $('button[type=submit]').prop('disabled', false);
        });
    });
});