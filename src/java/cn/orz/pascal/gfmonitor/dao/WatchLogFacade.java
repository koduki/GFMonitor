/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.dao;

import cn.orz.pascal.gfmonitor.models.ServerMonitorLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author koduki
 */
@Stateless
public class WatchLogFacade extends AbstractFacade<ServerMonitorLog> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WatchLogFacade() {
        super(ServerMonitorLog.class);
    }
    
}
