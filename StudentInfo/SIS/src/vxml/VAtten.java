package vxml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.DBConnection;

/**
 * Servlet implementation class VAtten
 */
public class VAtten extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public VAtten() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
String sem=request.getParameter("sem");
		
		
		String semid=null;
		
		String aper=null;
//		String apercentage=null;
//		String backlog=null;
		
		HttpSession hs=request.getSession();
		String stid=(String)hs.getAttribute("stid");
		System.out.println("stid...."+stid);
		String year=(String)hs.getAttribute("year");
		System.out.println("year...."+year);
		
		con=DBConnection.getConnection();
		try {
			st=con.createStatement();
			String qry="select SEM_ID from SEMESTER where SEM='"+sem+"' and year='"+year+"'";
			
			System.out.println(qry);rs=st.executeQuery(qry);
			if(rs.next())
			{
				semid=rs.getString(1);
			}
			
			String qry1="select PERCENTAGE from ATTENDANCE where SEM_ID='"+semid+"' and S_ID='"+stid+"'";
			System.out.println(qry1);
			rs=st.executeQuery(qry1);
			if(rs.next())
			{
				aper=rs.getString(1);
			}
			
			request.setAttribute("aper",aper);
			
			RequestDispatcher rd=request.getRequestDispatcher("VattPrompt.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
				try {
					rs.close();
					if(st!=null)
						st.close();
					if(con!=null)
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	}

}
