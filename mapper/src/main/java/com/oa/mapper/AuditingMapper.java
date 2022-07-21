package com.oa.mapper;

import com.oa.pojo.Auditing;
import com.oa.pojo.AuditingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditingMapper {
    long countByExample(AuditingExample example);

    int deleteByExample(AuditingExample example);

    int deleteByPrimaryKey(Integer auditid);

    int insert(Auditing record);

    int insertSelective(Auditing record);

    List<Auditing> selectByExample(AuditingExample example);

    Auditing selectByPrimaryKey(Integer auditid);

    int updateByExampleSelective(@Param("record") Auditing record, @Param("example") AuditingExample example);

    int updateByExample(@Param("record") Auditing record, @Param("example") AuditingExample example);

    int updateByPrimaryKeySelective(Auditing record);

    int updateByPrimaryKey(Auditing record);
}