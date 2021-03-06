package com.etaoguan.wea.client.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWCashInvService;
import com.etaoguan.wea.client.web.service.IWCustService;
import com.etaoguan.wea.client.web.service.IWOrderService;
import com.etaoguan.wea.client.web.vo.CashInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.service.impl.CashInvService;
import com.etaoguan.wea.vo.CashInvoice;
import com.etaoguan.wea.vo.Order;

@Service("wcashInvService")
public class WCashInvService extends CashInvService implements IWCashInvService{
	@Autowired
	IWCustService iWCustService;
	
	@Autowired
	IWOrderService iWOrderService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listCashInvs(CashInvSearch cashInvSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", cashInvSearch.getCustNum());
		dataCriteria.setParam("referOrderNum", cashInvSearch.getReferOrderNum());
		dataCriteria.setParam("ownerNum", cashInvSearch.getOwnerNum());
		DataSet dataSet = listCashInvs(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getEditCashInvInitData(String ownerNum,String orderNum, String cashNum) {
		
		Map dataMap = new HashMap();
		if(StringUtils.isNotEmpty(cashNum)){
			CashInvoice cashInv = getCashInv(cashNum);
			dataMap.put("cashInv",cashInv);
			orderNum = cashInv.getReferOrderNum();
		}
		Order order =iWOrderService.getOrder(orderNum);
		dataMap.put("order",order);
		dataMap.put("customer",iWCustService.getCust(order.getCustNum()));
		dataMap.put("cashTypes", WeaDataCache.getCache().getCashTypeCodeNameMap());
		return dataMap;

	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Map getListCashInvsSearchInitData(String ownerNum) {
		Map dataMap = new HashMap();
		return dataMap;
	}

	@Override
	public void saveOrUpdateCashInv(CashInvoice cashInv) {
		if(StringUtils.isEmpty(cashInv.getCashNum())){
			addCashInv(cashInv);
		}else{
			updateCashInv(cashInv);
		}
	}
}
