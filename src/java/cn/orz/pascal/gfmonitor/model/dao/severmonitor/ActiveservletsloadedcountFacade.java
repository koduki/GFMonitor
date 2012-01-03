/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.model.dao.severmonitor;

import cn.orz.pascal.gfmonitor.model.dao.AbstractFacade;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Activeservletsloadedcount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author koduki
 */
@Stateless
public class ActiveservletsloadedcountFacade extends AbstractFacade<Activeservletsloadedcount> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActiveservletsloadedcountFacade() {
        super(Activeservletsloadedcount.class);
    }
    
}
