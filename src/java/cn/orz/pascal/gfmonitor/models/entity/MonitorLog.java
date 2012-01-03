/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models.entity;

import java.util.Date;

/**
 *
 * @author koduki
 */
public interface MonitorLog {

    public long getCount();

    public void setCount(long count);

    public String getDescription();

    public void setDescription(String description);

    public Date getLastSampleTime();

    public void setLastSampleTime(Date lastSampleTime);

    public String getName();

    public void setName(String name);

    public Date getStartTime();

    public void setStartTime(Date startTime);

    public String getUnit();

    public void setUnit(String unit);
}
