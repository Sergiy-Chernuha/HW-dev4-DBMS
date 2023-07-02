package ua.goit.db_dto;

import java.time.LocalDate;

public class AgeestWorker {
    private String type;
    private String name;
    private LocalDate birthday;

    public AgeestWorker(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "AgeestWorker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
