package DataManager;

import java.sql.*;

public class DataManager {
    private static final String DATABASE_URL = "jdbc:sqlite:mydatabase.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void createOrder(int nameId, String name, String visionParam, int lensesId, int frameId, String status, String createdAt) {
        String sql = "INSERT INTO orders (name_id, name, vision_param, lenses_id, frame_id, status, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);){

            ps.setInt(1, nameId);
            ps.setString(2, name);
            ps.setString(3, visionParam);
            ps.setInt(4, lensesId);
            ps.setInt(5, frameId);
            ps.setString(6, status);
            ps.setString(7, createdAt);

            // Выполняем запрос
            ps.executeUpdate();

            System.out.println("Заказ успешно создан.");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании заказа: " + e.getMessage());
        }
    }

    public static void deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Установка параметра для ID заказа
            pstmt.setInt(1, orderId);

            // Выполнение запроса на удаление заказа
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Заказ успешно удален.");
            } else {
                System.out.println("Ошибка: Не удалось найти заказ с таким ID.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении заказа: " + e.getMessage());
        }
    }




    }