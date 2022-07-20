package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		try{
		File src=new File("./Configuration/config.properties");
		
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		
		}
		catch(Exception e){
			System.out.println("Exception is :" +e.getMessage());
		}
			
	}
	
	public String getChromePath() {
		String path=pro.getProperty("chromepath");
		return path;
	}
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	
	
public String getFirePath() {
	String fpath=pro.getProperty("firepath");
		return fpath;
	}

}
