package database.database;

import database.config.DatabaseProperties;
import database.config.PropertiesFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MyDataBase {
    private static MyDataBase instance;

    private final DatabaseProperties properties = PropertiesFactory.getProperties();

    private MyDataBase() {
        init();
    }

    public synchronized static MyDataBase getInstance() {
        if (instance == null) {
            instance = new MyDataBase();
        }

        return instance;
    }

    private void init() {
        createSchema();
        createTableGamblers();
    }

    public void createSchema() {
        String sql = """
                    create schema if not exists dice;
                    """;
        execute(sql);
    }

    private void createTableGamblers() {
        String sql = """
                    create table if not exists dice.gamblers (
                    id serial primary key,
                    name varchar(255),
                    gamblers integer,
                    bolt integer
                    )
                    """;

        execute(sql);
    }

    public void execute(String sql) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public int selectSomeColumnByName(String name, String column) {
        int result = 0;
        String sql = """
                    select %s
                    from dice.gamblers
                    where name = '%s'
                    """;
        String select = String.format(sql, column, name);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                result = set.getInt(column);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public int selectColumnById(int id, String column) {
        int result = 0;
        String sql = """
                    select %s
                    from dice.gamblers
                    where id = %d
                    """;
        String select = String.format(sql, column, id);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                result = set.getInt(column);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public String selectNameById(int id, String column) {
        String result = null;
        String sql = """
                    select %s
                    from dice.gamblers
                    where id = %d
                    """;
        String select = String.format(sql, column, id);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                result = set.getString("name");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public Map<Integer, String> selectAll(String... columnNames) {

        String sql = """
                    select %s
                    from dice.gamblers
                    """;
        String names = String.join(", ", columnNames);

        String select = String.format(sql, names);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(select);
            String resultString = "";

            Map<Integer, String> obj = new HashMap<>();
            int i = 0;
            while (result.next()) {
                ++i;
                resultString = "name is: " + result.getString(1) + " | count of opponents is: " + result.getString(2) + " | bolt is: " + result.getString(3);
                obj.put(i, resultString);
            }

            return obj;
        } catch (SQLException ex) {
            System.out.println("Cannot connect to DB: " + ex.getMessage());
            return Map.of();
        }
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(
                properties.getUrl(),
                properties.getUser(),
                properties.getPassword()
        );
    }
}