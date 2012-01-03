/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.MonitorAverageLog;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Expiredsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Activeservletsloadedcount;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Servletprocessingtimes;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Totalservletsloadedcount;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import javax.ejb.Stateless;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 *
 * @author koduki
 */
@Stateless
public class WatchMonitor {

    private MBeanServerConnection mbeanserver;
    String serverMon = "amx:pp=/mon/server-mon[server],type=servlet-mon,name=JMXMonitor_old/server";
    String sessionMon = "amx:pp=/mon/server-mon[server],type=session-mon,name=JMXMonitor_old/server";

    public WatchMonitor() throws MalformedURLException, IOException {
        String url = "service:jmx:rmi://192.168.11.5:8686/jndi/rmi://192.168.11.5:8686/jmxrmi";
        JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(url));

        // MBeanServerConnection取得
        this.mbeanserver = connector.getMBeanServerConnection();
    }

    public Activeservletsloadedcount getActiveservletsloadedcount() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.serverMon, "activeservletsloadedcount");
        Activeservletsloadedcount log = build(new Activeservletsloadedcount(), data);

        return log;
    }

    public Totalservletsloadedcount getTotalservletsloadedcount() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.serverMon, "totalservletsloadedcount");
        Totalservletsloadedcount log = build(new Totalservletsloadedcount(), data);

        return log;
    }

    public Servletprocessingtimes getServletprocessingtimes() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.serverMon, "servletprocessingtimes");
        Servletprocessingtimes log = build(new Servletprocessingtimes(), data);

        return log;
    }

    public Expiredsessionstotal getExpiredsessionstotal() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.sessionMon, "expiredsessionstotal");
        Expiredsessionstotal log = build(new Expiredsessionstotal(), data);

        return log;
    }

    private <T extends MonitorLog> T build(T monitorLog, CompositeDataSupport data) {
        monitorLog.setName((String) data.get("name"));
        monitorLog.setUnit((String) data.get("unit"));
        monitorLog.setDescription((String) data.get("description"));
        monitorLog.setCount((Long) data.get("count"));
        monitorLog.setStartTime(new Date((Long) data.get("startTime")));
        monitorLog.setLastSampleTime(new Date((Long) data.get("lastSampleTime")));

        return monitorLog;
    }

    private <T extends MonitorAverageLog> T build(T monitorLog, CompositeDataSupport data) {
        monitorLog.setName((String) data.get("name"));
        monitorLog.setUnit((String) data.get("unit"));
        monitorLog.setDescription((String) data.get("description"));
        monitorLog.setCurrent((Integer) data.get("current"));
        monitorLog.setCurrent((Integer) data.get("current"));
        monitorLog.setHighWaterMark((Integer) data.get("highWaterMark"));
        monitorLog.setLowWaterMark((Integer) data.get("lowWaterMark"));
        monitorLog.setStartTime(new Date((Long) data.get("startTime")));
        monitorLog.setLastSampleTime(new Date((Long) data.get("lastSampleTime")));

        return monitorLog;
    }

    private CompositeDataSupport getProperty(MBeanServerConnection mbeanserver, String name, String key) throws IOException, InstanceNotFoundException, MBeanException, ReflectionException, NullPointerException, MalformedObjectNameException, AttributeNotFoundException {
        ObjectName objName = new ObjectName(name);
        CompositeDataSupport activeservletsloadedcount = (CompositeDataSupport) mbeanserver.getAttribute(objName, key);
        return activeservletsloadedcount;
    }
}
