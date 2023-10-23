package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Batch;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Mapper
public interface BatchMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param batchNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Batch selectBatchByBatchNumber(String batchNumber);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param batch 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Batch> selectBatchList(Batch batch);

    /**
     * 新增【请填写功能名称】
     *
     * @param batch 【请填写功能名称】
     * @return 结果
     */
    public int insertBatch(Batch batch);

    /**
     * 修改【请填写功能名称】
     *
     * @param batch 【请填写功能名称】
     * @return 结果
     */
    public int updateBatch(Batch batch);

    /**
     * 删除【请填写功能名称】
     *
     * @param batchNumber 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBatchByBatchNumber(String batchNumber);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param batchNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBatchByBatchNumbers(String[] batchNumbers);
}
