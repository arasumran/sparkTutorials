package java8.DummyClasses;

public class Developer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    private String name;
    private String surname;
    private String title;

    public Developer(String name, String surname, String title, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.salary = salary;
    }

    private Integer salary;
}
