/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:40:40
 */
package com.mongo.dao;

import java.util.List;

import com.mongo.bean.Person;

/**
 * TODO
 * @author cuiran
 * @version TODO
 */
public interface AbstractRepository {
	
	/**
	 * 
	 *<b>function:</b>��Ӷ���
	 * @author cuiran
	 * @createDate 2012-12-12 11:41:30
	 */
	public void insert(Person person); 
	
	/**
	 * 
	 *<b>function:</b>����ID���Ҷ���
	 * @author cuiran
	 * @createDate 2012-12-12 11:41:41
	 */
    public Person findOne(String id);   
    /**
     * 
     *<b>function:</b>��ѯ����
     * @author cuiran
     * @createDate 2012-12-12 16:26:06
     */
    public List<Person> findAll();   
    
    public List<Person> findByRegex(String regex);
    /**
     * 
     *<b>function:</b>ɾ��ָ����ID����
     * @author cuiran
     * @createDate 2012-12-12 16:26:16
     */
    public void removeOne(String id);   
    /**
     * 
     *<b>function:</b>ɾ������
     * @author cuiran
     * @createDate 2012-12-12 16:25:40
     */
    public void removeAll();   
    /**
     * ͨ��ID�ҵ����޸�
     *<b>function:</b>
     * @author cuiran
     * @createDate 2012-12-12 16:25:51
     */
    public void findAndModify(String id);   

	
}
