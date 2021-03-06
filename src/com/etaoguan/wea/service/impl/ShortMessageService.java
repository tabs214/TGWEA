package com.etaoguan.wea.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.etaoguan.wea.service.ICustService;
import com.etaoguan.wea.service.IOwnerService;
import com.etaoguan.wea.service.IShortMessageService;
import com.etaoguan.wea.vo.Customer;

public class ShortMessageService extends BaseService implements IShortMessageService{
	
	private final static Log logger = LogFactory.getLog(ShortMessageService.class);
	
	@Resource(name="ownerService") 
	protected IOwnerService iOwnerService;
	
	@Resource(name="custService")
	protected ICustService iCustService;
	
	
	@Override
	public String getShortMessageCode() {
		String checkCode = String.valueOf(Math.random()).substring(3,7);
		return checkCode;
	}

	@Override
	public void sendRegShortMessageContent(String mobileNum, String code,String ownerNum) {
		String companyName = iOwnerService.getOwner(ownerNum).getCompanyName();
		StringBuffer content = new StringBuffer();
		content.append("您的验证码是：【");
		content.append(code);
		content.append("】【 ");
		content.append(companyName);
		content.append("】。请不要把验证码泄露给其他人。如非本人操作，可不用理会！");
		sendShortMessage(mobileNum,content.toString());
	}
	
	@Override
	public void sendMobileOrderShortMessageContent(String custNum, String orderNum,String ownerNum) {
		
		Customer customer = iCustService.getCust(custNum);
		String contactPerson = customer.getContactPerson();
		String phoneNumber = customer.getPhoneNum();
		
		String mobileNum = iOwnerService.getOwner(ownerNum).getMobileNum();
		
		StringBuffer content = new StringBuffer();
		content.append("您有新的订单：【");
		content.append(orderNum);
		content.append("】【指掌通】，收货人：【");
		content.append(contactPerson);
		content.append("】，电话：【");
		content.append(phoneNumber);
		content.append("】，请及时确认订单！");
		
		sendShortMessage(mobileNum,content.toString());
	}

	@Override
	public void sendShortMessage(String mobileNum, String content) {
		 
		try {
			String	PostData = "account=yinuo1014&password=etaoguan123&mobile="+mobileNum+"&content="+java.net.URLEncoder.encode(content+"","utf-8");
			 String ret =SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
			 logger.info("****************** http://www.106jiekou.com/member/member/help/  验证码状态  *******"+ret);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

	 public String SMS(String postData, String postUrl) {
	        try {
	            //发送POST请求
	            URL url = new URL(postUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);

	            conn.setRequestProperty("Content-Length", "" + postData.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            out.write(postData);
	            out.flush();
	            out.close();

	            //获取响应状态
	            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.out.println("connect failed!");
	                return "";
	            }
	            //获取响应内容体
	            String line, result = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            while ((line = in.readLine()) != null) {
	                result += line + "\n";
	            }
	            in.close();
	            return result;
	        } catch (IOException e) {
	            e.printStackTrace(System.out);
	        }
	        return "";
	    }
	 
}
