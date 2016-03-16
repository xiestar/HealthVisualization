package dao;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Resident;

public class DB_resident {

	DB_conn db_conn = null;
	
	public Vector<Resident> list_residents(){
		db_conn = new DB_conn();
		ResultSet rs = null;		
		try {
//			String sql = "select RestNo,ResAge,ResSex,District,Hypertension from residents";
			String sql = "select * from residents";
			sql = new String(sql.getBytes("ISO8859-1"), "GB2312");
			rs = db_conn.executeQuery(sql);
			Resident resident = null;
			Vector<Resident> residents = new Vector<Resident>();
           //ResultSet指针最初位于第一行之前，调用next方法使下一行成为当前航
			while(rs.next()){
				resident = new Resident();
				resident.setResNo(rs.getString("RestNo"));
				resident.setResAge(rs.getInt("ResAge"));
				resident.setResSex(rs.getString("ResSex"));
				resident.setDistrict(rs.getString("District"));
				resident.setIshypertension(rs.getInt("Hypertension"));
//				resident.setIshyperglycemia(rs.getInt("Hyperglycemial"));
//				resident.setIshyperlipidemia(rs.getShort("Hyperlipidemia"));
//				resident.setIsobesity(rs.getInt("Obesity"));
				
				//向Vector中添加对象residents
				residents.addElement(resident);
			}
			return residents;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			//关闭连接，释放数据库资源
			db_conn.closeConnection();
		}
		
	}
	
	/**
	 * @param ispreferred
	 * @return
	 * 将表中存储字段ispreferred的值1和0转变为yes和no显示
	 */
	public String int2Str(int isSick){
		String isPre = null;
		if(isSick == 0){
			isPre = "No";
		}else if(isSick == 1){
			isPre = "Yes";
		}else{
			isPre = "error";
		}
		return isPre;
	}
}
