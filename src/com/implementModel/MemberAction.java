package com.implementModel;
import com.interfaceModel.ActionModel;  
import com.service.DBConnection;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import com.model.Member;
import java.sql.ResultSet;
public class MemberAction implements ActionModel{
	private Logger log = Logger.getLogger(this.getClass());
	private DBConnection conn = null;
	private ResultSet rs;
	
	public Member query(String tableName, String pointerName, String pointerValue){
		String sql = "SELECT * FROM " + tableName + " WHERE " + pointerName + "=" + pointerValue;
		Member mem = new Member();
		conn = new DBConnection();
		rs = conn.manageData(sql);
		try{
		while(rs.next()){
			log.info("MemberAction rs.next() in while");
			mem.setUserID(Integer.parseInt(rs.getString("userid")));
			mem.setUserName(rs.getString("username"));
			mem.setPassword(rs.getString("password"));
			mem.setFullName(rs.getString("fullname"));
			mem.setBirthDate(rs.getString("birthdate"));
			mem.setHeight(Float.parseFloat(rs.getString("height")));
			mem.setWeight(Float.parseFloat(rs.getString("weight")));
			mem.setBloodType(rs.getString("blood_type"));
			mem.setHobby(rs.getString("hobby"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setDetailEdu(rs.getString("detail_edu"));
			mem.setDetailFav(rs.getString("detail_fav"));
			mem.setDetailLsk(rs.getString("detail_lsk"));
			mem.setPicturePath(rs.getString("picturePath"));
			mem.setAdmin(Integer.parseInt(rs.getString("admin")));
			mem.setCareerID(Integer.parseInt(rs.getString("career_id")));
		}
		}catch(Exception ex){
			log.info("MemberAction Exception in rs.next() : " + ex.getLocalizedMessage());
		}
		return mem;
	}
	
	public ResultSet update(String tableName, String field, String update, String pointerName, String pointerValue){
		String sql = "UPDATE " + tableName + " SET " + field + "=" + 
				update + " WHERE " + pointerName + "=" + pointerValue;
		conn = new DBConnection();
		rs = conn.manageData(sql);
		conn.closeDB();
		return rs;
	}
	
	public boolean insert(String tableName, String[] fields, String[] values){
		String fieldName = "";
		String valuesTmp = "";
		boolean result = false;
		fieldName += " ("; 
		for(int i=0;i<values.length-1;i++){
			if(fields != null)
				fieldName += fields[i] + ", ";
			valuesTmp += values[i] + ", ";
		}
		if(fields != null)
			fieldName += fields[fields.length - 1] + ")";
		else
			fieldName = "";
		valuesTmp += values[values.length - 1];
		String sql = "INSERT INTO " + tableName + fieldName + " VALUES (" + 
					valuesTmp + ")";
		log.info("insert =>>>> " + sql);
		try{
			result = conn.executeData(sql);
			
		}catch(Exception ex){
			
			log.info("after conn.executeData(sql) : " + ex.getMessage());
		}
		return result;
		
	}
	
}
