package comt.baidu.aip.utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.FaceVerifyRequest;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import org.json.JSONObject;
 
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
 
/**
 * Created by BF100 on 2018/6/25.
 */
public class FaceUtil {
    //����APPID/AK/SK
    public static final String APP_ID = "11429094";
    public static final String API_KEY = "V0wjNP0yctaIHqrvfGbfaKkC";
    public static final String SECRET_KEY = "GQnl9x5bVrqP5hUSRldwZYuzQznT6iFs";
 
    static AipFace client = null;
    static {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // ��ѡ�������������Ӳ���
        // ����http����
        // client.setHttpProxy("proxy_host", proxy_port);
        // ����socket����
        // client.setSocketProxy("proxy_host", proxy_port);
        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
//        System.setProperty("aip.log4j.conf", "src/main/java/log4j.properties");
        client.setConnectionTimeoutInMillis(2000);
        // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
        client.setSocketTimeoutInMillis(60000);
    }
    /**
     * �������
     * @param file
     * @param max_face_num
     * @return
     */
    public static String detectFace(File file, String max_face_num) {
        try {
            return detectFace(FileToByte(file), max_face_num);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * �������
     * @param arg0
     * @param max_face_num
     * @return
     */
    public static String detectFace(byte[] arg0, String max_face_num) {
        try {
 
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,qualities");
            options.put("max_face_num", "2");
            options.put("face_type", "LIVE");
 
            // ͼƬ����
            String imgStr = Base64Util.encode(arg0);
            String imageType = "BASE64";
            JSONObject res = client.detect(imgStr, imageType, options);
            System.out.println(res.toString(2));
            return res.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * �����ȶ�
     * @param file1
     * @param file2
     * @return
     */
    public static String matchFace(File file1, File file2) {
        try {
            return matchFace(FileToByte(file1), FileToByte(file2));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * �����ȶ�
     * @param arg0
     * @param arg1
     * @return
     */
    public static String matchFace(byte[] arg0, byte[] arg1) {
        String imgStr1 = Base64Util.encode(arg0);
        String imgStr2 = Base64Util.encode(arg1);
        MatchRequest req1 = new MatchRequest(imgStr1, "BASE64");
        MatchRequest req2 = new MatchRequest(imgStr2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        JSONObject res = client.match(requests);
        return res.toString();
    }
 
    /**
     * ��������
     * @param file
     * @param groupIdList
     * @param userId
     * @return
     */
    public static String searchFace(File file, String groupIdList, String userId) {
        try {
            return searchFace(FileToByte(file), groupIdList, userId);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * ��������
     * @param arg0
     * @param groupIdList
     * @param userId
     * @return
     */
    public static String searchFace(byte[] arg0, String groupIdList, String userId) {
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        if (userId != null ) {
            options.put("user_id", userId);
        }
        options.put("max_user_num", "1");
        JSONObject res = client.search(imgStr, imageType, groupIdList, options);
        return res.toString(2);
    }
 
    /**
     * ע���û�
     * @param file
     * @param userInfo
     * @param userId
     * @param groupId
     * @return
     */
    public static String addUser(File file, String userInfo, String userId, String groupId) {
        try {
            return addUser(FileToByte(file), userInfo, userId, groupId);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * ע���û�
     * @param arg0
     * @param userInfo
     * @param userId
     * @param groupId
     * @return
     */
    public static String addUser(byte[] arg0, String userInfo, String userId, String groupId) {
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", userInfo);
        options.put("quality_control", "NORMAL");
//        options.put("liveness_control", "LOW");
 
        JSONObject res = client.addUser(imgStr, imageType, groupId, userId, options);
        return res.toString(2);
    }
 
    /**
     * ��ѯ�û���Ϣ
     * @param userId
     * @param groupId
     * @return
     */
    public static String searchUserInfo(String userId, String groupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        // �û���Ϣ��ѯ
        JSONObject res = client.getUser(userId, groupId, options);
        return res.toString(2);
    }
 
    /**
     * ��ȡ�û������б�
     * @param userId
     * @param groupId
     * @return
     */
    public static String getUserFaceList(String userId, String groupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        // ��ȡ�û������б�
        JSONObject res = client.faceGetlist(userId, groupId, options);
        return res.toString(2);
    }
 
    /**
     * ��ȡһ���û�
     * @param groupId
     * @param returnNum
     * @return
     */
    public static String getGroupUsers(String groupId, String returnNum) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        if (returnNum != null) {
            options.put("length", returnNum);
        }
        // ��ȡ�û��б�
        JSONObject res = client.getGroupUsers(groupId, options);
        return res.toString(2);
    }
 
    /**
     * �����û�
     * @param file
     * @param userInfo
     * @param userId
     * @param groupId
     * @return
     */
    public static String updateUser(File file, String userInfo, String userId, String groupId) {
        try {
            return updateUser(FileToByte(file), userInfo, userId, groupId);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * �����û�
      * @param arg0
     * @param userInfo
     * @param userId
     * @param groupId
     * @return
     */
    public static String updateUser(byte[] arg0, String userInfo, String userId, String groupId) {
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        HashMap<String, String> options = new HashMap<String, String>();
        if (userInfo != null) {
            options.put("user_info", userInfo);
        }
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
 
        JSONObject res = client.updateUser(imgStr, imageType, groupId, userId, options);
        return res.toString(2);
    }
 
    /**
     * ɾ���û� ����ɾ��
     * @param userId
     * @param groupId
     * @param faceToken
     * @return
     */
    public static String deleteUserFace(String userId, String groupId, String faceToken) {
        HashMap<String, String> options = new HashMap<String, String>();
        // ����ɾ��
        JSONObject res = client.faceDelete(userId, groupId, faceToken, options);
        return res.toString();
    }
 
    /**
     * ���û�����
     * @param userId
     * @param srcGroupId
     * @param dstGroupId
     * @return
     */
    public static String userCopy(String userId, String srcGroupId, String dstGroupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("src_group_id", srcGroupId);
        options.put("dst_group_id", dstGroupId);
        // �����û�
        JSONObject res = client.userCopy(userId, options);
        return res.toString(2);
    }
 
    /**
     * ɾ���û�
     * @param userId
     * @param groupId
     * @return
     */
    public static String deleteUser(String userId, String groupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        // ����ɾ��
        JSONObject res = client.deleteUser(groupId, userId, options);
        return res.toString();
    }
 
    /**
     * ��������Ϣ
     * @param groupId
     * @return
     */
    public static String addGroup(String groupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        // �����û���
        JSONObject res = client.groupAdd(groupId, options);
        return res.toString();
    }
 
    /**
     * ɾ���û���
     * @param groupId
     * @return
     */
    public static String deleteGroup(String groupId) {
        HashMap<String, String> options = new HashMap<String, String>();
        // �����û���
        JSONObject res = client.groupDelete(groupId, options);
        return res.toString();
    }
 
    /**
     * ��ȡ���б�
     * @param length
     * @return
     */
    public static String getGroupList(String length) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", length);
        // ���б��ѯ
        JSONObject res = client.getGroupList(options);
        return res.toString();
    }
 
    /**
     * ������
     * @param arg0
     * @return
     */
    public static String faceverify(byte[] arg0){
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        FaceVerifyRequest req = new FaceVerifyRequest(imgStr, imageType);
        ArrayList<FaceVerifyRequest> list = new ArrayList<FaceVerifyRequest>();
        list.add(req);
        JSONObject res = client.faceverify(list);
        return res.toString();
    }
 
    /**
     * �����֤
     * @param arg0
     * @param idCardNumber
     * @param name
     * @return
     */
    public static String personVerify(byte[] arg0, String idCardNumber, String name){
        String imgStr = Base64Util.encode(arg0);
        String imageType = "BASE64";
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
 
        // �����֤
        JSONObject res = client.personVerify(imgStr, imageType, idCardNumber, name, options);
        return  res.toString(2);
    }
 
 
    /**
     * ���ļ�תΪ��
     * @param file
     * @return
     * @throws IOException
     */
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
}
