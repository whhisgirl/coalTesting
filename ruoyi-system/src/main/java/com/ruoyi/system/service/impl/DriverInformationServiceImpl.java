package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DriverInformationMapper;
import com.ruoyi.system.domain.DriverInformation;
import com.ruoyi.system.service.IDriverInformationService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class DriverInformationServiceImpl implements IDriverInformationService 
{
    @Autowired
    private DriverInformationMapper driverInformationMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DriverInformation selectDriverInformationById(Integer id)
    {
        return driverInformationMapper.selectDriverInformationById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param driverInformation 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DriverInformation> selectDriverInformationList(DriverInformation driverInformation)
    {
        return driverInformationMapper.selectDriverInformationList(driverInformation);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param driverInformation 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDriverInformation(DriverInformation driverInformation)
    {
        return driverInformationMapper.insertDriverInformation(driverInformation);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param driverInformation 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDriverInformation(DriverInformation driverInformation)
    {
        return driverInformationMapper.updateDriverInformation(driverInformation);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDriverInformationByIds(Integer[] ids)
    {
        return driverInformationMapper.deleteDriverInformationByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDriverInformationById(Integer id)
    {
        return driverInformationMapper.deleteDriverInformationById(id);
    }
}
