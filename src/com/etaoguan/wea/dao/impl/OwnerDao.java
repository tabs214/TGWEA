package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOwnerDao;
import com.etaoguan.wea.vo.Owner;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class OwnerDao extends SpringBaseDao implements IOwnerDao{

	@Override
	@Resource(name="ownerSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addOwner(Owner owner) {
		this.getSqlMapClientTemplate().insert("createOwner", owner);
		
	}

	@Override
	public Owner getOwner(DataCriteria dataCriteria) {
		return (Owner)this.getSqlMapClientTemplate().queryForObject("getOwner", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getOwnerDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getOwnerCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Owner> ownerList = this.getSqlMapClientTemplate().queryForList("getOwnerDatSet", params);
		
		DataSet<Owner> dataSet = new DataSet<Owner>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(ownerList);
		return dataSet;
	}

	@Override
	public void updateOwner(Owner owner) {
		this.getSqlMapClientTemplate().update("updateOwner",owner);
		
	}

	@Override
	public void updateOwner(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateOwnerByMap",dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwner(DataCriteria dataCriteria) {

		return  this.getSqlMapClientTemplate().queryForList("getAllOwner", dataCriteria.getParams());
	}

	@Override
	public int getExistShopCount(DataCriteria dataCriteria) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getExistShopCount", dataCriteria.getParams());
	}

	@Override
	public void updateOwnerShopNum(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateOwnerShopNum",dataCriteria.getParams());
		
	}

	@Override
	public String getRandomOwnerShopNum(DataCriteria dataCriteria) {
		
		return (String) this.getSqlMapClientTemplate().queryForObject("getRandomOwnerShopNum", dataCriteria.getParams());
		
	}

}
