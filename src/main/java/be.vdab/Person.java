package be.vdab;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Person {

    @Id
    private long id;
    private long version;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private GenderType gender;
    private byte[] picture;
    private String comment;

    @Basic(optional = false)
    private boolean married;

    private int age;
    private String homepage;

}
