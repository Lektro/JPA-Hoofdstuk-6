package be.vdab;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
@Table (name ="PERSONS", uniqueConstraints = {@UniqueConstraint(columnNames ="id")})
public class Person {


    private long id;
    private long version;
    private String firstName;
    private String lastName;
    private int age;
    private LocalDate birthDay;
    private GenderType gender;
    private byte[] picture;
    private String comment;
    private boolean married;
    private String homepage;

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Id
    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @Transient
    @Column(name="BIRTHDAY")
    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = Math.toIntExact(ChronoUnit.YEARS.between(now, birthDay));
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Id
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Id
    @Lob
    @Column(nullable = true, name="PICTURE")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Id
    @Lob
    @Column(name="COMMNT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Id
    @Basic(optional = false)
    @Column(name="MARRIED")
    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Id
    @Column(name="HOMEPAGE")
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
