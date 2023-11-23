package com.buildpiper.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.aeonbits.owner.ConfigFactory;
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
import com.buildpiper.utils.XlsReadData;
import com.buildpiper.utils.testDataUtil;

/**
 * @author: SagarT
 * @reviewer: @
 * 
 *
 */

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class ServiceCreationTestcases extends BaseTest {

	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

//	@DataProvider
//	public Iterator<Object[]> createServiceTestData() {
//		ArrayList<Object[]> CreateServiceData = testDataUtil.getMicroServiceData();
//		return CreateServiceData.iterator();
//	}

	ExcelUtility reader = new ExcelUtility();

//	ArrayList<String> languageList = new ArrayList<String>();
//	ArrayList<String> chipList = new ArrayList<String>();
//	ArrayList<String> list = new ArrayList<String>();

	@Test(groups = { "Regression" }, priority = 0)
	public void createServ() {

		ArrayList<String> chipList = new ArrayList<String>();
//		chipList.add(" All");
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");
//		chipList.add("linux/386");
//		chipList.add("linux/riscv64");
//		chipList.add("linux/ppc64le");
//		chipList.add("linux/s390x");
//		chipList.add("linux/arm/v7");
//		chipList.add("linux/arm/v6");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");
//		languageList.add("GOLANG");
//		languageList.add("PHP");
//		languageList.add("PYTHON");
//		languageList.add("NODEJS");
//		languageList.add("OTHER");

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
//		new HomePage().HealthQueue();
//		new PreRequisitesPage().defaultQueueTest(reader.getCellData("userPreReqData", "adminDeployWorker", 2),
//				reader.getCellData("userPreReqData", "adminPublicApiWorker", 2),
//				reader.getCellData("userPreReqData", "bpBuildWorker", 2),
//				reader.getCellData("userPreReqData", "bpDeployWorker", 2),
//				reader.getCellData("userPreReqData", "deployApiWorker", 2),
//				reader.getCellData("userPreReqData", "publicApiWorker", 2),
//				reader.getCellData("userPreReqData", "schedulerWorker", 2),
//				reader.getCellData("userPreReqData", "versioningWorker", 2));
//		new PreRequisitesPage().accountPreRequisites();
		//new PreRequisitesPage().switchUser();
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
//		new BuildConfigurationPage().approveConfiguartions();
		new DeployConfigurationPage().CreateAndValidateDeployConfig(
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
				reader.getCellData("MicroServiceData", "configName", 2));
//		new BuildConfigurationPage().approveConfiguartionsDeploy();
		new ServiceCreationPage().addNewEnvironmentToService(reader.getCellData("MicroServiceData", "toEnv", 2), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 2),
				reader.getCellData("MicroServiceData", "cloneText", 2),
				reader.getCellData("MicroServiceData", "envCloneValue", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2),
				reader.getCellData("MicroServiceData", "AccessType", 2),
				reader.getCellData("MicroServiceData", "AccessName", 2),
				reader.getCellData("MicroServiceData", "portNumber", 2),
				reader.getCellData("MicroServiceData", "TargetPort", 2));
//		new BuildConfigurationPage().approveConfiguartions();
//		new DeployConfigurationPage().CreateAndValidateDeployConfig(
//				reader.getCellData("MicroServiceData", "AccessType", 2),
//				reader.getCellData("MicroServiceData", "AccessName", 2),
//				reader.getCellData("MicroServiceData", "portNumber", 2),
//				reader.getCellData("MicroServiceData", "TargetPort", 2), serviceButton,
//				reader.getCellData("MicroServiceData", "configName", 2));
//		new BuildConfigurationPage().approveConfiguartionsDeploy();
	}
//RK
	@Test(groups = { "Regression" }, priority = 0)
//	@RetryCountIfFailed(2)
	public void ServiceOverviewSearch() throws Exception {
	XlsReadData reader = new XlsReadData(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BuildPiperTestData.xlsx");
	int RowNumber=reader.getRowByTestCaseName("MicroServiceData", "ServiceOverviewSearch");
		new LoginPage().login(config.username(), config.password());
		new PreRequisitesPage().switchUser();
		ui_wait(5);
		new ServiceCreationPage().SearchService(
				reader.getCellData("MicroServiceData", "applicationName", RowNumber),reader.getCellData("MicroServiceData", "serviceName", RowNumber));
		//new EnvironmentCreationPage().SeacrhEnvironmentOverviewbyEnvironment(EnvName);
	}	
	
	@Test(groups = { "Regression" }, priority = 1)
	public void BuildDeployAlternate() {

		new LoginPage().login(config.username(), config.password());
		new ServiceCreationPage().accountPreRequisites();
		new BuildDeployAlternatePage().TriggerAlternateMethod(
				reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "serviceName", 2),
				reader.getCellData("MicroServiceData", "BranchName", 2));

	}

	@Test(groups = { "Regression" }, priority = 2)
	public void CreateSesrviceNegativeTest1() {

		new LoginPage().login(config.username(), config.password());
		new ServiceCreationPage().CreateSesrviceNegativeTest3(
				reader.getCellData("MicroServiceData", "applicationName", 2),
				reader.getCellData("MicroServiceData", "envName", 2),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 2),
				reader.getCellData("MicroServiceData", "serviceName", 2));

	}

	@Test(groups = { "Regression" }, priority = 3)
	public void createHelmService() {

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");
//		languageList.add("GOLANG");
//		languageList.add("PHP");
//		languageList.add("PYTHON");
//		languageList.add("NODEJS");
//		languageList.add("OTHER");

		new LoginPage().login(config.username(), config.password());
		new ServiceCreationPage().CreateHelmNewService(reader.getCellData("MicroServiceData", "applicationName", 3),
				reader.getCellData("MicroServiceData", "envName", 3),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 3), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 3),
				reader.getCellData("MicroServiceData", "gitURL", 3),
				reader.getCellData("MicroServiceData", "BranchName", 3),
				reader.getCellData("MicroServiceData", "FilePath", 3),
				reader.getCellData("MicroServiceData", "DockerFilePath", 3), languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 3),
				reader.getCellData("MicroServiceData", "deployEnvName", 3),
				reader.getCellData("MicroServiceData", "key1", 3), reader.getCellData("MicroServiceData", "value1", 3),
				reader.getCellData("MicroServiceData", "key2", 3), reader.getCellData("MicroServiceData", "value2", 3),
				reader.getCellData("MicroServiceData", "key3", 3), reader.getCellData("MicroServiceData", "value3", 3),
				reader.getCellData("MicroServiceData", "uploadTypeName", 3),
				reader.getCellData("MicroServiceData", "deployBranchName", 3),
				reader.getCellData("MicroServiceData", "folderPath", 3),
				reader.getCellData("MicroServiceData", "helmReleaseName", 3),
				reader.getCellData("MicroServiceData", "folderPathValue", 3));

	}

	@Test(groups = { "Regression" }, priority = 5)
	public void CreateBuildXService() {

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> chipList = new ArrayList<String>();
//		chipList.add(" All");
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");
//		chipList.add("linux/386");
//		chipList.add("linux/riscv64");
//		chipList.add("linux/ppc64le");
//		chipList.add("linux/s390x");
//		chipList.add("linux/arm/v7");
//		chipList.add("linux/arm/v6");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");
//		languageList.add("GOLANG");
//		languageList.add("PHP");
//		languageList.add("PYTHON");
//		languageList.add("NODEJS");
//		languageList.add("OTHER");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");

		new LoginPage().login(reader.getCellData("UserData", "username", 2),
				reader.getCellData("UserData", "password", 2));
		new ServiceCreationPage().buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", 4),
				reader.getCellData("MicroServiceData", "envName", 4),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", 4), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", 4));
		new BuildConfigurationPage().CreateAndValidateBuildConfig(reader.getCellData("MicroServiceData", "gitURL", 4),
				reader.getCellData("MicroServiceData", "BranchName", 4),
				reader.getCellData("MicroServiceData", "FilePath", 4),
				reader.getCellData("MicroServiceData", "DockerFilePath", 4), chipList, languageList,
				reader.getCellData("MicroServiceData", "preHookPass", 4),
				reader.getCellData("MicroServiceData", "deployEnvName", 4));
		new DeployConfigurationPage().CreateAndValidateDeployConfig("PRIVATE", "OT", "8080", "8080", serviceButton,
				"autoconfig-mhikniisw");
	}

}
