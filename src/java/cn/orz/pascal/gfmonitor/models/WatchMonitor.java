/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.SessionMonitorLog;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
import cn.orz.pascal.gfmonitor.models.entity.ServerMonitorLog;
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

    public WatchMonitor() throws MalformedURLException, IOException {
        String url = "service:jmx:rmi://192.168.11.5:8686/jndi/rmi://192.168.11.5:8686/jmxrmi";
        JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(url));

        // MBeanServerConnection取得
        this.mbeanserver = connector.getMBeanServerConnection();
    }

    public ServerMonitorLog getServerMonitorLog() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        String serverMon = "amx:pp=/mon/server-mon[server],type=servlet-mon,name=JMXMonitor_old/server";
        CompositeDataSupport totalservletsloadedcount = getProperty(this.mbeanserver, serverMon, "totalservletsloadedcount");
        ServerMonitorLog log = build(new ServerMonitorLog(), totalservletsloadedcount);

        return log;
    }

    public SessionMonitorLog getSessionMonitorLog() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        String serverMon = "amx:pp=/mon/server-mon[server],type=session-mon,name=JMXMonitor_old/server";
        CompositeDataSupport totalservletsloadedcount = getProperty(this.mbeanserver, serverMon, "expiredsessionstotal");
        SessionMonitorLog log = build(new SessionMonitorLog(), totalservletsloadedcount);

        return log;
    }
    
    private <T extends MonitorLog> T build(T monitorLog, CompositeDataSupport totalservletsloadedcount) {
        monitorLog.setName((String) totalservletsloadedcount.get("name"));
        monitorLog.setUnit((String) totalservletsloadedcount.get("unit"));
        monitorLog.setDescription((String) totalservletsloadedcount.get("description"));
        monitorLog.setCount((Long) totalservletsloadedcount.get("count"));
        monitorLog.setStartTime(new Date((Long) totalservletsloadedcount.get("startTime")));
        monitorLog.setLastSampleTime(new Date((Long) totalservletsloadedcount.get("lastSampleTime")));
        
        return monitorLog;
    }

    private CompositeDataSupport getProperty(MBeanServerConnection mbeanserver, String name, String key) throws IOException, InstanceNotFoundException, MBeanException, ReflectionException, NullPointerException, MalformedObjectNameException, AttributeNotFoundException {
        ObjectName objName = new ObjectName(name);
        CompositeDataSupport activeservletsloadedcount = (CompositeDataSupport) mbeanserver.getAttribute(objName, key);
        return activeservletsloadedcount;
    }
}
