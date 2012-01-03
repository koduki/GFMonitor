/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.model.monitor;

import cn.orz.pascal.gfmonitor.models.entity.system.SystemLog;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author koduki
 */
@Stateless
public class SystemMonitor {

    public SystemMonitor() {
    }

    public SystemLog getSystemLog() {
        SystemLog log = new SystemLog();

        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        log.setAvailableProcessors(operatingSystemMXBean.getAvailableProcessors());
        log.setSystemLoadAverage(operatingSystemMXBean.getSystemLoadAverage());

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        log.setHeapMemoryUsageCommitted(memoryMXBean.getHeapMemoryUsage().getCommitted());
        log.setHeapMemoryUsageInit(memoryMXBean.getHeapMemoryUsage().getInit());
        log.setHeapMemoryUsageMax(memoryMXBean.getHeapMemoryUsage().getMax());
        log.setHeapMemoryUsageUsed(memoryMXBean.getHeapMemoryUsage().getUsed());
        log.setNonHeapMemoryUsageCommitted(memoryMXBean.getNonHeapMemoryUsage().getCommitted());
        log.setNonHeapMemoryUsageInit(memoryMXBean.getNonHeapMemoryUsage().getInit());
        log.setNonHeapMemoryUsageMax(memoryMXBean.getNonHeapMemoryUsage().getMax());
        log.setNonHeapMemoryUsageUsed(memoryMXBean.getNonHeapMemoryUsage().getUsed());
        log.setObjectPendingFinalizationCount(memoryMXBean.getObjectPendingFinalizationCount());

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        log.setThreadCount(threadMXBean.getThreadCount());

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        log.setLoadedClassCount(classLoadingMXBean.getLoadedClassCount());
        log.setTotalLoadedClassCount(classLoadingMXBean.getTotalLoadedClassCount());
        log.setUnloadedClassCount(classLoadingMXBean.getUnloadedClassCount());

        log.setCreatedAt(new Date(System.currentTimeMillis()));
        return log;
    }
}
