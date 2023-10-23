package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 driver_information
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public class DriverInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Integer id;

    /** 司机姓名 */
    @Excel(name = "司机姓名")
    private String driverName;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String driverLicensePlate;

    /** 司机年龄 */
    @Excel(name = "司机年龄")
    private String driverAge;

    /** 司机驾龄 */
    @Excel(name = "司机驾龄")
    private String driverExperience;

    /** 司机信用 */
    @Excel(name = "司机信用")
    private String driverCredit;

    /** 车型 */
    @Excel(name = "车型")
    private String vehicleModel;

    /** 荷载（车能装多少） */
    @Excel(name = "荷载", readConverterExp = "车=能装多少")
    private String vehicleLoad;

    /** 车辆使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车辆使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vehicleUsageTime;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setDriverLicensePlate(String driverLicensePlate) 
    {
        this.driverLicensePlate = driverLicensePlate;
    }

    public String getDriverLicensePlate() 
    {
        return driverLicensePlate;
    }
    public void setDriverAge(String driverAge) 
    {
        this.driverAge = driverAge;
    }

    public String getDriverAge() 
    {
        return driverAge;
    }
    public void setDriverExperience(String driverExperience) 
    {
        this.driverExperience = driverExperience;
    }

    public String getDriverExperience() 
    {
        return driverExperience;
    }
    public void setDriverCredit(String driverCredit) 
    {
        this.driverCredit = driverCredit;
    }

    public String getDriverCredit() 
    {
        return driverCredit;
    }
    public void setVehicleModel(String vehicleModel) 
    {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleModel() 
    {
        return vehicleModel;
    }
    public void setVehicleLoad(String vehicleLoad) 
    {
        this.vehicleLoad = vehicleLoad;
    }

    public String getVehicleLoad() 
    {
        return vehicleLoad;
    }
    public void setVehicleUsageTime(Date vehicleUsageTime) 
    {
        this.vehicleUsageTime = vehicleUsageTime;
    }

    public Date getVehicleUsageTime() 
    {
        return vehicleUsageTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("driverName", getDriverName())
            .append("driverLicensePlate", getDriverLicensePlate())
            .append("driverAge", getDriverAge())
            .append("driverExperience", getDriverExperience())
            .append("driverCredit", getDriverCredit())
            .append("vehicleModel", getVehicleModel())
            .append("vehicleLoad", getVehicleLoad())
            .append("vehicleUsageTime", getVehicleUsageTime())
            .toString();
    }
}
