/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.dao.WatchLogFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.jws.WebService;
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
@WebService(serviceName = "WatchLogService")
@Stateless()
public class WatchLogService {
    @EJB WatchLogFacade dao;

    /** This is a sample web service operation */
    public String get() throws Exception {
                   JMXServiceURL url =
                new JMXServiceURL("service:jmx:rmi://192.168.11.5:8686/jndi/rmi://192.168.11.5:8686/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(url);

        // MBeanServerConnection取得
        MBeanServerConnection mbeanserver = connector.getMBeanServerConnection();
        
        String serverMon = "amx:pp=/mon/server-mon[server],type=servlet-mon,name=JMXMonitor_old/server";
        CompositeDataSupport totalservletsloadedcount = getProperty(mbeanserver, serverMon, "totalservletsloadedcount");

        WatchLog log = new WatchLog();
        log.setName((String)totalservletsloadedcount.get("name"));
        log.setUnit((String)totalservletsloadedcount.get("unit"));
        log.setDescription((String)totalservletsloadedcount.get("description"));      
        log.setCount((Long)totalservletsloadedcount.get("count"));
        log.setStartTime((Long)totalservletsloadedcount.get("startTime"));
        log.setLastSampleTime((Long)totalservletsloadedcount.get("lastSampleTime"));
        
        dao.create(log);
        
        for (WatchLog l : dao.findAll()) {
            System.out.println(l.getId());
        }
        
        return "Hello !";
    }
    
    private CompositeDataSupport getProperty(MBeanServerConnection mbeanserver, String name, String key) throws IOException, InstanceNotFoundException, MBeanException, ReflectionException, NullPointerException, MalformedObjectNameException, AttributeNotFoundException {
        ObjectName objName = new ObjectName(name);
        CompositeDataSupport activeservletsloadedcount = (CompositeDataSupport) mbeanserver.getAttribute(objName, key);
        return activeservletsloadedcount;
    }
}
