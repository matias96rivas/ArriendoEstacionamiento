/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
!(function (a) {
    a(function () {
        a(".button-sent #back").hide(),
                a(".button-sent #continue").click(function (b) {
            a("#area .master-card").css("transform", "rotateY(180deg)"),
                    a(".button-sent #back").show();
        }),
                a(".button-sent #back").click(function (b) {
            a("#area .master-card").css("transform", "rotateY(0deg)"),
                    a(this).hide();
        });
    });
})(jQuery);

