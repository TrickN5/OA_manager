package com.oa.mapper;

import com.oa.pojo.Expimage;
import com.oa.pojo.ExpimageExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpimageMapper {
    long countByExample(ExpimageExample example);

    int deleteByExample(ExpimageExample example);

    int deleteByPrimaryKey(Integer imgid);

    int insert(Expimage record);

    int insertSelective(Expimage record);

    List<Expimage> selectByExample(ExpimageExample example);

    Expimage selectByPrimaryKey(Integer imgid);

    int updateByExampleSelective(@Param("record") Expimage record, @Param("example") ExpimageExample example);

    int updateByExample(@Param("record") Expimage record, @Param("example") ExpimageExample example);

    int updateByPrimaryKeySelective(Expimage record);

    int updateByPrimaryKey(Expimage record);
}