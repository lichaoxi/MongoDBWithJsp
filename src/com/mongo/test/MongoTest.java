/**
 * MongoTest.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:54:30
 */
package com.mongo.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongo.bean.Person;
import com.mongo.dao.AbstractRepository;
import com.mongo.dao.impl.PersonRepository;



/**
 * TODO
 * @author cuiran
 * @version TODO
 */
public class MongoTest {

	private static Log log = LogFactory.getLog(MongoTest.class.getName());
	
	private  AbstractRepository pr=null;
	
	/**
	 * 
	 *<b>function:</b>
	 * @author cuiran
	 * @createDate 2012-12-12 16:08:02
	 */
	public void init(){
		 log.debug("��ʼ����");
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  pr= (PersonRepository)ctx.getBean("personRepository");
		 
		
		
	}
	/**
	 * 
	 *<b>function:</b>���
	 * @author cuiran
	 * @createDate 2012-12-12 16:11:01
	 */
	public void insert(){
		
		Person p=new Person("cuiran",27);
		 pr.insert(p);
		 log.debug("��ӳɹ�");
	}
	/**
	 * 
	 *<b>function:</b>���������ID���Ҷ���
	 * @author cuiran
	 * @createDate 2012-12-12 16:24:10
	 */
	public void findOne(){
		String name="cuiran";
		Person p= pr.findOne(name);
		log.debug(p);
	}
	
	
	/**
	 * 
	 *<b>function:</b>��ѯ����
	 * @author cuiran
	 * @createDate 2012-12-12 16:08:54
	 */
	public void listAll(){
		
		List<Person> list=pr.findAll();
		log.debug("��ѯ�������:");
		for (Person p:list){
			log.debug(p.toString());
		}
		
		
	}
	
	/**
	 * 
	 *<b>function:</b>���Է���
	 * @author cuiran
	 * @createDate 2012-12-12 16:11:37
	 */
	public void start(){
		init();
		
		//insert();
		listAll();
		
		//findOne();
	}
	
	/**
	 *<b>function:</b>main����
	 * @author cuiran
	 * @createDate 2012-12-12 11:54:30
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoTest t=new MongoTest();
		t.start();
	}

}
