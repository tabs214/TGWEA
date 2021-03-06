package com.etaoguan.wea.client.web.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWGuestBookService;
import com.etaoguan.wea.client.web.vo.GuestBookSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.GuestBookService;

@Service("wguestBookService")
public class WGuestBookService extends GuestBookService implements IWGuestBookService{
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listGuestBooks(GuestBookSearch guestBookSearch,SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", guestBookSearch.getOwnerNum());
		DataSet dataSet = listGuestBooks(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

}
