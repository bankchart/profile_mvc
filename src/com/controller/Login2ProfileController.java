package com.controller;

import org.apache.log4j.Logger; 

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import com.model.Member;
import com.service.ExistMember;
import com.service.ValidateLogin;
import com.service.Register;
import com.service.ValidateRegister;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Login2ProfileController {

	private HttpSession session;
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String forceLogout(HttpServletRequest req) throws ServletException, IOException {
		session = req.getSession(true);
		session.setAttribute("user", null);
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String actionIndex(HttpServletRequest req, HttpServletResponse res, ModelMap model)
			throws ServletException, IOException {

		
		
		ExistMember chkMem = new ExistMember();
		//session = req.getSession(true);
		//session.setAttribute("user", null);
		String direct = "profile";
	
		if(null == session.getAttribute("user"))
			direct = "login";
		//String direct = chkMem.MemberSetting(model, req, s);
		
		if(direct.equals("profile")){
			//test(req, res);
			session = req.getSession(true);
			Member tmp = (Member)session.getAttribute("user");
		//Member tmp = (Member)session.getAttribute("user");
		
		String username = tmp.getUserName();
		String fullname = tmp.getFullName();
		String birthdate = tmp.getBirthDate();
		String height = "" + tmp.getHeight();
		String weight = "" + tmp.getWeight();
		String blood_type = tmp.getBloodType();
		String hobby = tmp.getHobby();
		String phone = tmp.getPhone();
		String email = tmp.getEmail();
		String detail_edu = tmp.getDetailEdu();
		String detail_fav = tmp.getDetailFav();
		String detail_lsk = tmp.getDetailLsk();
		String admin = "" + tmp.getAdmin();
		String career_id = "" + tmp.getCareerID();
		
		
		
		model.addAttribute("username", username);
		model.addAttribute("fullname", fullname);
		model.addAttribute("birthdate", birthdate);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("blood_type", blood_type);
		model.addAttribute("hobby", hobby);
		model.addAttribute("phone", phone);
		model.addAttribute("email", email);
		model.addAttribute("detail_edu", detail_edu);
		model.addAttribute("detail_fav", detail_fav);
		model.addAttribute("detail_lsk", detail_lsk);
		model.addAttribute("admin", admin);
		model.addAttribute("career_id", career_id);
			return direct;
			}else{
				return direct;
			}
		
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public void test(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		PrintWriter out = res.getWriter();
		session = req.getSession(true);
		Member tmp = (Member)session.getAttribute("user");
		//out.print(tmp.getUserName());
	}
	
	@RequestMapping(value = "Login2Profile", method = RequestMethod.POST)
	public void checkLogin(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		log.info("in checkLogin mapping : Login2Profile");
		new ValidateLogin().findMember(req, res);

	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public void registerMember(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ValidateRegister vReg = new ValidateRegister();
		Register reg = new Register();
		String mode = (String) req.getParameter("mode");
		String username = (String) req.getParameter("memReg");
		PrintWriter out = res.getWriter();
		if ("isRepeatUsername".equals(mode)) {
			out.print(vReg.isRepeatUsername(username));
		} else {
			String[] values = {

					"null", // userid
					(String) req.getParameter("username"),
					(String) req.getParameter("passwd"),
					(String) req.getParameter("fullname"),
					(String) req.getParameter("birthdate"),
					(String) req.getParameter("height"),
					(String) req.getParameter("weight"),
					(String) req.getParameter("blood_type"),
					(String) req.getParameter("hobby"),
					(String) req.getParameter("phone"),
					(String) req.getParameter("email"), 
					"null", // detail_edu
					"null", // detail_fav
					"null", // detail_lsk
					"null",
					"0", // admin
					"3" // career_id : no career

			};
			out.print(reg.registerPerform(values));
		}
		
		/*
		 * 
		 * Member member = new Member();
		 * 
		 * String username = req.getParameter("username"); String password =
		 * req.getParameter("passwd"); String repassword =
		 * req.getParameter("repasswd"); String fullname =
		 * req.getParameter("fullname"); String birthdate =
		 * req.getParameter("birthdate"); String height =
		 * req.getParameter("height"); String weight =
		 * req.getParameter("weight"); String bloodType =
		 * req.getParameter("blood-type"); String hobby =
		 * req.getParameter("hobby"); String education =
		 * req.getParameter("education"); String faculty =
		 * req.getParameter("faculty"); String major =
		 * req.getParameter("major"); String phone = req.getParameter("phone");
		 * String email = req.getParameter("email");
		 * 
		 * if(birthdate.length() > 0){ String[] tmpDate = birthdate.split("/");
		 * birthdate = "'" + tmpDate[2] + "-" + tmpDate[1] + "-" + tmpDate[0] +
		 * "'"; }else{ birthdate = "null"; } try{ Double.parseDouble(height);
		 * }catch(Exception ex){ height = "0"; } try{
		 * Double.parseDouble(weight); }catch(Exception ex){ weight = "0"; }
		 * if("choose".equals(bloodType)) bloodType = null; if("".equals(hobby))
		 * hobby = null; if("".equals(phone)) phone = null; if("".equals(email))
		 * email = null; member.setUserName(username);
		 * member.setPassword(password); member.setFullName(fullname);
		 * member.setBirthDate(birthdate);
		 * member.setHeight(Float.parseFloat(height));
		 * member.setWeight(Float.parseFloat(weight));
		 * member.setBloodType(bloodType); member.setHobby(hobby);
		 * member.setPhone(phone); member.setEmail(email);
		 * member.setDetailEducation("null"); member.setDetailFavorite("null");
		 * member.setDetailLittleSkill("null"); member.setPicturePath("null");
		 * member.setAdmin(0); member.setCareerID(3); log.info("in register.");
		 * //String tmp = member.sqlExecute("insert", "" ,"" ,"" ,"");
		 * 
		 * if(member.sqlExecute("insert", "" ,"" ,"" ,"")) return true; else
		 * return false;
		 */
		// return tmp;
	}
	
	public void getAllData(ModelMap model, HttpServletRequest req,
			HttpServletResponse res, String username) throws ServletException,
			IOException {
		/*
		 * DBConnection conn = new DBConnection(); //String usernametmp =
		 * (String)session.getAttribute("user"); String sql =
		 * "SELECT * FROM member_tb WHERE username = '" + username + "'";
		 * ResultSet rs = conn.manageData(sql); String password = ""; String
		 * fullname = ""; String birthdate = ""; String height = ""; String
		 * weight = ""; String blood_type = ""; String hobby = ""; String phone
		 * = ""; String email = ""; String detail_edu = ""; String detail_fav =
		 * ""; String detail_lsk = ""; String picture_path = ""; String admin =
		 * ""; Member mem = new Member();
		 * mem.setUserName((String)session.getAttribute("user")); try{
		 * while(rs.next()){ mem.setPassword(rs.getString("password"));
		 * mem.setFullName(rs.getString("fullname"));
		 * mem.setBirthDate(rs.getString("birthdate"));
		 * mem.setHeight((rs.getString("height") == null) ? 0 :
		 * Float.parseFloat(rs.getString("height")));
		 * mem.setWeight((rs.getString("weight") == null) ? 0 :
		 * Float.parseFloat(rs.getString("weight")));
		 * mem.setBloodType(rs.getString("blood_type"));
		 * mem.setHobby(rs.getString("hobby"));
		 * mem.setPhone(rs.getString("phone"));
		 * mem.setEmail(rs.getString("email"));
		 * mem.setDetailEducation(rs.getString("detail_edu"));
		 * mem.setDetailFavorite(rs.getString("detail_fav"));
		 * mem.setDetailLittleSkill(rs.getString("detail_lsk"));
		 * mem.setPicturePath(rs.getString("picture_path"));
		 * mem.setAdmin(Integer.parseInt(rs.getString("admin")));
		 * 
		 * password = (rs.getString("password")); fullname =
		 * (rs.getString("fullname")); birthdate = (rs.getString("birthdate"));
		 * height = ((rs.getString("height") == null) ? 0 + "" :
		 * rs.getString("height")); weight = ((rs.getString("weight") == null) ?
		 * 0 + "" : rs.getString("weight")); blood_type =
		 * (rs.getString("blood_type")); hobby = (rs.getString("hobby")); phone
		 * = (rs.getString("phone")); email = (rs.getString("email"));
		 * detail_edu = (rs.getString("detail_edu")); detail_fav =
		 * (rs.getString("detail_fav")); detail_lsk =
		 * (rs.getString("detail_lsk")); picture_path =
		 * (rs.getString("picture_path")); admin = rs.getString("admin"); }
		 * }catch(SQLException ex){ log.info(ex.getMessage());
		 * 
		 * } req.setAttribute("member", mem);
		 * 
		 * model.addAttribute("username", username);
		 * model.addAttribute("password", password);
		 * model.addAttribute("fullname", fullname);
		 * model.addAttribute("birthdate", birthdate);
		 * model.addAttribute("height", height); model.addAttribute("weight",
		 * weight); model.addAttribute("blood_type", blood_type);
		 * model.addAttribute("hobby", hobby); model.addAttribute("phone",
		 * phone); model.addAttribute("email", email);
		 * model.addAttribute("detail_edu", detail_edu);
		 * model.addAttribute("detail_fav", detail_fav);
		 * model.addAttribute("detail_lsk", detail_lsk);
		 * model.addAttribute("admin", admin);
		 */
	}
}
