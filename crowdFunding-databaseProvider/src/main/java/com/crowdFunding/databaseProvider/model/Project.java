package com.crowdFunding.databaseProvider.model;

public class Project {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.id
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.type
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.day
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Byte day;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.money
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Long money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.name
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.main_description
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private String mainDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.highlight
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private String highlight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.return_purchase
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Byte returnPurchase;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.crowd_funding_story
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private String crowdFundingStory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.company_file
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private String companyFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.team_file
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private String teamFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.initiator_id
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Integer initiatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.status
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.gmt_create
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.gmt_deploy
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Long gmtDeploy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.fund_money
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Long fundMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.supporter_number
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Integer supporterNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.follower_count
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Integer followerCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.like_count
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    private Integer likeCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.id
     *
     * @return the value of project.id
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.id
     *
     * @param id the value for project.id
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.type
     *
     * @return the value of project.type
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.type
     *
     * @param type the value for project.type
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.day
     *
     * @return the value of project.day
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Byte getDay() {
        return day;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.day
     *
     * @param day the value for project.day
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setDay(Byte day) {
        this.day = day;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.money
     *
     * @return the value of project.money
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Long getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.money
     *
     * @param money the value for project.money
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.name
     *
     * @return the value of project.name
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.name
     *
     * @param name the value for project.name
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.main_description
     *
     * @return the value of project.main_description
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public String getMainDescription() {
        return mainDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.main_description
     *
     * @param mainDescription the value for project.main_description
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription == null ? null : mainDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.highlight
     *
     * @return the value of project.highlight
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public String getHighlight() {
        return highlight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.highlight
     *
     * @param highlight the value for project.highlight
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setHighlight(String highlight) {
        this.highlight = highlight == null ? null : highlight.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.return_purchase
     *
     * @return the value of project.return_purchase
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Byte getReturnPurchase() {
        return returnPurchase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.return_purchase
     *
     * @param returnPurchase the value for project.return_purchase
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setReturnPurchase(Byte returnPurchase) {
        this.returnPurchase = returnPurchase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.crowd_funding_story
     *
     * @return the value of project.crowd_funding_story
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public String getCrowdFundingStory() {
        return crowdFundingStory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.crowd_funding_story
     *
     * @param crowdFundingStory the value for project.crowd_funding_story
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setCrowdFundingStory(String crowdFundingStory) {
        this.crowdFundingStory = crowdFundingStory == null ? null : crowdFundingStory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.company_file
     *
     * @return the value of project.company_file
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public String getCompanyFile() {
        return companyFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.company_file
     *
     * @param companyFile the value for project.company_file
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setCompanyFile(String companyFile) {
        this.companyFile = companyFile == null ? null : companyFile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.team_file
     *
     * @return the value of project.team_file
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public String getTeamFile() {
        return teamFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.team_file
     *
     * @param teamFile the value for project.team_file
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setTeamFile(String teamFile) {
        this.teamFile = teamFile == null ? null : teamFile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.initiator_id
     *
     * @return the value of project.initiator_id
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Integer getInitiatorId() {
        return initiatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.initiator_id
     *
     * @param initiatorId the value for project.initiator_id
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setInitiatorId(Integer initiatorId) {
        this.initiatorId = initiatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.status
     *
     * @return the value of project.status
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.status
     *
     * @param status the value for project.status
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.gmt_create
     *
     * @return the value of project.gmt_create
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.gmt_create
     *
     * @param gmtCreate the value for project.gmt_create
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.gmt_deploy
     *
     * @return the value of project.gmt_deploy
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Long getGmtDeploy() {
        return gmtDeploy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.gmt_deploy
     *
     * @param gmtDeploy the value for project.gmt_deploy
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setGmtDeploy(Long gmtDeploy) {
        this.gmtDeploy = gmtDeploy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.fund_money
     *
     * @return the value of project.fund_money
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Long getFundMoney() {
        return fundMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.fund_money
     *
     * @param fundMoney the value for project.fund_money
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setFundMoney(Long fundMoney) {
        this.fundMoney = fundMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.supporter_number
     *
     * @return the value of project.supporter_number
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Integer getSupporterNumber() {
        return supporterNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.supporter_number
     *
     * @param supporterNumber the value for project.supporter_number
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setSupporterNumber(Integer supporterNumber) {
        this.supporterNumber = supporterNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.follower_count
     *
     * @return the value of project.follower_count
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Integer getFollowerCount() {
        return followerCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.follower_count
     *
     * @param followerCount the value for project.follower_count
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.like_count
     *
     * @return the value of project.like_count
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.like_count
     *
     * @param likeCount the value for project.like_count
     *
     * @mbg.generated Tue Feb 18 13:50:25 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}