/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.model.monitor;

import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Activeservletsloadedcount;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Servletprocessingtimes;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Totalservletsloadedcount;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.ejb.Stateless;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;

/**
 *
 * @author koduki
 */
@Stateless
public class ServerMonitor extends GlassFishMonitor {
    protected String path = "amx:pp=/mon/server-mon[server],type=servlet-mon,name=JMXMonitor_old/server";
 
    public ServerMonitor() throws MalformedURLException, IOException {
        super.init();
    }

    public Activeservletsloadedcount getActiveservletsloadedcount() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "activeservletsloadedcount");
        Activeservletsloadedcount log = build(new Activeservletsloadedcount(), data);

        return log;
    }

    public Totalservletsloadedcount getTotalservletsloadedcount() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "totalservletsloadedcount");
        Totalservletsloadedcount log = build(new Totalservletsloadedcount(), data);

        return log;
    }

    public Servletprocessingtimes getServletprocessingtimes() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "servletprocessingtimes");
        Servletprocessingtimes log = build(new Servletprocessingtimes(), data);

        return log;
    }
}
