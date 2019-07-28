//弹出窗口
$(document).ready(function() {
    $('.server_img_pop').magnificPopup({
        delegate: 'a',
        type:'image',
        gallery:{enabled:true}
    });
});

$("span.menu").click(function () {
    $("ul.res").slideToggle(300, function () {
        // Animation complete.
    });
});
