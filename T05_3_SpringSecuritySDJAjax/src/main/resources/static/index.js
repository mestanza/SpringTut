$(function () {
    $('#loginForm').on('submit', function (e) {
        e.preventDefault();

        $.ajax({
            url: '/session-user',
            type: 'GET',
            headers: {
                'Authorization': 'Basic ' + btoa($('#username').val() + ':' + $('#password').val())
            },
            success: function (response) {
                console.log('response: ', response);
            }
        });
    });

    $('#logoutBtn').on('click', function() {
        $.ajax({
            url: '/logout',
            type: 'POST',
            headers: {
                'X-XSRF-TOKEN': $.cookie('XSRF-TOKEN')
            },
            success: function (response) {
                console.log('response: ', response);
            }
        });
    });
});