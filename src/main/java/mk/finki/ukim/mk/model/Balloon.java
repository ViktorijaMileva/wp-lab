package mk.finki.ukim.mk.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Manufacturer manufacturer;
    @ManyToOne
    private Country country;

    public Balloon(String name, String description, Manufacturer manufacturer, Country country) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.country = country;
    }

    public Balloon() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
