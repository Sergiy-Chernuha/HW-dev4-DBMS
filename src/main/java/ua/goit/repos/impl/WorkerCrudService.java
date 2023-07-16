package ua.goit.repos.impl;

import ua.goit.configs.Database;
import ua.goit.db_dto.Level;
import ua.goit.db_dto.Worker;
import ua.goit.repos.DtoCrudServices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WorkerCrudService implements DtoCrudServices<Worker> {
    Connection conn;

    public WorkerCrudService() {
        conn = Database.getInstance().getConnection();
    }

    @Override
    public void save(Worker entity) {
        if (Objects.isNull(entity.getId())) {
            saveAsNew(entity);
        } else if (findById(entity.getId()).isEmpty()) {
            saveAsNew(entity);
        } else {
            update(entity);
        }
    }

    private void saveAsNew(Worker entity) {
        String insertSQL = "insert into worker (NAME,BIRTHDAY,LEVEL,SALARY) values (?,?,?::EXP,?)";

        if (Objects.isNull(entity.getId())) {
            try (PreparedStatement preparedStatement =
                         conn.prepareStatement(insertSQL)) {

                preparedStatement.setString(1, entity.getName());
                preparedStatement.setDate(2, entity.getBirthday());
                preparedStatement.setString(3, entity.getLevel());
                preparedStatement.setInt(4, entity.getSalary());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<Worker> findById(Long id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from worker where ID=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Worker worker = null;

            while (resultSet.next()) {
                worker = new Worker(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getDate("BIRTHDAY"),
                        Level.valueOf(resultSet.getString("LEVEL").toUpperCase()),
                        resultSet.getInt("SALARY"));
            }

            resultSet.close();
            return Optional.of(worker);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Worker> findAll() {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from worker")) {
            List<Worker> workers = new ArrayList<>();

            while (resultSet.next()) {
                Worker worker = new Worker(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getDate("BIRTHDAY"),
                        Level.valueOf(resultSet.getString("LEVEL").toUpperCase()),
                        resultSet.getInt("SALARY")
                );

                workers.add(worker);
            }

            return workers;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void update(Worker entity) {
        try (PreparedStatement preparedStatement =
                     conn.prepareStatement("update worker set NAME=?,BIRTHDAY=?,LEVEL=?::EXP,SALARY=? where id=?")) {

            preparedStatement.setLong(5, entity.getId());
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDate(2, entity.getBirthday());
            preparedStatement.setString(3, entity.getLevel());
            preparedStatement.setInt(4, entity.getSalary());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("delete from worker where id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Worker entity) {
        deleteById(entity.getId());
    }

    @Override
    public void deleteAll() {
        try (Statement statement = conn.createStatement()) {
            statement.execute("delete from worker");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
