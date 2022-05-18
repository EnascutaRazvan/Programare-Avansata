public class Person{
    String name;
    int age;

    int id;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    Person(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }
}
