package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person personOne = new Person();

            personOne.setFirstName("Kevin");
            personOne.setLastName("van der Kruk");
            personOne.setAge(31);
            em.persist(personOne);

            tx.commit();
            System.out.println("Person Saved");

        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();

        }
    }
}
