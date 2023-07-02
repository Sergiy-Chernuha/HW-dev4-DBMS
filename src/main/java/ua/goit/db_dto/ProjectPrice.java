package ua.goit.db_dto;

public class ProjectPrice {
    private Integer id;
    private Integer amount;

    public ProjectPrice(Integer id, Integer amound) {
        this.id = id;
        this.amount = amound;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
