package com.buildpiper.testcases;

import org.aeonbits.owner.ConfigFactory;
import org.mozilla.javascript.tools.shell.Environment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.pages.BuildPipeLinePage;
import com.buildpiper.pages.EnvironmentCreationPage;
import com.buildpiper.pages.HomePage;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.pages.PreRequisitesPage;
import com.buildpiper.pages.ServiceCreationPage;
import com.buildpiper.utils.ExcelUtility;
import com.buildpiper.utils.FrameworkConfig;

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class LenskartScan extends BaseTest {
	
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	ExcelUtility reader = new ExcelUtility();
	
	 @BeforeMethod
	    public void StartDriver() {
	    	new LoginPage().login(config.username(), config.password());
	    	ui_wait(5);
	    }
	 @AfterMethod
	   public void StopDriver() {
    	ui_getUIDriver().quit();
	    }
	
	@Test(groups = { "Regression" },priority = 0)
	public void LoginViaCreds() {
		ui_getUIDriver().quit();
		new LoginPage().login(config.username(), config.password());

	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void LoginViaGitLab() {
		ui_getUIDriver().quit();
		new LoginPage().loginPageViaGitLab(config.username(), config.password());

	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void HealthCheck() {
		
		//new LoginPage().login(config.username(), config.password());
		new HomePage().HealthQueue(config.tag());
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void BannerTest() {
		
	//	new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
     	new HomePage().LenskartBanner();
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void PagginationofAllModules() {
		
		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new HomePage().Pagination(reader.getCellData("MicroServiceData", "applicationName", 2));
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void UserportalGeneral() {
		
	//	new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new HomePage().VerifyAllModulesAccessible(reader.getCellData("MicroServiceData", "applicationName", 2));
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
   public void EditService() {
	
	//new LoginPage().login(config.username(), config.password());
	new PreRequisitesPage().switchUser();
	ui_wait(3);
	new ServiceCreationPage().editService(reader.getCellData("MicroServiceData", "applicationName", 2));
	
}
	
	@Test(groups = { "Regression" },priority = 0)
	   public void EditPipeline() {
		
		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new BuildPipeLinePage().editPipeline(reader.getCellData("MicroServiceData", "applicationName", 2));
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void HistoryPipeline() {
		
		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new BuildPipeLinePage().historyPipeline(reader.getCellData("MicroServiceData", "applicationName", 2));
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
	public void RunwithParameterPipeline() {
		
		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new BuildPipeLinePage().RunwithParameter(reader.getCellData("MicroServiceData", "applicationName", 2));
		
	}
	
	@Test(groups = { "Regression" },priority = 0)
	   public void EditEnvironment() throws Exception {
		
		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new EnvironmentCreationPage().editEnvironment(reader.getCellData("MicroServiceData", "applicationName", 2));
		
	}
	
//	@Test(groups = { "Regression" },priority = 0)
////	public void Pipeline() {
//		
//		new LoginPage().login(config.username(), config.password());
//		new PreRequisitesPage().switchUser();
////		new HomePage().LenskartBanner();
//		new BuildPipeLinePage().sear
//		
	}


//}