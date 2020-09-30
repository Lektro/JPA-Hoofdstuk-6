package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetPerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person visitor = em.find(Person.class, 1L);
            Person visitor1 = em.find(Person.class, 2L);
            System.out.println(visitor.getId());
            System.out.println(visitor.getVersion());
            System.out.println(visitor.getAge());
            System.out.println(visitor.getBirthDay());
            System.out.println(visitor.getFirstName());
            System.out.println(visitor.getLastName());
            System.out.println(visitor.getComment());

            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
