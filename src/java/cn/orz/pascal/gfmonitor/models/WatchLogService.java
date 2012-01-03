/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Expiredsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Totalservletsloadedcount;
import cn.orz.pascal.gfmonitor.dao.ServerMonitorLogFacade;
import cn.orz.pascal.gfmonitor.dao.SessionMonitorLogFacade;
import cn.orz.pascal.gfmonitor.dao.ActiveservletsloadedcountFacade;
import cn.orz.pascal.gfmonitor.dao.ServletprocessingtimesFacade;
import cn.orz.pascal.gfmonitor.dao.TotalservletsloadedcountFacade;
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
//    @EJB
//    ActiveservletsloadedcountFacade activeservletsloadedcountFacade;
//    @EJB
//    ServletprocessingtimesFacade servletprocessingtimesFacade;
//    @EJB
//    TotalservletsloadedcountFacade totalservletsloadedcountFacade;
    @EJB
    ServerMonitorLogFacade serverMonitorLogFacade;
    @EJB
    SessionMonitorLogFacade sessionMonitorLogFacade;

    public String get() throws Exception {
        Totalservletsloadedcount serverMonitorLog = monitor.getTotalservletsloadedcount();
        serverMonitorLogFacade.create(serverMonitorLog);

        Expiredsessionstotal sessionMonitorLog = monitor.getExpiredsessionstotal();
        sessionMonitorLogFacade.create(sessionMonitorLog);

        for (MonitorLog l : sessionMonitorLogFacade.findAll()) {
            System.out.println(l.toString());
        }

        return "success";
    }
}
