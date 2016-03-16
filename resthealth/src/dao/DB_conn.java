package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author star
 * ���ݿ�����Bean
 * 2014��2��21��
 */
public class DB_conn {
	
	private final String dbDriver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/rest_health";  
	private final String userName = "root";
	private final String passWord = "root";
	
	private ResultSet rs = null;
	private Statement stmt = null;
	private Connection conn = null;
	
	public DB_conn() {
		try {
			Class.forName(dbDriver).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ����ʧ�ܡ�����");
		} 		
	}	
	
	private boolean createConnection(){
		
		try {
			conn = DriverManager.getConnection(url,userName,passWord);
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * @param sql
	 * @return
	 * ���ݿ����
	 */
	public boolean executeUpdate(String sql){		
		if(null == conn){
			createConnection();
		}		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * @param sql
	 * @return
	 * ���ݿ��ѯ
	 */
	public ResultSet executeQuery(String sql){
		if(null == conn){	
			createConnection();
		}		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public void closeConnection(){
		if(null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != stmt){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
