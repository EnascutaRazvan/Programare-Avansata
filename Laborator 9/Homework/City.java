package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.name"),
        @NamedQuery(name = "City.findByCountry",
                query = "select e from City e where e.country = ?1"),
        @NamedQuery(name = "City.findByName",
                query = "select e from City e where e.name = ?1"),
})
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capital")
    private Boolean capital;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    private Country country;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getCountryId() {
        return country.getId();
    }

    public void setCountryId(int countryId) {
        country.setId(countryId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (!Objects.equals(country.getId(), country.getId())) return false;
        if (!Objects.equals(name, city.name)) return false;
        if (!Objects.equals(capital, city.capital)) return false;
        if (!Objects.equals(latitude, city.latitude)) return false;
        if (!Objects.equals(longitude, city.longitude)) return false;

        return true;
    }

    public String toString() {
        return "id=" + id + "  country=" + country.getName() + "  name=" + name + "  capital=" + capital + "  latitude=" + latitude + "  longitude=" + longitude;
    }
}
