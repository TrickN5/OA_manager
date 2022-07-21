package com.oa.mapper;

import com.oa.pojo.Expense;
import com.oa.pojo.ExpenseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseMapper {
    long countByExample(ExpenseExample example);

    int deleteByExample(ExpenseExample example);

    int deleteByPrimaryKey(Integer expid);

    int insert(Expense record);

    int insertSelective(Expense record);

    List<Expense> selectByExample(ExpenseExample example);

    Expense selectByPrimaryKey(Integer expid);

    int updateByExampleSelective(@Param("record") Expense record, @Param("example") ExpenseExample example);

    int updateByExample(@Param("record") Expense record, @Param("example") ExpenseExample example);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);
}