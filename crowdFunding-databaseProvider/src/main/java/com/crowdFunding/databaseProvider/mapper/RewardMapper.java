package com.crowdFunding.databaseProvider.mapper;

import com.crowdFunding.databaseProvider.model.Reward;
import com.crowdFunding.databaseProvider.model.RewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RewardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    long countByExample(RewardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int deleteByExample(RewardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int insert(Reward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int insertSelective(Reward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    List<Reward> selectByExample(RewardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    Reward selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int updateByExampleSelective(@Param("record") Reward record, @Param("example") RewardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int updateByExample(@Param("record") Reward record, @Param("example") RewardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int updateByPrimaryKeySelective(Reward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reward
     *
     * @mbg.generated Thu Jan 30 00:02:39 CST 2020
     */
    int updateByPrimaryKey(Reward record);
}