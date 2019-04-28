package com.tooltar.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class Code implements CodeI{
	@Override
	public Integer getCode(String code) {
		
		String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
		// 产品域名,开发者无需替换
		String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
		// 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找) accessKeyId:LTAI19VtpLnVuvTQ;  accessKeySecret:rwcchUoYCVjyrEGHzyxNkZJF77HGZU
		String accessKeyId = "LTAI19VtpLnVuvTQ";//自己的accessKeyId
		String accessKeySecret = "rwcchUoYCVjyrEGHzyxNkZJF77HGZU";//自己的accessKeySecret
		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception");
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象-具体描述见控制台-文档部分内容
		SendSmsRequest request = new SendSmsRequest();
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,
		// 验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
		request.setPhoneNumbers("17325564167");
		// 必填:短信签名-可在短信控制台中找到，举个例子
		request.setSignName("tooltar");
		// 必填:短信模板id-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版，是id不是名字，举个例子
		request.setTemplateCode("SMS_161594089");
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为--必填，与模板相对应
		// request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
		request.setTemplateParam("{\"code\":\""+SecurityCode.getMsgCode()+"\"}");
		// 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");
		// hint 此处可能会抛出异常，注意catch
		try {
			SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			if("ok".equals(sendSmsResponse.getCode())&&"ok".equals(sendSmsResponse.getMessage())) {
				return 1;
			}
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
