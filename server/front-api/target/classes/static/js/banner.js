var slideIndex = 3;   //记录初始图片的下标( 默认最初展示第四张图片，下标从0开始，所以初始值为3 )
//左边按钮的点击事件
$("#slideLeftBtn").on("click",function(){
    // 点击左按钮的时候想要显示当前图片的前一张，所以slideIndex值要减去1
    slideIndex--;
    // animateLength表示想要让slideImageLists移动到什么位置，slideImageLists 的位置由 left属性来控制
    var animateLength = slideIndex * (-600) + "px";
    $(".slideImageLists").animate({"left":animateLength},"slow",function(){
        // animate的回调函数(即执行完动画之后才会执行函数里面的内容)
        if(slideIndex <= 0){
            $(".slideImageLists").css({"left":"-1800px"});
            slideIndex = 3;
        }
    });
})
//右边按钮的点击事件
$("#slideRightBtn").on("click",function(){
    // 点击右按钮的时候想要显示当前图片的后一张，所以slideIndex值要加上1
    slideIndex++;
    var animateLength = slideIndex * (-600) + "px";
    $(".slideImageLists").animate({"left":animateLength},"slow",function(){
        if(slideIndex >= 6){
            $(".slideImageLists").css({"left":"-1800px"});
            slideIndex = 3;
        }
    })
})