package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CoalIndicatorsMapper;
import com.ruoyi.system.domain.CoalIndicators;
import com.ruoyi.system.service.ICoalIndicatorsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class CoalIndicatorsServiceImpl implements ICoalIndicatorsService 
{
    @Autowired
    private CoalIndicatorsMapper coalIndicatorsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public CoalIndicators selectCoalIndicatorsByCoalNumber(String coalNumber)
    {
        return coalIndicatorsMapper.selectCoalIndicatorsByCoalNumber(coalNumber);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param coalIndicators 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CoalIndicators> selectCoalIndicatorsList(CoalIndicators coalIndicators)
    {
        return coalIndicatorsMapper.selectCoalIndicatorsList(coalIndicators);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param coalIndicators 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCoalIndicators(CoalIndicators coalIndicators)
    {
        return coalIndicatorsMapper.insertCoalIndicators(coalIndicators);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param coalIndicators 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCoalIndicators(CoalIndicators coalIndicators)
    {
        return coalIndicatorsMapper.updateCoalIndicators(coalIndicators);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param coalNumbers 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCoalIndicatorsByCoalNumbers(String[] coalNumbers)
    {
        return coalIndicatorsMapper.deleteCoalIndicatorsByCoalNumbers(coalNumbers);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCoalIndicatorsByCoalNumber(String coalNumber)
    {
        return coalIndicatorsMapper.deleteCoalIndicatorsByCoalNumber(coalNumber);
    }
}
