package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CoalRegistrationMapper;
import com.ruoyi.system.domain.CoalRegistration;
import com.ruoyi.system.service.ICoalRegistrationService;

/**
 * 指标结果记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class CoalRegistrationServiceImpl implements ICoalRegistrationService 
{
    @Autowired
    private CoalRegistrationMapper coalRegistrationMapper;

    /**
     * 查询指标结果记录
     * 
     * @param coalNumber 指标结果记录主键
     * @return 指标结果记录
     */
    @Override
    public CoalRegistration selectCoalRegistrationByCoalNumber(String coalNumber)
    {
        return coalRegistrationMapper.selectCoalRegistrationByCoalNumber(coalNumber);
    }

    /**
     * 查询指标结果记录列表
     * 
     * @param coalRegistration 指标结果记录
     * @return 指标结果记录
     */
    @Override
    public List<CoalRegistration> selectCoalRegistrationList(CoalRegistration coalRegistration)
    {
        return coalRegistrationMapper.selectCoalRegistrationList(coalRegistration);
    }

    /**
     * 新增指标结果记录
     * 
     * @param coalRegistration 指标结果记录
     * @return 结果
     */
    @Override
    public int insertCoalRegistration(CoalRegistration coalRegistration)
    {
        return coalRegistrationMapper.insertCoalRegistration(coalRegistration);
    }

    /**
     * 修改指标结果记录
     * 
     * @param coalRegistration 指标结果记录
     * @return 结果
     */
    @Override
    public int updateCoalRegistration(CoalRegistration coalRegistration)
    {
        return coalRegistrationMapper.updateCoalRegistration(coalRegistration);
    }

    /**
     * 批量删除指标结果记录
     * 
     * @param coalNumbers 需要删除的指标结果记录主键
     * @return 结果
     */
    @Override
    public int deleteCoalRegistrationByCoalNumbers(String[] coalNumbers)
    {
        return coalRegistrationMapper.deleteCoalRegistrationByCoalNumbers(coalNumbers);
    }

    /**
     * 删除指标结果记录信息
     * 
     * @param coalNumber 指标结果记录主键
     * @return 结果
     */
    @Override
    public int deleteCoalRegistrationByCoalNumber(String coalNumber)
    {
        return coalRegistrationMapper.deleteCoalRegistrationByCoalNumber(coalNumber);
    }
}
