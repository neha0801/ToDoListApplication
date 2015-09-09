import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import java.util.*;
import java.util.List;

import model.*;



public class ToDoListDB {

    public static void insert(TodoList list) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(list);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(TodoList list) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(list);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(TodoList list) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(list));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static List<TodoList> getList(User1 user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM TodoList u " +
                "WHERE u.user1 = :user";
        TypedQuery<TodoList> q = em.createQuery(qString, TodoList.class).setParameter("user", user);
        List<TodoList> list = new ArrayList<TodoList>();
        try {
        	 list = q.getResultList();
        	if(list==null || list.isEmpty())
        		list=null;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
        return list;
    }
}