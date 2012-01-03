/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.SessionMonitorLog;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
import cn.orz.pascal.gfmonitor.models.entity.ServerMonitorLog;
import cn.orz.pascal.gfmonitor.dao.ServerMonitorLogFacade;
import cn.orz.pascal.gfmonitor.dao.SessionMonitorLogFacade;
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
    @EJB
    WatchMonitor monitor;
    @EJB
    ServerMonitorLogFacade serverMonitorLogFacade;
    @EJB
    SessionMonitorLogFacade sessionMonitorLogFacade;

    public String get() throws Exception {
        ServerMonitorLog serverMonitorLog = monitor.getServerMonitorLog();
        serverMonitorLogFacade.create(serverMonitorLog);

        SessionMonitorLog sessionMonitorLog = monitor.getSessionMonitorLog();
        sessionMonitorLogFacade.create(sessionMonitorLog);

        for (MonitorLog l : sessionMonitorLogFacade.findAll()) {
            System.out.println(l.toString());
        }

        return "success";
    }
}
