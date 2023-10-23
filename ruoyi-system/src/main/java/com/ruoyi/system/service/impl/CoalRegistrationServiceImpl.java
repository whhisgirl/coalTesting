package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CoalRegistrationMapper;
import com.ruoyi.system.domain.CoalRegistration;
import com.ruoyi.system.service.ICoalRegistrationService;

/**
 * 【请填写功能名称】Service业务层处理
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
     * 查询【请填写功能名称】
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public CoalRegistration selectCoalRegistrationByCoalNumber(String coalNumber)
    {
        return coalRegistrationMapper.selectCoalRegistrationByCoalNumber(coalNumber);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param coalRegistration 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CoalRegistration> selectCoalRegistrationList(CoalRegistration coalRegistration)
    {
        return coalRegistrationMapper.selectCoalRegistrationList(coalRegistration);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param coalRegistration 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCoalRegistration(CoalRegistration coalRegistration)
    {
        return coalRegistrationMapper.insertCoalRegistration(coalRegistration);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param coalRegistration 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCoalRegistration(CoalRegistration coalRegistration)
    {
        return coalRegistrationMapper.updateCoalRegistration(coalRegistration);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param coalNumbers 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCoalRegistrationByCoalNumbers(String[] coalNumbers)
    {
        return coalRegistrationMapper.deleteCoalRegistrationByCoalNumbers(coalNumbers);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param coalNumber 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCoalRegistrationByCoalNumber(String coalNumber)
    {
        return coalRegistrationMapper.deleteCoalRegistrationByCoalNumber(coalNumber);
    }
}
