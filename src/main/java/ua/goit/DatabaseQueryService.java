package ua.goit;

import ua.goit.configs.Database;
import ua.goit.db_dto.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String fileName = "src/main/java/resource/SQL/find_max_projects_client.sql";
        List<MaxProjectCountClient> resultList = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(fileName)) {

            while (resultSet.next()) {
                resultList.add(
                        new MaxProjectCountClient
                                (resultSet.getString("name")
                                        , resultSet.getInt("PROJECT_COUNT")));
            }
        } catch (SQLException e) {
            System.out.println("not correct query");
        }

        return resultList;
    }

    public List<MaxSalaryCountWorker> findMaxSalaryWorker() {
        String fileName = "src/main/java/resource/SQL/find_max_salary_worker.sql";
        List<MaxSalaryCountWorker> resultList = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(fileName)) {

            while (resultSet.next()) {
                resultList.add(
                        new MaxSalaryCountWorker
                                (resultSet.getString("name")
                                        , resultSet.getInt("salary")));
            }
        } catch (SQLException e) {
            System.out.println("not correct query");
        }

        return resultList;
    }

    public List<LongestProject> findLongestProject() {
        String fileName = "src/main/java/resource/SQL/find_longest_project.sql";
        List<LongestProject> resultList = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(fileName)) {

            while (resultSet.next()) {
                resultList.add(
                        new LongestProject
                                (resultSet.getInt("id")
                                        , resultSet.getInt("MONTH_COUNT")));
            }
        } catch (SQLException e) {
            System.out.println("not correct query");
        }

        return resultList;
    }

    public List<AgeestWorker> findYoungestOldestWorkers() {
        String fileName = "src/main/java/resource/SQL/find_youngest_eldest_workers.sql";
        List<AgeestWorker> resultList = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(fileName)) {

            while (resultSet.next()) {
                resultList.add(
                        new AgeestWorker
                                (resultSet.getString("TYPE")
                                        , resultSet.getString("name")
                                        , LocalDate.parse(resultSet.getString("birthday"))));
            }
        } catch (SQLException e) {
            System.out.println("not correct query");
        }

        return resultList;
    }

    public List<ProjectPrice> findProjectPrices() {
        String fileName = "src/main/java/resource/SQL/print_project_prices.sql";
        List<ProjectPrice> resultList = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(fileName)) {

            while (resultSet.next()) {
                resultList.add(
                        new ProjectPrice
                                (resultSet.getInt("project_id")
                                        , resultSet.getInt("Amount")));
            }
        } catch (SQLException e) {
            System.out.println("not correct query");
        }

        return resultList;
    }

    private ResultSet getResultSet(String fileName) throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        String sql = DBUtils.getSQL(fileName);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }
}
