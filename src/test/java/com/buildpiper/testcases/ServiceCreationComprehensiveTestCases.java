package com.buildpiper.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.pages.BuildConfigurationPage;
import com.buildpiper.pages.BuildDeployAlternatePage;
import com.buildpiper.pages.DeployConfigurationPage;
import com.buildpiper.pages.EnvironmentCreationPage;
import com.buildpiper.pages.HomePage;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.pages.PreRequisitesPage;
import com.buildpiper.pages.ServiceCreationPage;
import com.buildpiper.utils.ExcelUtility;
import com.buildpiper.utils.FrameworkConfig;
import com.buildpiper.utils.testDataUtil;

/**
 * @author: SagarT
 * @reviewer: @
 * 
 *
 */

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class ServiceCreationComprehensiveTestCases extends BaseTest {

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

	@Test(groups = { "Regression" }, priority = 0)
	public void serviceOverview_TriggerBuild_NoCache() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
		new ServiceCreationPage().buildTrigger();
	}
//RK
	@Test(groups = { "Regression" }, priority = 0)
	public void serviceOverview_TriggerBuild_Cache() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));		
		new ServiceCreationPage().buildButton_Click();
		ui_wait(3);
		new ServiceCreationPage().Verify_EnvironmentandSubEnvironment("DEV","dev1");
		ui_wait(3);
		new ServiceCreationPage().CacheCheckbox_Click();
		ui_wait(3);
		new ServiceCreationPage().triggerBuild_Click();
		ui_wait(5);
		new ServiceCreationPage().Verify_buildStatus("RUNNING");
		ui_wait(3);
		new ServiceCreationPage().buildRecentButtonClick();
		ui_wait(3);
		//ui_getUIDriver().close();
	}

	
	@Test(groups = { "Regression" }, priority = 1)
	public void serviceOverview_Deploy() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
		new ServiceCreationPage().deployService("");
		ui_getUIDriver().close();
	}


	@Test(groups = { "Regression" }, priority = 2)
	public void serviceOverview_Promote() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
		new ServiceCreationPage().addNewEnvironmentToService(reader.getCellData("MicroServiceData", "toEnv", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2),
				reader.getCellData("MicroServiceData", "cloneText", 2),
				reader.getCellData("MicroServiceData", "envCloneValue", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2));
		
		new ServiceCreationPage().switchEnvironmentTab("DEV");
		ui_wait(3);
		new ServiceCreationPage().buildButton_Click();
		ui_wait(3);
		new ServiceCreationPage().Verify_EnvironmentandSubEnvironment("DEV",reader.getCellData("MicroServiceData", "envName", 2));
		ui_wait(3);
		new ServiceCreationPage().CacheCheckbox_Click();
		ui_wait(3);
		new ServiceCreationPage().triggerBuild_Click();
		ui_wait(5);
		//new ServiceCreationPage().Verify_buildStatus("RUNNING");
		ui_wait(3);
		new ServiceCreationPage().closeBuildWindow();
		ui_wait(3);
		new ServiceCreationPage().deployService("");
		ui_wait(3);
		new ServiceCreationPage().closeDeployWindow();
		ui_wait(3);
		new ServiceCreationPage().promoteService("","");
		ui_wait(3);
		new ServiceCreationPage().verify_BuildHistory();
		
		new ServiceCreationPage().historyButton();
		
		new ServiceCreationPage().switchEnvironmentTab("QA");
		ui_wait(3);
		new ServiceCreationPage().buildButton_Click();
		ui_wait(3);
		new ServiceCreationPage().Verify_EnvironmentandSubEnvironment("QA",reader.getCellData("MicroServiceData", "toEnv", 2));
		ui_wait(3);
		new ServiceCreationPage().CacheCheckbox_Click();
		ui_wait(3);
		new ServiceCreationPage().triggerBuild_Click();
		ui_wait(5);
		//new ServiceCreationPage().Verify_buildStatus("RUNNING");
		ui_wait(3);
		new ServiceCreationPage().closeBuildWindow();
		ui_wait(3);
		new ServiceCreationPage().deployService("");
		ui_wait(3);
		new ServiceCreationPage().closeDeployWindow();
		ui_wait(3);
		new ServiceCreationPage().promoteService("","");
		
	}


	@Test(groups = { "Regression" }, priority = 3)
	public void serviceOverview_History() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		//new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(3);
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
		ui_getUIDriver().close();
	}

	@Test(groups = { "Regression" }, priority = 4)
	public void deploymentRestart() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
		ui_getUIDriver().close();
	}
	
	@Test(groups = { "Regression" }, priority = 5)
	public void serviceOverview_TriggerBuildAndDeploy_Cache() {

		ArrayList<String> chipList = new ArrayList<String>();
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "FilePath", 2),
				reader.getCellData("MicroServiceData", "DockerFilePath", 2), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 2),
				reader.getCellData("MicroServiceData", "envName", 2));
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
		new ServiceCreationPage().buildTriggerAndDeploy();
		ui_getUIDriver().close();
	}

}
