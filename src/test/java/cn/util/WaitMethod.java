package cn.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



//显示等待封装方法
public class WaitMethod {
	
	public static void xsWait(WebDriver driver,By by,int time){
		try{
				WebDriverWait wait=new WebDriverWait(driver,time);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		}catch(NoSuchElementException e){
			log.info("等待:"+time+"秒没有找到 "+ by +" 元素");
			Screenshot.method(driver,"显示等待"+by+"元素"+time+"秒超时");
			log.info("调用Screenshot.method方法截图");
	}
	}

}
