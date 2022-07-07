package dao;

import model.Sach;
import connect.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Queue;

public class SachDAO implements DAOInterface<Sach> {
    public static SachDAO getInstance() {
        return new SachDAO();
    }
 
    @Override
    public int insert(Sach sach) throws SQLException {
        int rowAffected = 0;
        try {
            //Create connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/nhasach", "root", "");
            //Create PreparedStatement
            String sql = "Insert Into sach(id, tenSach, giaBan, namXuatBan, ngayXuatBan)\n"
                    + "values(?, ?, ?, ?, ?);";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, sach.getId());
            pstm.setString(2, sach.getTenSach());
            pstm.setFloat(3, sach.getGiaBan());
            pstm.setInt(4, sach.getNamXuatBan());
            pstm.setDate(5, sach.getNgayXuatBan());
            rowAffected = pstm.executeUpdate();
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAffected;
    }

    @Override
    public int update(Sach sach) {
        int rowAffected = 0;
        try {
            //Create connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/nhasach", "root", "");
            //Create PreparedStatement
            String sql = "Update sach Set tenSach = ?, giaBan = ?, namXuatBan = ?, ngayXuatBan = ?\n" +
                    "Where id = ?;";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, sach.getTenSach());
            pstm.setFloat(2, sach.getGiaBan());
            pstm.setInt(3, sach.getNamXuatBan());
            pstm.setDate(4, sach.getNgayXuatBan());
            pstm.setString(5, sach.getId());
            rowAffected = pstm.executeUpdate();
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAffected;
    }

    @Override
    public int delete(Sach sach) {
        int rowAffected = 0;
        try {
            //Create connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/nhasach", "root", "");
            //Create PreparedStatement
            String sql = "Delete From sach\n" +
                    "Where id = ?;";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, sach.getId());
            rowAffected = pstm.executeUpdate();
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAffected;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            //Create connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/nhasach", "root", "");
            //Create PreparedStatement
            String sql = "Select * from sach;";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Date ngayXuatBan = rs.getDate("ngayXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan, ngayXuatBan);
                listSach.add(sach);
            }
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSach;
    }

    @Override
    public Sach selectById(Sach sach) {
        Sach s = null;
        try {
            //Close connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/nhasach", "root", "");
            //Create PreparedStatement
            String sql = "Select * from sach\n" +
                    "where id = ?;";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, sach.getId());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Date ngayXuatBan = rs.getDate("ngayXuatBan");
                s = new Sach(id, tenSach, giaBan, namXuatBan, ngayXuatBan);
            }
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            //Create connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/nhasach", "root", "");
            //Create PreparedStatement
            String sql = "Select * from sach\n" +
                    "Where " + condition + ";";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Date ngayXuatBan = rs.getDate("ngayXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan, ngayXuatBan);
                listSach.add(sach);
            }
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSach;
    }

    public static int loadTable(Queue<Sach> queue, int batchSize) throws SQLException {
        int [] rowAffected = new int[0];
        try {
            //Create connection
            Connection connection = JDBCUtil.getConnection("jdbc:mySQL://localhost:3306/bookstore", "root", "");
            connection.setAutoCommit(false);
            //Create PreparedStatement
            String sql = "Insert Into book(id, tenSach, giaBan, namXuatBan, ngayXuatBan)\n"
                    + "values(?, ?, ?, ?, ?);";
            PreparedStatement pstm = connection.prepareStatement(sql);
            int a = 0;
            if (queue.size() >= batchSize){
                a = batchSize;
            }else {
                a = queue.size();
            }
            for (int i = 0; i < a; i++) {
                Sach sach = queue.poll();
                pstm.setString(1, sach.getId());
                pstm.setString(2, sach.getTenSach());
                pstm.setFloat(3, sach.getGiaBan());
                pstm.setInt(4, sach.getNamXuatBan());
                pstm.setDate(5, sach.getNgayXuatBan());
                pstm.addBatch();
            }
            try {
                rowAffected = pstm.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAffected.length;
    }
}



