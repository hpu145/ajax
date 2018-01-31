package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;

public class MessageDao {

	public List<Message> findAll(){
		
		String sql = "select * from t_message order by id desc";
		return DbHelp.query(sql, new BeanListHandler<>(Message.class));
		
	}

	public List<Message> findAllByMaxId(int maxId) {
		String sql = "select * from t_message where id > ? order by id desc";
		return DbHelp.query(sql, new BeanListHandler<>(Message.class), maxId);
		
	}
	
}
