package ua.goit.db_dto;

public class Client {

    private long id;
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
