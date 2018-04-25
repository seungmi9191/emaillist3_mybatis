package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmailVO;

@Repository
public class EmaillistDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(EmailVO vo) {
		
		return sqlSession.insert("emaillist.insert", vo);
		
		//int count = sqlSession.insert("emaillist.insert", vo);
		//return count;	
	}
	
	public List<EmailVO> getList() {
		return sqlSession.selectList("emaillist.list");
	}
	
}
