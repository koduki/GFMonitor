/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.gfmonitor.dao.severmonitor;

import cn.orz.pascal.gfmonitor.dao.AbstractFacade;
import cn.orz.pascal.gfmonitor.models.entity.servermonitor.Servletprocessingtimes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author koduki
 */
@Stateless
public class ServletprocessingtimesFacade extends AbstractFacade<Servletprocessingtimes> {
    @PersistenceContext(unitName = "GlassFishMonitorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ServletprocessingtimesFacade() {
        super(Servletprocessingtimes.class);
    }
    
}
