package com.service;
import com.model.Member;
import com.implementModel.MemberAction;
import java.sql.ResultSet;

public class ValidateRegister {
	public ValidateRegister(){}
	public String isRepeatUsername(String username){
		Member mem = new Member();
		ResultSet rs;
		mem.setAction(new MemberAction());
		rs = (ResultSet) mem.getAction().query("member_tb", "username", username);		
		return (rs == null) ? "no-repeat" : "repeat";
	}
}
