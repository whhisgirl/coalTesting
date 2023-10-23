package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CoalIndicators;

/**
 * 指标结果记录Service接口
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public interface ICoalIndicatorsService 
{
    /**
     * 查询指标结果记录
     * 
     * @param coalNumber 指标结果记录主键
     * @return 指标结果记录
     */
    public CoalIndicators selectCoalIndicatorsByCoalNumber(String coalNumber);

    /**
     * 查询指标结果记录列表
     * 
     * @param coalIndicators 指标结果记录
     * @return 指标结果记录集合
     */
    public List<CoalIndicators> selectCoalIndicatorsList(CoalIndicators coalIndicators);

    /**
     * 新增指标结果记录
     * 
     * @param coalIndicators 指标结果记录
     * @return 结果
     */
    public int insertCoalIndicators(CoalIndicators coalIndicators);

    /**
     * 修改指标结果记录
     * 
     * @param coalIndicators 指标结果记录
     * @return 结果
     */
    public int updateCoalIndicators(CoalIndicators coalIndicators);

    /**
     * 批量删除指标结果记录
     * 
     * @param coalNumbers 需要删除的指标结果记录主键集合
     * @return 结果
     */
    public int deleteCoalIndicatorsByCoalNumbers(String[] coalNumbers);

    /**
     * 删除指标结果记录信息
     * 
     * @param coalNumber 指标结果记录主键
     * @return 结果
     */
    public int deleteCoalIndicatorsByCoalNumber(String coalNumber);
}
