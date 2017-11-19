package com.stone.webapp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 224503735392361679L;
	private Logger log = Logger.getLogger(this.getClass());
	
	public void init() throws ServletException{
		log.info("TestServlet Init");
	 }

	  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//	      log.info("doGet");
//	      log.info(request.getParameter("name"));
//	      log.info(request.getParameter("sex"));
	      Map<String,String[]> parameters = request.getParameterMap();
	      for(String key : parameters.keySet()){
	    	  log.info(key);
	    	  String[] values = parameters.get(key);
	    	  for(int index=0; index<values.length; index++){
	    		  log.info(values[index]);
	    	  }
	      }
	  }

	  public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		  log.info("doPost");
		  log.info(request.getContentType());
		  Map<String,String[]> parameters = request.getParameterMap();
	      for(String key : parameters.keySet()){
	    	  log.info("--KEY--");
	    	  log.info(key);
	    	  String[] values = parameters.get(key);
	    	  for(int index=0; index<values.length; index++){
	    		  log.info("-----VALUE-----");
	    		  log.info(values[index]);
	    	  }
	      }
	      log.info("==================");
	      InputStream is = request.getInputStream();
	      byte[] bytes = new byte[request.getContentLength()];
	      while(is.read(bytes) != -1){
	    	  log.info(new String(bytes));
	      }
	  }
	  
	  public void destroy(){
	      // 什么也不做
	  }
}
