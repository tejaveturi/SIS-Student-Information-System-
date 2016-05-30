package vxml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.DBConnection;
import com.sun.org.apache.bcel.internal.util.BCELifier;

/**
 * Servlet implementation class GetFacList
 */
public class GetFacList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public GetFacList() {
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
	String branch=request.getParameter("faculty");
	System.out.println(branch);
	
	String branchid=null;
	String fname=null;
	String femail=null;
	String fmob=null;
	
	con=DBConnection.getConnection();
	try {
		st=con.createStatement();
		String qry="select BRANCH_ID from BRANCH where BRANCH='"+branch+"'";
		rs=st.executeQuery(qry);
		if(rs.next())
		{
			branchid=rs.getString(1);
			HttpSession brid=request.getSession();
			brid.setAttribute("brid",branchid);
		}
		ArrayList<HashMap<String, String>> al=new ArrayList<HashMap<String,String>>();
		String qry1="select F_NAME from FACULTY where BRANCH_ID='"+branchid+"'";
		rs=st.executeQuery(qry1);
		while(rs.next())
		{
			HashMap<String, String> hm=new HashMap<String, String>();
			fname=rs.getString(1);
//			femail=rs.getString(2);
//			fmob=rs.getString(3);
			hm.put("fname",fname);
//			hm.put("femail",femail);
//			hm.put("fmob",fmob);
			al.add(hm);	
		}
		request.setAttribute("al",al);
		RequestDispatcher rd=request.getRequestDispatcher("VFacDetPrompt.jsp");
		rd.forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
