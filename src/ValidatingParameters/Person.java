package ValidatingParameters;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        if ((!name.isBlank() || name.length() < 40) && (age > 0 && age < 120) && (name != null)) {
            this.name = name;
            this.age = age;
        }
        else
            throw new IllegalArgumentException("Grade cannot be blank or more than 40 characters");
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
