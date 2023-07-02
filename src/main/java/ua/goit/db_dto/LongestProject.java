package ua.goit.db_dto;

public class LongestProject {
    private Integer id;
    private Integer MonthCount;

    public LongestProject(Integer id, Integer monthCount) {
        this.id = id;
        MonthCount = monthCount;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMonthCount() {
        return MonthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", MonthCount=" + MonthCount +
                '}';
    }
}
