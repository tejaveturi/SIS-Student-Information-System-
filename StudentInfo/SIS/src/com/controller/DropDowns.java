package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DropDowns
 */
public class DropDowns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public DropDowns() {
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
	String action=request.getParameter("action");
	con=DBConnection.getConnection();
	if(action.equals("branches"))
	{
		branchnames(request,response);
	}
	else if(action.equals("years"))
	{
		yearno(request,response);
	}
	else if(action.equals("sem"))
	{
		semister(request,response);
	}
	}

	private void semister(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		con=DBConnection.getConnection();
		String year=request.getParameter("year");
		System.out.println(year);
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String qry="select SEM from SEMESTER where YEAR='"+year+"'";
			rs=st.executeQuery(qry);
			pw.println("<semister>");
			while(rs.next())
			{
				pw.println("<sem>"+rs.getString(1)+"</sem>");
			}
			pw.println("</semister>");
		} catch (SQLException e) {
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

	private void yearno(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		con=DBConnection.getConnection();
		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/xml");
			st=con.createStatement();
			String qry="select year from year";
			rs=st.executeQuery(qry);
			pw.println("<year>");
			while(rs.next())
			{
				pw.println("<yearno>"+rs.getString(1)+"</yearno>");
			}
			pw.println("</year>");
		} catch (SQLException e) {
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

		private void branchnames(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
			try {
				PrintWriter pw=response.getWriter();
				response.setContentType("text/xml");
				st=con.createStatement();
				String qry="select branch from branch";
				rs=st.executeQuery(qry);
				pw.println("<branch>");
				while(rs.next())
				{
					pw.println("<branchnames>"+rs.getString(1)+"</branchnames>");
				}
				pw.println("</branch>");
			} catch (SQLException e) {
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
