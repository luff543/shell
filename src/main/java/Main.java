import java.io.*;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Main extends HttpServlet {
  public static String getLocalHostName() {
	    String hostName;
	    try {
	        InetAddress addr = InetAddress.getLocalHost();
	        hostName = addr.getHostName();
	    } catch (Exception ex) {
	        hostName = "";
	    }
	    return hostName;
	}
	 
	public static String[] getAllLocalHostIP() {
	    String[] ret = null;
	    try {
	        String hostName = getLocalHostName();
	        if (hostName.length() > 0) {
	            InetAddress[] addrs = InetAddress.getAllByName(hostName);
	            if (addrs.length > 0) {
	                ret = new String[addrs.length];
	                for (int i = 0; i < addrs.length; i++) {
	                    ret[i] = addrs[i].getHostAddress();
	                }
	            }
	        }
	 
	    } catch (Exception ex) {
	        ret = null;
	    }
	    return ret;
	}
	
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
     //resp.getWriter().print("New 2014 1207 2127 Hello from Java 中文測試! https://fast-thicket-5960.herokuapp.com/");
    
	 
    PrintWriter out = resp.getWriter();
    String docType =
    	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
    	      "transitional//en\">\n";
    out.println(docType +
            "<html lang=\"zh-TW\">\n" +
            "<head><title>test20141218 1230</title></head>\n" +
            "<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">test</h1>\n" +
            "<ul>\n" +
            "  <li><b>queryString</b>: "
            + "content" + "\n" +
            "</ul>\n");
    
    String[] localIP = getAllLocalHostIP();
    for (int i = 0; i < localIP.length; i++) {
    	 out.println("<p>" + localIP[i] + "</p>");
    }
    
    String commandStr = "/bin/ls";
    out.println("<h1>" + commandStr + "</h1>");
    
    Process pl = Runtime.getRuntime().exec(commandStr);
    String line = "";
    BufferedReader p_in = new BufferedReader(new InputStreamReader(pl.getInputStream()));
    while((line = p_in.readLine()) != null){
            //System.out.println(line);
    	 	out.println("<p>" + line + "</p>");
    }
    p_in.close();
    
    try
    {
	    String meCommandParameter = req.getParameter("command");
	    String meCommandStr = "";
	    meCommandStr = java.net.URLDecoder.decode(meCommandParameter,"UTF-8");
	    out.println("<h1>" + "meCommandStr : " + meCommandStr + "</h1>");
	    
	    
	    pl = Runtime.getRuntime().exec(meCommandStr);
	    p_in = new BufferedReader(new InputStreamReader(pl.getInputStream()));
	    while((line = p_in.readLine()) != null){
	            //System.out.println(line);
	    	 	out.println("<p>" + line + "</p>");
	    }
	    p_in.close();
    }
    catch(Exception ex)
    {
    	out.println("<p>" + ex.toString() + "</p>");
    }
    
    String folderPath = "/bin";
    
    out.println("<h1>" + folderPath + "</h1>");
    StringBuffer fileList = new StringBuffer();
    try{
       java.io.File folder = new java.io.File(folderPath);
       String[] list = folder.list();           
                 for(int i = 0; i < list.length; i++){
                     fileList.append(list[i]).append(", ");
                }
     }catch(Exception e){
    	 out.println("<p>" + "'"+folderPath+"' folder not exist"+ "/<p>");
     } 
    out.println("<p>" + fileList + "</p>");
    
    folderPath = "/sbin";    
    out.println("<h1>" + folderPath + "</h1>");
    fileList = new StringBuffer();
    try{
       java.io.File folder = new java.io.File(folderPath);
       String[] list = folder.list();           
                 for(int i = 0; i < list.length; i++){
                     fileList.append(list[i]).append(", ");
                }
     }catch(Exception e){
              out.println("<p>" + "'"+folderPath+"' folder not exist"+ "/<p>");
     } 
    out.println("<p>" + fileList + "</p>");
    
    
    folderPath = "/usr/local/sbin";    
    out.println("<h1>" + folderPath + "</h1>");
    fileList = new StringBuffer();
    try{
       java.io.File folder = new java.io.File(folderPath);
       String[] list = folder.list();           
                 for(int i = 0; i < list.length; i++){
                     fileList.append(list[i]).append(", ");
                }
     }catch(Exception e){
              out.println("<p>" + "'"+folderPath+"' folder not exist"+ "/<p>");
     } 
    out.println("<p>" + fileList + "</p>");
    
    folderPath = "/usr/local/bin";    
    out.println("<h1>" + folderPath + "</h1>");
    fileList = new StringBuffer();
    try{
       java.io.File folder = new java.io.File(folderPath);
       String[] list = folder.list();           
                 for(int i = 0; i < list.length; i++){
                     fileList.append(list[i]).append(", ");
                }
     }catch(Exception e){
              out.println("<p>" + "'"+folderPath+"' folder not exist"+ "/<p>");
     } 
    out.println("<p>" + fileList + "</p>");
    
    
    folderPath = "/usr/sbin";    
    out.println("<h1>" + folderPath + "</h1>");
    fileList = new StringBuffer();
    try{
       java.io.File folder = new java.io.File(folderPath);
       String[] list = folder.list();           
                 for(int i = 0; i < list.length; i++){
                     fileList.append(list[i]).append(", ");
                }
     }catch(Exception e){
              out.println("<p>" + "'"+folderPath+"' folder not exist"+ "/<p>");
     } 
    out.println("<p>" + fileList + "</p>");
    
    folderPath = "/usr/bin";    
    out.println("<h1>" + folderPath + "</h1>");
    fileList = new StringBuffer();
    try{
       java.io.File folder = new java.io.File(folderPath);
       String[] list = folder.list();           
                 for(int i = 0; i < list.length; i++){
                     fileList.append(list[i]).append(", ");
                }
     }catch(Exception e){
              out.println("<p>" + "'"+folderPath+"' folder not exist"+ "/<p>");
     } 
    out.println("<p>" + fileList + "</p>");
    
    out.println("</body></html>");
           
  }
  

}
