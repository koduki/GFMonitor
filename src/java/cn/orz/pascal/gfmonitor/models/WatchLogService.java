/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Expiredsessionstotal;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
import cn.orz.pascal.gfmonitor.dao.SessionMonitorLogFacade;
import cn.orz.pascal.gfmonitor.dao.sessionmonitor.ActivatedsessionstotalFacade;
import cn.orz.pascal.gfmonitor.dao.sessionmonitor.ActivesessionscurrentFacade;
import cn.orz.pascal.gfmonitor.dao.sessionmonitor.ExpiredsessionstotalFacade;
import cn.orz.pascal.gfmonitor.dao.sessionmonitor.PassivatedsessionstotalFacade;
import cn.orz.pascal.gfmonitor.dao.sessionmonitor.PersistedsessionstotalFacade;
import cn.orz.pascal.gfmonitor.dao.sessionmonitor.RejectedsessionstotalFacade;
import cn.orz.pascal.gfmonitor.dao.severmonitor.ActiveservletsloadedcountFacade;
import cn.orz.pascal.gfmonitor.dao.severmonitor.ServletprocessingtimesFacade;
import cn.orz.pascal.gfmonitor.dao.severmonitor.TotalservletsloadedcountFacade;
import cn.orz.pascal.gfmonitor.models.entity.MonitorAverageLog;
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
    ServerMonitor serverMonitor;
    @EJB
    SessionMonitor sessionMonitor;
    @EJB
    ActiveservletsloadedcountFacade activeservletsloadedcountFacade;
    @EJB
    ServletprocessingtimesFacade servletprocessingtimesFacade;
    @EJB
    TotalservletsloadedcountFacade totalservletsloadedcountFacade;
    @EJB
    ActivatedsessionstotalFacade activatedsessionstotalFacade;
    @EJB
    ActivesessionscurrentFacade activesessionscurrentFacade;
    @EJB
    ExpiredsessionstotalFacade expiredsessionstotalFacade;
    @EJB
    PassivatedsessionstotalFacade passivatedsessionstotalFacade;
    @EJB
    PersistedsessionstotalFacade persistedsessionstotalFacade;
    @EJB
    RejectedsessionstotalFacade rejectedsessionstotalFacade;

    public String get() throws Exception {
        // server-mon
        activeservletsloadedcountFacade.create(serverMonitor.getActiveservletsloadedcount());
        servletprocessingtimesFacade.create(serverMonitor.getServletprocessingtimes());
        totalservletsloadedcountFacade.create(serverMonitor.getTotalservletsloadedcount());

        // session-mon
        activatedsessionstotalFacade.create(sessionMonitor.getActivatedsessionstotal());
        activesessionscurrentFacade.create(sessionMonitor.getActivesessionscurrent());
        expiredsessionstotalFacade.create(sessionMonitor.getExpiredsessionstotal());
        passivatedsessionstotalFacade.create(sessionMonitor.getPassivatedsessionstotal());
        persistedsessionstotalFacade.create(sessionMonitor.getPersistedsessionstotal());
        rejectedsessionstotalFacade.create(sessionMonitor.getRejectedsessionstotal());

        for (MonitorLog l : totalservletsloadedcountFacade.findAll()) {
            System.out.println(l.toString());
        }

        for (MonitorAverageLog l : activeservletsloadedcountFacade.findAll()) {
            System.out.println(l.toString());
        }
        return "success";
    }
}
