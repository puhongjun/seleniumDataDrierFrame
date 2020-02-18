package cn.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.util.ObjectMap;

public class HomePage {
	//指定页面元素定位表达式配置文件的绝对路径
		private ObjectMap objectMap=new ObjectMap("F:\\Eclipse\\DataFrameWork\\objectMap.properties");
		private WebElement element;
		private WebDriver driver;
		
		public HomePage(WebDriver driver){
			this.driver=driver;
		}
		//返回 首页 元素对象
		public WebElement shouyeText() throws Exception{
			//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
			element=driver.findElement(objectMap.getLocator("homepage.shouyetext"));
			return element;
		}
		//返回 通讯录 元素对象
		public WebElement tongxunId() throws Exception{
			element=driver.findElement(objectMap.getLocator("homepage.addressbook"));
			return element;
		}
	
}
