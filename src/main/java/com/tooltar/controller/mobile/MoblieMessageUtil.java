package com.tooltar.controller.mobile;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.tooltar.util.SecurityCode;

/**
 * 短信验证
 * */
public class MoblieMessageUtil {
	//初始化ascClient需要的几个参数
	// 产品名称:云通信短信API产品,开发者无需替换
	static final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	// 产品域名,开发者无需替换
	static final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	// 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找) accessKeyId:LTAI19VtpLnVuvTQ;  accessKeySecret:rwcchUoYCVjyrEGHzyxNkZJF77HGZU
	static final String accessKeyId = "LTAI0gc2FTMi9qpA";//自己的accessKeyId
	static final String accessKeySecret = "UeU35YfT7LoBfkLKRVGqu7m5YHDXKK";//自己的accessKeySecret

	public static SendSmsResponse sendSms() throws ClientException {
		//设置超时时间-可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
		System.setProperty("sun.net.client.defaultReadTimeout", "5000");
		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象-具体描述见控制台-文档部分内容
		SendSmsRequest request = new SendSmsRequest();
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,
		// 验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
		request.setPhoneNumbers("18310701720");
		// 必填:短信签名-可在短信控制台中找到，举个例子
		request.setSignName("云景科技-熊凯");
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
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		return sendSmsResponse;
	}

	public static QuerySendDetailsResponse querySendDetails(String bizId) throws ServerException, ClientException {
		// 可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);

		// 组装请求对象
		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-待发送的手机号码
		request.setPhoneNumber("18310701720");
		// 可选-流水号
		request.setBizId(bizId);
		// 必填-发送日期 支持30天内记录查询，格式yyyyMMdd
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		request.setSendDate(ft.format(new Date()));
		// 必填-页大小
		request.setPageSize(10L);
		// 必填-当前页码从1开始计数
		request.setCurrentPage(1L);

		// hint 此处可能会抛出异常，注意catch
		QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
		return querySendDetailsResponse;
	}

	public static void main(String[] args) throws ClientException, InterruptedException {

		SendSmsResponse sendSms = MoblieMessageUtil.sendSms();
		// 发短信
		SendSmsResponse response = sendSms();

		System.out.println("response:"+response+"code:"+response.getCode());
		Thread.sleep(3000L);
		

		// 查明细
		if (response.getCode() != null && response.getCode().equals("OK")) {
			System.out.println("请求成功");
			QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
			System.out.println("短信明细查询接口返回数据----------------");
			System.out.println("Code=" + querySendDetailsResponse.getCode());
			System.out.println("Message=" + querySendDetailsResponse.getMessage());
			int i = 0;
			for (QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse
					.getSmsSendDetailDTOs()) {
				System.out.println("SmsSendDetailDTO[" + i + "]:");
				System.out.println("Content=" + smsSendDetailDTO.getContent());
				System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
				System.out.println("OutId=" + smsSendDetailDTO.getOutId());
				System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
				System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
				System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
				System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
				System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
			}
			System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
			System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
		}else {
			System.out.println("---------------");
		}

	}

}
