package Lesson8;

import java.sql.*;
import java.util.ArrayList;

public class Demo {
    // �������� singleton DriveManager-a
    public static void main(String[] args) throws SQLException {

        // load JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try ( Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8db.db");
              Statement statement = connection.createStatement()){

            // ������ ������� ��� �������
            performDropTable(statement);

            // ������ �������� ��
            performCreateDB(statement);

            // ������� ������� �������, autoCommit
            populateDB(statement, connection);

            // ������ ���������� �������
            performUpdateDb(statement);

            // �������� �������
            performDeleteRows(statement);

            // ������������ prepared statement
            performPreparedStatement(connection);

            // ������ ������� ������
            readStudentsFromDB(statement);

        }

    }

    private static void performPreparedStatement(Connection connection) throws SQLException {
        // ������������ prepared statement
        try(PreparedStatement  preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?,?)")) {

            for (int i = 1; i < 10; i++) {
                preparedStatement.setString(1, "����" + i);
                preparedStatement.setInt(2, i);
//                preparedStatement.execute();
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }

    private static void performDeleteRows(Statement statement) throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE id > 9000");
    }

    private static void performUpdateDb(Statement statement) throws SQLException {
        performUpdateStudents("UPDATE students SET score = 0 WHERE id > 100", statement);
    }

    private static void performUpdateStudents(String s, Statement statement) throws SQLException {
        statement.executeUpdate(s);
    }

    private static void populateDB(Statement statement, Connection connection) throws SQLException {
        /*-------------- ������������ ������� ������� ----------- */
        //            for (int i = 1; i < 11; i++) {
        //                statement.executeUpdate(
        //                    "INSERT INTO students (name, score) VALUES ('student" + i + "'," + i +");"
        //                );
        //            }

        /*-------------- AUTO COMMIT (�������� �������� � bufferedOutputStream) ----------- */

        /* ������ ����� ���������� ������� 10� ������� */
        //            long start = System.currentTimeMillis();
        //            for (int i = 1; i < 10_000; i++) {
        //                statement.executeUpdate(
        //                    "INSERT INTO students (name, score) VALUES ('student" + i + "'," + i +");"
        //                );
        //            }
        //            System.out.println(System.currentTimeMillis() - start);

        /* ������ ����� ���������� � ���� autoCommit */
        long start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i < 10_000; i++) {
            statement.executeUpdate(
                    "INSERT INTO students (name, score) VALUES ('student" + i + "'," + i +");"
            );
        }
        connection.commit();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students");
    }

    private static void performCreateDB(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name STRING, score INTEGER NOT NULL);");
    }

    private static void readStudentsFromDB(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        // � ������ ������ result set ��������� ��� �������������� �������
        ArrayList<MyClass> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt(1) + " - " +
                            resultSet.getString(2) + " - " +
                            resultSet.getDouble("score") + " - "


            );
            arrayList.add(new MyClass(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble("score")));
        }
        System.out.println("");
    }

    public static class MyClass{
        private Integer id;
        private String name;
        private Double score;

        public MyClass(Integer id, String name, Double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }
    }

}
