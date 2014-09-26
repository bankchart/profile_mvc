package com.service;

import com.model.Member; 
import com.implementModel.MemberAction;
import com.service.DBConnection;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateLogin {
	private Logger log = Logger.getLogger(this.getClass());
	public void findMember(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int num = 0;
		PrintWriter out = res.getWriter();
		DBConnection conn = new DBConnection();
		String admin = "0";
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");

		username = "'" + username.trim() + "'";
		password = "'" + password.trim() + "'";
		String tableName = new Member().getTableName();
		String sql = "SELECT * FROM " + tableName + " WHERE username = " + username
				+ " AND password = " + password;
		ResultSet rs = conn.manageData(sql);
		HttpSession session = req.getSession(true);
		try{
			while(rs.next()){
				admin = "" + rs.getString("admin");
				num++;
			}
		}catch(Exception ex){
			}
		if (num == 0) {
			log.info("validate login : incorrect");
			log.info("sql for login  :" + sql);
			log.info("username : " + username + ", password  :" + password);
			
			out.print("incorrect");
		} else {		
			log.info("validate login : correct , num : " + num);
			log.info("sql for login  :" + sql);
			Member mem = new Member();
			log.info("map to Member query by username : " + username);
			mem.setAction(new MemberAction());
			Member tmp = mem.getAction().query("member_tb", "username", username);
			mem = tmp;
			if(mem == null){
				log.info("Member is null");				
			}else{
				log.info("Member.getUserName() : " + mem.getUserName());
			}
			session.setAttribute("user", mem);
			log.info("username session : " + ((Member) session.getAttribute("user")).getUserName());
			out.print("correct");
		}

	}

}
