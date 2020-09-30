package be.vdab;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
@Table (name ="PERSONS", uniqueConstraints = {@UniqueConstraint(columnNames ="id")})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="VERSION")
    private long version;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="AGE")
    private int age;

    //@Temporal(TemporalType.DATE)
    @Column(name="BIRTHDAY")
    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    private GenderType gender;

    @Lob
    @Column(nullable = true, name="PICTURE")
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @Lob
    @Column(name="COMMNT")
    @Basic(fetch = FetchType.LAZY)
    private String comment;

    @Basic(optional = false)
    @Column(name="MARRIED")
    private boolean married;

    @Column(name="HOMEPAGE")
    private String homepage;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public int getAge() {
        //LocalDate now = LocalDate.now();
        //int age = Math.toIntExact(ChronoUnit.YEARS.between(now, birthDay));
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }


    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
