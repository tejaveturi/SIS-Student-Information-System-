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
 * Servlet implementation class StoreFaculty
 */
public class StoreFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public StoreFaculty() {
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
		String fname=request.getParameter("uname");
		String fnum=request.getParameter("num");
		String email=request.getParameter("email");
		String sno=request.getParameter("serial");
		String branch=request.getParameter("branch");
		String brid=null;
		
		con=DBConnection.getConnection();
		try {
			st=con.createStatement();
			String qry="select BRANCH_ID from branch where BRANCH='"+branch+"'";
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				brid=rs.getString(1);
			}
			
			String qry3="insert into faculty(F_ID,F_NAME,EMAIL,F_NUM,BRANCH_ID) values('"+sno+"','"+fname+"','"+email+"','"+fnum+"','"+brid+"')";
			System.out.println(qry3);
			int iu=st.executeUpdate(qry3);
			if(iu>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("profilestoresuccess1.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("profilestoreunsuccess1.jsp");
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

	


