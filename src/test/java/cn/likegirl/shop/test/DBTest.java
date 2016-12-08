package cn.likegirl.shop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBTest {

	private ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Test
	public void test() {
		System.out.println(ctx);
	}

}
