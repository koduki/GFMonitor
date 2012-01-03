/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.requestmonitor.Countrequests;
import cn.orz.pascal.gfmonitor.models.entity.requestmonitor.Errorcount;
import cn.orz.pascal.gfmonitor.models.entity.requestmonitor.Maxtime;
import cn.orz.pascal.gfmonitor.models.entity.requestmonitor.Processingtime;
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
public class RequestMonitor extends WatchMonitor {

    protected String path = "amx:pp=/mon/server-mon[server],type=request-mon,name=http-service/server/request";

    public RequestMonitor() throws MalformedURLException, IOException {
        super.init();
    }

    public Countrequests getCountrequests() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "countrequests");
        Countrequests log = build(new Countrequests(), data);

        return log;
    }

    public Errorcount getErrorcount() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "errorcount");
        Errorcount log = build(new Errorcount(), data);

        return log;
    }

    public Maxtime getMaxtime() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "maxtime");
        Maxtime log = build(new Maxtime(), data);

        return log;
    }

    public Processingtime getProcessingtime() throws MBeanException, IOException, NullPointerException, MalformedObjectNameException, InstanceNotFoundException, AttributeNotFoundException, ReflectionException {
        CompositeDataSupport data = getProperty(this.mbeanserver, this.path, "processingtime");
        Processingtime log = build(new Processingtime(), data);

        return log;
    }
}
