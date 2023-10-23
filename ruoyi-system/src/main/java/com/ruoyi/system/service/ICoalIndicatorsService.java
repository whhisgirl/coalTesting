package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CoalIndicators;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public interface ICoalIndicatorsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CoalIndicators selectCoalIndicatorsByCoalNumber(String coalNumber);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param coalIndicators 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CoalIndicators> selectCoalIndicatorsList(CoalIndicators coalIndicators);

    /**
     * 新增【请填写功能名称】
     * 
     * @param coalIndicators 【请填写功能名称】
     * @return 结果
     */
    public int insertCoalIndicators(CoalIndicators coalIndicators);

    /**
     * 修改【请填写功能名称】
     * 
     * @param coalIndicators 【请填写功能名称】
     * @return 结果
     */
    public int updateCoalIndicators(CoalIndicators coalIndicators);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param coalNumbers 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteCoalIndicatorsByCoalNumbers(String[] coalNumbers);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCoalIndicatorsByCoalNumber(String coalNumber);
}
