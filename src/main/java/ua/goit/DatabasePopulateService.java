package ua.goit;

import ua.goit.configs.Database;
import ua.goit.db_dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        String clientSql = DBUtils.getSQL("src/main/java/resource/SQL/populate_db_client.sql");
        String projectSql = DBUtils.getSQL("src/main/java/resource/SQL/populate_db_project.sql");
        String workerSql = DBUtils.getSQL("src/main/java/resource/SQL/populate_db_worker.sql");
        String projectWorkerSql = DBUtils.getSQL("src/main/java/resource/SQL/populate_db_project_worker.sql");

        List<Client> clients = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        List<ProjectWorker> projectWorkers = new ArrayList<>();

        clients.add(new Client("Michale"));
        clients.add(new Client("Sergio"));
        clients.add(new Client("Nataly"));
        clients.add(new Client("Christa"));
        clients.add(new Client("Sophie"));

        projects.add(new Project(1, Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01")));
        projects.add(new Project(1, Date.valueOf("2020-01-01"), Date.valueOf("2020-03-01")));
        projects.add(new Project(2, Date.valueOf("2020-01-01"), Date.valueOf("2020-04-01")));
        projects.add(new Project(3, Date.valueOf("2020-01-01"), Date.valueOf("2020-05-01")));
        projects.add(new Project(3, Date.valueOf("2020-01-01"), Date.valueOf("2020-06-01")));
        projects.add(new Project(3, Date.valueOf("2020-01-01"), Date.valueOf("2020-12-01")));
        projects.add(new Project(4, Date.valueOf("2020-01-01"), Date.valueOf("2021-01-01")));
        projects.add(new Project(4, Date.valueOf("2020-01-01"), Date.valueOf("2021-06-01")));
        projects.add(new Project(4, Date.valueOf("2020-01-01"), Date.valueOf("2021-06-01")));
        projects.add(new Project(4, Date.valueOf("2020-01-01"), Date.valueOf("2022-01-01")));

        workers.add(new Worker("Den", Date.valueOf("2010-01-01"), "Trainee", 100));
        workers.add(new Worker("Gen", Date.valueOf("2010-02-01"), "Trainee", 500));
        workers.add(new Worker("Sem", Date.valueOf("2010-01-03"), "Trainee", 1150));
        workers.add(new Worker("Joy", Date.valueOf("2014-01-01"), "Trainee", 1500));
        workers.add(new Worker("Jen", Date.valueOf("2010-05-01"), "Junior", 2000));
        workers.add(new Worker("Lee", Date.valueOf("2010-01-06"), "Junior", 2500));
        workers.add(new Worker("Len", Date.valueOf("2017-01-01"), "Junior", 2900));
        workers.add(new Worker("Ken", Date.valueOf("2010-08-01"), "Middle", 5000));
        workers.add(new Worker("Rem", Date.valueOf("2010-01-09"), "Middle", 10000));
        workers.add(new Worker("Jon", Date.valueOf("2020-01-01"), "Senior", 100000));

        projectWorkers.add(new ProjectWorker(1, 1));
        projectWorkers.add(new ProjectWorker(1, 2));
        projectWorkers.add(new ProjectWorker(1, 3));
        projectWorkers.add(new ProjectWorker(2, 3));
        projectWorkers.add(new ProjectWorker(2, 4));
        projectWorkers.add(new ProjectWorker(2, 5));
        projectWorkers.add(new ProjectWorker(3, 5));
        projectWorkers.add(new ProjectWorker(3, 6));
        projectWorkers.add(new ProjectWorker(4, 6));
        projectWorkers.add(new ProjectWorker(4, 7));
        projectWorkers.add(new ProjectWorker(5, 8));
        projectWorkers.add(new ProjectWorker(6, 9));
        projectWorkers.add(new ProjectWorker(6, 10));
        projectWorkers.add(new ProjectWorker(7, 10));
        projectWorkers.add(new ProjectWorker(8, 1));
        projectWorkers.add(new ProjectWorker(8, 2));
        projectWorkers.add(new ProjectWorker(8, 3));
        projectWorkers.add(new ProjectWorker(8, 10));
        projectWorkers.add(new ProjectWorker(9, 5));
        projectWorkers.add(new ProjectWorker(9, 10));
        projectWorkers.add(new ProjectWorker(10, 10));

        populatingClients(conn, clientSql, clients);
        populatingProjects(conn, projectSql, projects);
        populatingWorkers(conn, workerSql, workers);
        populatingProjectWorkers(conn, projectWorkerSql, projectWorkers);
    }

    private static void populatingClients(Connection conn, String sql, List<Client> clients) {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (Client client : clients) {
                statement.setString(1, client.getName());

                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println("not correct query client");
        }
    }

    private static void populatingProjects(Connection conn, String sql, List<Project> projects) {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (Project project : projects) {
                statement.setLong(1, project.getClientId());
                statement.setDate(2, project.getStartDate());
                statement.setDate(3, project.getFinishDate());

                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println("not correct query project");
        }
    }

    private static void populatingWorkers(Connection conn, String sql, List<Worker> workers) {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (Worker worker : workers) {
                statement.setString(1, worker.getName());
                statement.setDate(2, worker.getBirthday());
                statement.setString(3, worker.getLevel());
                statement.setInt(4, worker.getSalary());

                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println("not correct query worker");
        }
    }

    private static void populatingProjectWorkers(Connection conn, String sql, List<ProjectWorker> projectWorkers) {
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (ProjectWorker projectWorker : projectWorkers) {
                statement.setInt(1, projectWorker.getProjectId());
                statement.setInt(2, projectWorker.getWorkerId());

                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println("not correct query projectWorker");
        }
    }
}
