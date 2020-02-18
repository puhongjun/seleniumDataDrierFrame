package cn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties properties;
	public ObjectMap(String propFile){
	properties =new Properties();
	try{
		FileInputStream in=new FileInputStream(propFile);
		properties.load(in);
		in.close();
	}catch(IOException e){
		log.info("读取文件对象出错");
		e.printStackTrace();
	}
	}
	
	public By getLocator(String ElenmentNameInpropFile) throws Exception{
		//根据变量ElenmentNameInpropFile，从属性配置文件中读取对应的配置对象
		String locator=properties.getProperty(ElenmentNameInpropFile);
		//将配置对象中定位类型存储到locatorType变量，将定位表达式的值存储到locatorValue变量
		String locatorType=locator.split(">")[0];
		String locatorValue=locator.split(">")[1];
		//在Eclipse中的配置文件均默认为ISO-8859-1编码存储，使用getBytes方法可以将字符
		//转换为UTF-8编码，以此解决在配置文件中读取中文乱码的问题
		locatorValue=new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		//输出locatorType变量值和locatorValue变量值，验证赋值是否正确
		log.info("获取的定位类型为："+locatorType+"\t定位表达式为："+locatorValue);
		//根据locatorType的变量值内容判断返回何种定位方式的By对象
		if(locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if((locatorType.toLowerCase().equals("classname"))||(locatorType.
				toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if((locatorType.toLowerCase().equals("tagname"))||(locatorType.
				toLowerCase().equals("tag")))
			return By.tagName(locatorValue);
		else if((locatorType.toLowerCase().equals("linktext"))||(locatorType.
				toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if((locatorType.toLowerCase().equals("cssselector"))||(locatorType.
				toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if(locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			log.info("输入的locator type未在程序中被定义："+locatorType);
			throw new Exception("输入的locator type未在程序中被定义："+locatorType);
		
	}
	
}
