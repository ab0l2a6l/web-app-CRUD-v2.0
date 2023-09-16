package model.domain;

public class Student {
    private long id;
    private String name;
    private String family;

    public long getId() {
        return id;
    }

    public Student setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Student setFamily(String family) {
        this.family = family;
        return this;
    }
}
