package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CoalListMapper;
import com.ruoyi.system.domain.CoalList;
import com.ruoyi.system.service.ICoalListService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class CoalListServiceImpl implements ICoalListService {
    @Autowired
    private CoalListMapper coalListMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public CoalList selectCoalListByCoalNumber(String coalNumber) {
        return coalListMapper.selectCoalListByCoalNumber(coalNumber);
    }
    /**
     * 查询【请填写功能名称】列表
     *
     * @param coalList 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CoalList> selectCoalList(CoalList coalList) {
        return coalListMapper.selectCoalList(coalList);
    }
}

