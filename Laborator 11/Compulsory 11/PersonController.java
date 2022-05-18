import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

        private final List<Person> persons = new ArrayList<>();
        public PersonController() {
            persons.add(new Person("Enascuta Razvan", 21, 1));
            persons.add(new Person("Nafornita Andra", 19, 2));
        }
        @GetMapping
        public List<Person> getProducts() {
            return persons;
        }
        @GetMapping("/count")
        public int countProducts() {
            return persons.size();
        }
        @GetMapping("/{id}")
        public Person getProduct(@PathVariable("id") int id) {
            return persons.stream()
                    .filter(p -> p.getId() == id).findFirst().orElse(null);
        }

}
