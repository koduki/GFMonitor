/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models.entity.servermonitor;

import cn.orz.pascal.gfmonitor.models.entity.MonitorAverageLog;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author koduki
 */
@Entity
public class Activeservletsloadedcount implements Serializable, MonitorAverageLog {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String unit;
    private String description;
    private Long currentValue;
    private Long highWaterMark;
    private Long lowWaterMark;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date lastSampleTime;

    public Activeservletsloadedcount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getCurrentValue() {
        return currentValue;
    }

    @Override
    public void setCurrentValue(Long current) {
        this.currentValue = current;
    }

    @Override
    public Long getHighWaterMark() {
        return highWaterMark;
    }

    @Override
    public void setHighWaterMark(Long highWaterMark) {
        this.highWaterMark = highWaterMark;
    }

    @Override
    public Long getLowWaterMark() {
        return lowWaterMark;
    }

    @Override
    public void setLowWaterMark(Long lowWaterMark) {
        this.lowWaterMark = lowWaterMark;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getLastSampleTime() {
        return lastSampleTime;
    }

    @Override
    public void setLastSampleTime(Date lastSampleTime) {
        this.lastSampleTime = lastSampleTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Activeservletsloadedcount other = (Activeservletsloadedcount) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.unit == null) ? (other.unit != null) : !this.unit.equals(other.unit)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if (this.currentValue != other.currentValue && (this.currentValue == null || !this.currentValue.equals(other.currentValue))) {
            return false;
        }
        if (this.highWaterMark != other.highWaterMark && (this.highWaterMark == null || !this.highWaterMark.equals(other.highWaterMark))) {
            return false;
        }
        if (this.lowWaterMark != other.lowWaterMark && (this.lowWaterMark == null || !this.lowWaterMark.equals(other.lowWaterMark))) {
            return false;
        }
        if (this.startTime != other.startTime && (this.startTime == null || !this.startTime.equals(other.startTime))) {
            return false;
        }
        if (this.lastSampleTime != other.lastSampleTime && (this.lastSampleTime == null || !this.lastSampleTime.equals(other.lastSampleTime))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        hash = 17 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 17 * hash + (this.currentValue != null ? this.currentValue.hashCode() : 0);
        hash = 17 * hash + (this.highWaterMark != null ? this.highWaterMark.hashCode() : 0);
        hash = 17 * hash + (this.lowWaterMark != null ? this.lowWaterMark.hashCode() : 0);
        hash = 17 * hash + (this.startTime != null ? this.startTime.hashCode() : 0);
        hash = 17 * hash + (this.lastSampleTime != null ? this.lastSampleTime.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" + "id=" + id + ", name=" + name + ", unit=" + unit + ", description=" + description + ", current=" + currentValue + ", highWaterMark=" + highWaterMark + ", lowWaterMark=" + lowWaterMark + ", startTime=" + startTime + ", lastSampleTime=" + lastSampleTime + '}';
    }
}
