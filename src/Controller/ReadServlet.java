package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectionClass;
import DAO.PlayersDAOImpl;

public class ReadServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request,  
		HttpServletResponse response) 
		        throws ServletException, IOException {
	
	
	try {
		ResultSet rs =  PlayersDAOImpl.ReadPlayers();
		
		PrintWriter out = response.getWriter();
        out.println("<table border=\"1\">");
        out.println("<table border=\"1\">"+"<html> <tr>\r\n" + 
        		"    <th>Players id</th>\r\n" + 
        		"    <th>Players id</th>\r\n" + 
        		"    <th>Players Team</th>\r\n" + 
        		"    <th>Players Status</th>\r\n" + 
        		"  </tr><body></body></html>"); 
        while(rs.next()) {
        	
            out.println("<tr>");
            out.println("<td>" +rs.getInt(1) + "</td>");
            out.println("<td>" + rs.getString(2) + "</td>");
            out.println("<td>" + rs.getString(3) + "</td>");
            out.println("<td>" + rs.getString(4) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } 
}
}


