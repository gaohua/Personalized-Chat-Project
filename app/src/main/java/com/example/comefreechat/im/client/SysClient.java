package com.example.comefreechat.im.client;

import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.example.comefreechat.http.HttpClient;
import com.gsww.weioa.agreement.pojo.ResponseObject;
import com.gsww.weioa.agreement.pojo.sys.AuthCode;
import com.gsww.weioa.agreement.pojo.sys.Login;
import com.gsww.weioa.agreement.pojo.sys.Register;
import com.gsww.weioa.agreement.pojo.sys.SetInfoChange;
import com.gsww.weioa.agreement.pojo.sys.SetInfoCreate;


/**
 * 类名: SysClient <br/> 
 * 功能: 系统Activity与引擎交互的类. <br/> 
 * 创建日期: 2014-9-16 下午4:55:27 <br/> 
 *
 * @author Administrator
 * @version V3.0
 * @since Jdk 1.6
 * @see       
 *
 */
public class SysClient extends BaseClient {
/**
 * 
 * userLogin:登录方法. <br/> 
 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
 * 
 * @author wujd 
 * @param password  --密码明文传输
 * @param setId     --工作圈ID为空时默认进入新手村
 * @return
 * @throws Exception
 */
    public ResponseObject userLogin(String password)
    		throws Exception {
    	List<BasicNameValuePair> params = createReqParam();
    	params.add(new BasicNameValuePair(Login.Request.PASSWORD,password));
    	resultJSON = com.example.comefreechat.http.HttpClient.post(Login.SERVICE, params);
    	return getResult(resultJSON);
    }
    /**
     * 
     * sendVerCode:验证码下发接口. <br/> 
     * TODO输入参数为用户的手机号码.另一个参数为下发验证码类型。0：注册；1：修改密码<br/>
     * 当为注册时服务器会判断是否已经注册 
     * 
     * @author Administrator 
     * @param userMDN          ----用户手机号码
     * @return
     * @throws Exception
     */
       public ResponseObject sendVerCode()
                throws Exception {
            List<BasicNameValuePair> params = createReqParam();
            params.add(new BasicNameValuePair(AuthCode.Request.REQUEST_TYPE, com.example.comefreechat.utils.Constants.VERCODE_TYPE_REGISTER));
            resultJSON = com.example.comefreechat.http.HttpClient.post(AuthCode.SERVICE, params);
            return getResult(resultJSON);
        }
    /**
    * 
    * userRegister:(用户注册接口). <br/> 
    * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
    * 
    * @author Administrator 
    * @param userName
    * @param userPwd
    * @return
    * @throws Exception
    */
   public ResponseObject userRegister(String userName,String userPwd)
           throws Exception {
       List<BasicNameValuePair> params = createReqParam();
       params.add(new BasicNameValuePair(Register.Request.USER_NAME, userName));
       params.add(new BasicNameValuePair(Register.Request.PASSWORD, userPwd));
       resultJSON = HttpClient.post(Register.SERVICE, params);
       return getResult(resultJSON);
   }
   
   
   /**
    * 
    * createSet:新建圈子. <br/> 
    * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
    * 
    * @author Administrator 
    * @param setName
    * @return
    * @throws Exception
    */
  public ResponseObject createSet(String setName)
           throws Exception {
       List<BasicNameValuePair> params = createReqParam();
       params.add(new BasicNameValuePair(SetInfoCreate.Request.SET_NAME, setName));
       resultJSON = HttpClient.post(SetInfoCreate.SERVICE, params);
       return getResult(resultJSON);
   }
  /**
   * 
   * changeSet:切换圈子. <br/> 
   * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
   * 
   * @author Administrator 
   * @param setId
   * @return
   * @throws Exception
   */
  public ResponseObject changeSet(String setId)
          throws Exception {
      List<BasicNameValuePair> params = createReqParam();
      params.add(new BasicNameValuePair(SetInfoChange.Request.SET_ID,setId));
      resultJSON = HttpClient.post(SetInfoChange.SERVICE, params);
      return getResult(resultJSON);
  }
}
