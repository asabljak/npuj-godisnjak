// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package hr.tvz.java.godisnjak.entity;

import hr.tvz.java.godisnjak.entity.ApplicationUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ApplicationUser_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ApplicationUser.entityManager;
    
    public static final List<String> ApplicationUser.fieldNames4OrderClauseFilter = java.util.Arrays.asList("username", "password", "userRole", "enabled");
    
    public static final EntityManager ApplicationUser.entityManager() {
        EntityManager em = new ApplicationUser().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ApplicationUser.countApplicationUsers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ApplicationUser o", Long.class).getSingleResult();
    }
    
    public static List<ApplicationUser> ApplicationUser.findAllApplicationUsers() {
        return entityManager().createQuery("SELECT o FROM ApplicationUser o", ApplicationUser.class).getResultList();
    }
    
    public static List<ApplicationUser> ApplicationUser.findAllApplicationUsers(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ApplicationUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ApplicationUser.class).getResultList();
    }
    
    public static ApplicationUser ApplicationUser.findApplicationUser(Long id) {
        if (id == null) return null;
        return entityManager().find(ApplicationUser.class, id);
    }
    
    public static List<ApplicationUser> ApplicationUser.findApplicationUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ApplicationUser o", ApplicationUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<ApplicationUser> ApplicationUser.findApplicationUserEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ApplicationUser o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ApplicationUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ApplicationUser.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ApplicationUser.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ApplicationUser attached = ApplicationUser.findApplicationUser(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ApplicationUser.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ApplicationUser.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ApplicationUser ApplicationUser.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ApplicationUser merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
