package com.yicheng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yicheng.pojo.Cloth;
import com.yicheng.service.ClothMaterialService;
import com.yicheng.service.ClothService;
import com.yicheng.service.data.ClothMaterialDetailData;
import com.yicheng.util.GenericResult;
import com.yicheng.util.ResultCode;
import com.yicheng.util.Utils;

@Controller
public class BuyerController {
	
	private static Logger logger = LoggerFactory.getLogger(BuyerController.class);
	
	@Autowired
	private ClothService clothService;
	
	@Autowired
	private ClothMaterialService clothMaterialService;
	
	@RequestMapping(value = "/Buyer/ClothCountManage", method = RequestMethod.GET)
	public ModelAndView clothMaterialList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		GenericResult<List<Cloth>> clothResult = clothMaterialService.getNeedCount();
		
		if(clothResult.getResultCode() == ResultCode.NORMAL) {
			model.put("clothes", clothResult.getData());
		}else {
			logger.warn("cloth get all exception");
		}
		return new ModelAndView("buyer/cloth_count_manage", "model", null);
	}
	
	@RequestMapping(value = "/Pricing/ClothPCountDetail", method = RequestMethod.GET)
	public ModelAndView clothMaterialDetail(HttpServletRequest request, HttpServletResponse response) {
		int clothId = Utils.getRequestIntValue(request, "clothId", true);
		
		Map<String, Object> model = new HashMap<String, Object>();
		GenericResult<Cloth> clothResult = clothService.getById(clothId);
		GenericResult<List<ClothMaterialDetailData>> clothMaterialDetailResult = clothMaterialService.getDetailByCloth(clothId);
		if(clothResult.getResultCode() == ResultCode.NORMAL
				&& clothMaterialDetailResult.getResultCode() == ResultCode.NORMAL) {
			model.put("cloth", clothResult.getData());
			model.put("clothMaterialDetails", clothMaterialDetailResult.getData());
		}
		return new ModelAndView("pricing/cloth_count_detail", "model", model);
	}
}
