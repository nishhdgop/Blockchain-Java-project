package gui;

import java.util.HashMap;

public class IDandPasswords {

		HashMap<String,String> logininfo = new HashMap<String,String>();
		
		IDandPasswords(){
			
			logininfo.put("nish","2002");
			logininfo.put("hello","1234");
			logininfo.put("a","a");
			
		}
		
		public HashMap getLoginInfo(){
			return logininfo;
		}
	}

