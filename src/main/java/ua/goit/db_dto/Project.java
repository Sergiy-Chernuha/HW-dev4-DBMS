package ua.goit.db_dto;

import java.sql.Date;

public class Project {

    private Long id;
    private Long clientId;
    private java.sql.Date startDate;
    private java.sql.Date finishDate;

    public Project(Long clientId, Date startDate, Date finishDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(java.sql.Date finishDate) {
        this.finishDate = finishDate;
    }
}
