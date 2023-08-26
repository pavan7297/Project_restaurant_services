package com.restaurent.dao;

import java.util.List;

import com.restaurent.exceptions.DataNotFoundException;


public interface RestarentApp {
	public List<?> getData(String strQuery);

	public String saveData(String strQuery);

	public String getSingleData(String strQuery) throws DataNotFoundException;
}
