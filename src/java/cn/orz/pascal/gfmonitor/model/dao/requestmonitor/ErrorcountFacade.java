/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.model.dao.requestmonitor;

import cn.orz.pascal.gfmonitor.model.dao.AbstractFacade;
import cn.orz.pascal.gfmonitor.models.entity.requestmonitor.Errorcount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author koduki
 */
@Stateless
public class ErrorcountFacade extends AbstractFacade<Errorcount> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ErrorcountFacade() {
        super(Errorcount.class);
    }
    
}
