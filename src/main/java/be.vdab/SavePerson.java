package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

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
            personOne.setGender(GenderType.MALE);
            personOne.setBirthDay(LocalDate.of(1989,07,26));
            personOne.setComment("Still need to upload a picture, it ain't over yet!");
            // personOne.isMarried();
            personOne.setHomepage("www.ferienwohnungmosea.de");

            Person personTwo = new Person();

            personTwo.setFirstName("Sydney ");
            personTwo.setLastName("Van Koeckhoven");
            personTwo.setAge(31);
            personTwo.setGender(GenderType.FEMALE);
            personTwo.setBirthDay(LocalDate.of(1989,05,21));
            personTwo.setComment("Sorry Syd I made you a woman today!");
            // personTwo.isMarried();
            personTwo.setHomepage("www.google.be");

            em.persist(personOne);
            em.persist(personTwo);
            tx.commit();
            System.out.println("Persons Saved");

        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
