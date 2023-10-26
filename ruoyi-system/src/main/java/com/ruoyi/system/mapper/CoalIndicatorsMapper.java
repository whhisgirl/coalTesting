package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CoalIndicators;
import com.ruoyi.system.domain.DO.BatchAndIndicators;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Mapper
public interface CoalIndicatorsMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CoalIndicators selectCoalIndicatorsByCoalNumber(String coalNumber);

    /**
     * 查询【请填写功能名称】
     *
     * @param batchAndIndicators 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<BatchAndIndicators> selectBatchAndIndicatorsList(BatchAndIndicators batchAndIndicators);

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
     * 删除【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCoalIndicatorsByCoalNumber(String coalNumber);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param coalNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCoalIndicatorsByCoalNumbers(String[] coalNumbers);
}
