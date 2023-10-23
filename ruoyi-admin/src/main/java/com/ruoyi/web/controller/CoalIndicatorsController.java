package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
 * 指标结果记录Controller
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
     * 查询指标结果记录列表
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
     * 导出指标结果记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:export')")
    @Log(title = "指标结果记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CoalIndicators coalIndicators)
    {
        List<CoalIndicators> list = coalIndicatorsService.selectCoalIndicatorsList(coalIndicators);
        ExcelUtil<CoalIndicators> util = new ExcelUtil<CoalIndicators>(CoalIndicators.class);
        util.exportExcel(response, list, "指标结果记录数据");
    }

    /**
     * 获取指标结果记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:query')")
    @GetMapping(value = "/{coalNumber}")
    public AjaxResult getInfo(@PathVariable("coalNumber") String coalNumber)
    {
        return success(coalIndicatorsService.selectCoalIndicatorsByCoalNumber(coalNumber));
    }

    /**
     * 新增指标结果记录
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:add')")
    @Log(title = "指标结果记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoalIndicators coalIndicators)
    {
        return toAjax(coalIndicatorsService.insertCoalIndicators(coalIndicators));
    }

    /**
     * 修改指标结果记录
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:edit')")
    @Log(title = "指标结果记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoalIndicators coalIndicators)
    {
        return toAjax(coalIndicatorsService.updateCoalIndicators(coalIndicators));
    }

    /**
     * 删除指标结果记录
     */
    @PreAuthorize("@ss.hasPermi('system:indicators:remove')")
    @Log(title = "指标结果记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{coalNumbers}")
    public AjaxResult remove(@PathVariable String[] coalNumbers)
    {
        return toAjax(coalIndicatorsService.deleteCoalIndicatorsByCoalNumbers(coalNumbers));
    }
}
