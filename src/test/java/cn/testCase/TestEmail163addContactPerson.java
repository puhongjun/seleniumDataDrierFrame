package cn.testCase;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.appModules.AddContactPersonAction;
import cn.util.Constant;
import cn.util.ExcelUtil;
import cn.util.Screenshot;
import cn.util.log;




public class TestEmail163addContactPerson {
	public WebDriver driver;
	String url=Constant.url;
	
	//定义dataprovider,并命名为testData
	@DataProvider(name="testData")
	public static Object[][] data() throws IOException{
		/*
		 *调用ExcelUtil类中的getTestData静态方法，获取Excel数据文件中倒数第二列
		 *标记为y的测试数据行，函数参数为常量Constant.TestDataExcelFilePath和常量
		 *Constant.TestDataExcelFileSheet,指定数据文件的路径和Sheet名称 
		*/
//		System.out.println(Constant.TestDataExcelFilePath);
//		System.out.println(Constant.TestDataExcelFileSheet);
		log.info("调用ExcelUtil类中的getTestData静态方法获取Excel中标记为y的测试数据");
		return ExcelUtil.getTestData(Constant.TestDataExcelFilePath,Constant.TestDataExcelFileSheet);
		
	}
	//使用名称为testData的dataProvider作为测试方法的测试数据集
	//测试方法一个使用了10个参数，对应到Excel数据文件的1~10列
	@Test(dataProvider="testData")
	public void testAddContactPerson(String CaseRow,String CaseName,String UserName,
			String PassWord,String Name,String Email,String PhoneNumber,
			String AssertName,String AssertEmail,String AssertPhoneNumber) throws  Exception{
		
		log.startTestCase(CaseName);
			driver.get(url);
			log.info("访问网页"+url);
			
			try {
				log.info("调用AddContactPersonAction类的execute方法");
				//调用新建联系人封装方法,并传入相应参数
				AddContactPersonAction.execute(driver,UserName, PassWord,Name, Email,PhoneNumber);
				
			} catch (Exception e) {
				/*
				 * 执行AddContactPersonAction类的execute方法失败时，catch语句可以捕获AssertionError类型
				 * 的异常，并设置Excel中测试数据行的执行结果为“测试失败”。由于Excel中的序号格式被默认设定
				 * 为带有一位小数点，所以使用 split("[.]"[0]) 语句获取序号的整数部分，并传给setCellData函
				 * 数在对应序号的测试数据行的最后一列设定“测试失败”
				 */
				ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
						ExcelUtil.getLastColumnNum(),"测试失败");
				log.info("添加联系人失败");
				Screenshot.method(driver,"添加联系人失败");
				log.info("调用Screenshot.method方法进行截图");
				log.endTestCase(CaseName);
				//调用Assert.fail方法将此测试用例设定为执行失败，后续测试代码将不被执行
				Assert.fail("执行AddContactPersonAction类的execute方法失败");

			}
					
		Thread.sleep(3000);
		log.info("调用AddContactPersonAction类的execute方法后休眠3秒");
		
		try{
			log.info("断言页面是否包含联系人姓名："+AssertName);
			//断言页面是否包含AssertName变量的关键字
			Assert.assertTrue(driver.getPageSource().contains(AssertName));
			}catch(AssertionError error){
			log.info("断言通讯录页面是否包含联系人姓名："+AssertName +" 失败");
			ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
					ExcelUtil.getLastColumnNum(),"测试失败");
			Screenshot.method(driver, "断言联系人姓名为"+AssertName+"失败");
			log.info("调用Screenshot.method方法进行截图");
			log.endTestCase(CaseName);
			Assert.fail("断言通讯录页面是否包含联系人姓名的关键字失败");
		}
		

		try{
			log.info("断言页面是否包含联系人邮箱："+AssertEmail);
			//断言页面是否包含AssertEmail变量的关键字
			Assert.assertTrue(driver.getPageSource().contains(AssertEmail));
		}catch(AssertionError error){
			log.info("断言通讯录页面是否包含联系人邮箱地址："+AssertEmail+" 失败");		
			ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
					ExcelUtil.getLastColumnNum(),"测试失败");
			log.info("调用Screenshot.method方法进行截图");
			Screenshot.method(driver,"断言联系人邮箱为"+AssertEmail+"失败");
			log.endTestCase(CaseName);
			Assert.fail("断言通讯录页面是否包含联系人邮箱地址的关键字失败");
		}
		
		
		try{
			log.info("断言通讯录页面是否包含联系人手机号码："+AssertPhoneNumber);
			//断言页面是否包含AssertPhoneNumber变量的关键字
			Assert.assertTrue(driver.getPageSource().contains(AssertPhoneNumber));
		}catch(AssertionError error){
			ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
					ExcelUtil.getLastColumnNum(),"测试失败");
			log.info("断言通讯录页面是否包含联系人手机号码："+AssertPhoneNumber+" 失败");
			Screenshot.method(driver,"断言联系人手机号码为"+AssertPhoneNumber+"失败");
			log.info("调用Screenshot.method方法进行截图");
			log.endTestCase(CaseName);
			Assert.fail("断言通讯录页面是否包含联系人手机号码关键字失败");
		}
		ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
				ExcelUtil.getLastColumnNum(),"测试成功");
		log.info("新建联系人全部断言成功，在Excel的测试数据文件“测试执行结果”列中写入“测试成功”");
		log.endTestCase(CaseName);
		
	}
	
	@BeforeClass
	public void beforeClass() throws Exception{
		//读取Log4j.xml配置文件信息
		DOMConfigurator.configure("Log4j.xml");
		
		//使用Constant类中的常量，设定测试数据的文件路径和Sheet名称
		ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath,Constant.TestDataExcelFileSheet);
		log.info("使用Constant类中的常量，设定测试数据的文件路径："+Constant.TestDataExcelFilePath);
		log.info("使用Constant类中的常量，设定测试数据的Sheet名称："+Constant.TestDataExcelFileSheet);
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		log.info("启动浏览器");
	}

	@AfterMethod
	public void afterMethod(){
		driver.quit();
		log.info("关闭浏览器");
		
	}

}
