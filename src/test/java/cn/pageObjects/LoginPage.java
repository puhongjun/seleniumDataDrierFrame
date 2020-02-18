package cn.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.util.ObjectMap;

public class LoginPage {
	//指定页面元素定位表达式配置文件的绝对路径
	private ObjectMap objectMap=new ObjectMap("F:\\Eclipse\\DataFrameWork\\objectMap.properties");
	private WebElement element;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	//返回进入密码登录页面元素对象
	public WebElement intoLogin() throws Exception{
		//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element=driver.findElement(objectMap.getLocator("loginpage.intologin"));
		return element;
	}
	//返回登录页面的frame元素对象
	public WebElement loginFrame() throws Exception{
		//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element=driver.findElement(objectMap.getLocator("loginpage.loginframe"));
		return element;
		}
	//返回登录页面用户名输入框元素对象
	public WebElement userName() throws Exception{
		//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element=driver.findElement(objectMap.getLocator("loginpage.username"));
		return element;
		}
	//返回登录页面密码输入框元素对象
	public WebElement passWord() throws Exception{
		//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element=driver.findElement(objectMap.getLocator("loginpage.password"));
		return element;
		}
	//返回登录页面登录按钮元素对象
	public WebElement loginButton() throws Exception{
		//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element=driver.findElement(objectMap.getLocator("loginpage.loginbutton"));
		return element;
		}

}
