package com.oa.manage.service;


import com.oa.pojo.Position;

import java.sql.SQLIntegrityConstraintViolationException;

import java.util.Map;

public interface PositionService {
    int addPosition(Position position);

    Position checkPositionNo(int posid);

    Position checkPositionName(String pname);

    Map<String, Object> selectAllPositions(int page, int rows);

    long getTotal();

    int updatePosition(Position position);

    int deletePositionByNo(int posid) throws SQLIntegrityConstraintViolationException;
}
