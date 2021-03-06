package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IWechatKeysDao;
import com.etaoguan.wea.vo.WechatKeys;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class WechatKeysDao extends SpringBaseDao implements IWechatKeysDao{

	@Override
	@Resource(name="wechatSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addWechatKeys(WechatKeys wechatKeys) {
		this.getSqlMapClientTemplate().insert("createWechatKeys", wechatKeys);
		
	}

	@Override
	public void delWechatKeys(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteWechatKeys", dataCriteria.getParams());
		
	}


	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getWechatKeysDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getWechatKeysCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<WechatKeys> wchatKeysList = this.getSqlMapClientTemplate().queryForList("getWechatKeysDataSet", params);
		DataSet<WechatKeys> dataSet = new DataSet<WechatKeys>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(wchatKeysList);
		return dataSet;
	}

	@Override
	public void updateWechatKeys(WechatKeys wechatKeys) {
		this.getSqlMapClientTemplate().update("updateWechatKeys", wechatKeys);
		
	}

	@Override
	public void updateWechatKeysByMap(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateWechatKeysByMap", dataCriteria.getParams());
		
	}

	@Override
	public WechatKeys getWechatKeys(DataCriteria dataCriteria) {
		
		return (WechatKeys)this.getSqlMapClientTemplate().queryForObject("getWechatKeys", dataCriteria.getParams());
		
	}


}
