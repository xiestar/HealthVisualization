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
           //ResultSetָ�����λ�ڵ�һ��֮ǰ������next����ʹ��һ�г�Ϊ��ǰ��
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
				
				//��Vector����Ӷ���residents
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
			//�ر����ӣ��ͷ����ݿ���Դ
			db_conn.closeConnection();
		}
		
	}
	
	/**
	 * @param ispreferred
	 * @return
	 * �����д洢�ֶ�ispreferred��ֵ1��0ת��Ϊyes��no��ʾ
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
