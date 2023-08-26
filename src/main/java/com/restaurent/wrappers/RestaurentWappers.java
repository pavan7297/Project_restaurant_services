package com.restaurent.wrappers;

import java.io.Serializable;
import java.util.List;

import com.restaurent.model.GetAllItems;
import com.restaurent.response.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestaurentWappers extends Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7043314566145321128L;
	
	List<GetAllItems> objectGet;
}
