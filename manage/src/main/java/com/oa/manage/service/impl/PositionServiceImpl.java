package com.oa.manage.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.manage.service.PositionService;

import com.oa.mapper.PositionMapper;

import com.oa.pojo.Position;
import com.oa.pojo.PositionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;

    @Override
    public int addPosition(Position position) {
        int n = positionMapper.insert(position);
        return n;
    }

    @Override
    public Position checkPositionNo(int posid) {
        Position position = positionMapper.selectByPrimaryKey(posid);
        return position;
    }

    @Override
    public Position checkPositionName(String pname) {
        PositionExample exp = new PositionExample();
        exp.createCriteria().andPnameEqualTo(pname);
        List<Position> positions = positionMapper.selectByExample(exp);
        if (positions != null && positions.size() == 1) {
            return positions.get(0);
        }
        return null;

    }

    @Override
    public Map<String, Object> selectAllPositions(int page, int rows) {
        //使用分页
        PageHelper.startPage(page, rows);
        List<Position> positions = positionMapper.selectByExample(null);
        PageInfo<Position> info = new PageInfo<>(positions);
        //当前页码
        int pageNum = info.getPageNum();
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("positions", info.getList());
        return map;
    }

    @Override
    public long getTotal() {
        long l = positionMapper.countByExample(null);
        return l;
    }

    @Override
    public int updatePosition(Position position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    @Override
    public int deletePositionByNo(int posid) throws SQLIntegrityConstraintViolationException {
        int n;
        try {
            n = positionMapper.deleteByPrimaryKey(posid);
        } catch (Exception e) {
            throw new SQLIntegrityConstraintViolationException("有外键");
        }
        return n;
    }

}