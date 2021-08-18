import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "291103";

        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            if (!connection.isClosed()) {
                System.out.println("соеденение выполнено");
            }

            System.out.println("введите id, возраст, имя, фамилию :");
            int id = scanner.nextInt();
            int age = scanner.nextInt();
            String name = scanner.next();
            String surname = scanner.next();

            String query =
                    "INSERT INTO users.Customers " +
                            "(id, Age, FirstName, LastName) values(?, ?, ?, ?)";

            try(final PreparedStatement prst = connection.prepareStatement(query)) {
                prst.setInt(1, id);
                prst.setInt(2, age);
                prst.setString(3, name);
                prst.setString(4, surname);

                prst.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
