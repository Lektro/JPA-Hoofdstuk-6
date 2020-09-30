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
            emf = Persistence.createEntityManagerFactory("read");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person p = em.find(Person.class, 1L);
           // Person visitor1 = em.find(Person.class, 2L);
            System.out.println(p.getId());
            System.out.println(p.getVersion());
            System.out.println(p.getAge());
            System.out.println(p.getBirthDay());
            System.out.println(p.getFirstName());
            System.out.println(p.getLastName());
            System.out.println(p.getComment());
            System.out.println(p.getAddress().getStreet());
            System.out.println(p.getAddress().getNumber());
            System.out.println(p.getAddress().getCity());
            System.out.println(p.getAddress().getZipCode());
            System.out.println(p.getAddress().getCountry());

            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
