package com.restaurent.mapper;

import java.util.ArrayList;
import java.util.List;

import com.restaurent.constant.HMSConistants;
import com.restaurent.model.GetAllItems;

public class GetMappers {
//	public List<GetAllItems> allItemsConvertionofPresistance(List<Object[]> list) {
//
//		List<GetAllItems> districtData = new ArrayList<GetAllItems>();
//
//		for (Object[] data : list) {
//
//			GetAllItems districts = new GetAllItems();
//
//			if (data[0] != null) {
//				districts.setSno(HMSConistants.DATA_NOT_AVIALABLE);
//
//			} else {
//
//				districts.setSno(HMSConistants.DATA_NOT_AVIALABLE);
//			}
//
//			if (data[1] != null) {
//				districts.setItemName(HMSConistants.DATA_NOT_AVIALABLE);
//
//			} else {
//
//				districts.setItemName(HMSConistants.DATA_NOT_AVIALABLE);
//			}
//			if (data[2] != null) {
//				districts.setPrice(HMSConistants.DATA_NOT_AVIALABLE);
//
//			} else {
//
//				districts.setPrice(HMSConistants.DATA_NOT_AVIALABLE);
//			}
//
//			districtData.add(districts);
//
//		}
//
//		return districtData;
//
//	}

	public List<GetAllItems> allItemsConvertionofPresistance(List<Object[]> list) {
	    List<GetAllItems> districtData = new ArrayList<>();

	    for (Object[] data : list) {
	        GetAllItems item = new GetAllItems();

	        if (data[0] != null) {
	            item.setSno(data[0].toString());
	        } else {
	            item.setSno(HMSConistants.DATA_NOT_AVIALABLE);
	        }

	        if (data[1] != null) {
	            item.setItemName(data[1].toString());
	        } else {
	            item.setItemName(HMSConistants.DATA_NOT_AVIALABLE);
	        }

	        if (data[2] != null) {
	            item.setPrice(data[2].toString());
	        } else {
	            item.setPrice(HMSConistants.DATA_NOT_AVIALABLE);
	        }

	        districtData.add(item);
	    }

	    return districtData;
	}
}
