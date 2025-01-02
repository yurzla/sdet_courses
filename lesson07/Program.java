import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * проект написан и запускается в vscode
 */

/* Задание 7:
 * Тема Базы данных.
 * Зарегистрироваться на https://sql-ex.ru/ и выполнить задания 1-20 https://sql-ex.ru/exercises/index.php?act=learn
 * 
 * С помощью JDBC реализовать создание БД, наполнение ее данными и выборку и
 * изменение этих данных. В качестве субд выбрать любую удобную для разворачивания на
 * локальной машине (например, PostgreSQL).
 */
public class Program{
    static String jdbcURL = "jdbc:postgresql://localhost:5433/";
    static String username = "postgres";
    static String password = "1";

    /*
     * создание БД, наполнение ее данными, выборка и изменение этих данных
     */
    public static void main(String[] args) {
        String databaseName = "lesson07";
        String tableName = "foobarbaz1";
        try {
            Class.forName("org.postgresql.Driver"); // проверяем наличие драйвера для постгреса, если нет - кидается исключение
            try {
                createDatabase(databaseName); // создание базы кидает исключение если база уже есть
            }
            catch (Exception e) {
                /* не говорим про исключение, т.к. оно могло вылететь при попытке создания существующей базы */
            }
            createTableIfNotExists(databaseName, tableName);

            addRecordToTable(databaseName, tableName, new Record("foo1", "bar1", "baz1"));
            addRecordToTable(databaseName, tableName, new Record("foo2", "bar2", "baz2"));
            addRecordToTable(databaseName, tableName, new Record("foo3", "bar3", "baz3"));

            ArrayList<Record> result = getRecordsByFoo(databaseName, tableName, "foo1");
            System.out.println(
                    "[" + String.join(";\n", result.stream().map(x -> x.toString()).toArray(String[]::new)) + "]");

            patchRecordsByFoo(databaseName, tableName, "foo2", new Record("foo2", "bar2m", "baz2m"));

            result = getRecordsByFoo(databaseName, tableName, "foo2");
            System.out.println(
                    "[" + String.join(";\n", result.stream().map(x -> x.toString()).toArray(String[]::new)) + "]");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * создание базы данных
     * @param databaseName - имя базы данных которую надо создать
     */
    public static void createDatabase(String databaseName) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
                Statement stmt = conn.createStatement();) {
            stmt.executeUpdate("CREATE DATABASE " + databaseName);
        }
    }

    /*
     * создает таблицу со столбцами Foo, Bar, Baz
     * @param databaseName база где создаем таблицу
     * @param tableName имя таблицы котоую хотим создать
     */
    public static void createTableIfNotExists(String databaseName, String tableName) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS \"" + tableName + "\" (Id serial PRIMARY KEY, Foo VARCHAR(255), Bar VARCHAR(255), Baz VARCHAR(255))";
        try (Connection conn = DriverManager.getConnection(jdbcURL + databaseName, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        }
    }

    /*
     * запись в таблице со стообцами Foo, Bar, Baz
     */
    static class Record {
        public String Foo;
        public String Bar;
        public String Baz;

        public Record() {
        }

        public Record(String foo, String bar, String baz) {
            this.Foo = foo;
            this.Bar = bar;
            this.Baz = baz;
        }

        public String toString() {
            return "{" + String.join(",", new String[] { this.Foo, this.Bar, this.Baz }) + "}";
        }
    }

    /*
     * добавление записи в таблицу
     * @param databaseName имя базы данных
     * @param tableName имя таблицы в которую производится добавление записи
     * @param recordToAdd данные которые записываем в таблицу
     */
    public static void addRecordToTable(String databaseName, String tableName, Record recordToAdd) throws SQLException
    {
        String sql = "INSERT INTO \"" + tableName + "\" (foo, bar, baz) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL + databaseName, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recordToAdd.Foo);
            pstmt.setString(2, recordToAdd.Bar);
            pstmt.setString(3, recordToAdd.Baz);
            pstmt.executeUpdate();
        }
    }

    /*
     * выбираем все записи из таблицы по значению поля foo
     * @param databaseName имя базы данных
     * @param tableName имя таблицы в которой ищем
     * @param foo значение поля по которому будем выбирать записи в таблице
     * @return список найденных в таблице Record-ов
     */
    public static ArrayList<Record> getRecordsByFoo(String databaseName, String tableName, String foo)
            throws SQLException {
        ArrayList<Record> result = new ArrayList<Record>();
        String sql = "SELECT * FROM \"" + tableName + "\" WHERE foo=?";
        try (Connection conn = DriverManager.getConnection(jdbcURL + databaseName, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, foo);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Record(resultSet.getString("foo"), resultSet.getString("bar"),
                            resultSet.getString("baz")));
                }
            }
        }
        return result;
    }

    /*
     * меняем все записи в таблице со значением поля foo
     * @param databaseName имя базы данных
     * @param tableName имя таблицы в которой ищем и меняем записи
     * @param foo значение поля по которому будем выбирать записи в таблице
     * @param newRecord значения которые будем устанавливаться найденным записям
     */
    public static void patchRecordsByFoo(String databaseName, String tableName, String foo, Record newRecord)
            throws SQLException {
        String sql = "UPDATE \"" + tableName + "\" SET foo=?, bar=?, baz=? WHERE foo=?";
        try (Connection conn = DriverManager.getConnection(jdbcURL + databaseName, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newRecord.Foo);
            pstmt.setString(2, newRecord.Bar);
            pstmt.setString(3, newRecord.Baz);
            pstmt.setString(4, foo);
            pstmt.executeUpdate();
        }
    }
}