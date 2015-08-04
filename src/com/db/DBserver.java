package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.JDBCUtil;

/*
 * This file is for interacting with DB, including both read and write
 */
public class DBserver {
	private static JDBCUtil jdbcUtil = new JDBCUtil();
	
	/*
	 * Upload function
	 */
	public void insertCombine(String Com_id, String Ctype, String Des){
		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into combine(Com_id,Ctype,Des) values(?, ?, ?)";
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			int i=1;
			pst.setString(i++, Com_id);
			pst.setString(i++, Ctype);
			pst.setString(i++, Des);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, pst, rs);
		}
		return;
	}
	
	public void insertBrick(String Bri_id, String Btype, String BDes, String Uses){
		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into brick(Bri_id,Btype,Uses, BDes) values(?, ?, ?, ?)";
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			int i=1;
			pst.setString(i++, Bri_id);
			pst.setString(i++, Btype);
			pst.setString(i++, Uses);
			pst.setString(i++, BDes);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, pst, rs);
		}
		return;
	}
	
	public void insertContain(String Com_id, int bsta, int Bend, String Bri_id){
		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into brick(Bri_id,Btype,Uses, BDes) values(?, ?, ?, ?)";
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			int i=1;
			pst.setString(i++, Com_id);
			pst.setInt(i++, bsta);
			pst.setInt(i++, Bend);
			pst.setString(i++, Bri_id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtil.close(conn, pst, rs);
		}
		return;
	}
}
