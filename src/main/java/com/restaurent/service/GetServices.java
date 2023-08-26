package com.restaurent.service;

import java.sql.SQLDataException;
import java.util.List;

import com.restaurent.model.GetAllItems;



public interface GetServices {

	List<GetAllItems> getAllItems(String RequestedString) throws Exception, SQLDataException;

}
