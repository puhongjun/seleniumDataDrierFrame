package cn.testCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.appModules.LoginAction;
import cn.pageObjects.HomePage;
import cn.pageObjects.LoginPage;
import cn.pageObjects.WaitByElement;
import cn.util.WaitMethod;
import cn.util.log;

public class TestEmail163Login {
	public WebDriver driver;
	String url="https://mail.163.com/";
	@BeforeMethod
	public void beforeMEthod(){
		DOMConfigurator.configure("Log4j.xml");
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test
	public void testLogin() throws Exception{
		log.startTestCase("登录163邮箱");
		log.info("访问网页："+url);
		driver.get(url);
		log.info("调用封装的登录方法LoginAction.execute进行登录操作");
		//调用封装的登录方法进行登录操作
		LoginAction.execute(driver, "13647452447", "puhongjun123456");
		log.info("调用封装的显示等待方法确定登录成功");
		//调用封装的显示等待方法确定登录成功
		WaitMethod.xsWait(driver,WaitByElement.weiduButton,5);
		log.info("断言登录后的页面的Title值是否为“网易邮箱6.0版”，获取到的title为："+driver.getTitle());
		//断言是否登录成功
		Assert.assertEquals(driver.getTitle(), "网易邮箱6.0版");
		log.info("休眠5秒");
		Thread.sleep(5000);
		log.info("实例化HomePage类");
		HomePage homePage=new HomePage(driver);
		log.info("点击 通讯录 按钮");
		homePage.tongxunId().click();
		log.info("休眠3秒");
		Thread.sleep(3000);
	}
	@AfterMethod
	public void afterMethod(){
		log.info("关闭浏览器");
		driver.quit();
		log.endTestCase("登录163邮箱");
	}

}
