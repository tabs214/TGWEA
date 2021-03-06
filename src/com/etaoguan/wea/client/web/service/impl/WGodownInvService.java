package com.etaoguan.wea.client.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWGodownInvService;
import com.etaoguan.wea.client.web.service.IWWareHouseService;
import com.etaoguan.wea.client.web.vo.GodownInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.GodownInvService;
import com.etaoguan.wea.vo.GodownInvoice;
@Service("wgodownInvService")
public class WGodownInvService extends GodownInvService implements IWGodownInvService{

	@Autowired
	IWWareHouseService iWWareHouseService;
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getListGodownInvsSearchInitData(String ownerNum) {
		Map dataMap = new HashMap();
		dataMap.put("warehouses",iWWareHouseService.getAllWarehouses(ownerNum));
		return dataMap;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public WPage listGodownInvs(GodownInvSearch godownInvSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", godownInvSearch.getOwnerNum());
		dataCriteria.setParam("prodName", godownInvSearch.getProdName());
		dataCriteria.setParam("whNum", godownInvSearch.getWhNum());
		DataSet dataSet = listGodownInvs(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getEditGodownInvInitData(String ownerNum, String gdNum) {
		Map dataMap = new HashMap();
		dataMap.put("warehouses",iWWareHouseService.getAllWarehouses(ownerNum));
		if(StringUtils.isNotEmpty(gdNum)){
			dataMap.put("godownInv",getGodownInv(gdNum));
		}
		return dataMap;
	}

	@Override
	public void saveOrUpdateGodownInv(GodownInvoice godownInvoice) {
		if(StringUtils.isEmpty(godownInvoice.getGdNum())){
			addGodownInv(godownInvoice);
		}else{
			updateGodownInv(godownInvoice);
		}
		
	}


}
