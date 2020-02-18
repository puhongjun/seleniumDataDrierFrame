package cn.appModules;

import org.openqa.selenium.WebDriver;

import cn.pageObjects.AddressBookPage;
import cn.pageObjects.HomePage;
import cn.pageObjects.LinkmanPage;
import cn.pageObjects.WaitByElement;
import cn.util.Screenshot;
import cn.util.WaitMethod;
import cn.util.log;

public class AddContactPersonAction {
	//新建联系人封装方法
	public static void execute(WebDriver driver,String userName,String passWord,
			String Name,String Email,String Phonenumber) throws Exception {
		log.info("调用登录封装方法");
		//调用登录封装方法
		try {
			LoginAction.execute(driver,userName, passWord);
		} catch (Exception e) {
			log.info("登录进入163邮箱首页失败");
			Screenshot.method(driver,"登录进入163邮箱首页失败");
		}
		log.info("显示等待"+WaitByElement.weiduButton+" 元素");
		//显示等待
		WaitMethod.xsWait(driver,WaitByElement.weiduButton,10);
		log.info("实例化HomePage对象");
		//实例化HomePage对象
		HomePage homePage=new HomePage(driver);
		log.info("点击 通讯录");
		//点击 通讯录
		homePage.tongxunId().click();
		log.info("显示等待"+WaitByElement.addLinMan+" 元素");
		//显示等待
		WaitMethod.xsWait(driver, WaitByElement.addLinMan, 5);
		log.info("实例化LinkmanPage对象");
		//实例化LinkmanPage对象
		LinkmanPage linkmanPage=new LinkmanPage(driver);
		log.info("点击 新建联系人");
		//点击 新建联系人
		linkmanPage.addressBook().click();
		log.info("显示等待"+ WaitByElement.confirmButton+" 元素");
		//显示等待
		WaitMethod.xsWait(driver, WaitByElement.confirmButton, 5);
		log.info("实例化AddressBookPage");
		//实例化AddressBookPage
		AddressBookPage addressbookPage=new AddressBookPage(driver);
		log.info("输入联系人姓名："+Name);
		//输入联系人姓名
		addressbookPage.inputName().sendKeys(Name);
		log.info("输入联系人电子邮箱："+Email);
		//输入联系人电子邮箱
		addressbookPage.inputEmail().sendKeys(Email);
		log.info("输入联系人手机号码："+Phonenumber);
		//输入联系人手机号码
		addressbookPage.inputPhonenumber().sendKeys(Phonenumber);
		log.info("点击新建联系人界面的 确定按钮");
		//点击新建联系人界面的 确定按钮
		addressbookPage.inputConfirmbutton().click();
	}

}
