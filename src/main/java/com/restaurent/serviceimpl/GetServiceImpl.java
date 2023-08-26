package com.restaurent.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.restaurent.RestaurentApplication;
import com.restaurent.dao.RestarentApp;
import com.restaurent.mapper.GetMappers;
import com.restaurent.model.GetAllItems;
import com.restaurent.service.GetServices;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@Service("getServiceImpl")
@Slf4j
public class GetServiceImpl implements GetServices{
	
	@Autowired
	RestarentApp objRestarentApp; 

	@Value("${uat.datasource.url}")
	private String strJdbcUrl;

	@Value("${uat.datasource.username}")
	private String strDBUSERNAME;

	@Value("${uat.datasource.password}")
	private String strDBPWD;
	
	
	@Override
	public List<GetAllItems> getAllItems(String RequestedString) throws Exception, SQLDataException {

		List<GetAllItems> objControllerDto = null;
		PreparedStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call get_all_items()}");

		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {			connection.close();
		}
//		 log.info("SQL QUERY :::::::::::"+cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objRestarentApp.getData(cs.toString());
	
		
		GetMappers mappers = new GetMappers();

		objControllerDto = mappers.allItemsConvertionofPresistance(data);
	
		return objControllerDto;
	}

}
