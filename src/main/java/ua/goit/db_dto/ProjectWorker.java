package ua.goit.db_dto;

public class ProjectWorker {

    private Long projectId;
    private Long workerId;

    public ProjectWorker(Long projectId, Long workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
