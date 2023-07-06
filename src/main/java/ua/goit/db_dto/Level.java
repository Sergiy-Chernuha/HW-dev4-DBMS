package ua.goit.db_dto;

public enum Level {
    TRAINEE("Trainee"), JUNIOR("Junior"), MIDDLE("Middle"), SENIOR("Senior");

    public String name;

    Level(String name) {
        this.name = name;
    }
}
