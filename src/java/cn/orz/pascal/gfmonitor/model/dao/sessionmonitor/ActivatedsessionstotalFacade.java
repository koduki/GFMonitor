/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.model.dao.sessionmonitor;

import cn.orz.pascal.gfmonitor.model.dao.AbstractFacade;
import cn.orz.pascal.gfmonitor.models.entity.sessionmonitor.Activatedsessionstotal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author koduki
 */
@Stateless
public class ActivatedsessionstotalFacade extends AbstractFacade<Activatedsessionstotal> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivatedsessionstotalFacade() {
        super(Activatedsessionstotal.class);
    }
    
}
