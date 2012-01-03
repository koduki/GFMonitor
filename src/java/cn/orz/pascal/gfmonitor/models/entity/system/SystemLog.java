/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models.entity.system;

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
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    private Integer availableProcessors;
    private Double systemLoadAverage;
    private Long heapMemoryUsageCommitted;
    private Long heapMemoryUsageMax;
    private Long heapMemoryUsageUsed;
    private Long heapMemoryUsageInit;
    private Long nonHeapMemoryUsageCommitted;
    private Long nonHeapMemoryUsageMax;
    private Long nonHeapMemoryUsageUsed;
    private Long nonHeapMemoryUsageInit;
    private Integer objectPendingFinalizationCount;
    private Integer threadCount;
    private Integer loadedClassCount;
    private Long totalLoadedClassCount;
    private Long unloadedClassCount;

    public Integer getAvailableProcessors() {
        return availableProcessors;
    }

    public void setAvailableProcessors(Integer availableProcessors) {
        this.availableProcessors = availableProcessors;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getHeapMemoryUsageCommitted() {
        return heapMemoryUsageCommitted;
    }

    public void setHeapMemoryUsageCommitted(Long heapMemoryUsageCommitted) {
        this.heapMemoryUsageCommitted = heapMemoryUsageCommitted;
    }

    public Long getHeapMemoryUsageInit() {
        return heapMemoryUsageInit;
    }

    public void setHeapMemoryUsageInit(Long heapMemoryUsageInit) {
        this.heapMemoryUsageInit = heapMemoryUsageInit;
    }

    public Long getHeapMemoryUsageMax() {
        return heapMemoryUsageMax;
    }

    public void setHeapMemoryUsageMax(Long heapMemoryUsageMax) {
        this.heapMemoryUsageMax = heapMemoryUsageMax;
    }

    public Long getHeapMemoryUsageUsed() {
        return heapMemoryUsageUsed;
    }

    public void setHeapMemoryUsageUsed(Long heapMemoryUsageUsed) {
        this.heapMemoryUsageUsed = heapMemoryUsageUsed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLoadedClassCount() {
        return loadedClassCount;
    }

    public void setLoadedClassCount(Integer loadedClassCount) {
        this.loadedClassCount = loadedClassCount;
    }

    public Long getNonHeapMemoryUsageCommitted() {
        return nonHeapMemoryUsageCommitted;
    }

    public void setNonHeapMemoryUsageCommitted(Long nonHeapMemoryUsageCommitted) {
        this.nonHeapMemoryUsageCommitted = nonHeapMemoryUsageCommitted;
    }

    public Long getNonHeapMemoryUsageInit() {
        return nonHeapMemoryUsageInit;
    }

    public void setNonHeapMemoryUsageInit(Long nonHeapMemoryUsageInit) {
        this.nonHeapMemoryUsageInit = nonHeapMemoryUsageInit;
    }

    public Long getNonHeapMemoryUsageMax() {
        return nonHeapMemoryUsageMax;
    }

    public void setNonHeapMemoryUsageMax(Long nonHeapMemoryUsageMax) {
        this.nonHeapMemoryUsageMax = nonHeapMemoryUsageMax;
    }

    public Long getNonHeapMemoryUsageUsed() {
        return nonHeapMemoryUsageUsed;
    }

    public void setNonHeapMemoryUsageUsed(Long nonHeapMemoryUsageUsed) {
        this.nonHeapMemoryUsageUsed = nonHeapMemoryUsageUsed;
    }

    public Integer getObjectPendingFinalizationCount() {
        return objectPendingFinalizationCount;
    }

    public void setObjectPendingFinalizationCount(Integer objectPendingFinalizationCount) {
        this.objectPendingFinalizationCount = objectPendingFinalizationCount;
    }

    public Double getSystemLoadAverage() {
        return systemLoadAverage;
    }

    public void setSystemLoadAverage(Double systemLoadAverage) {
        this.systemLoadAverage = systemLoadAverage;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public Long getTotalLoadedClassCount() {
        return totalLoadedClassCount;
    }

    public void setTotalLoadedClassCount(Long totalLoadedClassCount) {
        this.totalLoadedClassCount = totalLoadedClassCount;
    }

    public Long getUnloadedClassCount() {
        return unloadedClassCount;
    }

    public void setUnloadedClassCount(Long unloadedClassCount) {
        this.unloadedClassCount = unloadedClassCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemLog other = (SystemLog) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.createdAt != other.createdAt && (this.createdAt == null || !this.createdAt.equals(other.createdAt))) {
            return false;
        }
        if (this.availableProcessors != other.availableProcessors && (this.availableProcessors == null || !this.availableProcessors.equals(other.availableProcessors))) {
            return false;
        }
        if (this.systemLoadAverage != other.systemLoadAverage && (this.systemLoadAverage == null || !this.systemLoadAverage.equals(other.systemLoadAverage))) {
            return false;
        }
        if (this.heapMemoryUsageCommitted != other.heapMemoryUsageCommitted && (this.heapMemoryUsageCommitted == null || !this.heapMemoryUsageCommitted.equals(other.heapMemoryUsageCommitted))) {
            return false;
        }
        if (this.heapMemoryUsageMax != other.heapMemoryUsageMax && (this.heapMemoryUsageMax == null || !this.heapMemoryUsageMax.equals(other.heapMemoryUsageMax))) {
            return false;
        }
        if (this.heapMemoryUsageUsed != other.heapMemoryUsageUsed && (this.heapMemoryUsageUsed == null || !this.heapMemoryUsageUsed.equals(other.heapMemoryUsageUsed))) {
            return false;
        }
        if (this.heapMemoryUsageInit != other.heapMemoryUsageInit && (this.heapMemoryUsageInit == null || !this.heapMemoryUsageInit.equals(other.heapMemoryUsageInit))) {
            return false;
        }
        if (this.nonHeapMemoryUsageCommitted != other.nonHeapMemoryUsageCommitted && (this.nonHeapMemoryUsageCommitted == null || !this.nonHeapMemoryUsageCommitted.equals(other.nonHeapMemoryUsageCommitted))) {
            return false;
        }
        if (this.nonHeapMemoryUsageMax != other.nonHeapMemoryUsageMax && (this.nonHeapMemoryUsageMax == null || !this.nonHeapMemoryUsageMax.equals(other.nonHeapMemoryUsageMax))) {
            return false;
        }
        if (this.nonHeapMemoryUsageUsed != other.nonHeapMemoryUsageUsed && (this.nonHeapMemoryUsageUsed == null || !this.nonHeapMemoryUsageUsed.equals(other.nonHeapMemoryUsageUsed))) {
            return false;
        }
        if (this.nonHeapMemoryUsageInit != other.nonHeapMemoryUsageInit && (this.nonHeapMemoryUsageInit == null || !this.nonHeapMemoryUsageInit.equals(other.nonHeapMemoryUsageInit))) {
            return false;
        }
        if (this.objectPendingFinalizationCount != other.objectPendingFinalizationCount && (this.objectPendingFinalizationCount == null || !this.objectPendingFinalizationCount.equals(other.objectPendingFinalizationCount))) {
            return false;
        }
        if (this.threadCount != other.threadCount && (this.threadCount == null || !this.threadCount.equals(other.threadCount))) {
            return false;
        }
        if (this.loadedClassCount != other.loadedClassCount && (this.loadedClassCount == null || !this.loadedClassCount.equals(other.loadedClassCount))) {
            return false;
        }
        if (this.totalLoadedClassCount != other.totalLoadedClassCount && (this.totalLoadedClassCount == null || !this.totalLoadedClassCount.equals(other.totalLoadedClassCount))) {
            return false;
        }
        if (this.unloadedClassCount != other.unloadedClassCount && (this.unloadedClassCount == null || !this.unloadedClassCount.equals(other.unloadedClassCount))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.createdAt != null ? this.createdAt.hashCode() : 0);
        hash = 79 * hash + (this.availableProcessors != null ? this.availableProcessors.hashCode() : 0);
        hash = 79 * hash + (this.systemLoadAverage != null ? this.systemLoadAverage.hashCode() : 0);
        hash = 79 * hash + (this.heapMemoryUsageCommitted != null ? this.heapMemoryUsageCommitted.hashCode() : 0);
        hash = 79 * hash + (this.heapMemoryUsageMax != null ? this.heapMemoryUsageMax.hashCode() : 0);
        hash = 79 * hash + (this.heapMemoryUsageUsed != null ? this.heapMemoryUsageUsed.hashCode() : 0);
        hash = 79 * hash + (this.heapMemoryUsageInit != null ? this.heapMemoryUsageInit.hashCode() : 0);
        hash = 79 * hash + (this.nonHeapMemoryUsageCommitted != null ? this.nonHeapMemoryUsageCommitted.hashCode() : 0);
        hash = 79 * hash + (this.nonHeapMemoryUsageMax != null ? this.nonHeapMemoryUsageMax.hashCode() : 0);
        hash = 79 * hash + (this.nonHeapMemoryUsageUsed != null ? this.nonHeapMemoryUsageUsed.hashCode() : 0);
        hash = 79 * hash + (this.nonHeapMemoryUsageInit != null ? this.nonHeapMemoryUsageInit.hashCode() : 0);
        hash = 79 * hash + (this.objectPendingFinalizationCount != null ? this.objectPendingFinalizationCount.hashCode() : 0);
        hash = 79 * hash + (this.threadCount != null ? this.threadCount.hashCode() : 0);
        hash = 79 * hash + (this.loadedClassCount != null ? this.loadedClassCount.hashCode() : 0);
        hash = 79 * hash + (this.totalLoadedClassCount != null ? this.totalLoadedClassCount.hashCode() : 0);
        hash = 79 * hash + (this.unloadedClassCount != null ? this.unloadedClassCount.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "SystemLog{" + "id=" + id + ", createdAt=" + createdAt + ", availableProcessors=" + availableProcessors + ", systemLoadAverage=" + systemLoadAverage + ", heapMemoryUsageCommitted=" + heapMemoryUsageCommitted + ", heapMemoryUsageMax=" + heapMemoryUsageMax + ", heapMemoryUsageUsed=" + heapMemoryUsageUsed + ", heapMemoryUsageInit=" + heapMemoryUsageInit + ", nonHeapMemoryUsageCommitted=" + nonHeapMemoryUsageCommitted + ", nonHeapMemoryUsageMax=" + nonHeapMemoryUsageMax + ", nonHeapMemoryUsageUsed=" + nonHeapMemoryUsageUsed + ", nonHeapMemoryUsageInit=" + nonHeapMemoryUsageInit + ", objectPendingFinalizationCount=" + objectPendingFinalizationCount + ", threadCount=" + threadCount + ", loadedClassCount=" + loadedClassCount + ", totalLoadedClassCount=" + totalLoadedClassCount + ", unloadedClassCount=" + unloadedClassCount + '}';
    }
}
