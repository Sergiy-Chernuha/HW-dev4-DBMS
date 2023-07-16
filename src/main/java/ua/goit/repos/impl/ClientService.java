package ua.goit.repos.impl;

import ua.goit.configs.Database;
import ua.goit.db_dto.Client;
import ua.goit.repos.DtoCrudServices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClientService implements DtoCrudServices<Client> {
    Connection conn;

    public ClientService() {
        conn = Database.getInstance().getConnection();
    }

    @Override
    public void save(Client entity) {
        if (Objects.isNull(entity.getId())) {
            saveAsNew(entity);
        } else if (findById(entity.getId()).isEmpty()) {
            saveAsNew(entity);
        } else {
            update(entity);
        }
    }

    private void saveAsNew(Client entity) {
        String insertSQL = "insert into client (name) values (?)";

        if (Objects.isNull(entity.getId())) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {

                preparedStatement.setString(1, entity.getName());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<Client> findById(Long id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from client where ID=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Client client = null;

            while (resultSet.next()) {
                client = new Client(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"));
            }
            resultSet.close();

            return Optional.ofNullable(client);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Client> findAll() {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from client")) {
            List<Client> clients = new ArrayList<>();

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"));

                clients.add(client);
            }

            return clients;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void update(Client entity) {
        try (PreparedStatement preparedStatement =
                     conn.prepareStatement("update client set NAME=? where id=?")) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("delete from client where id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Client entity) {
        deleteById(entity.getId());
    }

    @Override
    public void deleteAll() {
        try (Statement statement = conn.createStatement()) {
            statement.execute("delete from client");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
