package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CoalRegistration;

/**
 * 指标结果记录Service接口
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public interface ICoalRegistrationService 
{
    /**
     * 查询指标结果记录
     * 
     * @param coalNumber 指标结果记录主键
     * @return 指标结果记录
     */
    public CoalRegistration selectCoalRegistrationByCoalNumber(String coalNumber);

    /**
     * 查询指标结果记录列表
     * 
     * @param coalRegistration 指标结果记录
     * @return 指标结果记录集合
     */
    public List<CoalRegistration> selectCoalRegistrationList(CoalRegistration coalRegistration);

    /**
     * 新增指标结果记录
     * 
     * @param coalRegistration 指标结果记录
     * @return 结果
     */
    public int insertCoalRegistration(CoalRegistration coalRegistration);

    /**
     * 修改指标结果记录
     * 
     * @param coalRegistration 指标结果记录
     * @return 结果
     */
    public int updateCoalRegistration(CoalRegistration coalRegistration);

    /**
     * 批量删除指标结果记录
     * 
     * @param coalNumbers 需要删除的指标结果记录主键集合
     * @return 结果
     */
    public int deleteCoalRegistrationByCoalNumbers(String[] coalNumbers);

    /**
     * 删除指标结果记录信息
     * 
     * @param coalNumber 指标结果记录主键
     * @return 结果
     */
    public int deleteCoalRegistrationByCoalNumber(String coalNumber);
}
