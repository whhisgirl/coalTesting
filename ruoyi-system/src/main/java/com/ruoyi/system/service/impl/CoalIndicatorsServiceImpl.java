package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CoalIndicatorsMapper;
import com.ruoyi.system.domain.CoalIndicators;
import com.ruoyi.system.service.ICoalIndicatorsService;

/**
 * 指标结果记录Service业务层处理
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
     * 查询指标结果记录
     * 
     * @param coalNumber 指标结果记录主键
     * @return 指标结果记录
     */
    @Override
    public CoalIndicators selectCoalIndicatorsByCoalNumber(String coalNumber)
    {
        return coalIndicatorsMapper.selectCoalIndicatorsByCoalNumber(coalNumber);
    }

    /**
     * 查询指标结果记录列表
     * 
     * @param coalIndicators 指标结果记录
     * @return 指标结果记录
     */
    @Override
    public List<CoalIndicators> selectCoalIndicatorsList(CoalIndicators coalIndicators)
    {
        return coalIndicatorsMapper.selectCoalIndicatorsList(coalIndicators);
    }

    /**
     * 新增指标结果记录
     * 
     * @param coalIndicators 指标结果记录
     * @return 结果
     */
    @Override
    public int insertCoalIndicators(CoalIndicators coalIndicators)
    {
        return coalIndicatorsMapper.insertCoalIndicators(coalIndicators);
    }

    /**
     * 修改指标结果记录
     * 
     * @param coalIndicators 指标结果记录
     * @return 结果
     */
    @Override
    public int updateCoalIndicators(CoalIndicators coalIndicators)
    {
        return coalIndicatorsMapper.updateCoalIndicators(coalIndicators);
    }

    /**
     * 批量删除指标结果记录
     * 
     * @param coalNumbers 需要删除的指标结果记录主键
     * @return 结果
     */
    @Override
    public int deleteCoalIndicatorsByCoalNumbers(String[] coalNumbers)
    {
        return coalIndicatorsMapper.deleteCoalIndicatorsByCoalNumbers(coalNumbers);
    }

    /**
     * 删除指标结果记录信息
     * 
     * @param coalNumber 指标结果记录主键
     * @return 结果
     */
    @Override
    public int deleteCoalIndicatorsByCoalNumber(String coalNumber)
    {
        return coalIndicatorsMapper.deleteCoalIndicatorsByCoalNumber(coalNumber);
    }
}
