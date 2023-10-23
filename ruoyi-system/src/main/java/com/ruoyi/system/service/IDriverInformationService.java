package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DriverInformation;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public interface IDriverInformationService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DriverInformation selectDriverInformationById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param driverInformation 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DriverInformation> selectDriverInformationList(DriverInformation driverInformation);

    /**
     * 新增【请填写功能名称】
     * 
     * @param driverInformation 【请填写功能名称】
     * @return 结果
     */
    public int insertDriverInformation(DriverInformation driverInformation);

    /**
     * 修改【请填写功能名称】
     * 
     * @param driverInformation 【请填写功能名称】
     * @return 结果
     */
    public int updateDriverInformation(DriverInformation driverInformation);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDriverInformationByIds(Integer[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDriverInformationById(Integer id);
}
