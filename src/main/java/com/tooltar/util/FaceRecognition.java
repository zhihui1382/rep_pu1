package com.tooltar.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import bai.face.api.Test02;
/**
 * 人脸识别功能
 * 
 * */
public class FaceRecognition {
	// 以下参数分别对应着意见申请好的AppID、API Key 以及 Secret Key
	public static final String APP_ID = "15675983";
	public static final String API_KEY = "Z3yajvfrGL7GLyUqmqa3T3si";
	public static final String SECRET_KEY = "gepx6uWZypW7V3S46EMlhYQuKlRwsDuX";

	/**
	 * 将文件转为流
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] FileToByte(File file) throws IOException {
		// 将数据转为流
		InputStream content = new FileInputStream(file);
		// 字节数组输出流在内存中创建一个字节数组缓冲区，所有发送到输出流的数据保存在该字节数组缓冲区中。
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = content.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		// 获得二进制数组
		return swapStream.toByteArray();
	}

	/**
	 * 返回颜值分数
	 * 
	 * @param str JSON字符串
	 * @return 颜值分数
	 * @throws Exception
	 */
	public static String getBeauty(String str) throws Exception {
		JsonParser parse = new JsonParser(); // 创建json解析器
		JsonObject json = (JsonObject) parse.parse(str);
		JsonObject jsonResult = (JsonObject) json.get("result");
		JsonArray face_list = (JsonArray) jsonResult.get("face_list");
		JsonObject myFace = (JsonObject) face_list.get(0);
		String beauty = myFace.get("beauty").getAsString();
		int i = str.indexOf("beauty");
		str = str.substring(i);
		int begin = str.indexOf(":");
		int end = str.indexOf(",");
		System.out.println(str.substring(begin + 1, end));
		return beauty;
	}

	/**
	 * 返回年龄
	 * 
	 * @param str JSON字符串
	 * @return 年龄
	 * @throws Exception
	 */
	public static int getAge(String str) throws Exception {
		JsonParser parse = new JsonParser(); // 创建json解析器
		JsonObject json = (JsonObject) parse.parse(str);
		JsonObject jsonResult = (JsonObject) json.get("result");
		JsonArray face_list = (JsonArray) jsonResult.get("face_list");
		JsonObject myFace = (JsonObject) face_list.get(0);
		int age = myFace.get("age").getAsInt();
		return age;
	}
	/**
	 * 返回性别
	 * 
	 * @param str JSON字符串
	 * @return 性别
	 * @throws Exception
	 */
	public static String getSex(String str) throws Exception {
		JsonParser parse = new JsonParser(); // 创建json解析器
		JsonObject json = (JsonObject) parse.parse(str);
		JsonObject jsonResult = (JsonObject) json.get("result");
		JsonArray face_list = (JsonArray) jsonResult.get("face_list");
		JsonObject myFace = (JsonObject) face_list.get(0);
		JsonObject gender = (JsonObject) myFace.get("gender");
		return gender.get("type").getAsString();
	}

	/** 人脸识别实现(通过输入图片来进行智能识别) */
	public static JSONObject getFaceValues(String url) throws Exception {
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);// 初始化一个AipFace
		client.setConnectionTimeoutInMillis(2000);// 建立连接的超时时间（单位：毫秒）
		client.setSocketTimeoutInMillis(60000);// 通过打开的连接传输数据的超时时间（单位：毫秒）
		// 图片数据
		String imgStr = Base64Util.encode(Test02.FileToByte(new File(url)));

		HashMap<String, String> options = new HashMap<String, String>();
		//options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,qualities");
		options.put("face_field", "age,beauty,gender");
		options.put("max_face_num", "2");// 最多检测到的人脸数量
		options.put("face_type", "LIVE");// LIVE表示生活照,WATERMARK表示带水印证件照,IDCARD表示身份证芯片照,CERT表示证件照片

		// 需要进行人脸识别的图像位置
		JSONObject res = client.detect(imgStr, "BASE64", options);
		return res;
	}

	public static void main(String[] args) throws Exception {

		JSONObject res = FaceRecognition.getFaceValues("C:/Users/Administrator/Desktop/1.png");
		System.out.println("-----------------------------------------------");
		System.out.println(res.toString(2));
		System.out.println("-----------------------------------------------");
		System.out.println("颜值：" + FaceRecognition.getBeauty(res.toString(2)));
		System.out.println("年龄：" + FaceRecognition.getAge(res.toString(2)));
		System.out.println("性别：" + FaceRecognition.getSex(res.toString(2)));

	}

}
