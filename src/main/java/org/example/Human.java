package org.example;

public record Human(String name, String lastName, Integer age) implements Comparable<Human> {

    @Override
    public int compareTo(Human o) {
        int result;

        if (this.equals(o)) return 0;

        result = name.compareTo(o.name);
        if (result != 0) return result;
        else result = lastName.compareTo(o.lastName);
        if (result != 0) return result;
        else return age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

}


