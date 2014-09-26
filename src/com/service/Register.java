package com.service;

import com.model.Member;
import com.implementModel.MemberAction;
import org.apache.log4j.Logger;

public class Register {
	private Logger log = Logger.getLogger(this.getClass());
	public Register() {
	}

	public String registerPerform(String[] values){
		String[] birthDateTmp = new String[3];
		values[1] = ("".equals(values[1]) || null == values[1]) ? "null" : "'" + values[1] + "'"; // username
		values[2] = ("".equals(values[2]) || null == values[2]) ? "null" : "'" + values[2] + "'"; // password
		values[3] = ("".equals(values[3]) || null == values[3]) ? "null" : "'" + values[3] + "'"; // fullname
		if(null != values[4]){
			if(!"".equals(values[4])){
				log.info("in Register.registerPerform exist birthdate : >" + values[4] + "<");
				birthDateTmp = values[4].split("/");
				values[4] = birthDateTmp[2] + "-" + birthDateTmp[1] + "-" + birthDateTmp[0];
			}else{
				log.info("in Register.registerPerform birthdate isn't null");
				values[4] = "null";
			}
		}else{
			log.info("in Register.registerPerform birthdate is null");
			values[4] = "null";
		}
		
		values[5] = ("".equals(values[5]) || null == values[5]) ? "null" : values[5]; // height
		values[6] = ("".equals(values[6]) || null == values[6]) ? "null" : values[6]; // weight
	   	values[7] = ("choose".equals(values[7]) || null == values[7]) ? "null" : "'" + values[7] + "'"; // blood_type
		values[8] = ("".equals(values[8]) || null == values[8]) ? "null" : "'" + values[8] + "'"; // hobby
		values[9] = ("".equals(values[9]) || null == values[9]) ? "null" : "'" + values[9] + "'"; // phone
		values[10] = ("".equals(values[10]) || null == values[10]) ? "null" : "'" + values[9] + "'"; // email
		Member mem = new Member();
		mem.setAction(new MemberAction());
		if(mem.getAction().insert("member_tb", null, values))
			return "completed";
		else
			return "fail";
	}
}
