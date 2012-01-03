/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

/**
 *
 * @author koduki
 */
public interface MonitorLog {

    public long getCount();

    public void setCount(long count);

    public String getDescription();

    public void setDescription(String description);

    public long getLastSampleTime();

    public void setLastSampleTime(long lastSampleTime);

    public String getName();

    public void setName(String name);

    public long getStartTime();

    public void setStartTime(long startTime);

    public String getUnit();

    public void setUnit(String unit);
}
