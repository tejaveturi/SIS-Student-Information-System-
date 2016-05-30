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
 * Servlet implementation class GetFnum
 */
public class GetFnum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public GetFnum() {
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
	
	String fname=request.getParameter("fname");
	System.out.println("faculty name in servlet is"+fname);
	
	HttpSession brid=request.getSession();
	String branchid=(String)brid.getAttribute("brid");
	
	String email=null;
	String mob=null;
	
	con=DBConnection.getConnection();
	try {
		st=con.createStatement();
		String qry="select EMAIL,F_NUM from FACULTY where F_NAME='"+fname+"' and BRANCH_ID='"+branchid+"'";
		System.out.println(qry);
		rs=st.executeQuery(qry);
		if(rs.next())
		{
			email=rs.getString(1);
			mob=rs.getString(2);
			request.setAttribute("email",email);
			request.setAttribute("mob",mob);
			RequestDispatcher rd=request.getRequestDispatcher("VFacultyDetPrompt.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("VNOfaculty.jsp");
			rd.forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
