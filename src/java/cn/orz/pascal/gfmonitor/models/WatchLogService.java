/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.dao.WatchLogFacade;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author koduki
 */
@WebService(serviceName = "WatchLogService")
@Stateless()
public class WatchLogService {
    @EJB WatchLogFacade dao;
    @EJB WatchLogMonitor monitor;

    /** This is a sample web service operation */
    public String get() throws Exception {
        ServerMonitorLog serverMonitorLog = monitor.getServerMonitorLog();
        
        dao.create(serverMonitorLog);
        
        for (ServerMonitorLog l : dao.findAll()) {
            System.out.println(l.toString());
        }
        
        return "Hello !";
    }

}
