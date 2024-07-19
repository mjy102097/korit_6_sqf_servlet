package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Producer;
import com.study.dvd.util.DBConnectionMgr;

public class ProducerDao {
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<Producer> searchProducerByProducerName(String searchText) {
		List<Producer> producers = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dvd_db.producer_tb ");
			sql.append("where producer_name like ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + searchText + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Producer producer = Producer.builder()
						.producer_id(rs.getInt(1))
						.producer_name(rs.getString(2))
						.build();
				producers.add(producer);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return producers;
	}
	
	public static int save(Producer producer) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "insert into producer_tb values(0, ?)";
			pstmt = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,  producer.getProducer_name());
			successCount = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			while(rs.next()) {
				producer.setProducer_id(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		
		return successCount;
	}
}
