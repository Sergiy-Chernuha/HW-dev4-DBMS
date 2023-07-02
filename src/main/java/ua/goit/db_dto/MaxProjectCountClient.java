package ua.goit.db_dto;

public class MaxProjectCountClient {
    private String name;
    private Integer projectCount;

    public MaxProjectCountClient(String name, Integer projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
