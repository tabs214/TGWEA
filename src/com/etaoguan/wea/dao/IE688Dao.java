package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.e688.vo.MemberInfo;
import com.etaoguan.wea.e688.vo.OfferDescription;
import com.etaoguan.wea.e688.vo.OfferDetailInfo;
import com.etaoguan.wea.e688.vo.OfferImageInfo;
import com.etaoguan.wea.e688.vo.PriceRangeInfo;
import com.etaoguan.wea.e688.vo.ProductCategory;
import com.etaoguan.wea.e688.vo.ProductDiffer;
import com.etaoguan.wea.e688.vo.ProductFeatureInfo;



public interface IE688Dao{
	/**
	 * 保存会员信息
	 */
	public void saveMemberInfo(MemberInfo memberInfo);
	/**
	 * 保存产品详细信息
	 */
	public void saveOfferDetailInfo(List<OfferDetailInfo> offerDetailInfos);
	/**
	 * 保存产品图片信息
	 */
	public void saveOfferImageInfo(List<OfferImageInfo> OfferImageInfos);
	/**
	 * 保存产品特性信息
	 */
	public void saveProductFeatureInfo(List<ProductFeatureInfo> productFeatureInfos);
	/**
	 * 保存企业分类信息
	 */
	public void saveEnterpriseCategory(List<ProductCategory> productCategorys);
	/**
	 *获取商品中的类目id
	 */
	@SuppressWarnings("rawtypes")
	public List getCategoryIdByOfferDatailInfo(DataCriteria dataCriteria);
	/**
	 * 保存产品价格区间信息
	 */
	public void savePriceRangeInfo(List<PriceRangeInfo> priceRangeInfos);
	/**
	 * 同步阿里数据到企业版数据库
	 */
	public void syncE688Data2Wea(DataCriteria dataCriteria);
	/**
	 * 调用存储过程删除阿里数据
	 */
	public void deleteE688Data(DataCriteria dataCriteria);
	/**
	 * 插入产品不同颜色	 
	 */
	public void saveProductDiffer(List<ProductDiffer> productDifferList);
	/**
	 * 保存产品描述
	 * @param offerDescriptionList
	 */
	public void saveOfferDescription(List<OfferDescription> offerDescriptionList);

}