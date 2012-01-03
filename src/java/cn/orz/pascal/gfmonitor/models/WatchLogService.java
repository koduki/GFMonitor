/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.models;

import cn.orz.pascal.gfmonitor.dao.requestmonitor.CountrequestsFacade;
import cn.orz.pascal.gfmonitor.dao.requestmonitor.ErrorcountFacade;
import cn.orz.pascal.gfmonitor.dao.requestmonitor.MaxtimeFacade;
import cn.orz.pascal.gfmonitor.dao.requestmonitor.ProcessingtimeFacade;
import cn.orz.pascal.gfmonitor.models.entity.MonitorLog;
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
    RequestMonitor requestMonitor;
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
    @EJB
    CountrequestsFacade countrequestsFacade;
    @EJB
    ErrorcountFacade errorcountFacade;
    @EJB
    MaxtimeFacade maxtimeFacade;
    @EJB
    ProcessingtimeFacade processingtimeFacade;

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
        
        // request-mon
        countrequestsFacade.create(requestMonitor.getCountrequests());
        errorcountFacade.create(requestMonitor.getErrorcount());
        maxtimeFacade.create(requestMonitor.getMaxtime());
        processingtimeFacade.create(requestMonitor.getProcessingtime());

        for (MonitorLog l : totalservletsloadedcountFacade.findAll()) {
            System.out.println(l.toString());
        }

        for (MonitorAverageLog l : activeservletsloadedcountFacade.findAll()) {
            System.out.println(l.toString());
        }
        return "success";
    }
}
