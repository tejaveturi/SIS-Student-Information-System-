package vxml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.DBConnection;

/**
 * Servlet implementation class GetSem
 */
public class GetSem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public GetSem() {
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
	
	con=DBConnection.getConnection();
	String sem=null;
	
	HttpSession hs=request.getSession();
	String stid=(String)hs.getAttribute("stid");
	System.out.println(stid);
	
	ArrayList<String> al=new ArrayList<String>();
	String year=request.getParameter("year");
	System.out.println(year);
	hs.setAttribute("year",year);
	try {
		st=con.createStatement();
		String qry="select SEM from SEMESTER where YEAR='"+year+"'";
		System.out.println(qry);
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			sem=rs.getString(1);
			al.add(sem);
		}
		request.setAttribute("semal",al);
		RequestDispatcher rd=request.getRequestDispatcher("VAtSem.jsp");
		rd.forward(request, response);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
