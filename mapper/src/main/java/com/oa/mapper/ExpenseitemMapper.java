package com.oa.mapper;

import com.oa.pojo.Expenseitem;
import com.oa.pojo.ExpenseitemExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseitemMapper {
    long countByExample(ExpenseitemExample example);

    int deleteByExample(ExpenseitemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(Expenseitem record);

    int insertSelective(Expenseitem record);

    List<Expenseitem> selectByExample(ExpenseitemExample example);

    Expenseitem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") Expenseitem record, @Param("example") ExpenseitemExample example);

    int updateByExample(@Param("record") Expenseitem record, @Param("example") ExpenseitemExample example);

    int updateByPrimaryKeySelective(Expenseitem record);

    int updateByPrimaryKey(Expenseitem record);
}