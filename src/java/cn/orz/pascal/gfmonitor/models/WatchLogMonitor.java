/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import java.io.IOException;
import java.net.MalformedURLException;
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
public class WatchLogMonitor {

    private MBeanServerConnection mbeanserver;

    public WatchLogMonitor() throws MalformedURLException, IOException {
        String url = "service:jmx:rmi://192.168.11.5:8686/jndi/rmi://192.168.11.5:8686/jmxrmi";
        JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(url));

        // MBeanServerConnection取得
        this.mbeanserver = connector.getMBeanServerConnection();
    }

    public ServerMonitorLog getServerMonitorLog() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        String serverMon = "amx:pp=/mon/server-mon[server],type=servlet-mon,name=JMXMonitor_old/server";
        CompositeDataSupport totalservletsloadedcount = getProperty(this.mbeanserver, serverMon, "totalservletsloadedcount");
        ServerMonitorLog log = build(totalservletsloadedcount);

        return log;
    }

    private <T extends ServerMonitorLog> T build(CompositeDataSupport totalservletsloadedcount) {
        T log = (T)new ServerMonitorLog();
        
        log.setName((String) totalservletsloadedcount.get("name"));
        log.setUnit((String) totalservletsloadedcount.get("unit"));
        log.setDescription((String) totalservletsloadedcount.get("description"));
        log.setCount((Long) totalservletsloadedcount.get("count"));
        log.setStartTime((Long) totalservletsloadedcount.get("startTime"));
        log.setLastSampleTime((Long) totalservletsloadedcount.get("lastSampleTime"));
        
        return log;
    }

    private CompositeDataSupport getProperty(MBeanServerConnection mbeanserver, String name, String key) throws IOException, InstanceNotFoundException, MBeanException, ReflectionException, NullPointerException, MalformedObjectNameException, AttributeNotFoundException {
        ObjectName objName = new ObjectName(name);
        CompositeDataSupport activeservletsloadedcount = (CompositeDataSupport) mbeanserver.getAttribute(objName, key);
        return activeservletsloadedcount;
    }
}
