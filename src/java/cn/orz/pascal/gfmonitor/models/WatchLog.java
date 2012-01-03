/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author koduki
 */
@Entity
public class WatchLog implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String unit;
    private String description;
    private long count;
    private long startTime;
    private long lastSampleTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLastSampleTime() {
        return lastSampleTime;
    }

    public void setLastSampleTime(long lastSampleTime) {
        this.lastSampleTime = lastSampleTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 37 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        hash = 37 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 37 * hash + (int) (this.count ^ (this.count >>> 32));
        hash = 37 * hash + (int) (this.startTime ^ (this.startTime >>> 32));
        hash = 37 * hash + (int) (this.lastSampleTime ^ (this.lastSampleTime >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WatchLog other = (WatchLog) obj;
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
        if (this.count != other.count) {
            return false;
        }
        if (this.startTime != other.startTime) {
            return false;
        }
        if (this.lastSampleTime != other.lastSampleTime) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WatchLog{" + "id=" + id + ", name=" + name + ", unit=" + unit + ", description=" + description + ", count=" + count + ", startTime=" + startTime + ", lastSampleTime=" + lastSampleTime + '}';
    }
}
