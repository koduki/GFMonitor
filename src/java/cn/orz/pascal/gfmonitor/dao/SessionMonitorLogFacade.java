/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.dao;

import cn.orz.pascal.gfmonitor.models.entity.SessionMonitorLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pascalm3
 */
@Stateless
public class SessionMonitorLogFacade extends AbstractFacade<SessionMonitorLog> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionMonitorLogFacade() {
        super(SessionMonitorLog.class);
    }
    
}
