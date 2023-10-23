package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BatchMapper;
import com.ruoyi.system.domain.Batch;
import com.ruoyi.system.service.IBatchService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
@Service
public class BatchServiceImpl implements IBatchService 
{
    @Autowired
    private BatchMapper batchMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param batchNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Batch selectBatchByBatchNumber(String batchNumber)
    {
        return batchMapper.selectBatchByBatchNumber(batchNumber);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param batch 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Batch> selectBatchList(Batch batch)
    {
        return batchMapper.selectBatchList(batch);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param batch 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBatch(Batch batch)
    {
        return batchMapper.insertBatch(batch);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param batch 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBatch(Batch batch)
    {
        return batchMapper.updateBatch(batch);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param batchNumbers 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBatchByBatchNumbers(String[] batchNumbers)
    {
        return batchMapper.deleteBatchByBatchNumbers(batchNumbers);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param batchNumber 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBatchByBatchNumber(String batchNumber)
    {
        return batchMapper.deleteBatchByBatchNumber(batchNumber);
    }
}
