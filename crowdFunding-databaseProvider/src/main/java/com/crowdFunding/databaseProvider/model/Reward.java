package com.crowdFunding.databaseProvider.model;

public class Reward {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.id
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.project_id
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Integer projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.type
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.money
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Integer money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.description
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.picture
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.limited_amount
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Integer limitedAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.limited_purchase
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Integer limitedPurchase;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.freight
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Byte freight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.reward_data
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Byte rewardData;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reward.receipt
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    private Byte receipt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.id
     *
     * @return the value of reward.id
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.id
     *
     * @param id the value for reward.id
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.project_id
     *
     * @return the value of reward.project_id
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.project_id
     *
     * @param projectId the value for reward.project_id
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.type
     *
     * @return the value of reward.type
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.type
     *
     * @param type the value for reward.type
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.money
     *
     * @return the value of reward.money
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.money
     *
     * @param money the value for reward.money
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.description
     *
     * @return the value of reward.description
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.description
     *
     * @param description the value for reward.description
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.picture
     *
     * @return the value of reward.picture
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.picture
     *
     * @param picture the value for reward.picture
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.limited_amount
     *
     * @return the value of reward.limited_amount
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Integer getLimitedAmount() {
        return limitedAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.limited_amount
     *
     * @param limitedAmount the value for reward.limited_amount
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setLimitedAmount(Integer limitedAmount) {
        this.limitedAmount = limitedAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.limited_purchase
     *
     * @return the value of reward.limited_purchase
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Integer getLimitedPurchase() {
        return limitedPurchase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.limited_purchase
     *
     * @param limitedPurchase the value for reward.limited_purchase
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setLimitedPurchase(Integer limitedPurchase) {
        this.limitedPurchase = limitedPurchase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.freight
     *
     * @return the value of reward.freight
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Byte getFreight() {
        return freight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.freight
     *
     * @param freight the value for reward.freight
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setFreight(Byte freight) {
        this.freight = freight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.reward_data
     *
     * @return the value of reward.reward_data
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Byte getRewardData() {
        return rewardData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.reward_data
     *
     * @param rewardData the value for reward.reward_data
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setRewardData(Byte rewardData) {
        this.rewardData = rewardData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reward.receipt
     *
     * @return the value of reward.receipt
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public Byte getReceipt() {
        return receipt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reward.receipt
     *
     * @param receipt the value for reward.receipt
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    public void setReceipt(Byte receipt) {
        this.receipt = receipt;
    }
}