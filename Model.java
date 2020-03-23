package com.Bank;

import java.sql.*;
import java.util.ArrayList;

public class Model {
	private String name;
	private int accno;
	private int balance;
	private String custid;
	private String pwd;
	private int raccno;
	private ArrayList<Integer> al= null;
	
	Connection con= null;
	PreparedStatement pstmt= null;
	ResultSet res=null;
	
	public ArrayList<Integer> getAl() {
		return al;
	}
	public void setAl(ArrayList<Integer> al) {
		this.al = al;
	}
	

	public int getRaccno() {
		return raccno;
	}
	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	Model()
	{
		try
		{
			//load the driver
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loaded");

			//get the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","SYSTEM", "shivam");
			System.out.println("connection established");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean login()
	{
		try
		{
			//prepare statement
			pstmt=con.prepareStatement("select *from SWISS_BANK where CUSTID=? and PWD=?");
			//set data
			pstmt.setString(1, custid);
			pstmt.setString(2, pwd);

			//get the result object
			res=pstmt.executeQuery();

			//fetch the data
			if(res.next())
			{
				accno=res.getInt("ACCNO");
				return true;


			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(res!=null)
					res.close();
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean checkBalance()
	{
		try
		{
			//prepare statement
			pstmt=con.prepareStatement("select *from SWISS_BANK where ACCNO=?");
			//set data
			pstmt.setInt(1,accno);

			//get the resultset object
			res=pstmt.executeQuery();

			//fetch the data
			if(res.next())
			{
				balance=res.getInt("BALANCE");
				return true;

			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(res!=null)
					res.close();
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean changePwd()
	{
		try
		{
			pstmt=con.prepareStatement("update SWISS_BANK set PWD=? where ACCNO=?");
			pstmt.setString(1, pwd);
			pstmt.setInt(2, accno);
			int result=pstmt.executeUpdate();
			if(result==1)
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(res!=null)
					res.close();
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean transfer()
	{
		try
		{
			pstmt=con.prepareStatement("update SWISS_BANK set BALANCE=BALANCE-? where ACCNO=?");
			pstmt.setInt(1, balance);
			pstmt.setInt(2, accno);
			int q1=pstmt.executeUpdate();
			if(q1==1)
			{
				pstmt=con.prepareStatement("update SWISS_BANK set BALANCE=BALANCE+? where ACCNO=?");
				pstmt.setInt(1, balance);
				pstmt.setInt(2, raccno);
				int q2=pstmt.executeUpdate();

				if(q2==1)
				{
					pstmt=con.prepareStatement("insert into STATEMENT values(?,?)");
					pstmt.setInt(1, accno);
					pstmt.setInt(2, (balance*-1));
					int q3=pstmt.executeUpdate();	

					if(q3==1)
					{
						pstmt.getConnection().prepareStatement("insert into STATEMENT values(??)");
						pstmt.setInt(1, raccno);
						pstmt.setInt(2, balance);
						int q4=pstmt.executeUpdate();

						if(q4==1)
						{
							return true;
						}
					}
				}


			}
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	void getStatement()
	{
		try
		{
			pstmt=con.prepareStatement("select * from STATEMENT where ACCNO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			al =new ArrayList<Integer>();
			while(res.next())
			{
				int amt=res.getInt("AMT");
				al.add(amt);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}















































