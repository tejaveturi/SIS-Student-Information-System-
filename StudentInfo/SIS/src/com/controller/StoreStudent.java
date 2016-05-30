package com.controller;

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

/**
 * Servlet implementation class StoreStudent
 */
public class StoreStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public StoreStudent() {
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
	String sname=request.getParameter("uname");
	String roll=request.getParameter("roll");
	String sno=request.getParameter("serial");
	String num=request.getParameter("num");
	String branch=request.getParameter("branch");
	String year=request.getParameter("year");
	String sem=request.getParameter("sem");
	String brid=null;
	String semid=null;
	
	con=DBConnection.getConnection();
	try {
		st=con.createStatement();
		String qry="select BRANCH_ID from branch where BRANCH='"+branch+"'";
		rs=st.executeQuery(qry);
		if(rs.next())
		{
			brid=rs.getString(1);
		}
		
		String qry1="select SEM_ID from branch where SEM='"+sem+"'";
		rs=st.executeQuery(qry);
		if(rs.next())
		{
			semid=rs.getString(1);
		}
		String qry3="insert into student(S_ID,ROLL_NO,S_NAME,P_NUM,BRANCH_ID,SEM_ID) values('"+sno+"','"+roll+"','"+sname+"','"+num+"','"+brid+"','"+semid+"')";
		int iu=st.executeUpdate(qry3);
		if(iu>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("ProfileStoredSuccess.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ProfileStoredunSuccess.jsp");
			rd.forward(request, response);
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
