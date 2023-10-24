package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CoalRegistration;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public interface ICoalRegistrationService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CoalRegistration selectCoalRegistrationByCoalNumber(String coalNumber);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param coalRegistration 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CoalRegistration> selectCoalRegistrationList(CoalRegistration coalRegistration);

    /**
     * 新增【请填写功能名称】
     * 
     * @param coalRegistration 【请填写功能名称】
     * @return 结果
     */
    public int insertCoalRegistration(CoalRegistration coalRegistration);

    /**
     * 修改【请填写功能名称】
     * 
     * @param coalRegistration 【请填写功能名称】
     * @return 结果
     */
    public int updateCoalRegistration(CoalRegistration coalRegistration);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param coalNumbers 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteCoalRegistrationByCoalNumbers(String[] coalNumbers);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCoalRegistrationByCoalNumber(String coalNumber);
}
