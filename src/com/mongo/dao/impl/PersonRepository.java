/**
 * PersonRepository.java
 * 版权所有(C) 2012 
 * 创建:cuiran 2012-12-12 11:42:51
 */
package com.mongo.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import com.mongo.bean.Person;
import com.mongo.dao.AbstractRepository;

/**
 * TODO
 * @author cuiran
 * @version TODO
 */
public class PersonRepository implements AbstractRepository {

	  private MongoTemplate mongoTemplate;   

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#findAll()
	 */
	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return getMongoTemplate().find(new Query(), Person.class);   

	}

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#findAndModify(java.lang.String)
	 */
	@Override
	public void findAndModify(String id) {
		// TODO Auto-generated method stub
		//new Query(Criteria.where("id").is(id)), new Update().inc("age", 3)
		
		getMongoTemplate().updateFirst(new Query(Criteria.where("id").is(id)), new Update().inc("age", 3));

	}

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#findByRegex(java.lang.String)
	 */
	@Override
	public List<Person> findByRegex(String regex) {
		// TODO Auto-generated method stub
		 Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);   
	      Criteria criteria = new Criteria("name").regex(pattern.toString());   
	        return getMongoTemplate().find(new Query(criteria), Person.class);   

	}

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#findOne(java.lang.String)
	 */
	@Override
	public Person findOne(String id) {
		// TODO Auto-generated method stub
		 return getMongoTemplate().findOne(new Query(Criteria.where("id").is(id)), Person.class);   

	}

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#insert(com.mongo.bean.Person)
	 */
	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub
		getMongoTemplate().insert(person);   
	}

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#removeAll()
	 */
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		List<Person> list = this.findAll();   
        if(list != null){   
            for(Person person : list){   
                getMongoTemplate().remove(person);   
            }   
        }   

	}

	/* (non-Javadoc)
	 * @see com.mongo.dao.AbstractRepository#removeOne(java.lang.String)
	 */
	@Override
	public void removeOne(String id) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("id").in(id);   
        if(criteria == null){   
             Query query = new Query(criteria);   
             if(query != null && getMongoTemplate().findOne(query, Person.class) != null)   
                 getMongoTemplate().remove(getMongoTemplate().findOne(query, Person.class));   
        }   

	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
