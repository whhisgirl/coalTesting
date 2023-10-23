package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DriverInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Mapper
public interface DriverInformationMapper
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
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDriverInformationById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDriverInformationByIds(Integer[] ids);
}
