package membership;

import java.sql.*;

public class MemberBeanDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/jspdb";


	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "1116");
			System.out.print("커넥트 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 신규 주소록 메시지 추가 메소드
	public boolean insertDB(MemberDO member) {

		connect();

		String sql = "insert into jspdb(id,name,password) values(?,?,?)";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.print("여기");
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;

	}
	
	public boolean delete(String id) {
	

		connect();
		String sql ="delete from jspdb where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
			return false;
		}
		finally {	disconnect();}
		return true;

	}

	// 특정 주소록 게시글 가져오는 메서드
	public boolean login(MemberDO mao) {
		connect();
		String sql = "select * from jspdb where id=? and password=?";
		MemberDO ma = new MemberDO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mao.getId());
			pstmt.setString(2, mao.getPassword());
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			ma.setId(rs.getString("id"));
			ma.setName(rs.getString("name"));
			ma.setPassword(rs.getString("password"));
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		if(ma.getId()!= null)
			return true;
		else
			return false;
	}
	// 특정 주소록 게시글 가져오는 메서드
		public MemberDO userdata(MemberDO mao) {
			connect();
			String sql = "select * from jspdb where id=?";
			MemberDO ma = new MemberDO();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mao.getId());
				
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
				ma.setId(rs.getString("id"));
				ma.setName(rs.getString("name"));
				ma.setPassword(rs.getString("password"));
				
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return ma;
		}
		public boolean update(MemberDO mao) {
			// 수정된 주소록 내용 갱신을 위한 메서드
				connect();
				String sql ="update jspdb set id=?, name=?, password=? where id=?";		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,mao.getId());
				pstmt.setString(2,mao.getName());
				pstmt.setString(3, mao.getPassword());
				pstmt.setString(4,mao.getId());
			
				pstmt.executeUpdate();
				} catch (SQLException e) { e.printStackTrace();
				return false;
				}
			return true;
		}
}
