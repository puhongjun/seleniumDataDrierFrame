package cn.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.util.ObjectMap;

public class AddressBookPage {
	private WebElement element;
	private WebDriver driver;
	//指定定位元素表达式配置文件的绝对路径
	private ObjectMap objectMap=new ObjectMap("F:\\Eclipse\\DataFrameWork\\objectMap.properties");
	
	public AddressBookPage(WebDriver driver){
		this.driver=driver;
	}
	//返回新建联系人界面的 姓名输入框
	public WebElement inputName() throws Exception{
		element=driver.findElement(objectMap.getLocator("addressbookpage.name"));
		return element;
	}
	//返回新建联系人界面的 电子邮箱输入框
	public WebElement inputEmail() throws Exception{
		element=driver.findElement(objectMap.getLocator("addressbookpage.email"));
		return element;
	}
	//返回新建联系人界面的 手机号码输入框
	public WebElement inputPhonenumber() throws Exception{
		element=driver.findElement(objectMap.getLocator("addressbookpage.phonenumber"));
		return element;
	}
	//返回新建联系人界面的 确定按钮
	public WebElement inputConfirmbutton() throws Exception{
		element=driver.findElement(objectMap.getLocator("addressbookpage.confirmbutton"));
		return element;
	}

}
