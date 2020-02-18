package cn.pageObjects;

import org.openqa.selenium.By;

public class WaitByElement {
	//登录界面的frame
	public static By loginFrame=By.xpath("//*[@id='loginDiv']/iframe[@frameborder='0']");
	//首页未读邮件按钮
	public static By weiduButton=By.id("_mail_tabitem_0_3text");
	//通讯录页面的 新建联系人按钮
	public static By addLinMan=By.xpath("//span[text()='新建联系人']");
	//新建联系人界面的 确定按钮
	public static By confirmButton=By.xpath("//div[@role='button']/span[text()='确 定']");

}
