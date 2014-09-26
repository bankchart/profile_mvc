package com.service;

import org.springframework.ui.ModelMap; 
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import com.model.Member;

public class ExistMember {
	private Logger log = Logger.getLogger(this.getClass());
	private HttpSession session;
	public ExistMember(){}
	
	public String MemberSetting(ModelMap model, HttpServletRequest req, String chk) 
	throws ServletException, IOException {
			
		if(null == session.getAttribute("user")){
			return "login";
		}else{
			return "profile";
		}
		
	}

}
