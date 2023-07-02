package ua.goit.db_dto;

public class MaxSalaryCountWorker {
    private String name;
    private Integer salary;

    public MaxSalaryCountWorker(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryCountWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
