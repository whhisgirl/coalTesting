package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONObject;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.system.domain.DO.BatchAndIndicators;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CoalIndicators;
import com.ruoyi.system.service.ICoalIndicatorsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@RestController
@RequestMapping("/system/indicators")
public class CoalIndicatorsController extends BaseController
{
    @Autowired
    private ICoalIndicatorsService coalIndicatorsService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoalIndicators coalIndicators)
    {
        startPage();
        List<CoalIndicators> list = coalIndicatorsService.selectCoalIndicatorsList(coalIndicators);
        return getDataTable(list);
    }

    /**
     * 查询指标结果记录和批次
     */
    @GetMapping("/listBatchAndIndicators")
    public R listBatchAndIndicators(BatchAndIndicators batchAndIndicators)
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        List<BatchAndIndicators> list = coalIndicatorsService.selectBatchAndIndicators(batchAndIndicators);
        List<BatchAndIndicators> batchAndIndicatorsList = list.subList(
                pageDomain.getPageSize() * (pageDomain.getPageNum() - 1),
                (pageDomain.getPageNum() * pageDomain.getPageSize()) > list.size() ? list.size() : (pageDomain.getPageSize() * pageDomain.getPageNum())
        );
        JSONObject resObj = new JSONObject();
        resObj.set("total", list.size());
        resObj.set("batchAndIndicatorsList", batchAndIndicatorsList);
        return R.ok(resObj);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CoalIndicators coalIndicators)
    {
        List<CoalIndicators> list = coalIndicatorsService.selectCoalIndicatorsList(coalIndicators);
        ExcelUtil<CoalIndicators> util = new ExcelUtil<CoalIndicators>(CoalIndicators.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:query')")
    @GetMapping(value = "/{coalNumber}")
    public AjaxResult getInfo(@PathVariable("coalNumber") String coalNumber)
    {
        return success(coalIndicatorsService.selectCoalIndicatorsByCoalNumber(coalNumber));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoalIndicators coalIndicators)
    {
        return toAjax(coalIndicatorsService.insertCoalIndicators(coalIndicators));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoalIndicators coalIndicators)
    {
        return toAjax(coalIndicatorsService.updateCoalIndicators(coalIndicators));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{coalNumbers}")
    public AjaxResult remove(@PathVariable String[] coalNumbers)
    {
        return toAjax(coalIndicatorsService.deleteCoalIndicatorsByCoalNumbers(coalNumbers));
    }
}
