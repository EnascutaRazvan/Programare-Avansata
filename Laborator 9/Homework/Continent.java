package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from Continent e order by e.name"),
        @NamedQuery(name = "Continent.findByName",
                query = "select e from Continent e where e.name = ?1"),
})
public class Continent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent that = (Continent) o;

        if (id != that.id) return false;
        if (Objects.equals(name, that.name)) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "id=" + id + "  name=" + name;
    }
}
