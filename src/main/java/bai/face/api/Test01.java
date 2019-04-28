/*package bai.face.api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject; *//**��Ҫ����SDK��jar http://ai.baidu.com/sdk#bfr*//*

import comt.baidu.aip.utils.Base64Util;
import comt.baidu.aip.face.AipFace;
import comt.baidu.aip.face.MatchRequest;

*//** ��Ҫ����SDK��jar http://ai.baidu.com/sdk#bfr *//*

public class Test01 {
	// ���²����ֱ��Ӧ���������õ�AppID��API Key �Լ� Secret Key
	public static final String APP_ID = "15675983";
	public static final String API_KEY = "Z3yajvfrGL7GLyUqmqa3T3si";
	public static final String SECRET_KEY = "gepx6uWZypW7V3S46EMlhYQuKlRwsDuX";
	*//**
     * ���ļ�תΪ��
     * @param file
     * @return
     * @throws IOException
     *//*
    public static byte[] FileToByte(File file) throws IOException {
        // ������תΪ��
        InputStream content = new FileInputStream(file);
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = content.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        // ��ö���������
        return swapStream.toByteArray();
    }
    *//**�����Ա�ʵ��*//*
	public static void main(String[] args) throws Exception {
		AipFace client = new AipFace(APP_ID , API_KEY , SECRET_KEY);
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		
		String img_1 =Base64Util.encode( Test01.FileToByte( new File("E:/img/a.jpg"))); ;  //��Ҫ��������ʶ���ͼ��λ��
		String img_2 = Base64Util.encode( Test01.FileToByte( new File("E:/img/b.jpg")));;  //��Ҫ��������ʶ���ͼ��λ��
	    
		ArrayList<MatchRequest> pathArray = new ArrayList<MatchRequest>();
	    pathArray.add(new MatchRequest(img_1,"BASE64"));
	    pathArray.add(new MatchRequest(img_2,"BASE64"));
	   
	    System.out.println("�ϴ�ing... ...");
	    JSONObject response = client.match(pathArray );
	    System.out.println("----------------------------------------------------");
	    System.out.println(response.toString()); //�������JSON��ʽ
	     a��c �ԱȽ��
	     * {
	     * "result":
	     * 	{	"score":100,
	     * 		"face_list":[
	     * 				{"face_token":"2e6419fc3aa3690ac73898eab3bca337"},
	     * 				{"face_token":"2e6419fc3aa3690ac73898eab3bca337"}
	     * 		]},
	     * 		"log_id":304569223953962581,
	     * 		"error_msg":"SUCCESS",
	     * 		"cached":0,
	     * 		"error_code":0,
	     * 		"timestamp":1552395396
	     * }
	     * 
	     * a��b��ֵ
	     * {
	     * 	"result":{
	     * 			"score":87.28437805,
	     * 			"face_list":[
	     * 					{"face_token":"2e6419fc3aa3690ac73898eab3bca337"},
	     * 					{"face_token":"f2df61751667aa11f5d52b203029ba0e"}
	     * 					]},
	     * 			"log_id":304569223965808051,
	     * 			"error_msg":"SUCCESS",
	     * 			"cached":0,
	     * 			"error_code":0,
	     * 			"timestamp":1552396580
	     * }
	     

	}

}
*/