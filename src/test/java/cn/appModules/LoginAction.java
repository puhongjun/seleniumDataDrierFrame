package cn.appModules;
//封装登录操作

import org.openqa.selenium.WebDriver;
import cn.pageObjects.LoginPage;
import cn.pageObjects.WaitByElement;
import cn.util.WaitMethod;
import cn.util.log;

public class LoginAction {
	public static void execute(WebDriver driver,String userName,String passWord)
		throws Exception{
		log.info("浏览器最大化");
		//浏览器最大化
		driver.manage().window().maximize();
		log.info("实例化LoginPage对象");
		//实例化LoginPage对象
		LoginPage login=new LoginPage(driver);
		log.info("点击进入密码登录按钮");
		//点击进入密码登录按钮
		login.intoLogin().click();
		log.info("显示等待"+WaitByElement.loginFrame+" 元素5秒");
		//显示等待
		WaitMethod.xsWait(driver,WaitByElement.loginFrame,5);
		log.info("进入登录界面的frame");
		//控制权交给登录界面的frame
		driver.switchTo().frame(login.loginFrame());
		log.info("输入用户名"+userName);
		//输入用户名
		login.userName().sendKeys(userName);
		log.info("输入密码"+passWord);
		//输入密码
		login.passWord().sendKeys(passWord);
		log.info("点击登录按钮");
		//点击登录按钮
		login.loginButton().click();
//		Thread.sleep(5000);
	}

}
