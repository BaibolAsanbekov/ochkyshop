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

            System.out.println("The order has been successfully created.");
        } catch (SQLException e) {
            System.out.println("Error when creating an order: " + e.getMessage());
        }
    }

    public static void deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Установка параметра для ID заказа
            pstmt.setInt(1, orderId);

            // Выполнение запроса на удаление заказа
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order successfully deleted.");
            } else {
                System.out.println("Error: Unable to find an order with this ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error when deleting an order: " + e.getMessage());
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
            System.out.println("Error when adding a product: " + e.getMessage());
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
            System.out.println("Error when adding a product: " + e.getMessage());
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
            System.out.println("No products available.");
            return;
        }
        System.out.println("---------------------------");
        System.out.println("List of all products:");
        System.out.println("---------------------------");
        if (!frames.isEmpty()) {
            System.out.println("Frames:");
            for (String frame : frames) {
                System.out.println(frame);
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("There are no available frames.");
        }

        if (!lenses.isEmpty()) {
            System.out.println("Lenses:");
            for (String lens : lenses) {
                System.out.println(lens);
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("No lenses available.");
        }
    }


    public static void deleteFrame(int frameId) {
        String sql = "DELETE FROM frame WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, frameId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The frame has been successfully removed.");
            } else {
                System.out.println("Error: Could not find a frame with this ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error when removing the frame: " + e.getMessage());
        }
    }

    public static void deleteLens(int lensId) {
        String sql = "DELETE FROM lenses WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, lensId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The lens has been successfully removed.");
            } else {
                System.out.println("Error: Unable to find a lens with this ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error when removing the lens: " + e.getMessage());
        }
    }
    public void viewAllOrders() {
        String sql = "SELECT * FROM orders";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Order list:");
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int nameId = rs.getInt("name_id");
                String name = rs.getString("name");
                String visionParam = rs.getString("vision_param");
                int lensesId = rs.getInt("lenses_id");
                int frameId = rs.getInt("frame_id");
                String status = rs.getString("status");
                String createdAt = rs.getString("created_at");

                System.out.printf("Order ID: %d, Name ID: %d, Name: %s, Vision parameters: %s, ID Lenses: %d, ID Frames: %d, Status: %s, Date of Creation: %s%n",
                        orderId, nameId, name, visionParam, lensesId, frameId, status, createdAt);
            }

        } catch (SQLException e) {
            System.out.println("Error when viewing orders: " + e.getMessage());

        }
    }
    public boolean addOrder(int clientId, String productName, String visionParam, String Create) {
        String sql = "INSERT INTO orders (client_id, product_name, vision_param, status, created_at) VALUES (?, ?, ?, 'Новый', ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clientId);
            pstmt.setString(2, productName);
            pstmt.setString(3, visionParam);
            pstmt.setString(4, Create); // Или используйте java.sql.Timestamp для точной даты и времени

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error when adding an order: " + e.getMessage());
            return false;
        }
    }
    public static void updateOrderStatus(int orderId, String newStatus) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newStatus);
            pstmt.setInt(2, orderId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order status has been successfully updated.");
            } else {
                System.out.println("Error: Unable to find an order with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error when updating order status: " + e.getMessage());
        }
    }
    public static void addOrderClient(int nameId, String name, String visionParam, int lensesId, int frameId,String createdAt) {
        String sql = "INSERT INTO orders (name_id, name, vision_param, lenses_id, frame_id, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, nameId);
            ps.setString(2, name);
            ps.setString(3, visionParam);
            ps.setInt(4, lensesId);
            ps.setInt(5, frameId);
            ps.setString(6, createdAt);

            // Выполняем запрос
            ps.executeUpdate();

            System.out.println("The order has been successfully created.");
        } catch (SQLException e) {
            System.out.println("Error when creating an order: " + e.getMessage());
        }
    }
    public static List<String> getClientOrders(int clientId) {
        List<String> orders = new ArrayList<>();

        String sql = "SELECT * FROM orders WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("id");
                String productName = rs.getString("product_name");
                String visionParam = rs.getString("vision_param");
                String status = rs.getString("status");
                String createdAt = rs.getString("created_at");

                orders.add("order ID: " + orderId + ", Product name: " + productName + ", Vision parameter: " + visionParam
                        + ", Status: " + status + ", Created: " + createdAt);
            }
        } catch (SQLException e) {
            System.out.println("Error when receiving the list of orders: " + e.getMessage());
        }

        return orders;
    }
}