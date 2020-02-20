//1.基本信息类
function BasicInfoDTO() {
    var userToken;
    var projectTempToken;
    var type;
    var day;
    var money;
    var typeList;
    var tagList;
    var name;
    var mainDescription;
    var highlight;
    var returnPurchase;
    var crowdFundingStory;
    var companyFile;
    var teamFile;
    var memberInfoDTOList;
}

BasicInfoDTO.prototype.getUserToken = function () {
    return this.userToken;
};
BasicInfoDTO.prototype.getProjectTempToken = function () {
    return this.projectTempToken;
};
BasicInfoDTO.prototype.getType = function () {
    return this.type;
};
BasicInfoDTO.prototype.getDay = function () {
    return this.day;
};
BasicInfoDTO.prototype.getMoney = function () {
    return this.money;
};
BasicInfoDTO.prototype.getTypeList = function () {
    return this.typeList;
};
BasicInfoDTO.prototype.getTagList = function () {
    return this.tagList;
};
BasicInfoDTO.prototype.getName = function () {
    return this.name;
};
BasicInfoDTO.prototype.getMainDescription = function () {
    return this.mainDescription;
};
BasicInfoDTO.prototype.getHighlight = function () {
    return this.highlight;
};
BasicInfoDTO.prototype.getReturnPurchase = function () {
    return this.returnPurchase;
};
BasicInfoDTO.prototype.getCrowdFundingStory = function () {
    return this.crowdFundingStory;
};
BasicInfoDTO.prototype.getCompanyFile = function () {
    return this.companyFile;
};
BasicInfoDTO.prototype.getTeamFile = function () {
    return this.teamFile;
};
BasicInfoDTO.prototype.getMemberInfoDTOList = function () {
    return this.memberInfoDTOList;
};
BasicInfoDTO.prototype.setUserToken = function (userToken) {
    this.userToken = userToken;
};
BasicInfoDTO.prototype.setProjectTempToken = function (projectTempToken) {
    this.projectTempToken = projectTempToken;
};
BasicInfoDTO.prototype.setType = function (type) {
    this.type = type;
};
BasicInfoDTO.prototype.setDay = function (day) {
    this.day = day;
};
BasicInfoDTO.prototype.setMoney = function (money) {
    this.money = money;
};
BasicInfoDTO.prototype.setTypeList = function (typeList) {
    this.typeList = typeList;
};
BasicInfoDTO.prototype.setTagList = function (tagList) {
    this.tagList = tagList;
};
BasicInfoDTO.prototype.setName = function (name) {
    this.name = name;
};
BasicInfoDTO.prototype.setMainDescription = function (mainDescription) {
    this.mainDescription = mainDescription;
};
BasicInfoDTO.prototype.setHighlight = function (highlight) {
    this.highlight = highlight;
};
BasicInfoDTO.prototype.setReturnPurchase = function (returnPurchase) {
    this.returnPurchase = returnPurchase;
};
BasicInfoDTO.prototype.setCrowdFundingStory = function (crowdFundingStory) {
    this.crowdFundingStory = crowdFundingStory;
};
BasicInfoDTO.prototype.setCompanyFile = function (companyFile) {
    this.companyFile = companyFile;
};
BasicInfoDTO.prototype.setTeamFile = function (teamFile) {
    this.teamFile = teamFile;
};
BasicInfoDTO.prototype.setMemberInfoDTOList = function (memberInfoDTOList) {
    this.memberInfoDTOList = memberInfoDTOList;
};
//1.1 type
//1.2 tag
//1.3 member

//2.回报挡位
function RewardDTO() {
    var userToken;
    var projectTempToken;
    var rewardList;
}

RewardDTO.prototype.getUserToken = function () {
    return this.userToken;
};
RewardDTO.prototype.getProjectTempToken = function () {
    return this.projectTempToken;
};
RewardDTO.prototype.getRewardList = function () {
    return this.rewardList;
};
RewardDTO.prototype.setUserToken = function (userToken) {
    this.userToken = userToken;
};
RewardDTO.prototype.setProjectTempToken = function (projectTempToken) {
    this.projectTempToken = projectTempToken;
};
RewardDTO.prototype.setRewardList = function (rewardList) {
    this.rewardList = rewardList;
};

function Reward() {
    var type;
    var money;
    var description;
    var picture;
    var remarks;
    var limitedAmount;
    var limitedPurchase;
    var freight;
    var rewardData;
    var receipt;
}

Reward.prototype.setType = function (type) {
    this.type = type;
};
Reward.prototype.setMoney = function (money) {
    this.money = money;
};
Reward.prototype.setDescription = function (description) {
    this.description = description;
};
Reward.prototype.setPicture = function (picture) {
    this.picture = picture;
};
Reward.prototype.setRemarks = function (remarks) {
    this.remarks = remarks;
};
Reward.prototype.setLimitedAmount = function (limitedAmount) {
    this.limitedAmount = limitedAmount;
};
Reward.prototype.setLimitedPurchase = function (limitedPurchase) {
    this.limitedPurchase = limitedPurchase;
};
Reward.prototype.setFreight = function (freight) {
    this.freight = freight;
};
Reward.prototype.setRewardDate = function (rewardDate) {
    this.rewardDate = rewardDate;
};
Reward.prototype.setReceipt = function (receipt) {
    this.receipt = receipt;
};
Reward.prototype.getType = function () {
    return this.type;
};
Reward.prototype.getMoney = function () {
    return this.money;
};
Reward.prototype.getDescription = function () {
    return this.description;
};
Reward.prototype.getPicture = function () {
    return this.picture;
};
Reward.prototype.getRemarks = function () {
    return this.remarks;
};
Reward.prototype.getLimitedAmount = function () {
    return this.limitedAmount;
};
Reward.prototype.getLimitedPurchase = function () {
    return this.limitedPurchase;
};
Reward.prototype.getFreight = function () {
    return this.freight;
};
Reward.prototype.getRewardDate = function () {
    return this.rewardDate;
};
Reward.prototype.getReceipt = function () {
    return this.receipt;
};

var rewardList = [];    //回报挡位信息数组

//媒体类
function Media() {
    var url;
}

Media.prototype.getUrl = function () {
    return this.url;
};
Media.prototype.setUrl = function (url) {
    this.url = url;
};

//3.推广资料
function PromotionalMaterialDTO() {
    var userToken;
    var projectTempToken;
    var importantBlockDisplay;
    var pcHomeDisplay;
    var pcProductDisplay;
    var video;
}

PromotionalMaterialDTO.prototype.getUserToken = function () {
    return this.userToken;
};
PromotionalMaterialDTO.prototype.getProjectTempToken = function () {
    return this.projectTempToken;
};
PromotionalMaterialDTO.prototype.getImportantBlockDisplay = function () {
    return this.importantBlockDisplay;
};
PromotionalMaterialDTO.prototype.getPcHomeDisplay = function () {
    return this.pcHomeDisplay;
};
PromotionalMaterialDTO.prototype.getPcProductDisplay = function () {
    return this.pcProductDisplay;
};
PromotionalMaterialDTO.prototype.getVideo = function () {
    return this.video;
};
PromotionalMaterialDTO.prototype.setUserToken = function (userToken) {
    this.userToken = userToken;
};
PromotionalMaterialDTO.prototype.setProjectTempToken = function (projectTempToken) {
    this.projectTempToken = projectTempToken;
};
PromotionalMaterialDTO.prototype.setImportantBlockDisplay = function (importantBlockDisplay) {
    this.importantBlockDisplay = importantBlockDisplay;
};
PromotionalMaterialDTO.prototype.setPcHomeDisplay = function (pcHomeDisplay) {
    this.pcHomeDisplay = pcHomeDisplay;
};
PromotionalMaterialDTO.prototype.setPcProductDisplay = function (pcProductDisplay) {
    this.pcProductDisplay = pcProductDisplay;
};
PromotionalMaterialDTO.prototype.setVideo = function (video) {
    this.video = video;
};

//4.资质信息
function QualificationInfoDTO() {
    var userToken;
    var projectTempToken;
    var brandPatent;              //品牌专利委托
    var managePermit;             //经营许可证
    var productionPermit;         //生产许可
    var certification;            //3C认证
    var qualityReport;            //质检报告
    var businessLicense;          //营业执照
    var otherQualificationFile;   //其他证件
}

QualificationInfoDTO.prototype.getUserToken = function () {
    return this.userToken;
};
QualificationInfoDTO.prototype.getProjectTempToken = function () {
    return this.projectTempToken;
};
QualificationInfoDTO.prototype.getBrandPatent = function () {
    return this.brandPatent;
};
QualificationInfoDTO.prototype.getManagePermit = function () {
    return this.managePermit;
};
QualificationInfoDTO.prototype.getProductionPermit = function () {
    return this.productionPermit;
};
QualificationInfoDTO.prototype.getCertification = function () {
    return this.certification;
};
QualificationInfoDTO.prototype.getQualityReport = function () {
    return this.qualityReport;
};
QualificationInfoDTO.prototype.getBusinessLicense = function () {
    return this.businessLicense;
};
QualificationInfoDTO.prototype.getOtherQualificationFile = function () {
    return this.otherQualificationFile;
};
QualificationInfoDTO.prototype.setUserToken = function (userToken) {
    this.userToken = userToken;
};
QualificationInfoDTO.prototype.setProjectTempToken = function (projectTempToken) {
    this.projectTempToken = projectTempToken;
};
QualificationInfoDTO.prototype.setBrandPatent = function (brandPatent) {
    this.brandPatent = brandPatent;
};
QualificationInfoDTO.prototype.setManagePermit = function (managePermit) {
    this.managePermit = managePermit;
};
QualificationInfoDTO.prototype.setProductionPermit = function (productionPermit) {
    this.productionPermit = productionPermit;
};
QualificationInfoDTO.prototype.setCertification = function (certification) {
    this.certification = certification;
};
QualificationInfoDTO.prototype.setQualityReport = function (qualityReport) {
    this.qualityReport = qualityReport;
};
QualificationInfoDTO.prototype.setBusinessLicense = function (businessLicense) {
    this.businessLicense = businessLicense;
};
QualificationInfoDTO.prototype.setOtherQualificationFile = function (otherQualificationFile) {
    this.otherQualificationFile = otherQualificationFile;
};


//资质信息
var brandPatent = new Map();
var managePermit = new Map();
var productionPermit = new Map();
var certification = new Map();
var qualityReport = new Map();
var businessLicenseReport = new Map();
var otherQualificationFile = new Map();
//推广资料
var importantBlockDisplay = new Map();
var pcHomeDisplay = new Map();
var pcProductDisplay = new Map();
var video = new Map();


/***********************************************挡位信息****************************************************/
function showBGLayer() {
    document.getElementsByClassName('order-layer-tip').item(0).style.display = "block";
    document.getElementById('addStallPopupShadow').style.display = 'block';
}

function hideBGLayer() {
    document.getElementsByClassName('order-layer-tip').item(0).style.display = "none";
    document.getElementById('addStallPopupShadow').style.display = 'none';
}

var formIndex = 0;       //表的索引
var rewardMap = new Map();

//添加挡位
function addRewardInfo() {
    //获取index
    var index = formIndex + '';
    formIndex++;
    //显示BGLayer
    showBGLayer();
    //生成表单以及表单控制脚本，追加在表单后面
    newForm(index);
}

//删除某个挡位
function deleteRewardInfo(index) {
    //1. 删除rewardMap中指定的记录
    rewardMap.delete(index + '');
    //2. 更新RewardIntroLis
    updateRewardIntroList(rewardMap);
}

//修改某个挡位
function modifyRewardInfo(index) {
    var i = index + '';
    var reward = rewardMap.get(i);
    showBGLayer();
    recoverForm(i, reward);
}

function generateRewardForm(index) {
    return "<div class='zpopup-wrap w984 popupab slideInDown' id='addStallsPopupBody-" + index + "'" +
        "         style='left: 182.5px; top: -394px; display: block;'>" +
        "        <div class='zpopup-head'>" +
        "            <div class='zpopup-title' id='redoundTitle'>添加档位</div>" +
        "            <div id='x-" + index + "' class='zpopup-closed-fixed' style='left: 1196.5px;'></div>" +
        "        </div>" +
        "        <div class='add-stall-block'>" +
        "            <!--回报类型-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>回报类型</span></dt>" +
        "                <dd class='order-dd'>" +
        "                    <div class='z-radios JradioReback'>" +
        "                        <div class='z-radio'>" +
        "                            <input type='radio' name='redoundType' id='rt1-" + index + "' value='1'>" +
        "                            <label class='radio-current' name='redoundType'>实物回报</label>" +
        "                        </div>" +
        "                        <div class='z-radio'>" +
        "                            <input type='radio' name='redoundType' id='rt0-" + index + "' value='0'>" +
        "                            <label class='radio-normal' name='redoundType'>虚拟物品回报</label>" +
        "                        </div>" +
        "                        <span class='z-notes'>（虚拟点卡、兑换码等不需要填写运单号发货的回报内容）</span>" +
        "                    </div>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--回报类型 end-->" +
        "            <!--支持金额-->" +
        "            <div class='clearfix'>" +
        "                <dl class='order-dl fl' id='AmountDiv' style='display: block;'>" +
        "                    <dt class='order-dt'><span class='fr'>支持金额</span></dt>" +
        "                    <dd class='order-dd clearfix w200'>" +
        "                        <div class='z-ipt-s w78 fl'>" +
        "                            <input type='text' class='z-ipt fl w78' placeholder='不少于0' id='reward-money-" + index + "' maxlength='8'>" +
        "                            <span class='ipt-span'>元</span>" +
        "                        </div>" +
        "                    </dd>" +
        "                </dl>" +
        "            </div>" +
        "            <!--支持金额 end-->" +
        "            <!--回报说明-->" +
        "            <dl class='order-dl' id='rewardContent'>" +
        "                <dt class='order-dt'><span class='fr'>回报内容</span></dt>" +
        "                <dd class='order-dd lt0 mt5 mb5'>" +
        "                <textarea class='z-textarea h80' placeholder='请简要概述该档位的回报内容，最多120字' id='reward-description-" + index + "'" +
        "                          style='width: 566px'></textarea>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--回报说明 end-->" +
        "            <!--说明图片-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>说明图片</span></dt>" +
        "                <dd class='order-dd'>" +
        "                    <input type='hidden' id='reward-picture-" + index + "' value=''>" +
        "                    <form enctype='multipart/form-data'>" +
        "                        <div class='form-group' style='line-height: 10px'>" +
        "                            <div class='file-loading'>" +
        "                                <input id='reward-picture-input-" + index + "' type='file' multiple>" +
        "                            </div>" +
        "                        </div>" +
        "                    </form>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--说明图片 end-->" +
        "            <!--备注信息-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>填写备注信息</span></dt>" +
        "                <dd class='order-dd'>" +
        "                    <div class='z-radios JradioMark'>" +
        "                        <input type='text' class='z-ipt w566' id='reward-remarks-" + index + "'" +
        "                               placeholder='请输入备注校验信息，例如回报物品的颜色、尺寸等（不超过30个字）。'" +
        "                               maxlength='30'>" +
        "                    </div>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--备注信息 end-->" +
        "            <!--限定发售量-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>限定数量</span></dt>" +
        "                <dd class='order-dd mb5'>" +
        "                    <div class='z-ipt-s fl w78'>" +
        "                        <input type='text' class='z-ipt fl w78' placeholder='0' id='reward-limitedAmount-" + index + "' value='0'>" +
        "                        <span class='ipt-span'>份</span>" +
        "                    </div>" +
        "                    <span id='count_tip' class='z-notes'>（0人为不限发售量，提示：该档位支持者每单可支持份）</span></dd>" +
        "            </dl>" +
        "            <!--限定发售量 end-->" +
        "            <!--单人限购数量-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>单人限购数量</span></dt>" +
        "                <dd class='order-dd mb5'>" +
        "                    <div class='z-ipt-s fl w78'>" +
        "                        <input type='text' class='z-ipt fl w78' placeholder='0' id='reward-limitedPurchase-" + index + "' value='0'>" +
        "                        <span class='ipt-span'>份</span>" +
        "                    </div>" +
        "                    <span id='singlg_count_tip' class='z-notes'>（0人为不限购）</span></dd>" +
        "            </dl>" +
        "            <!--单人限购数量 end-->" +
        "            <!--运费-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>运费单价</span></dt>" +
        "                <dd class='order-dd'>" +
        "                    <div class='z-ipt-s fl w78'>" +
        "                        <input type='text' class='z-ipt fl w78 fl' placeholder='0' id='reward-freight-" + index + "' value='0'>" +
        "                        <span class='ipt-span'>元</span>" +
        "                    </div>" +
        "                    <span class='z-notes'>（0元为包邮）</span></dd>" +
        "            </dl>" +
        "            <!--运费 end-->" +
        "            <!--回报时间-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>回报时间</span></dt>" +
        "                <dd class='order-dd'>" +
        "                    <span class='fl mr10'>众筹成功后</span>" +
        "                    <div class='z-ipt-s w78 fl'>" +
        "                        <input type='text' class='z-ipt fl w78' id='reward-rewardDate-" + index + "'>" +
        "                        <span class='ipt-span'>天</span>" +
        "                    </div>" +
        "                    <span class='fl ml50'>，将会向支持者发送回报</span>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--回报时间 end-->" +
        "            <!--是否支持开发票-->" +
        "            <dl class='order-dl'>" +
        "                <dt class='order-dt'><span class='fr'>是否支持发票</span></dt>" +
        "                <dd class='order-dd'>" +
        "                    <div class='z-radios JradioSetbuy'>" +
        "                        <div class='z-radio'>" +
        "                            <input type='radio' name='scrambleStatus' id='scramble1-" + index + "' value='1'>" +
        "                            <label class='radio-current' name='scrambleStatus'>是</label>" +
        "                        </div>" +
        "                        <div class='z-radio'>" +
        "                            <input type='radio' name='scrambleStatus' id='scramble0-" + index + "' value='0'>" +
        "                            <label class='radio-normal' name='scrambleStatus'>否</label>" +
        "                        </div>" +
        "                        <span class='z-notes'>（该项目请仔细选择，bula bula........）</span>" +
        "                    </div>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--是否支持开发票 end-->" +
        "            <!--取消、保存-->" +
        "            <dl class='order-dl'>" +
        "                <dd class='tc'>" +
        "                    <input type='button' class='common_btn_white mr10' value='取消' id='addRedoundCancelBtn-" + index + "'>" +
        "                    <input type='button' class='common_button' id='addRedoundSaveBtn-" + index + "' value='保存'>" +
        "                </dd>" +
        "            </dl>" +
        "            <!--取消、保存 end-->" +
        "        </div>" +
        "    </div>";
}


function generateRewardFormControllerCode(index) {
    return "$('#reward-picture-input-" + index + "').fileinput({\n" +
        "    theme: 'fas',\n" +
        "    uploadUrl: '/file/upload',\n" +
        "    allowedFileTypes: ['image'],\n" +
        "    maxFileCount: 1,\n" +
        "    minFileSize: 200,\n" +
        "    maxFileSize: 1024 * 4,\n" +
        "    maxFilesNum: 1,\n" +
        "    showClose: false,\n" +
        "    uploadExtraData: {userToken: 'fifteenthofjuly'},\n" +
        "    slugCallback: function (filename) {\n" +
        "        return filename.replace('(', '_').replace(']', '_');\n" +
        "    }\n" +
        "}).on('fileuploaded', function (event, data) {\n" +
        "    document.getElementById('reward-picture-" + index + "').setAttribute('value', data.response.data);\n" +
        "}).on('filesuccessremove', function () {\n" +
        "    document.getElementById('reward-picture-" + index + "').setAttribute('value', '');\n" +
        "});\n" +
        "var rewardForm_" + index + " = document.getElementById('addStallsPopupBody-" + index + "');\n" +
        "var rewardInfoConfirmBtn_" + index + " = document.getElementById('addRedoundSaveBtn-" + index + "');\n" +
        "var rewardInfoCancelBtn_" + index + " = document.getElementById('addRedoundCancelBtn-" + index + "');\n" +
        "var x_" + index + " = document.getElementById('x-" + index + "');\n" +
        "var actualItem_" + index + " = document.getElementById('rt1-" + index + "');\n" +
        "var actualItemLabel_" + index + " = actualItem_" + index + ".parentElement.children.item(1);\n" +
        "var visualItem_" + index + " = document.getElementById('rt0-" + index + "');\n" +
        "var visualItemLabel_" + index + " = visualItem_" + index + ".parentElement.children.item(1);\n" +
        "var receipt_" + index + " = document.getElementById('scramble1-" + index + "');\n" +
        "var receiptLabel_" + index + " = receipt_" + index + ".parentElement.children.item(1);\n" +
        "var noReceipt_" + index + " = document.getElementById('scramble0-" + index + "');\n" +
        "var noReceiptLabel_" + index + " = noReceipt_" + index + ".parentElement.children.item(1);\n" +
        "actualItemLabel_" + index + ".onclick = function () {\n" +
        "    if (actualItemLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        actualItemLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        visualItemLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "visualItemLabel_" + index + ".onclick = function () {\n" +
        "    if (visualItemLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        visualItemLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        actualItemLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "receiptLabel_" + index + ".onclick = function () {\n" +
        "    if (receiptLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        receiptLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        noReceiptLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "noReceiptLabel_" + index + ".onclick = function () {\n" +
        "    if (noReceiptLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        noReceiptLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        receiptLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "function getType_" + index + "() {\n" +
        "    if (actualItemLabel_" + index + ".getAttribute('class') === 'radio-current') {\n" +
        "        return parseInt(actualItem_" + index + ".getAttribute('value'));\n" +
        "    } else {\n" +
        "        return parseInt(visualItem_" + index + ".getAttribute('value'));\n" +
        "    }\n" +
        "}\n" +
        "function getReceipt_" + index + "() {\n" +
        "    if (receiptLabel_" + index + ".getAttribute('class') === 'radio-current') {\n" +
        "        return parseInt(receipt_" + index + ".getAttribute('value'));\n" +
        "    } else {\n" +
        "        return parseInt(noReceipt_" + index + ".getAttribute('value'));\n" +
        "    }\n" +
        "};\n" +
        "rewardInfoConfirmBtn_" + index + ".onclick = function () {\n" +
        "    var type = getType_" + index + "();\n" +
        "    var money = document.getElementById('reward-money-" + index + "').value;\n" +
        "    var description = document.getElementById('reward-description-" + index + "').value.replace(/\\s+/g, '');\n" +
        "    var picture = document.getElementById('reward-picture-" + index + "').value;\n" +
        "    var remarks = document.getElementById('reward-remarks-" + index + "').value.replace(/\\s+/g, '');\n" +
        "    var limitedAmount = document.getElementById('reward-limitedAmount-" + index + "').value;\n" +
        "    var limitedPurchase = document.getElementById('reward-limitedPurchase-" + index + "').value;\n" +
        "    var freight = document.getElementById('reward-freight-" + index + "').value;\n" +
        "    var rewardDate = document.getElementById('reward-rewardDate-" + index + "').value;\n" +
        "    var receipt = getReceipt_" + index + "();\n" +
        "    var reward = new Reward();\n" +
        "    reward.setType(type);\n" +
        "    reward.setMoney(money);\n" +
        "    reward.setDescription(description);\n" +
        "    reward.setPicture(picture);\n" +
        "    reward.setRemarks(remarks);\n" +
        "    reward.setLimitedAmount(limitedAmount);\n" +
        "    reward.setLimitedPurchase(limitedPurchase);\n" +
        "    reward.setFreight(freight);\n" +
        "    reward.setRewardDate(rewardDate);\n" +
        "    reward.setReceipt(receipt);\n" +
        "    rewardMap.set('" + index + "', reward);\n" +
        "    document.getElementById('addStallsPopupBody-" + index + "').remove();\n" +
        "    hideBGLayer();\n" +
        "    updateRewardIntroList(rewardMap);\n" +
        "    };\n" +
        "rewardInfoCancelBtn_" + index + ".onclick = function () {\n" +
        "    document.getElementById('addStallsPopupBody-" + index + "').remove();\n" +
        "    hideBGLayer();\n" +
        "    };\n" +
        "x_" + index + ".onclick = function () {\n" +
        "    document.getElementById('addStallsPopupBody-" + index + "').remove();\n" +
        "    hideBGLayer();\n" +
        "    };";
}

function generateRewardFormControllerCodeI(reward, index) {
    return "$('#reward-picture-input-" + index + "').fileinput({\n" +
        "    theme: 'fas',\n" +
        "    uploadUrl: '/file/upload',\n" +
        "    allowedFileTypes: ['image'],\n" +
        "    overwriteInitial: true,\n" +
        "    initialPreviewAsData: true,\n" +
        "    maxFileCount: 1,\n" +
        "    minFileSize: 200,\n" +
        "    maxFileSize: 1024 * 4,\n" +
        "    maxFilesNum: 1,\n" +
        "    showClose: false,\n" +
        "    initialPreview: ['https://" + reward.getPicture() + "'],\n" +
        "    uploadExtraData: {userToken: 'fifteenthofjuly'},\n" +
        "    slugCallback: function (filename) {\n" +
        "        return filename.replace('(', '_').replace(']', '_');\n" +
        "    }\n" +
        "    }).on('fileuploaded', function (event, data) {\n" +
        "        document.getElementById('reward-picture-" + index + "').setAttribute('value', data.response.data);\n" +
        "    }).on('filesuccessremove', function () {\n" +
        "        document.getElementById('reward-picture-" + index + "').setAttribute('value', '');\n" +
        "    });\n" +
        "    var rewardForm_" + index + " = document.getElementById('addStallsPopupBody-" + index + "');\n" +
        "    var rewardInfoConfirmBtn_" + index + " = document.getElementById('addRedoundSaveBtn-" + index + "');\n" +
        "    var rewardInfoCancelBtn_" + index + " = document.getElementById('addRedoundCancelBtn-" + index + "');\n" +
        "    var x_" + index + " = document.getElementById('x-" + index + "');\n" +
        "    var actualItem_" + index + " = document.getElementById('rt1-" + index + "');\n" +
        "    var actualItemLabel_" + index + " = actualItem_" + index + ".parentElement.children.item(1);\n" +
        "    var visualItem_" + index + " = document.getElementById('rt0-" + index + "');\n" +
        "    var visualItemLabel_" + index + " = visualItem_" + index + ".parentElement.children.item(1);\n" +
        "    var receipt_" + index + " = document.getElementById('scramble1-" + index + "');\n" +
        "    var receiptLabel_" + index + " = receipt_" + index + ".parentElement.children.item(1);\n" +
        "    var noReceipt_" + index + " = document.getElementById('scramble0-" + index + "');\n" +
        "    var noReceiptLabel_" + index + " = noReceipt_" + index + ".parentElement.children.item(1);\n" +
        "    actualItemLabel_" + index + ".onclick = function () {\n" +
        "    if (actualItemLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        actualItemLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        visualItemLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "visualItemLabel_" + index + ".onclick = function () {\n" +
        "    if (visualItemLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        visualItemLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        actualItemLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "receiptLabel_" + index + ".onclick = function () {\n" +
        "    if (receiptLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        receiptLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        noReceiptLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "noReceiptLabel_" + index + ".onclick = function () {\n" +
        "    if (noReceiptLabel_" + index + ".getAttribute('class') !== 'radio-current') {\n" +
        "        noReceiptLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        receiptLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "};\n" +
        "function getType_" + index + "() {\n" +
        "    if (actualItemLabel_" + index + ".getAttribute('class') === 'radio-current') {\n" +
        "        return parseInt(actualItem_" + index + ".getAttribute('value'));\n" +
        "    } else {\n" +
        "        return parseInt(visualItem_" + index + ".getAttribute('value'));\n" +
        "    }\n" +
        "}\n" +
        "function getReceipt_" + index + "() {\n" +
        "    if (receiptLabel_" + index + ".getAttribute('class') === 'radio-current') {\n" +
        "        return parseInt(receipt_" + index + ".getAttribute('value'));\n" +
        "    } else {\n" +
        "        return parseInt(noReceipt_" + index + ".getAttribute('value'));\n" +
        "    }\n" +
        "};\n" +
        "rewardInfoConfirmBtn_" + index + ".onclick = function () {\n" +
        "    var type = getType_" + index + "();\n" +
        "    var money = document.getElementById('reward-money-" + index + "').value;\n" +
        "    var description = document.getElementById('reward-description-" + index + "').value.replace(/\\s+/g, '');\n" +
        "    var picture = document.getElementById('reward-picture-" + index + "').value;\n" +
        "    var remarks = document.getElementById('reward-remarks-" + index + "').value.replace(/\\s+/g, '');\n" +
        "    var limitedAmount = document.getElementById('reward-limitedAmount-" + index + "').value;\n" +
        "    var limitedPurchase = document.getElementById('reward-limitedPurchase-" + index + "').value;\n" +
        "    var freight = document.getElementById('reward-freight-" + index + "').value;\n" +
        "    var rewardDate = document.getElementById('reward-rewardDate-" + index + "').value;\n" +
        "    var receipt = getReceipt_" + index + "();\n" +
        "    var reward = new Reward();\n" +
        "    reward.setType(type);\n" +
        "    reward.setMoney(money);\n" +
        "    reward.setDescription(description);\n" +
        "    reward.setPicture(picture);\n" +
        "    reward.setRemarks(remarks);\n" +
        "    reward.setLimitedAmount(limitedAmount);\n" +
        "    reward.setLimitedPurchase(limitedPurchase);\n" +
        "    reward.setFreight(freight);\n" +
        "    reward.setRewardDate(rewardDate);\n" +
        "    reward.setReceipt(receipt);\n" +
        "    rewardMap.set('" + index + "', reward);\n" +
        "    document.getElementById('addStallsPopupBody-" + index + "').remove();\n" +
        "    hideBGLayer();\n" +
        "    updateRewardIntroList(rewardMap);\n" +
        "    };\n" +
        "rewardInfoCancelBtn_" + index + ".onclick = function () {\n" +
        "    document.getElementById('addStallsPopupBody-" + index + "').remove();\n" +
        "    hideBGLayer();\n" +
        "    };\n" +
        "x_" + index + ".onclick = function () {\n" +
        "    document.getElementById('addStallsPopupBody-" + index + "').remove();\n" +
        "    hideBGLayer();\n" +
        "    };\n" +
        "    if ('" + reward.getType() + "' === '0') {\n" +
        "        visualItemLabel_" + index + ".setAttribute('class', 'radio-current');\n" +
        "        actualItemLabel_" + index + ".setAttribute('class', 'radio-normal')\n" +
        "    }\n" +
        "    document.getElementById('reward-money-" + index + "').value = '" + reward.getMoney() + "';\n" +
        "    document.getElementById('reward-description-" + index + "').value = '" + reward.getDescription() + "';\n" +
        "    document.getElementById('reward-picture-" + index + "').setAttribute('value', '" + reward.getPicture() + "');\n" +
        "    document.getElementById('reward-remarks-" + index + "').value = '" + reward.getRemarks() + "';\n" +
        "    document.getElementById('reward-limitedAmount-" + index + "').value = '" + reward.getLimitedAmount() + "';\n" +
        "    document.getElementById('reward-limitedPurchase-" + index + "').value = '" + reward.getLimitedPurchase() + "';\n" +
        "    document.getElementById('reward-freight-" + index + "').value = '" + reward.getFreight() + "';\n" +
        "    document.getElementById('reward-rewardDate-" + index + "').value = '" + reward.getRewardDate() + "';\n" +
        "    if ('" + reward.getReceipt() + "' === '0') {\n" +
        "        receiptLabel_" + index + ".setAttribute('class', 'radio-normal');\n" +
        "        noReceiptLabel_" + index + ".setAttribute('class', 'radio-current')\n" +
        "    }\n";
}

//新建表单
function newForm(index) {
    //1.生成表单
    var form = generateRewardForm(index);
    //2.追加显示表单
    document.getElementById('reward-form-group').insertAdjacentHTML('beforeend', form);
    //3.生成js code
    var code = generateRewardFormControllerCode(index);
    //4.载入js（浏览器的兼容性考虑）
    var script = document.createElement("script");
    script.type = "text/javascript";
    try {
        script.appendChild(document.createTextNode(code));
    } catch (ex) {
        script.text = code;
    }
    document.getElementById('addStallsPopupBody-' + index).appendChild(script);
}

//恢复表单数据
function recoverForm(index, reward) {
    //1.生成表单
    var form = generateRewardForm(index);
    //2.追加显示表单
    document.getElementById('reward-form-group').insertAdjacentHTML('beforeend', form);
    //3.生成js code(表单的控制函数以及表单的数据恢复函数)
    var code = generateRewardFormControllerCodeI(reward, index);
    //4.载入js（浏览器的兼容性考虑）
    var script = document.createElement("script");
    script.type = "text/javascript";
    try {
        script.appendChild(document.createTextNode(code));
    } catch (ex) {
        script.text = code;
    }
    document.getElementById('addStallsPopupBody-' + index).appendChild(script);
}

function generateRewardIntro(reward, tag, index) {
    return "<tr>" +
        "    <td >" + tag + "</td>" +
        "    <td >￥" + reward.getMoney() + "</td>" +
        "    <td >" + reward.getLimitedAmount() + "位</td>" +
        "    <td>" +
        "        <p class='tl'>" + reward.getDescription() + "</p>" +
        "    </td>" +
        "    <td >项目结束后" + reward.getRewardDate() + "天</td>" +
        "    <td >￥" + reward.getFreight() + "</td>" +
        "    <td>" +
        "        <span class='td-edit'>" +
        "            <a class='td-edit' href='javascript:void(0);' onclick='modifyRewardInfo(" + index + ");');'>编辑</a>" +
        "            <a class='td-edit' href='javascript:void(0);' onclick='deleteRewardInfo(" + index + ");');'>删除</a>" +
        "        </span>" +
        "    </td>" +
        "</tr>";
}

function updateRewardIntroList(rewardMap) {
    //1. 清除列表
    var redoundTable = document.getElementById('redoundTable');
    var listLength = redoundTable.children.length;
    if (listLength > 1) {
        for (var i = 0; i < listLength - 1; i++) {
            redoundTable.children[1].remove();
        }
    }
    //2.重新按照rewardList添加
    rewardMap.forEach(function (value, key) {
        redoundTable.insertAdjacentHTML('beforeend', generateRewardIntro(value, Number(key) + 1, key));
    });
}

/***********************************************挡位信息 end************************************************/








