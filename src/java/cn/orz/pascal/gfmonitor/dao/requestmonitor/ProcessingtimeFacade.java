/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.dao.requestmonitor;

import cn.orz.pascal.gfmonitor.dao.AbstractFacade;
import cn.orz.pascal.gfmonitor.models.entity.requestmonitor.Processingtime;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pascalm3
 */
@Stateless
public class ProcessingtimeFacade extends AbstractFacade<Processingtime> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcessingtimeFacade() {
        super(Processingtime.class);
    }
    
}
