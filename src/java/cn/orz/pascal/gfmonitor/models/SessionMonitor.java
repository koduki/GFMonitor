/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Activatedsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Activesessionscurrent;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Expiredsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Passivatedsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Persistedsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Rejectedsessionstotal;
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
public class SessionMonitor extends WatchMonitor {

    protected String path = "amx:pp=/mon/server-mon[server],type=session-mon,name=JMXMonitor_old/server";

    public SessionMonitor() throws MalformedURLException, IOException {
        super.init();
    }

    public Activatedsessionstotal getActivatedsessionstotal() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "activatedsessionstotal");
        Activatedsessionstotal log = build(new Activatedsessionstotal(), data);

        return log;
    }    
    
    public Activesessionscurrent getActivesessionscurrent() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "activesessionscurrent");
        Activesessionscurrent log = build(new Activesessionscurrent(), data);

        return log;
    }

    public Expiredsessionstotal getExpiredsessionstotal() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "expiredsessionstotal");
        Expiredsessionstotal log = build(new Expiredsessionstotal(), data);

        return log;
    }
    
    public Passivatedsessionstotal getPassivatedsessionstotal() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "passivatedsessionstotal");
        Passivatedsessionstotal log = build(new Passivatedsessionstotal(), data);

        return log;
    }
    
    public Persistedsessionstotal getPersistedsessionstotal() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "persistedsessionstotal");
        Persistedsessionstotal log = build(new Persistedsessionstotal(), data);

        return log;
    }

    public Rejectedsessionstotal getRejectedsessionstotal() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "rejectedsessionstotal");
        Rejectedsessionstotal log = build(new Rejectedsessionstotal(), data);

        return log;
    }
}
