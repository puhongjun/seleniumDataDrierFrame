package cn.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.util.ObjectMap;

public class LinkmanPage {
	private WebElement element;
	private WebDriver driver;
	//指定元素定位表达式配置文件的绝对路径
	private ObjectMap objectMap=new ObjectMap("F:\\Eclipse\\DataFrameWork\\objectMap.properties");
	public LinkmanPage(WebDriver driver){
		this.driver=driver;
	}
	
	//返回通讯录页面中的 新建联系人 元素
	public WebElement addressBook() throws Exception{
		element=driver.findElement(objectMap.getLocator("addressbookpage.addlinkman"));
		return element;
	}
}
