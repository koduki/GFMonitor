/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.model.dao.sessionmonitor;

import cn.orz.pascal.gfmonitor.model.dao.AbstractFacade;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Rejectedsessionstotal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author koduki
 */
@Stateless
public class RejectedsessionstotalFacade extends AbstractFacade<Rejectedsessionstotal> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RejectedsessionstotalFacade() {
        super(Rejectedsessionstotal.class);
    }
    
}
