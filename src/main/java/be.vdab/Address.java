package be.vdab;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name ="STREET")
    private String street;

    @Column(name ="NUMBER")
    private String number;

    @Column(name ="ZIPCODE")
    private String zipCode;

    @Column(name ="CITY")
    private String city;

    @Column(name ="COUNTRY")
    private String country;

}
