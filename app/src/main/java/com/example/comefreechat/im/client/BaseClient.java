package com.example.comefreechat.im.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.example.comefreechat.utils.Cache;
import com.example.comefreechat.utils.ConfigurationHelper;
import com.gsww.weioa.agreement.parser.AgreementParserFactory;
import com.gsww.weioa.agreement.pojo.ResponseObject;
import com.gsww.weioa.agreement.pojo.sys.CommonParams;


/**
 * 类名: BaseClient <br/> 
 * 功能: 业务模块数据调用的父类. <br/> 
 * 创建时间: 2014-9-14 下午8:03:16 <br/> 
 * 
 * @author wchhuangya 
 * @version  
 * @since Jdk 1.6
 */
public class BaseClient {
	/** 返回的json格式的数据 */
	public String resultJSON;
	/** 把json格式的数据转换为格式化数据 */
	public ResponseObject resInfo;
	/** 分页参数：每页展示的列表条数 */
	public String pageSize = ConfigurationHelper.getPropertyByStr("list.pagesize");

	/**
	 * 创建请求参数
	 * @return
	 */
	public List<BasicNameValuePair> createReqParam() {
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair(CommonParams.Request.USER_ID, Cache.USER_ID));
		params.add(new BasicNameValuePair(CommonParams.Request.COMMON_USER_MDN, Cache.USER_MDN));
		return params;
	}
	/**
	 * 统一封装引擎响应JSON
	 * @param result
	 * @return
	 * @throws Exception
	 */
	public ResponseObject getResult(String result) throws Exception {

		try {
			ResponseObject response = AgreementParserFactory
					.getAgreementParser().stringToResponse(result);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("解析服务端响应数据出错!", e);
		}
	}
	/**
	 * 统一封装引擎响应JSON
	 * @param result
	 * @return
	 * @throws Exception
	 */
	public ResponseObject getResult2(InputStreamReader inputStreamReader) throws Exception {

		try {
			ObjectMapper mapper = new ObjectMapper();
			try {
				ResponseObject response = mapper.readValue(inputStreamReader,
						new TypeReference<ResponseObject>() {
						});
				return response;
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("解析服务端响应数据出错!", e);
		}
	}
}
