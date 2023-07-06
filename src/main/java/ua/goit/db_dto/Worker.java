package ua.goit.db_dto;

import java.sql.Date;

public class Worker {

    private long id;
    private String name;
    private java.sql.Date birthday;
    private Level level;
    private Integer salary;

    public Worker(String name, Date birthday, String level, Integer salary) {
        this.name = name;
        this.birthday = birthday;
        this.level =Level.valueOf(level.toUpperCase());
        this.salary = salary;
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

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public String getLevel() {
        return level.name;
    }

    public void setLevel(String level) {
        this.level = Level.valueOf(level.toUpperCase());
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
