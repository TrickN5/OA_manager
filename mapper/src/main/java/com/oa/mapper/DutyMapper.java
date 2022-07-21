package com.oa.mapper;

import com.oa.pojo.Duty;
import com.oa.pojo.DutyExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyMapper {
    long countByExample(DutyExample example);

    int deleteByExample(DutyExample example);

    int deleteByPrimaryKey(Integer dtid);

    int insert(Duty record);

    int insertSelective(Duty record);

    List<Duty> selectByExample(DutyExample example);

    Duty selectByPrimaryKey(Integer dtid);

    int updateByExampleSelective(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByExample(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);
}