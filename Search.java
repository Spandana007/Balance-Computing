import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class Search extends HttpServlet{ 
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();

   
   Connection conn = null;
   

   
   Statement st;
   try {
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		String dbPath = application.getRealPath("/") + "HTMLAccess.mdb";
		conn=  DriverManager.getConnection("" +"jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};" +"DBQ =" + dbPath + ";uid=;pwd=;");
		if(conn != null)
		{
			out.println("Database Connected.");
		} 
		else 
		{
			out.println("Database Connect Failed.");
		}

   
        String  id  = request.getParameter("id");
   

        ArrayList al=null;
   ArrayList cust_list =new ArrayList();
   String query = "select * from  CustomerData where ID='"+id+"'";
   System.out.println("query " + query);
   st = conn.createStatement();
   ResultSet  rs = st.executeQuery(query);


   while(rs.next())
   {
   al  = new ArrayList();
   
   int balance=rs.getInt(4);
  int deposit=rs.getInt(5);
   int withdrawal=rs.getInt(6);
   int totalbalance=balance+deposit-withdrawal;
   al.add(rs.getString(1));
   al.add(totalbalance);
   System.out.println("al :: "+al);
   cust_list.add(al);
   }

   request.setAttribute("custList",cust_list);
   
  System.out.println("custList " + cust_list);

   // out.println("emp_list " + emp_list);

   String nextJSP = "/viewSearch.jsp";
   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
   dispatcher.forward(request,response);
   conn.close();
   System.out.println("Disconnected from database");
   } 
   catch (Exception e) 
   {
   e.printStackTrace();
   }
   }
 } 
