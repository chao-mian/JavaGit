package com.shop.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTools {

	private static SqlSessionFactory sf;
	static {
		String config = "mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(config);
			sf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSessionFactory() throws IOException {
		// 开启session的时候顺便帮我们提交事务
		return sf.openSession(true);
	}
	public static void  CloseSqlSession(SqlSession ss)
	{
		if(ss!=null)
		{
			ss.close();	
		}
		
	}
}
