package tooltar.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;
import com.tooltar.mapper.PermissionDaoI;
import com.tooltar.mapper.RoleDaoI;
import com.tooltar.service.RoleServiceI;

public class TestHui {
	
	/***
	 * 测试添加角色
	 */
	@Test
	public void testAddRole(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		//System.out.println("ac===="+ac);
		/*String[] names = ac.getBeanDefinitionNames();
		for (String s : names) {
			System.out.println(s+"***********");
		}*/
		Object dataSource = ac.getBean("dataSource");
		System.out.println("dataSource=="+dataSource);
		/*
		
		RoleDaoI roleDaoI = ac.getBean("roleDaoI",RoleDaoI.class);
		System.out.println(roleDaoI+"-----roleDaoI---");
		
		RoleBean role=new RoleBean();
		role.setMessage("管理员4");
		role.setPermissionId("1,2,3");
		
		roleDaoI.addRole(role);
		
		System.out.println("------完成------");*/
		
		//UserBean user=new UserBean();
		//roleDaoI.selRole(user, role);
	}
	
	/***
	 * 测试修改角色和删除角色
	 */
	@Test
	public void updateRoleTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		
		RoleDaoI roleDaoI = ac.getBean("roleDaoI",RoleDaoI.class);
		System.out.println(roleDaoI+"-----roleDaoI---");
		
		RoleBean role=new RoleBean();
		role.setId(2);
		//role.setMessage("管理员2");
		role.setPermissionId("1,2,3");
		
		//更新测试
		//roleDaoI.updRole(role);
		
		//测试删除
		//roleDaoI.delRole(4);
		
		System.out.println("------完成------");
		
	}
		
	/***
	 * 测试查询2
	 */
	@Test
	public void selRoleTest2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		
		RoleDaoI roleDaoI = ac.getBean("roleDaoI",RoleDaoI.class);
	
		UserBean u=new UserBean();
		u.setEmail("123");
		u.setTel("122");
		
		RoleBean r=new RoleBean();
		//r.setMessage("");
		
		/*List<Map<String,Object>> list = roleDaoI.selRole(u, r);
		
		for (Map<String, Object> map : list) {
			Set<Entry<String,Object>> entrySet = map.entrySet();
			
			for (Entry<String, Object> e : entrySet) {
				System.out.println(e.getKey()+"---"+e.getValue());
				
			}
			System.out.println();
		}
				
		System.out.println("-----完成--");*/
	}
	
	@Test
	public void testError(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		
		RoleServiceI roleServiceI = ac.getBean("roleService",RoleServiceI.class);
		
		UserBean u=new UserBean();
		
		RoleBean r=new RoleBean();
		System.out.println(u);
		
		/*List<Map<String,Object>> list =	roleServiceI.selRole(u, r);
		
		
		for (Map<String, Object> map : list) {
			Set<Entry<String,Object>> entrySet = map.entrySet();
			
			for (Entry<String, Object> e : entrySet) {
				System.out.println(e.getKey()+"---"+e.getValue());
				
			}
			System.out.println();
		}
				
		System.out.println("-----完成--");*/
		
	}
	
	@Test
	public void demo(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		
		RoleDaoI roleDaoI = ac.getBean("roleDaoI",RoleDaoI.class);
		PermissionDaoI permissionDaoI = ac.getBean("permissionDaoI",PermissionDaoI.class);
		
		UserBean u=new UserBean();
		RoleBean r=new RoleBean();
		
		/*List<Map<String,Object>> list = roleDaoI.selRole(u, r);
		System.out.println(list.size()+"============="); //roleDaoI.selRole(u, r);
		
		//处理结果
		for (Map<String, Object> map : list) {
			Set<Entry<String,Object>> entrySet = map.entrySet();
			for (Entry<String, Object> e : entrySet) {
				if(e.getKey().equals("authority")){
					String auths=(String) e.getValue(); //如 1,2,3
					String[] strs = auths.split(",");
					StringBuffer sb=new StringBuffer();
					for (String s : strs) {
						Integer idp = Integer.valueOf(s);
						String perDesc = permissionDaoI.getPerDesc(idp);
						sb.append(perDesc+",");
					}
					String s=sb.substring(0, sb.length()-1);
					System.out.println(s+"-----s");
					e.setValue(s);
				}//if 
				
			}
		}*/
		
	}
	
	@Test
	public void selTest1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		
		RoleDaoI roleDaoI = ac.getBean("roleDaoI",RoleDaoI.class);
		
		UserBean u=new UserBean();
		u.setEmail("123");
//		u.setTel("122");
		
		RoleBean r=new RoleBean();
		r.setMessage("管理员");
		
		/*List<Map<String,Object>> list = roleDaoI.selRole(u, r);
		System.out.println(list.size());
		
		for (Map<String, Object> map : list) {
			Set<Entry<String,Object>> entrySet = map.entrySet();
			
			for (Entry<String, Object> e : entrySet) {
				System.out.println(e.getKey()+"---"+e.getValue());
				
			}
			System.out.println();
		}
		
		System.out.println("-----完成--");*/
	}
	
}


