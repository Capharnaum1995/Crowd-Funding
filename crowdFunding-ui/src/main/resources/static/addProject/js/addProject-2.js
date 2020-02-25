/********************************************************1.首次进入首页提示*******************************************/
//这里需要添加一点，判断用户是否是第一次创建项目，暂且不用进行提示
var showTips = false;
var stepOne = document.getElementsByClassName('tabBar-step-one').item(0);  //第一步提示组件
var stepTwo = document.getElementsByClassName('tabBar-step-two').item(0);  //第二步提示组件
var confirmOne = document.getElementsByClassName('step-one-know').item(0); //第一步确认按钮
var confirmTwo = document.getElementsByClassName('step-two-know').item(0); //第二步确认按钮
var bgLayer = document.getElementsByClassName('order-layer-tip').item(0);    //背景层
var showBgLayer1 = true;
var showBgLayer2 = true;
if (showTips) {
    bgLayer.style.display = 'block';
    stepOne.style.display = 'block';
    stepTwo.style.display = 'block';
}
//"我知道了"按钮添加响应事件
confirmOne.onclick = function () {
    showBgLayer1 = false;
    stepOne.style.display = 'none';
    if ((!showBgLayer1) && (!showBgLayer2)) {
        bgLayer.style.display = 'none';
    }
};
confirmTwo.onclick = function () {
    showBgLayer2 = false;
    stepTwo.style.display = 'none';
    if ((!showBgLayer1) && (!showBgLayer2)) {
        bgLayer.style.display = 'none';
    }
};

/*******************************************************2.四个信息页切换*********************************************/
//清除所有头部选中的样式
function clearHead(var1, var2, var3, var4) {
    if (hasClass(var1, 'tabActive')) {
        removeClass(var1, 'tabActive')
    }
    if (hasClass(var2, 'tabActive')) {
        removeClass(var2, 'tabActive')
    }
    if (hasClass(var3, 'tabActive')) {
        removeClass(var3, 'tabActive')
    }
    if (hasClass(var4, 'tabActive')) {
        removeClass(var4, 'tabActive')
    }
}

//清除所有分页显示的样式
function clearPagination(var1, var2, var3, var4) {
    if (hasClass(var1, 'order-list')) {
        removeClass(var1, 'order-list')
    }
    if (hasClass(var2, 'order-list')) {
        removeClass(var2, 'order-list')
    }
    if (hasClass(var3, 'order-list')) {
        removeClass(var3, 'order-list')
    }
    if (hasClass(var4, 'order-list')) {
        removeClass(var4, 'order-list')
    }
}

//四个标签
var var1 = document.getElementsByClassName('tabBar-title-one').item(0);
var var2 = document.getElementsByClassName('tabBar-title-two').item(0);
var var3 = document.getElementsByClassName('tabBar-title-three').item(0);
var var4 = document.getElementsByClassName('tabBar-title-four').item(0);
//四个标签对应的信息填写页
var var5 = document.getElementById('basicInfo');
var var6 = document.getElementById('rewardInfo');
var var7 = document.getElementById('promoteMaterial');
var var8 = document.getElementById('qualificationInfo');

//标签体添加点击响应函数
var1.onclick = function () {
    if (!hasClass(var1, 'tabActive')) {
        clearHead(var1, var2, var3, var4);
        clearPagination(var5, var6, var7, var8);
        addClass(var1, 'tabActive');
        addClass(var5, "order-list")
    }
};
var2.onclick = function () {
    if (!hasClass(var2, 'tabActive')) {
        clearHead(var1, var2, var3, var4);
        clearPagination(var5, var6, var7, var8);
        addClass(var2, 'tabActive');
        addClass(var6, "order-list")
    }
};
var3.onclick = function () {
    if (!hasClass(var3, 'tabActive')) {
        clearHead(var1, var2, var3, var4);
        clearPagination(var5, var6, var7, var8);
        addClass(var3, 'tabActive');
        addClass(var7, "order-list")
    }
};
var4.onclick = function () {
    if (!hasClass(var4, 'tabActive')) {
        clearHead(var1, var2, var3, var4);
        clearPagination(var5, var6, var7, var8);
        addClass(var4, 'tabActive');
        addClass(var8, "order-list")
    }
};

/******************************************************3.类型/标签***************************************************/
//品类
document.getElementById('collapse-type-tag').onclick = function () {
    if (!hasClass(this, 'plus')) {
        addClass(this, 'plus');
        this.innerHTML = '收起标签';
        document.getElementById('type-tag').style.display = 'block';
    } else {
        removeClass(this, 'plus');
        this.innerHTML = '展开标签';
        document.getElementById('type-tag').style.display = 'none';
    }
};
$(".nowtips-type").on("click", "li", function () {
    if (!$(this).children('a').hasClass('selected')) {
        $(this).children('a').addClass('selected');
        var id = $(this).children('a').attr("tag-id");
        var text = $(this).children('a').children('span').html();
        var typeTagSelected = "<li>\n" +
            "                      <a href='javascript:void(0);' tag-id='" + id + "'>\n" +
            "                          <span>" + text + "</span>\n" +
            "                          <em></em>\n" +
            "                      </a>\n" +
            "                  </li>";
        document.getElementById('type-tag-selected').insertAdjacentHTML('beforeend', typeTagSelected);
    }
});
$("#type-tag-selected").on("click", "li", function () {
    var id = $(this).children('a').attr("tag-id");
    var tagList = $(".nowtips-type").children('li').children('a');
    var flag = true;
    for (var i = 0; i < tagList.length && flag; i++) {
        if (tagList[i].getAttribute('tag-id') === id) {
            tagList[i].setAttribute('class', '');
            flag = false;
        }
    }
    $(this).remove();
});
//标签
document.getElementById('collapse-tag-tag').onclick = function () {
    if (!hasClass(this, 'plus')) {
        addClass(this, 'plus');
        this.innerHTML = '收起标签';
        document.getElementById('tag-tag').style.display = 'block';
    } else {
        removeClass(this, 'plus');
        this.innerHTML = '展开标签';
        document.getElementById('tag-tag').style.display = 'none';
    }
};
$(".nowtips-tag").on("click", "li", function () {
    if (!$(this).children('a').hasClass('selected')) {
        $(this).children('a').addClass('selected');
        var id = $(this).children('a').attr("tag-id");
        var text = $(this).children('a').children('span').html();
        var tagTagSelected = "<li>\n" +
            "                      <a href='javascript:void(0);' tag-id='" + id + "'>\n" +
            "                          <span>" + text + "</span>\n" +
            "                          <em></em>\n" +
            "                      </a>\n" +
            "                  </li>";
        document.getElementById('tag-tag-selected').insertAdjacentHTML('beforeend', tagTagSelected);
    }
});
$("#tag-tag-selected").on("click", "li", function () {
    var id = $(this).children('a').attr("tag-id");
    var tagList = $(".nowtips-tag").children('li').children('a');
    var flag = true;
    for (var i = 0; i < tagList.length && flag; i++) {
        if (tagList[i].getAttribute('tag-id') === id) {
            tagList[i].setAttribute('class', '');
            flag = false;
        }
    }
    $(this).remove();
});

/******************************************************4.保存/提交信息***********************************************/
document.getElementById('drafts').onclick = function () {
    //保存基本信息
    if ($('.tabBar-title-one').hasClass('tabActive')) {
        /**前端校验 do something here...*/

            //获取typeList
        var type = $('#type-tag-selected').children('li').children('a');
        var typeList = [];
        for (var i = 0; i < type.length; i++) {
            typeList.push(type[i].getAttribute('tag-id') + '');
        }
        //获取tagList
        var tag = $('#tag-tag-selected').children('li').children('a');
        var tagList = [];
        for (var j = 0; j < tag.length; j++) {
            tagList.push(tag[j].getAttribute('tag-id') + '');
        }
        //获取memberList
        var memberList = [];
        var mList = document.getElementById('memberList').children;
        for (var k = 0; k < mList.length; k++) {
            var member_index = mList[k].getAttribute('id-index');
            var name = document.getElementById('member-name-' + member_index).value;
            var position = document.getElementById('member-position-' + member_index).value;
            var introduction = document.getElementById('member-introduction-' + member_index).value;
            var avatar = document.getElementById('member-avatar-' + member_index).getAttribute('value');
            //校验name position introduction avatar(省略。。。)
            var member = new Member();
            member.setName(name);
            member.setPosition(position);
            member.setIntroduction(introduction);
            member.setAvatar(avatar);
            memberList.push(member);
        }

        basicInfoDTO.setUserToken('this is useToken');    //$.sessionStorage.getItem('userToken')
        basicInfoDTO.setProjectTempToken('this is projectTempToken');    //$.sessionStorage.getItem('projectTempToken')
        basicInfoDTO.setType(document.getElementById('projectType').getAttribute('value'));
        basicInfoDTO.setDay(document.getElementById('collectDays').value);
        basicInfoDTO.setMoney(document.getElementById('projectAmount').value);
        basicInfoDTO.setTypeList(typeList);
        basicInfoDTO.setTagList(tagList);
        basicInfoDTO.setName(document.getElementById('projectName').value);
        basicInfoDTO.setMainDescription(document.getElementById('projectAdWord').value);
        basicInfoDTO.setHighlight(document.getElementById('projectSpot').value);
        basicInfoDTO.setReturnPurchase(document.getElementById('returnPurchase').getAttribute('value'));
        basicInfoDTO.setCrowdFundingStory(document.getElementsByClassName('editormd-markdown-textarea').item(0).value);
        basicInfoDTO.setCompanyFile(document.getElementById('companyInfo').value);
        basicInfoDTO.setTeamFile(document.getElementById('teamInfo').value);
        basicInfoDTO.setMemberList(memberList);
        $.ajax({
            type: "POST",
            url: "/save/project/basic/info",
            contentType: "application/json",
            data: JSON.stringify(basicInfoDTO),
            dataType: "json",
            success: function (response) {
                var status = response.status;
                if (status === 'SUCCESS') {
                    window.alert("项目基本信息保存成功。")
                } else {
                    window.alert("项目基本信息保存失败，请重试！")
                }
            }
        });
    }
    //保存挡位信息
    if ($('.tabBar-title-two').hasClass('tabActive')) {
        var rewardList = [];
        rewardDTO.setUserToken("This is userToken");//$.sessionStorage.getItem('userToken')
        rewardDTO.setProjectTempToken('This is projectTempToken');//$.sessionStorage.getItem('projectTempToken')
        rewardMap.forEach(function (value, key) {
            rewardList.push(value);
        });
        rewardDTO.setRewardList(rewardList);
        $.ajax({
            type: "POST",
            url: "/save/reward",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(rewardDTO),
            success: function (response) {
                var status = response.status;
                if (status === 'SUCCESS') {
                    window.alert("挡位信息保存成功。")
                } else {
                    window.alert("挡位信息保存失败，请重试！")
                }
            }
        });
    }
    //保存推广资料
    if ($('.tabBar-title-three').hasClass('tabActive')) {
        //保存推广资料
        if (promotionalMaterialDTO.getImportantBlockDisplay() === null || promotionalMaterialDTO.getImportantBlockDisplay() === undefined) {
            window.alert('请上传重点楼层展示图');
            return;
        }
        if (promotionalMaterialDTO.getPcHomeDisplay() === null || promotionalMaterialDTO.getPcHomeDisplay() === undefined) {
            window.alert('请上传产品主页展示图');
            return;
        }
        if (promotionalMaterialDTO.getPcProductDisplay() === null || promotionalMaterialDTO.getPcProductDisplay() === undefined) {
            window.alert('请上传产品展示图');
            return;
        }
        promotionalMaterialDTO.setUserToken('this is userToken');
        promotionalMaterialDTO.setProjectTempToken('this is projectTempToken');
        $.ajax({
            type: "POST",
            url: "/save/promotional/material",
            contentType: 'application/json', //请求头
            dataType: "json",                 //
            data: JSON.stringify(promotionalMaterialDTO),
            success: function (response) {
                var status = response.status;
                if (status === 'SUCCESS') {
                    window.alert("推广材料保存成功")
                } else {
                    window.alert("推广材料保存失败，请重试")
                }
            }
        });
    }
    //保存资质信息
    if ($('.tabBar-title-four').hasClass('tabActive')) {
        if (brandPatent.size < 1) {
            window.alert('请上传品牌、专利、委托或销售协议');
            return;
        }
        if (managePermit.size < 1) {
            window.alert('请上传经营许可证');
            return;
        }
        if (productionPermit.size < 1) {
            window.alert('请上传生产许可证');
            return;
        }
        if (certification.size < 1) {
            window.alert('请上传3C 认证、产品备案注册凭证等');
            return;
        }
        if (qualityReport.size < 1) {
            window.alert('请上传质检报告');
            return;
        }
        if (businessLicense.size < 1) {
            window.alert('请上传营业执照');
            return;
        }
        if (otherQualificationFile.size < 1) {
            window.alert('请上传其他证明');
            return;
        }
        qualificationInfoDTO.setUserToken('this is userToken');
        qualificationInfoDTO.setUserToken('this is projectTempToken');
        qualificationInfoDTO.setBrandPatent(mapToList(brandPatent));
        qualificationInfoDTO.setManagePermit(mapToList(managePermit));
        qualificationInfoDTO.setProductionPermit(mapToList(productionPermit));
        qualificationInfoDTO.setCertification(mapToList(certification));
        qualificationInfoDTO.setQualityReport(mapToList(qualityReport));
        qualificationInfoDTO.setBusinessLicense(mapToList(businessLicense));
        qualificationInfoDTO.setOtherQualificationFile(mapToList(otherQualificationFile));
        $.ajax({
            type: "POST",
            url: "/save/qualification/info",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(qualificationInfoDTO),
            success: function (response) {
                var status = response.status;
                if (status === 'SUCCESS') {
                    window.alert("资质信息保存成功")
                } else {
                    window.alert("资质信息保存失败，请重试")
                }
            }
        });
    }
};
document.getElementById('submit-info').onclick = function () {

};

/*****************************************************5.添加member**************************************************/
var memberIndex = 0;

function generateMemberHtml(index) {
    return "<div class='photos-item' id='photos-item-" + index + "' style='padding: 8px 8px 0 8px;height:385px;' id-index='" + index + "'>\n" +
        "                <div class='project-photos project-photos-w200 project-photos-h200'\n" +
        "                    style='width: 300px; line-height: 12px;'>\n" +
        "                    <input type='hidden' id='member-avatar-" + index + "' value='https://capharnaum.oss-us-west-1.aliyuncs.com/goCreate/images/default-avatar-male.png'>\n" +
        "                    <form enctype='multipart/form-data'>\n" +
        "                        <div class='form-group'>\n" +
        "                            <div class='file-loading'>\n" +
        "                                <input id='member-picture-" + index + "' type='file' multiple>\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                    </form>\n" +
        "                </div>\n" +
        "                <div class='z-editor z-editor-auto z-editor-member'\n" +
        "                    style='float: right;margin-top: 56px; margin-left: 0;width: 500px;'>\n" +
        "                    <div class='txt-wrapper clearfix'>\n" +
        "                        <input type='text' id='member-name-" + index + "' placeholder='请输入成员名称'\n" +
        "                            class='z-ipt' maxlength='20'\n" +
        "                            style='margin-right: 100px;margin-left: 20px; margin-bottom: 20px;'>\n" +
        "                        <input type='text' id='member-position-" + index + "' placeholder='请输入职位'\n" +
        "                            class='z-ipt' maxlength='20'\n" +
        "                            style='margin-right: 100px;margin-left: 20px; margin-bottom: 20px;'>\n" +
        "                    </div>\n" +
        "                    <textarea class='z-editor-textarea z-editor-textarea-2'\n" +
        "                         id='member-introduction-" + index + "' cols='30'\n" +
        "                         rows='10' placeholder='成员简介，字数限制100字'\n" +
        "                         style='margin-left:20px;width: 465px;height:156px'></textarea>\n" +
        "                <div style='padding-right: 12px;'>\n" +
        "                    <span class='delete-photo-txt' onclick='deleteMember(this)' id-delete='" + index + "'></span>\n" +
        "                </div>\n" +
        "                </div>\n" +
        "            </div>";
}

function generateMemberScript(index) {
    return "$('#member-picture-" + index + "').fileinput({\n" +
        "    theme: 'fas',\n" +
        "    uploadUrl: '/file/upload',\n" +
        "    allowedFileTypes: ['image'],\n" +
        "    overwriteInitial: true,\n" +
        "    initialPreviewAsData: true,\n" +
        "    maxFileCount: 1,\n" +
        "    minFileSize: 50,\n" +
        "    maxFileSize: 1024 * 4,\n" +
        "    maxFilesNum: 1,\n" +
        "    showClose: false,\n" +
        "    showRemove: false,\n" +
        "    initialPreview: ['https://capharnaum.oss-us-west-1.aliyuncs.com/goCreate/images/default-avatar-male.png'],\n" +
        "    uploadExtraData: {userToken: 'userToken'},\n" +
        "    slugCallback: function (filename) {\n" +
        "        return filename.replace('(', '_').replace(']', '_');\n" +
        "    }\n" +
        "    }).on('fileuploaded', function (event, data, previewId) {\n" +
        "        document.getElementById('member-avatar-" + index + "').setAttribute('value', data.response.data);\n" +
        "    }).on('filesuccessremove', function (event, id) {\n" +
        "        document.getElementById('member-avatar-" + index + "').setAttribute('value', 'https://capharnaum.oss-us-west-1.aliyuncs.com/goCreate/images/default-avatar-male.png');\n" +
        "    });";
}

function addNewMember(index) {
    var memberHtml = generateMemberHtml(index);
    document.getElementById('memberList').insertAdjacentHTML('beforeend', memberHtml);
    var code = generateMemberScript(index);
    var script = document.createElement("script");
    script.type = "text/javascript";
    try {
        script.appendChild(document.createTextNode(code));
    } catch (ex) {
        script.text = code;
    }
    document.getElementById('photos-item-' + index).appendChild(script);
}

document.getElementById('addMember').onclick = function () {
    var count = document.getElementById('memberList').children.length;
    if (count < 9) {
        addNewMember(memberIndex);
        memberIndex++;
        var now = 8 - count;
        this.setAttribute('value', '添加成员（还能添加 ' + now + ' 人）');
    } else {
        alert("添加人数已达上限");
    }
};

function deleteMember(element) {
    var index = element.getAttribute('id-delete');
    document.getElementById('photos-item-' + index).remove();
    var count = document.getElementById('memberList').children.length;
    var now = 9 - count;
    document.getElementById('addMember').setAttribute('value', '添加成员（还能添加 ' + now + ' 人）');
}

/*****************************************************6.文件上传**************************************************/
//资质信息
$("#brand-patent").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    //文件上传成功，id-url的形式加入map中
    brandPatent.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    brandPatent.delete(id);
});
$("#manage-permit").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    managePermit.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    managePermit.delete(id);
});
$("#production-permit").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    productionPermit.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    productionPermit.delete(id);
});
$("#certification").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    certification.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    certification.delete(id);
});
$("#quality-report").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    qualityReport.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    qualityReport.delete(id);
});
$("#business-license").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    businessLicense.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    businessLicense.delete(id);
});
$("#other-qualification-file").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 6,
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 6,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    otherQualificationFile.set(previewId, data.response.data);
}).on('filesuccessremove', function (event, id) {
    otherQualificationFile.delete(id);
});

//推广资料
$("#important-block-display").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 1,    //允许每次上传的文件数为1
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 1,
    showClose: false,
    uploadExtraData: {userToken: 'fifteenthofjuly'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    promotionalMaterialDTO.setImportantBlockDisplay(data.response.data);
}).on('filesuccessremove', function (event, id) {
    promotionalMaterialDTO.setImportantBlockDisplay(null);
});
$("#pc-home-display").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 1,  //允许每次上传的文件数为1
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 1,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    promotionalMaterialDTO.setPcHomeDisplay(data.response.data);
}).on('filesuccessremove', function (event, id) {
    promotionalMaterialDTO.setPcHomeDisplay(null);
});
$("#pc-product-display").fileinput({
    theme: 'fas',
    uploadUrl: '/file/upload',
    allowedFileTypes: ['image'],
    maxFileCount: 1,  //允许每次上传的文件数为1
    minFileSize: 50,
    maxFileSize: 1024 * 4,
    maxFilesNum: 1,
    showClose: false,
    uploadExtraData: {userToken: 'userToken'},
    slugCallback: function (filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
}).on('fileuploaded', function (event, data, previewId) {
    promotionalMaterialDTO.setPcProductDisplay(data.response.data);
}).on('filesuccessremove', function (event, id) {
    promotionalMaterialDTO.setPcProductDisplay(null);
});
$("#upload-video").fileinput({
    theme: 'fas',
    uploadUrl: '/resumable/file/upload',
    enableResumableUpload: true,            //支持断点续传
    allowedFileTypes: ['video'],            //设置其一就够了
    //overwriteInitial: false,
    resumableUploadOptions: {
        //testUrl: "/site/test-file-chunks",续传功能的开发
        chunkSize: 256 // 256KB
    },
    minFileSize: 1024 * 2,
    maxFileSize: 1024 * 200,
    maxFileCount: 1,
    showClose: false,
    uploadExtraData: {userToken: 'fifteenthofjuly'}  //$.sessionStorage.getItem("userToken")
}).on('fileuploaded', function (event, fileId) {
    var file_id = fileId.slice(19);  //这个返回的fileId比原始的fileId前面多追加了"thumb-upload-video-"
    $.ajax({
        type: "GET",
        url: "/complete/chunk/file",
        data: {"fileId": file_id},
        dataType: "json",
        success: function (response) {
            if (response.status === 'FAILED') {
                window.alert("视频上传失败，请删除再重传")
            } else {
                promotionalMaterialDTO.setVideo(response.data);
            }
        }
    })
}).on('filesuccessremove', function (event, id) {
    promotionalMaterialDTO.setVideo(null);
});

