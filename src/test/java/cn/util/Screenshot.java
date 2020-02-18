package cn.util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshot{


	
	public static void method(WebDriver driver,String CaseName) {
		try{
			//生成日期对象
			Date date=new Date();
			//调用DateUtil类中的方法，生成截图所在的文件夹日期类型
			String picDir="C:\\"+"errorScreenshot"+"\\"+String.valueOf(DataUtil.getYear(date))+"-"
			+String.valueOf(DataUtil.getMonth(date))+"-"+String.valueOf(DataUtil.getDay(date));
			if(!new File(picDir).exists()){
				FileUtil.createDir(picDir);
			}
			//调用DataUtil类中的方法，生成截图文件的时间名称
			String filePath=picDir+"//"+String.valueOf(DataUtil.getHour(new Date()))+"时"+
			String.valueOf(DataUtil.getMinute(new Date()))+"分"+
			String.valueOf(DataUtil.getSecond(new Date()))+"秒"+CaseName+".png";
			//进行截图，并将文件内容保存在srcFile对象中
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			File scrFile = new File("");
//			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//将截图文件内容写入磁盘中，生成截图文件
			FileUtils.copyFile(srcFile, new File(filePath));
		}catch(Exception e){
			log.info("截图失败");
		}
	}

}
