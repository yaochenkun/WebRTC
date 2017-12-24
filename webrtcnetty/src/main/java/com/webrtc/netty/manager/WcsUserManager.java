package com.webrtc.netty.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.webrtc.netty.common.Constants;
import com.webrtc.wcs.dao.WcsUser;
import com.webrtc.wcs.dao.WcsUserDAO;

public class WcsUserManager {
	private static WcsUserDAO wcsuserDAO = new WcsUserDAO();
	private static final Logger LOGGER = Logger.getLogger(WcsUserManager.class);
	
	
	//返回true or false
	public static boolean addWcsUser(String userId) {
		WcsUser wcsuser = new WcsUser();
		
		wcsuser.setAccess_token("");
		wcsuser.setBegin_time(0);
		wcsuser.setCode("");
		wcsuser.setExtend("");
		wcsuser.setServer_id(Integer.valueOf(Constants.SG_ID));
		wcsuser.setStatus("online");
		wcsuser.setUid(0);
		wcsuser.setUser_id(userId);
		wcsuser.setValid(1);
		
		try{	
			wcsuserDAO.save(wcsuser);
			System.out.println("save success");
			return true;
		}catch (Exception e) {
			LOGGER.debug(e);
			return false;
		}
	}
	
	public static List<WcsUser> findWcsUserByUser_Id(String user_id){
		try{
			return wcsuserDAO.findWcsUserByuserId(user_id);		
		}
		catch(Exception e){
			LOGGER.debug(e);
			return null;
		}
	}

	 public static void main(String[] args){
			
		 List<WcsUser> aaa = WcsUserManager.findWcsUserByUser_Id("9999");
		 if(aaa != null){
			 
			 System.out.println(aaa.get(0).getId());
		 }
		 else{
			 System.out.println("error");
		 }
	 }

}
