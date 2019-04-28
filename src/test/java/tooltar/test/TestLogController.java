package tooltar.test;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.UserBean;
import com.tooltar.controller.web.LogController;
import com.tooltar.controller.web.LoginController;
import com.tooltar.util.Page;

public class TestLogController {
//	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/*.xml");
	@Test
	public void Log() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		System.out.println(ac);
		LogController l = (LogController) ac.getBean("logController");
		Page page = new Page();
		page.setPage(1);//瑜版挸澧犳い鐢电垳
//		page.setStart(0);
		page.setRows(15);//濮ｅ繘銆夐弰鍓с仛閻ㄥ嫭鏆熼柌锟�
		System.out.println(page);
		ModelAndView log = l.toLog(page);
	}
	@Test
	public void Login() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-dao.xml","spring-service.xml","spring-mvc.xml"});
		System.out.println(ac);
		LoginController l = (LoginController) ac.getBean("loginController");
		UserBean userBean = new UserBean();
		userBean.setPassword("12345");
		userBean.setTel("18310701720");
		HttpServletRequest request = null;
		System.out.println(l.showLogin(userBean,request));
	}
}
