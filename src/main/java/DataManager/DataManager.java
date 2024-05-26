package DataManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;

public class DataManager {
    private static final String DATABASE_URL = "jdbc:sqlite:mydatabase.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void createOrder(int nameId, String name, String visionParam, int lensesId, int frameId, String status, String createdAt) {
        String sql = "INSERT INTO orders (name_id, name, vision_param, lenses_id, frame_id, status, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);) {

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

    public static boolean addFrame(String name, String description) {
        String sql = "INSERT INTO frame (form, description) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, description);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении товара: " + e.getMessage());
            return false;
        }
    }

    public static boolean addLenses(String name, String description) {
        String sql = "INSERT INTO lenses (name, description) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, description);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении товара: " + e.getMessage());
            return false;
        }
    }

    public static List<String> getAllFrames() {
        String sql = "SELECT * FROM frame";
        List<String> frames = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String frame = "Frame ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("form") +
                        ", Description: " + rs.getString("description");

                frames.add(frame);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return frames;
    }

    public static List<String> getAllLenses() {
        String sql = "SELECT * FROM lenses";
        List<String> lenses = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String lens = "Lens ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Description: " + rs.getString("description");
                lenses.add(lens);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lenses;
    }

    public static void viewAllProducts() {
        List<String> frames = getAllFrames();
        List<String> lenses = getAllLenses();

        if (frames.isEmpty() && lenses.isEmpty()) {
            System.out.println("Нет доступных товаров.");
            return;
        }
        System.out.println("---------------------------");
        System.out.println("Список всех товаров:");
        System.out.println("---------------------------");
        if (!frames.isEmpty()) {
            System.out.println("Оправы:");
            for (String frame : frames) {
                System.out.println(frame);
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("Нет доступных оправ.");
        }

        if (!lenses.isEmpty()) {
            System.out.println("Линзы:");
            for (String lens : lenses) {
                System.out.println(lens);
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("Нет доступных линз.");
        }
    }


    public static void deleteFrame(int frameId) {
        String sql = "DELETE FROM frame WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, frameId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Оправа успешно удалена.");
            } else {
                System.out.println("Ошибка: Не удалось найти оправу с таким ID.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении оправы: " + e.getMessage());
        }
    }

    public static void deleteLens(int lensId) {
        String sql = "DELETE FROM lenses WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, lensId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Линза успешно удалена.");
            } else {
                System.out.println("Ошибка: Не удалось найти линзу с таким ID.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении линзы: " + e.getMessage());
        }
    }

}