package tooltar.test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tooltar.bean.MSportBean;
import com.tooltar.bean.MUserBean;
import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;
import com.tooltar.mapper.RoleDaoI;
import com.tooltar.service.MSportServiceI;
import com.tooltar.service.MUserServiceI;
import com.tooltar.service.RoleServiceI;

public class TestHui2 {
	
	/***
	 * 测试前端用户
	 */
	@Test
	public void testMUser(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		
		MUserServiceI mUserServiceI = ac.getBean("MUserService",MUserServiceI.class);
		
		MUserBean u=new MUserBean();
		u.setAge(12);
//		u.setUsername("小红");
		u.setWeight(120);
		
		List<MUserBean> list = mUserServiceI.loadMUsersListService(u);
		for (MUserBean m : list) {
			System.out.println(m);
		}
		
		/*MSportServiceI mSportServiceI = ac.getBean("MSportService",MSportServiceI.class);
		
		
		List<MSportBean> list = mSportServiceI.loadTwmSportByMuidService(2);
		for (MSportBean m : list) {
			System.out.println(m);
		}*/
		
		/*MUserServiceI mUserServiceI = ac.getBean("MUserService",MUserServiceI.class);
		List<MUserBean> list = mUserServiceI.loadMUserListService();
		System.out.println(list.size());
		for (MUserBean m : list) {
			System.out.println(m);
		}*/
	}
	
	
	/***
	 * 测试查询2
	 */
	@Test
	public void selTest1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		RoleServiceI roleServiceI = ac.getBean("roleService",RoleServiceI.class);
				
		UserBean u=new UserBean();
		u.setEmail("123");
		u.setTel("125");
		
		RoleBean r=new RoleBean();
		r.setName("管理员2");
		
		List<ResultRoleBean> list = roleServiceI.selRole(u, r);
		for (ResultRoleBean rr : list) {
			System.out.println(rr);
		}
		
	}
	
}
