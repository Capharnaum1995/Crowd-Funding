function animate(obj, json, callback) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        var flag = true;
        for (var attr in json) {
            var now = parseInt(getStyle(obj, attr));         //不转型的话直接得到的是像素值，不是一个数字
            var speed = (json[attr] - now) / 6;               //越往左边运动，速度越慢
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            var next = now + speed;
            obj.style[attr] = next + "px";
            if (json[attr] !== next) {
                flag = false;
            }
        }
        if (flag) {
            clearInterval(obj.timer);
            if (callback) {
                callback();
            }
        }
    }, 30);
}

function multiAnimate(list, list2, callback) {
    var json1 = list2[0];
    var json2 = list2[1];
    clearInterval(list.timer);
    list.timer = setInterval(function () {
        var flag = true;
        for (var attribute in json1) {
            var now = parseInt(getStyle(list[0], attribute));
            var speed = (json1[attribute] - now) / 6;
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            var next = now + speed;
            list[0].style[attribute] = next + "px";
            list[1].style[attribute] = next + "px";
            if (json1[attribute] !== next) {
                flag = false;
            }
        }
        for (var attribute in json2) {
            var now = parseInt(getStyle(list[2], attribute));
            var speed = (json2[attribute] - now) / 6;
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            var next = now + speed;
            list[2].style[attribute] = next + "px";
            list[3].style[attribute] = next + "px";
            if (json2[attribute] !== next) {
                flag = false;
            }
        }
        if (flag) {
            clearInterval(list.timer);
            if (callback) {
                callback();
            }
        }
    }, 45);
}

function getStyle(obj, attr) { //获取obj元素当前样式的attr属性值
    return window.getComputedStyle ? window.getComputedStyle(obj, null)[attr] : obj.currentStyle[attr];
}