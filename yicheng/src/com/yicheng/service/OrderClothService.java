package com.yicheng.service;

import java.util.List;

import com.yicheng.pojo.OrderCloth;
import com.yicheng.util.GenericResult;
import com.yicheng.util.NoneDataResult;

public interface OrderClothService {
	public GenericResult<Integer> create(OrderCloth orderCloth);
	
	public NoneDataResult update(OrderCloth orderCloth);
	
	public NoneDataResult delete(int id, String orderNumber);
	
	public GenericResult<List<OrderCloth>> getByOrderNumber(String orderNumber);
}
