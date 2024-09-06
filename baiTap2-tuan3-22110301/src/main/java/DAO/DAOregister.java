package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.register;

public class DAOregister implements DAOinterface<register>{

	@Override
	public ArrayList<register> selectAll() {
		ArrayList<register> ketQua = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM dangnhap";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String username = rs.getString("usersname");
				String fullName = rs.getString("fullname");
				String Email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String password = rs.getString("password");
				
				
				register register = new register(username, fullName, Email, sdt, password);
				ketQua.add(register);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public register selectById(register t) {
		register reg = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM dangnhap where usersname=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUsername());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String username = rs.getString("usersname");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String password = rs.getString("password");
				
				reg = new register(username, fullname, sdt, email, password);
				
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reg;
	}

	@Override
	public int insert(register t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO dangnhap (usersname, fullname, email, sdt, password) "+
					" VALUES (?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUsername());
			st.setString(2, t.getFullname());
			st.setString(3, t.getEmail());
			st.setString(4, t.getSdt());
			st.setString(5, t.getPassword());
			
			ketQua = st.executeUpdate();
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<register> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(register t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<register> arr) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int update(register t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE dangnhap "+ " SET " +" fullname=? , email=? , sdt = ?, password = ?"+ " WHERE usersname=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullname());
			st.setString(2, t.getEmail());
			st.setString(3, t.getSdt());
			st.setString(4, t.getPassword());
			st.setString(5, t.getUsername());
			
			
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean reg = false;
		try {
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM dangnhap where usersname=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				return true;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reg;
	}
	public boolean checkLogin(String username, String password) {
	    boolean reg = false;
	    String sql = "SELECT * FROM dangnhap WHERE usersname = ? AND password = ?";
	    
	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement st = con.prepareStatement(sql)) {
	        
	        // Thiết lập các giá trị cho câu lệnh SQL
	        st.setString(1, username);
	        st.setString(2, password);
	        
	        // Thực thi truy vấn
	        try (ResultSet rs = st.executeQuery()) {
	            // Kiểm tra nếu có kết quả trả về
	            if (rs.next()) {
	                reg = true; // Nếu tìm thấy tài khoản, đăng nhập thành công
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ SQL
	    }
	    
	    return reg;
	}
}
