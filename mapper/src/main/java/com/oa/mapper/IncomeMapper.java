package com.oa.mapper;

import com.oa.commons.IncomeData;
import com.oa.pojo.Income;
import com.oa.pojo.IncomeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeMapper {
    long countByExample(IncomeExample example);

    int deleteByExample(IncomeExample example);

    int deleteByPrimaryKey(Integer icid);

    int insert(Income record);

    int insertSelective(Income record);

    List<Income> selectByExample(IncomeExample example);

    Income selectByPrimaryKey(Integer icid);

    int updateByExampleSelective(@Param("record") Income record, @Param("example") IncomeExample example);

    int updateByExample(@Param("record") Income record, @Param("example") IncomeExample example);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);

    public List<IncomeData> getIncomeDatas();
}