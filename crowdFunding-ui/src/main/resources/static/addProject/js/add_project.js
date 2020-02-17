function RewardDTO() {
    var userToken;
    var projectTempToken;
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

RewardDTO.prototype.setUserToken = function (userToken) {
    this.userToken = userToken;
};
RewardDTO.prototype.setProjectTempToken = function (projectTempToken) {
    this.projectTempToken = projectTempToken;
};
RewardDTO.prototype.setType = function (type) {
    this.type = type;
};
RewardDTO.prototype.setMoney = function (money) {
    this.money = money;
};
RewardDTO.prototype.setDescription = function (description) {
    this.description = description;
};
RewardDTO.prototype.setPicture = function (picture) {
    this.picture = picture;
};
RewardDTO.prototype.setRemarks = function (remarks) {
    this.remarks = remarks;
};
RewardDTO.prototype.setLimitedAmount = function (limitedAmount) {
    this.limitedAmount = limitedAmount;
};
RewardDTO.prototype.setLimitedPurchase = function (limitedPurchase) {
    this.limitedPurchase = limitedPurchase;
};
RewardDTO.prototype.setFreight = function (freight) {
    this.freight = freight;
};
RewardDTO.prototype.setRewardData = function (rewardData) {
    this.rewardData = rewardData;
};
RewardDTO.prototype.setReceipt = function (receipt) {
    this.receipt = receipt;
};
RewardDTO.prototype.getUserToken = function () {
    return this.userToken;
};
RewardDTO.prototype.getProjectTempToken = function () {
    return this.projectTempToken;
};
RewardDTO.prototype.getType = function () {
    return this.type;
};
RewardDTO.prototype.getMoney = function () {
    return this.money;
};
RewardDTO.prototype.getDescription = function () {
    return this.description;
};
RewardDTO.prototype.getPicture = function () {
    return this.picture;
};
RewardDTO.prototype.getRemarks = function () {
    return this.remarks;
};
RewardDTO.prototype.getLimitedAmount = function () {
    return this.limitedAmount;
};
RewardDTO.prototype.getLimitedPurchase = function () {
    return this.limitedPurchase;
};
RewardDTO.prototype.getFreight = function () {
    return this.freight;
};
RewardDTO.prototype.getRewardData = function () {
    return this.rewardData;
};
RewardDTO.prototype.getReceipt = function () {
    return this.receipt;
};

var rewardDTOList = [];    //回报挡位信息数组




