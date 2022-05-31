package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from Country e order by e.name"),
        @NamedQuery(name = "Country.findByName",
                query = "select e from Country e where e.name = ?1"),
})
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "continent_id", referencedColumnName = "id")
    @ManyToOne
    private Continent continent;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public int getContinentId() {
        return continent.getId();
    }

    public void setContinentId(int continentId) {
        continent.setId(continentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (!Objects.equals(name, country.name)) return false;
        if (!Objects.equals(code, country.code)) return false;
        if (!Objects.equals(continent, country.getContinent()))
            return false;

        return true;
    }

    public String toString() {
        return "id=" + id + "  name=" + name + "  code=" + code + "  continent=" + continent.getName() ;
    }
}
