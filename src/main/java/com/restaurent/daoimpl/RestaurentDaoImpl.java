package com.restaurent.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurent.dao.RestarentApp;
import com.restaurent.exceptions.DataNotFoundException;

@Repository("objCommonDaoImpls")
@Transactional
public class RestaurentDaoImpl implements RestarentApp {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getData(String strQuery) {
		Session session = null;
		List<Object[]> listData = null;
		session = sessionFactory.getCurrentSession();
		listData = session.createSQLQuery(strQuery).list();
		return listData;
	}

	@Override
	public String saveData(String strQuery) {
		Session session = null;
		String strResult = null;
		session = sessionFactory.getCurrentSession();
		strResult = session.createSQLQuery(strQuery).list().get(0).toString();
		return strResult;
	}

	@Override
	public String getSingleData(String strQuery) throws DataNotFoundException {
		Session session = null;
		String listData = null;
		session = sessionFactory.getCurrentSession();
		@SuppressWarnings({ "rawtypes", "deprecation" })
		List data = session.createSQLQuery(strQuery).list();
		if (data == null || data.isEmpty() || data.get(0) == null) {
			throw new DataNotFoundException("");
		} else {
			listData = data.get(0).toString();
		}
		return listData;
	}

}
