package ua.goit.db_dto;

import java.sql.Date;

public class Worker {

    private Long id;
    private String name;
    private java.sql.Date birthday;
    private Level level;
    private Integer salary;

    public Worker() {
    }

    public Worker(String name, Date birthday, String level, Integer salary) {
        this.name = name;
        this.birthday = birthday;
        this.level =Level.valueOf(level.toUpperCase());
        this.salary = salary;
    }

    public Worker(Long id, String name, Date birthday, Level level, Integer salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public Long getId() {
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
