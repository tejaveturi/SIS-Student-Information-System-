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
 * Servlet implementation class VSValidation
 */
public class VSValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public VSValidation() {
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

	String sno=request.getParameter("sno");
	String studname=null;
	String stid=null;
	
	con=DBConnection.getConnection();
	try {
		st=con.createStatement();
		String qry="select S_NAME,S_ID from STUDENT where S_ID='"+sno+"'";
		rs=st.executeQuery(qry);
		if(rs.next())
		{
			studname=rs.getString(1);
			stid=rs.getString(2);
			request.setAttribute("sname",studname);
			HttpSession hs=request.getSession();
			hs.setAttribute("sname",studname);
			hs.setAttribute("stid",stid);
			RequestDispatcher rd=request.getRequestDispatcher("Shome.jsp");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("VLoginFail.jsp");
			rd.forward(request,response);
		}
		
	} catch (SQLException e) {
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
