package com.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {

	/**
	 * 增删改
	 * @param conn
	 * @param sql
	 * @param param
	 * @throws Exception
	 */
	public void exeSql(Connection conn,String sql,Object[] param) throws Exception{
		PreparedStatement pstmt=null;
		pstmt=conn.prepareStatement(sql);
		if(param!=null){
			for(int i=0;i<param.length;i++){
				pstmt.setObject(1+i, param[i]);
			}
		}
		pstmt.executeUpdate();
	}
	
	/**
	 * 查
	 * @param conn
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ResultSet getRs(Connection conn,String sql,Object[] param)throws Exception{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		pstmt=conn.prepareStatement(sql);
		if(param!=null){
			for(int i=0;i<param.length;i++){
				pstmt.setObject(1+i, param[i]);
			}
		}
		rs=pstmt.executeQuery();
		
		return rs;
	}
	/**
	 * 总记录数
	 * @param conn
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int getRowCount(Connection conn,String sql,Object[] param)throws Exception{
		ResultSet rs=null;
		rs=this.getRs(conn, sql, param);
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	
}
