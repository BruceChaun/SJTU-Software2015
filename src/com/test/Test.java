package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.JDBCUtil;

public class Test {
	private static JDBCUtil jdbcUtil = new JDBCUtil();
	
	public static void testDB(String id, String type, String des){
		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into combine(Com_id,Ctype,Des) values(?, ?, ?)";
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			int i=1;
			pst.setString(i++, id);
			pst.setString(i++, type);
			pst.setString(i++, des);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, pst, rs);
		}
		return;
	}
	
	public static void main(String[] args){
		testDB("3", "3", "3");
	}

}
