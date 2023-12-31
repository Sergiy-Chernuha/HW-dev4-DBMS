package ua.goit.db_dto;

public class ProjectWorker {

    private Integer projectId;
    private Integer workerId;

    public ProjectWorker(Integer projectId, Integer workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
}
