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
import com.ruoyi.system.domain.CoalRegistration;
import com.ruoyi.system.service.ICoalRegistrationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 指标结果记录Controller
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
@RestController
@RequestMapping("/system/registration")
public class CoalRegistrationController extends BaseController
{
    @Autowired
    private ICoalRegistrationService coalRegistrationService;

    /**
     * 查询指标结果记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:registration:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoalRegistration coalRegistration)
    {
        startPage();
        List<CoalRegistration> list = coalRegistrationService.selectCoalRegistrationList(coalRegistration);
        return getDataTable(list);
    }

    /**
     * 导出指标结果记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:registration:export')")
    @Log(title = "指标结果记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CoalRegistration coalRegistration)
    {
        List<CoalRegistration> list = coalRegistrationService.selectCoalRegistrationList(coalRegistration);
        ExcelUtil<CoalRegistration> util = new ExcelUtil<CoalRegistration>(CoalRegistration.class);
        util.exportExcel(response, list, "指标结果记录数据");
    }

    /**
     * 获取指标结果记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:registration:query')")
    @GetMapping(value = "/{coalNumber}")
    public AjaxResult getInfo(@PathVariable("coalNumber") String coalNumber)
    {
        return success(coalRegistrationService.selectCoalRegistrationByCoalNumber(coalNumber));
    }

    /**
     * 新增指标结果记录
     */
    @PreAuthorize("@ss.hasPermi('system:registration:add')")
    @Log(title = "指标结果记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoalRegistration coalRegistration)
    {
        return toAjax(coalRegistrationService.insertCoalRegistration(coalRegistration));
    }

    /**
     * 修改指标结果记录
     */
    @PreAuthorize("@ss.hasPermi('system:registration:edit')")
    @Log(title = "指标结果记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoalRegistration coalRegistration)
    {
        return toAjax(coalRegistrationService.updateCoalRegistration(coalRegistration));
    }

    /**
     * 删除指标结果记录
     */
    @PreAuthorize("@ss.hasPermi('system:registration:remove')")
    @Log(title = "指标结果记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{coalNumbers}")
    public AjaxResult remove(@PathVariable String[] coalNumbers)
    {
        return toAjax(coalRegistrationService.deleteCoalRegistrationByCoalNumbers(coalNumbers));
    }
}
