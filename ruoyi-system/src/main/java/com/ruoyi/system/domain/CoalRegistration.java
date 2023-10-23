package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 coal_registration
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public class CoalRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 煤采样编号 */
    private String coalNumber;

    /** 煤采样时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "煤采样时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sampleTime;

    /** 采样标准号 */
    @Excel(name = "采样标准号")
    private String standardNumber;

    /** 样品粒度 */
    @Excel(name = "样品粒度")
    private String sampleStrength;

    /** 采样方式 */
    @Excel(name = "采样方式")
    private String samplingMethod;

    /** 矿区名称 */
    @Excel(name = "矿区名称")
    private String miningAreaName;

    /** 采样人 */
    @Excel(name = "采样人")
    private String sampler;

    /** 采样照片（出发前） */
    @Excel(name = "采样照片", readConverterExp = "出=发前")
    private String pictureBefore;

    /** 采样照片（到达目的地） */
    @Excel(name = "采样照片", readConverterExp = "到=达目的地")
    private String pictureAfter;

    /** 报告生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报告生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportTime;

    /** 检测标准号 */
    @Excel(name = "检测标准号")
    private String testStandardNumber;

    public void setCoalNumber(String coalNumber) 
    {
        this.coalNumber = coalNumber;
    }

    public String getCoalNumber() 
    {
        return coalNumber;
    }
    public void setSampleTime(Date sampleTime) 
    {
        this.sampleTime = sampleTime;
    }

    public Date getSampleTime() 
    {
        return sampleTime;
    }
    public void setStandardNumber(String standardNumber) 
    {
        this.standardNumber = standardNumber;
    }

    public String getStandardNumber() 
    {
        return standardNumber;
    }
    public void setSampleStrength(String sampleStrength) 
    {
        this.sampleStrength = sampleStrength;
    }

    public String getSampleStrength() 
    {
        return sampleStrength;
    }
    public void setSamplingMethod(String samplingMethod) 
    {
        this.samplingMethod = samplingMethod;
    }

    public String getSamplingMethod() 
    {
        return samplingMethod;
    }
    public void setMiningAreaName(String miningAreaName) 
    {
        this.miningAreaName = miningAreaName;
    }

    public String getMiningAreaName() 
    {
        return miningAreaName;
    }
    public void setSampler(String sampler) 
    {
        this.sampler = sampler;
    }

    public String getSampler() 
    {
        return sampler;
    }
    public void setPictureBefore(String pictureBefore) 
    {
        this.pictureBefore = pictureBefore;
    }

    public String getPictureBefore() 
    {
        return pictureBefore;
    }
    public void setPictureAfter(String pictureAfter) 
    {
        this.pictureAfter = pictureAfter;
    }

    public String getPictureAfter() 
    {
        return pictureAfter;
    }
    public void setReportTime(Date reportTime) 
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime() 
    {
        return reportTime;
    }
    public void setTestStandardNumber(String testStandardNumber) 
    {
        this.testStandardNumber = testStandardNumber;
    }

    public String getTestStandardNumber() 
    {
        return testStandardNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("coalNumber", getCoalNumber())
            .append("sampleTime", getSampleTime())
            .append("standardNumber", getStandardNumber())
            .append("sampleStrength", getSampleStrength())
            .append("samplingMethod", getSamplingMethod())
            .append("miningAreaName", getMiningAreaName())
            .append("sampler", getSampler())
            .append("pictureBefore", getPictureBefore())
            .append("pictureAfter", getPictureAfter())
            .append("reportTime", getReportTime())
            .append("testStandardNumber", getTestStandardNumber())
            .toString();
    }
}
