<%@ page import="java.util.*" %> 
 <html>
 <head>
 </head>
 <body>

 <br><br><br><br><br><br>
 <table style="width:700px; align=center;border:1px solid #000000;">
 <tr>
 <td colspan=8 align="center" style="background-color:ffeeff">
 <b>Customer Record</b></td>
 </tr>
 <tr style="background-color:efefef;">
 <td><b>ID</b></td>
 <td><b>Total Balance</b></td>
 

 </tr>
 <%
 int count=0;
 String color = "#F9EBB3";


 if(request.getAttribute("custList")!=null)
 {
 ArrayList al = (ArrayList)request.getAttribute("custList");
 Iterator itr = al.iterator();


 while(itr.hasNext()){

 if((count%2)==0){ 
 color = "#eeffee"; 
 }
 else{
 color = "#F9EBB3";
 }
 count++;
 ArrayList custList = (ArrayList)itr.next();
 %>
 <tr style="background-color:<%=color%>;">
 <td><%=custList.get(0)%></td>
 <td><%=custList.get(1)%></td>
 </tr>
 <%
 }
 }
 %> 
 <%
 if(count==0){
 %>
 <tr>
 <td colspan=8 align="center" style="background-color:eeffee"><b>No Record</b></td>
 </tr>
 <%
 }
 %>
 </table>
 </body>
 </html> 