package br.com.integracaocontinua.infra;

import com.mysema.query.jpa.impl.JPAQuery;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author rafael
 */
public abstract class JpaQueryDslRepository implements Serializable {
    
    @PersistenceContext(unitName="IntegracaoContinuaPU")
    private EntityManager entityManager;

    public <T> T salvar(T entity) {
        return entityManager.merge(entity);
    }

    public <T> T remover(T entity) {
        entityManager.remove(entity);
        return entity;
    }

    public <T> T buscarPorId(Class<T> classe, Serializable id) {
        return entityManager.find(classe, id);
    }

    public List buscarTodos(Class classe, String ordenarPor) {
        String sql = "SELECT o FROM " + classe.getName() + " o ";
        
        if(ordenarPor != null) {
            sql += "ORDER BY o." + ordenarPor;
        }        
        return entityManager.createQuery(sql).getResultList();
    }

    public JPAQuery query() {        
        return new JPAQuery(entityManager);
    }    
}
