package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ProdDiffer;
import com.etaoguan.wea.vo.ProdExternal;
import com.etaoguan.wea.vo.ProdFeature;
import com.etaoguan.wea.vo.ProdImg;
import com.etaoguan.wea.vo.Product;

/**
 * @author cunli
 * 产品信息
 */
public interface IProductDao {
	
	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 根据用户ID获取产品列表信息
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getProductsBycustNum(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addProduct(Product product);
	
	public Product getProduct(DataCriteria dataCriteria);
	
	public List<Product> getProducts(DataCriteria dataCriteria);
	
	public List<String> getProdNums(DataCriteria dataCriteria);
	
	public int getProdMaxPosSeqence(DataCriteria dataCriteria);
	
	public void updateProduct(Product product);
	
	public void delProduct(DataCriteria dataCriteria);
	
	public void addProdImg(ProdImg prodImg);
	
	public int getProdMaxImgSequence(DataCriteria dataCriteria);
	
	public void delProdImg(DataCriteria dataCriteria);
	
	public void updateProdImg(DataCriteria dataCriteria);
	
	public List<ProdImg> getProdImgs(DataCriteria dataCriteria);
	
	public ProdImg getProdImg(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getProducts(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet getCompProducts(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void updateProduct(DataCriteria dataCriteria);
	
	public List<ProdFeature> getProdFeatures(DataCriteria dataCriteria);
	
	public List<ProdDiffer> getProdDiffers(DataCriteria dataCriteria);
	
	public ProdFeature getProdFeature(DataCriteria dataCriteria);
	
	public List<ProdExternal> getProdExternals(DataCriteria dataCriteria);
	
	public ProdExternal getProdExternal(DataCriteria dataCriteria);
	
	public void delProdFeature(DataCriteria dataCriteria);
	
	public void delProdDiffer(DataCriteria dataCriteria);
	
	public void updateProdFeature(ProdFeature prodFeature);
	
	public void addProdFeature(ProdFeature prodFeature);
	
	public void addProdDiffer(ProdDiffer prodDiffer);
	
	
}
