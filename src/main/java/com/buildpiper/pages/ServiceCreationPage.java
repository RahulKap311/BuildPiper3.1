package com.buildpiper.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.buildpiper.base.BasePage;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

public class ServiceCreationPage extends BasePage {

	SoftAssert softAssert = new SoftAssert();

	String ServiceName = "automation-" + RandomStrings.generateRandomString(15);
	String ServiceHelmName = "automation-helm-" + RandomStrings.generateRandomString(15);

	String ExternalName = "automation-" + RandomStrings.generateRandomString(8);
	String ExternalHelmName = "automation-helm-" + RandomStrings.generateRandomString(8);

//	@FindBy(xpath = "//span[@title='perfeasy-testing']//..//..//span[text()='Service Overview']")
//	WebElement serviceOverViewTab;

	@FindBy(xpath = "//button//span[2][@class='flaticon-expand-arrow']/../..//div//span[@title='Service Overview']")
	WebElement serviceOverViewTab;

	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[1][@title]")
	List<WebElement> poc_qaProjectLink;

	@FindBy(xpath = "//a[@class='btn btn-submit']")
	WebElement addServiceBtn;

	@FindBy(xpath = "//h1[@class='main-heading']")
	WebElement main_Heading;

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container']//div[@class='txt']")
	List<WebElement> muiGridContainerText;

	@FindBy(xpath = "//p[(@class='service-form-heading')]")
	WebElement createaServiceHeading;

	@FindBy(xpath = "//p[(@class='hint-text-main-heading')]")
	WebElement subHeading;

	@FindBy(xpath = "//input[@placeholder='demo-app']")
	WebElement service_Name_SearchBox;

	@FindBy(xpath = "//input[@placeholder='Sample-Service']")
	WebElement external_Name_SearchBox;

	@FindBy(xpath = "//span[contains(.,'Build once and promote')]")
	WebElement buildForOnceBuild_Radiobtn;

	@FindBy(xpath = "//span[contains(.,'Build for every environment')]")
	WebElement buildForEveryBuild_Radiobtn;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement saveAndContinue_Create_Page;

	@FindBy(xpath = "//h1[@class='h1' and contains(.,'Create a Environment')]")
	WebElement environmentHeader;

	@FindBy(xpath = "//div[@class='staticwrap-inner']")
	WebElement environmentSubHeader;

	@FindBy(xpath = "//select[@name='env_id']")
	WebElement envDropdown;

	@FindBy(xpath = "//input[@name='manual_build']")
	WebElement allowManualBuildYes;

	@FindBy(xpath = "//input[@name='manual_deploy']")
	WebElement allowManualDeployYes;

	@FindBy(xpath = "//div[@class='selectJob_heading']//p")
	WebElement userRoleGroupText;

	@FindBy(xpath = "//input[@name='qa'][@type='checkbox']")
	WebElement qaroleGroupCheckbox;

	@FindBy(xpath = "//span[contains(@class,'MuiCheckbox-root')]//input")
	List<WebElement> roleGroupCheckbox;

	@FindBy(xpath = "//input[@name='job_template_version'][@type='radio'][@value='v2']")
	WebElement selectJobTemplateRadioBtn;

	@FindBy(xpath = "//select[@name='project_job_template_id']")
	WebElement jobTemplateDropdown;

	@FindBy(xpath = "//div[@class='font-27 font-family-nunito font-weight-300 lh-12 mr-5']")
	WebElement createdServiceName;

	@FindBy(xpath = "//span[contains(text(),'Project:')]")
	WebElement projectNameCheck;

	@FindBy(xpath = "//span[contains(text(),'Job Template: ')]")
	WebElement validateJobTemplate;

	@FindBy(xpath = "//span[contains(text(),' User Group: ')]")
	WebElement validateUserRole;

	////////////// change //////////////////////

//	@FindBy(xpath = "//*[text()='Build Details']")
//	WebElement validateBuildDetails;
//
//	@FindBy(xpath = "//*[text()='Deploy Details']")
//	WebElement validateDeployDetails;

	////////////// change //////////////////////

	@FindBy(xpath = "//*[text()='Env Build Details']")
	WebElement validateBuildDetails;

	@FindBy(xpath = "//*[text()='Env Deploy Details']")
	WebElement validateDeployDetails;

	@FindBy(xpath = "//*[text()='Integration Testing']")
	WebElement validateIntegrationDetails;

	@FindBy(xpath = "//*[text()='Other Deployment Info']")
	WebElement validateOtherDeploymentDetails;

	@FindBy(xpath = "//*[text()='Generated Manifest']")
	WebElement validateGeneratedManifest;

	@FindBy(xpath = "//p[@class='main-text mb-10']")
	WebElement buildDetailsTextMain;

	@FindBy(xpath = "//span[@class='sub-text mb-10']")
	WebElement buildDetailsTextSub;

	@FindBy(xpath = "//p[@class='main-text mb-10']")
	WebElement deployDetailsTextMain;

	@FindBy(xpath = "//span[@class='sub-text mb-10']")
	WebElement deployDetailsTextSub;

	@FindBy(xpath = "//*[text()='To have a very smooth configuration we strongly recommend BuildPiper UI.']")
	WebElement deployDetailsTextSub1;

	@FindBy(xpath = "//*[text()='you can also configure the CD by uploading your custom manifest file.']")
	WebElement deployDetailsTextSub2;

	@FindBy(xpath = "//*[text()='Integration Testing Configuration']")
	WebElement integrationText1;

	@FindBy(xpath = "//*[text()='To know more about integration testing please read the ']")
	WebElement integrationText2;

	@FindBy(xpath = "//*[text()='Integrations testing Configuration ']")
	WebElement integrationText3;

	@FindBy(xpath = "//*[text()='Other Deployment Details']")
	WebElement otherDeploymentDetails1;

	@FindBy(xpath = "//*[text()='To know more about access levels please read the ']")
	WebElement otherDeploymentDetails2;

	@FindBy(xpath = "//*[text()=' Please configure deployment details to setup HPA(Horizontal Pod Autoscaling)']")
	WebElement otherDeploymentDetails3;

	@FindBy(xpath = "//*[text()='No Manifest File has been generated.']")
	WebElement generatedManifestText;

	@FindBy(xpath = "//button[contains(@class,'btn-link-green')][text()=' Switch to User Portal']")
	WebElement switchToUSer;

	@FindBy(xpath = "//button[@type='button' and @aria-controls='menu-appbar']//div//div")
	WebElement userMenuAppBar;

	@FindBy(xpath = "//a[@href='/integration/containerRegistries']")
	WebElement containerRegistryBtn;

	@FindBy(xpath = "(//button[@class='test-btn'])[1]")
	WebElement testConnection;

	@FindBy(xpath = "//div[contains(@class,'connected text connected')]")
	WebElement connectionStatusText;

	//RK
	@FindBy(xpath = "//div[contains(@class,'service-name')]//a[contains(@href,'service')]")
	List<WebElement> serviceList;
	@FindBy(xpath = "//button[text()='Check Status']")
	WebElement statusCheck;
	@FindBy(xpath = "//span[@id='healthstatus']")
	WebElement healthStatus;
	@FindBy(xpath = "//div[@class='build-section']/span/span[contains(@class,'status-chip status-chip')]")
	WebElement runningBuildStatus;
	@FindBy(xpath = "(//p[text()='Artifact']/../span)[1]")
	WebElement buildArtifact;
	@FindBy(xpath = "//span[text()='Commit ID: ']/../div/span")
	WebElement commitID;
	@FindBy(xpath = "//span[text()='Commit Msg: ']/../div/span")
	WebElement commitMessage;
	@FindBy(xpath = "//span[text()='Build on: ']/following-sibling::span")
	WebElement buildOn;
	@FindBy(xpath = "//span[text()='Build By: ']/following-sibling::span")
	WebElement buildBy;
	@FindBy(xpath = "//span[text()='Manifest Applied']/span/span")
	WebElement deployManifestApplied;
	@FindBy(xpath = "//span[text()='Rollout']/span/span")
	WebElement deployRollout;
	@FindBy(xpath = "(//p[text()='Artifact']/../span)[2]")
	WebElement deployArtifact;
	@FindBy(xpath = "//span[text()='Deployed On: ']/following-sibling::span")
	WebElement deployOn;
	@FindBy(xpath = "//span[text()='Deployed By: ']/following-sibling::span")
	WebElement deployBy;
	@FindBy(xpath = "//span[text()='Uptime: ']/following-sibling::span")
	WebElement deployUptime;
	@FindBy(xpath = "//span[text()='Restart: ']/following-sibling::span")
	WebElement deployRestart;
	@FindBy(xpath = "//button[@title='Build']")
	WebElement build;
	@FindBy(xpath = "//button[@title='Deploy']")
	WebElement deploy;
	@FindBy(xpath = "//button/span[@class='flaticon-forward-arrow']")
	WebElement promote;
	@FindBy(xpath = "//button[@title='History']")
	WebElement history;
	@FindBy(xpath = "//button[@title='Monitoring']")
	WebElement monitoring;
	@FindBy(xpath = "//a[text()='Build #']")
	WebElement historyBuild;
	@FindBy(xpath = "//p[contains(@title,'tag : ')]")
	WebElement historyTag;
	@FindBy(xpath = "//p[contains(@title,'no_cache : ')]")
	WebElement historyCacheorNoCache;
	@FindBy(xpath = "//p[contains(@title,'is_deploy : ')]")
	WebElement historyIsDeploy;
	@FindBy(xpath = "//p[contains(@title,'custom_tag : ')]")
	WebElement historyCustomtag;
	@FindBy(xpath = "//p[contains(@title,'branch_name : ')]")
	WebElement historyBranchname;
	@FindBy(xpath = "//p[contains(@title,'activity_master_code : ')]")
	WebElement historyActivity_MasterCode;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd']")
	WebElement historywindow_closeButton;
	@FindBy(xpath = "//div[@class='history-body']/div/a")
	WebElement history_buildType;
	@FindBy(xpath = "//div[@class='history-body']/div/p[1]")
	WebElement history_buildStatus;
	@FindBy(xpath = "//div[@class='history-body']/div/p[2]")
	WebElement history_buildDuration;
	@FindBy(xpath = "//div[@class='history-body']/div/p[3]")
	WebElement history_buildDateandTime;
	@FindBy(xpath = "//div[@class='history-body']/div/p[4]")
	WebElement history_buildArtifact;
	@FindBy(xpath = "//div[@class='history-body']/div/p[5]")
	WebElement history_buildby;
	@FindBy(xpath = "(//div[@class='history-body']/div/div/p[1])[1]")
	WebElement history_CommitID;
	@FindBy(xpath = "(//div[@class='history-body']/div/div/p[1])[2]")
	WebElement history_CommitMessage;
	
	
	public ServiceCreationPage() {

	}

	public ServiceCreationPage accountPreRequisites() {

		ui_click(userMenuAppBar, "userMenuAppBar");
		boolean switchTypeCheck = ui_IsElementPresent(switchToUSer, "5");
		if (switchTypeCheck == true) {
			ui_click(containerRegistryBtn, "clicks on container registry");
			ui_click(testConnection, "clicks on first container registry test");
			ui_IsElementDisplay(ui_waitForElementToDisplay(connectionStatusText, Pause.MEDIUM));
			// Assert.assertEquals(connectionStatusText.getText().trim(), "CONNECTED",
			// "connection status validated");
			ui_wait(5);
			ui_click(userMenuAppBar, "userMenuAppBar");
			ui_click(switchToUSer, "switching to user account");
		}
		return this;

	}

	public ServiceCreationPage addService(String appName, String ProjectName, String buildRadioButtonName) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {

			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			String mainHeadingText = main_Heading.getText();
			///// Create Page Text Validations //////////////////////////
			Assert.assertEquals(mainHeadingText, "Benefits of creating Microservices",
					"Unable to validate 'Benefits of creating Microservices'");

			boolean muiTxtStatus = true;
			for (WebElement muicontainer : muiGridContainerText) {
				String muiText = muicontainer.getText();
				System.out.println(muiText);
				if (!(muiText.contains("Go Live with your App in just 24 hours")
						|| muiText.contains("Spin up new Environment in few clicks")
						|| muiText.contains("Onboard a Dockerized service in minutes")
						|| muiText.contains("Enable most robust & secure DevSecOps CI in few clicks")
						|| muiText.contains("Setup & Run hassle free secured Pipelines")
						|| muiText.contains("Speed, Security & Compliance together in one Platform")
						|| muiText.contains("Setup Observability tooling in just 5 mins"))) {
					muiTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(muiTxtStatus, "Unable to  valudate the MUI container Text on left side");

			String Text8 = createaServiceHeading.getText();
			Assert.assertEquals(Text8, "Create a New Service", "Unable to validate 'Create  new service label'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(subHeading, Pause.MEDIUM));
			String Text9 = subHeading.getText();
			Assert.assertEquals(Text9, "Microservice are used to group pipeline and other setting together",
					"Unable to validate 'Microservice are used to group pipeline and other setting together'");

			ui_setvalue(service_Name_SearchBox, "sets service name", ServiceName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");

		}
		return this;

	}

	public ServiceCreationPage buildAndValidateService(String appName, String ProjectName, String buildRadioButtonName,
			ArrayList<String> UserRoles, String JobTemplateValue) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			String mainHeadingText = main_Heading.getText();
			///// Create Page Text Validations //////////////////////////
			Assert.assertEquals(mainHeadingText, "Benefits of creating Microservices",
					"Unable to validate 'Benefits of creating Microservices'");

			boolean muiTxtStatus = true;
			for (WebElement muicontainer : muiGridContainerText) {
				String muiText = muicontainer.getText();
				System.out.println(muiText);
				if (!(muiText.contains("Go Live with your App in just 24 hours")
						|| muiText.contains("Spin up new Environment in few clicks")
						|| muiText.contains("Onboard a Dockerized service in minutes")
						|| muiText.contains("Enable most robust & secure DevSecOps CI in few clicks")
						|| muiText.contains("Setup & Run hassle free secured Pipelines")
						|| muiText.contains("Speed, Security & Compliance together in one Platform")
						|| muiText.contains("Setup Observability tooling in just 5 mins"))) {
					muiTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(muiTxtStatus, "Unable to  valudate the MUI container Text on left side");

			String Text8 = createaServiceHeading.getText();
			Assert.assertEquals(Text8, "Create a New Service", "Unable to validate 'Create  new service label'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(subHeading, Pause.MEDIUM));
			String Text9 = subHeading.getText();
			Assert.assertEquals(Text9, "Microservice are used to group pipeline and other setting together",
					"Unable to validate 'Microservice are used to group pipeline and other setting together'");

			ui_setvalue(service_Name_SearchBox, "sets service name", ServiceName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");

			////////////// Create a Service Environment ////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(environmentHeader, Pause.LOW));
			String Text10 = environmentHeader.getText();
			Assert.assertEquals(Text10, "Create a Environment", "Unable to validate 'Create a Environment'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(environmentSubHeader, Pause.MEDIUM));
			String Text11 = environmentSubHeader.getText();
			Assert.assertTrue(Text11.contains(
					"A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project."),
					"Unable to validate 'A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project.'");
			Assert.assertTrue(Text11.contains("To learn more about how to setup a Microservice please read"),
					"Unable to validate 'To learn more about how to setup a Microservice please read'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
			Select dropdown = new Select(envDropdown);
			dropdown.selectByVisibleText(ProjectName);
			// ui_wait(3);

			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(allowManualBuildYes, "Poc_QA allowManualBuildYes");
			if (allowManualDeployYes.getAttribute("value").equals("false"))
				ui_click(allowManualDeployYes, "Poc_QA allowManualDeployYes");

			///////////////// change //////////////////////////////////

//			String UserRoleGroupText = userRoleGroupText.getText();
//			softAssert.assertEquals(UserRoleGroupText,
//					"Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the",
//					"Unable to validate 'Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the'");

			///////////////// change //////////////////////////////////

			ui_selectValueFromDropDownByXPath(jobTemplateDropdown, "jobTemplateDropdown");
			Select jobdropdown = new Select(jobTemplateDropdown);
			jobdropdown.selectByVisibleText(JobTemplateValue);

			for (int i = 0; i < roleGroupCheckbox.size(); i++) {
				if (UserRoles.contains(roleGroupCheckbox.get(i).getAttribute("value").trim())) {
					roleGroupCheckbox.get(i).click();
				}
			}
			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(selectJobTemplateRadioBtn, "Poc_QA selectJobTemplateRadioBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinue_Create_Page, Pause.LOW));
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
			// ui_wait(5);

			///////////////// Validate Service Overview Page //////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(createdServiceName, Pause.MEDIUM));
			String CreatedServiceName = createdServiceName.getText();
			Assert.assertEquals(CreatedServiceName, ServiceName, "Unable to validate 'ServiceName'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(projectNameCheck, Pause.MEDIUM));
			String ProjectNameCheck = projectNameCheck.getText();
			// Assert.assertEquals(ProjectNameCheck, appName, "Unable to validate
			// 'poc-qa'");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateJobTemplate, Pause.MEDIUM));
//			String ValidateJobTemplate = validateJobTemplate.getText();
			// Assert.assertEquals(ValidateJobTemplate, JobTemplateValue, "Unable to
			// validate 'poc-pinelabs-v2'");

			////////////// change /////////////////////////////////////////

//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateUserRole, Pause.MEDIUM));
//			String ValidateUserRole = validateUserRole.getText();
			// Assert.assertEquals(ValidateUserRole, "QA", "Unable to validate 'QA'");

			////////////// change /////////////////////////////////////////

			////////////////// Validate Build Details Empty ///////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(validateBuildDetails, Pause.MEDIUM));
			ui_click(validateBuildDetails, "Poc_QA validateBuildDetails");
			ui_IsElementDisplay(ui_waitForElementToDisplay(buildDetailsTextMain, Pause.MEDIUM));
			String BuildDetailsTextMain = buildDetailsTextMain.getText();
			Assert.assertEquals(BuildDetailsTextMain, "Build Details Not Configured",
					"Unable to validate 'Build Details Not Configured'");
			// assert BuildDetailsTextMain.equals("Build Details Not Configured");
			ui_IsElementDisplay(ui_waitForElementToDisplay(buildDetailsTextSub, Pause.MEDIUM));
			String BuildDetailsTextSub = buildDetailsTextSub.getText();
			Assert.assertTrue(BuildDetailsTextSub.contains("Please note to build a service CI is required."),
					"Unable to validate 'Please note to build a service CI is required.'");
			// assert BuildDetailsTextSub.contains("Please note to build a service CI is
			// required.");
			Assert.assertTrue(BuildDetailsTextSub.contains("please click the button below to add Build Details."),
					"Unable to validate 'please click the button below to add Build Details.'");
			// assert BuildDetailsTextSub.contains("please click the button below to add
			// Build Details.");

			////////////////// Validate Deploy Details Empty ///////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
			ui_click(validateDeployDetails, "Poc_QA validateDeployDetails");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextMain, Pause.MEDIUM));
			String DeployDetailsTextMain = deployDetailsTextMain.getText();
			Assert.assertEquals(DeployDetailsTextMain, "CD Details Not Configured",
					"Unable to validate 'CD Details Not Configured'");
			// assert DeployDetailsTextMain.equals("CD Details Not Configured");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextSub, Pause.MEDIUM));
			String DeployDetailsTextSub = deployDetailsTextSub.getText();
			Assert.assertEquals(DeployDetailsTextSub,
					"Please note to deploy a service CD is required. Please choose from options below to add CD.",
					"Unable to validate 'Please note to deploy a service CD is required. Please choose from options below to add CD.'");
			// assert DeployDetailsTextSub.equals("Please note to deploy a service CD is
			// required. Please choose from options below to add CD.");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextSub1, Pause.MEDIUM));
			String DeployDetailsTextSub1 = deployDetailsTextSub1.getText();
			softAssert.assertTrue(DeployDetailsTextSub1.contains("BuildPiper-UI: "),
					"Unable to validate 'BuildPiper-UI: '");
			// assert DeployDetailsTextSub1.contains("BuildPiper-UI: ");
			softAssert.assertTrue(
					DeployDetailsTextSub1
							.contains("To have a very smooth configuration we strongly recommend BuildPiper UI."),
					"Unable to validate 'To have a very smooth configuration we strongly recommend BuildPiper UI.'");
			// assert DeployDetailsTextSub1.contains("To have a very smooth configuration we
			// strongly recommend BuildPiper UI.");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextSub2, Pause.MEDIUM));
			String DeployDetailsTextSub2 = deployDetailsTextSub2.getText();
			softAssert.assertTrue(DeployDetailsTextSub2.contains("Custom Manifest file/GitOps: "),
					"Unable to validate 'Custom Manifest file/GitOps: '");
			// assert DeployDetailsTextSub2.contains("Custom Manifest file/GitOps: ");
			softAssert.assertTrue(
					DeployDetailsTextSub2
							.contains("you can also configure the CD by uploading your custom manifest file."),
					"Unable to validate 'you can also configure the CD by uploading your custom manifest file.'");
			// assert DeployDetailsTextSub2.contains("you can also configure the CD by
			// uploading your custom manifest file.");

			////////////////// Validate Integration Details Empty ///////////////////

//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateIntegrationDetails, Pause.MEDIUM));
//			ui_click(validateIntegrationDetails, "Poc_QA validateIntegrationDetails");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(integrationText1, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(integrationText2, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(integrationText3, Pause.MEDIUM));
//
//			////////////////// Validate Other Deployment Details Empty ///////////////////
//
//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateOtherDeploymentDetails, Pause.MEDIUM));
//			ui_click(validateOtherDeploymentDetails, "Poc_QA validateOtherDeploymentDetails");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(otherDeploymentDetails1, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(otherDeploymentDetails2, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(otherDeploymentDetails3, Pause.MEDIUM));
//
//			////////////////// Validate Generated Manifest Details Empty ///////////////////
//
//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateGeneratedManifest, Pause.MEDIUM));
//			ui_click(validateGeneratedManifest, "Poc_QA validateGeneratedManifest");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(generatedManifestText, Pause.MEDIUM));
		}

		return this;

	}

//		ui_selectValueFromDropDownByXPath(pocQaDropdown, "Poc_QA");
//		ui_selectValueFromDropDownByXPath(preTestAppDropdown, "Pre_Test");
//        Select pocQaSelect = new Select(pocQaDropdown);
//        pocQaSelect.selectByVisibleText("Service Overview");
//        Select preTestAppSelect = new Select(preTestAppDropdown);
//        preTestAppSelect.selectByVisibleText("Service Overview");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(preTestAppDropdown, Pause.MEDIUM));
//		ui_click(preTestAppDropdown, "Poc_QA project");
//		ui_click(serviceOverViewTab, "Poc_QA serviceOverView");
//		ui_click(addServiceBtn, "Poc_QA addServiceBtn");

	// Wait for the dropdown elements to be present and visible
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("poc-qa")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre-test-app")));

	// Select an option from the "poc-qa" dropdown
//        WebElement pocQaDropdown = driver.findElement(By.id("poc-qa"));

	// Select an option from the "pre-test-app" dropdown
//        WebElement preTestAppDropdown = driver.findElement(By.id("pre-test-app"));

	@FindBy(xpath = "//div[@class='input-component']//div[@class='error-message']")
	WebElement errorMessage;

	public ServiceCreationPage CreateSesrviceNegativeTest3(String appName, String ProjectName,
			String buildRadioButtonName, String existingServiceName) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			String mainHeadingText = main_Heading.getText();
			///// Create Page Text Validations //////////////////////////
			Assert.assertEquals(mainHeadingText, "Benefits of creating Microservices",
					"Unable to validate 'Benefits of creating Microservices'");

			boolean muiTxtStatus = true;
			for (WebElement muicontainer : muiGridContainerText) {
				String muiText = muicontainer.getText();
				System.out.println(muiText);
				if (!(muiText.contains("Go Live with your App in just 24 hours")
						|| muiText.contains("Spin up new Environment in few clicks")
						|| muiText.contains("Onboard a Dockerized service in minutes")
						|| muiText.contains("Enable most robust & secure DevSecOps CI in few clicks")
						|| muiText.contains("Setup & Run hassle free secured Pipelines")
						|| muiText.contains("Speed, Security & Compliance together in one Platform")
						|| muiText.contains("Setup Observability tooling in just 5 mins"))) {
					muiTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(muiTxtStatus, "Unable to  valudate the MUI container Text on left side");

			String Text8 = createaServiceHeading.getText();
			Assert.assertEquals(Text8, "Create a New Service", "Unable to validate 'Create  new service label'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(subHeading, Pause.MEDIUM));
			String Text9 = subHeading.getText();
			Assert.assertEquals(Text9, "Microservice are used to group pipeline and other setting together",
					"Unable to validate 'Microservice are used to group pipeline and other setting together'");

			ui_setvalue(service_Name_SearchBox, "sets service name", existingServiceName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");
			ui_IsElementDisplay(ui_waitForElementToDisplay(errorMessage, Pause.MEDIUM));
			Assert.assertEquals(errorMessage.getText().trim(), "component with this name already exists.",
					"Service already exists");

		}
		return this;
	}

	@FindBy(xpath = "//*[text()='Configure Build']")
	WebElement clickConfigBuild;

	@FindBy(xpath = "//div[@class='md-step-circle current']")
	WebElement currentStepCircle;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement sourceDetailsHeading;

	@FindBy(xpath = "//*[text()='Please Select the Git URL']")
	WebElement sourceDetailsTitle1;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")
	WebElement gitUrlEnterDropdown;

	@FindBy(xpath = "//input[@name='git_url']")
	WebElement gitUrlInputField;

	@FindBy(xpath = "//ul[@id='git_url-popup']//li")
	List<WebElement> autoCompleteURLList;

	@FindBy(xpath = "//*[text()='Load Branches']")
	WebElement loadBranchesBtn;

	@FindBy(xpath = "//select[@name='branch_name']")
	WebElement selectBranchName;

	@FindBy(xpath = "//input[@name='file_paths']")
	WebElement fillFilePath;

	@FindBy(xpath = "//input[@name='file_paths_build_context']")
	WebElement fillDockerFilePath;

	@FindBy(xpath = "//input[@name='image_name']")
	WebElement enterImageName;

	@FindBy(xpath = "//*[text()='Advance Configurations']")
	WebElement sourceDetailsTitle2;

	@FindBy(xpath = "//span[@class='switch-handle']")
	WebElement advanceConfigSwitch;

	@FindBy(xpath = "//*[text()='Default Image is generated for AMD 64 Platform/OS']")
	WebElement sourceDetailsTitle3;

	@FindBy(xpath = "//input[@name='buildkit_enabled']/..//span[@class='switch-handle']")
	WebElement defaultImageSwitch;

	@FindBy(xpath = "//*[text()='Select Platforms']")
	WebElement sourceDetailsTitle4;

	@FindBy(xpath = "//*[text()='Please note we use ']")
	WebElement sourceDetailsTitle5;

	@FindBy(xpath = "//div[@class='input-component']//div[@class='input-chip-checkbox']//label")
	List<WebElement> selectChipType;

	@FindBy(xpath = "//*[text()='linux/amd64']")
	WebElement selectamd64;

	@FindBy(xpath = "//*[text()='linux/arm64']")
	WebElement selectarm64;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement clickContinueBtn;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement ciDetailsHeading;

	@FindBy(xpath = "//div[@class='d-flex space-between']")
	WebElement ciDetailsSubHeading;

	@FindBy(xpath = "//input[@name='language'][@type='checkbox']")
	List<WebElement> selectLanguage;

	@FindBy(xpath = "//*[text()=' Publish CI Report to Sonar?']")
	WebElement ciDetailsSubHeading2;

	@FindBy(xpath = "//span[@class='switch-label'][@data-on]")
	WebElement sonarSwitch;

	@FindBy(xpath = "//*[text()='Project Key']")
	WebElement ciDetailsSubHeading3;

	@FindBy(xpath = "//input[@name='sonar_project_key']")
	WebElement sonarKeyEnter;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement envHeading;

	@FindBy(xpath = "//*[text()='Build Env Details']")
	WebElement envSubHeading;

	@FindBy(xpath = "//span[@class='switch-label'][@data-on]")
	WebElement envDetailsSwitch;

	@FindBy(xpath = "//*[text()='Use Field view to manage small number of variables. Use Editor view in case you want to copy paste or manage large number of variables']")
	WebElement envDetailsDefText;

	@FindBy(xpath = "//input[@name='key']")
	WebElement envName;

	@FindBy(xpath = "//input[@name='value']")
	WebElement envValue;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement hooksHeading;

	@FindBy(xpath = "//*[text()='Do you have build pre hooks?']")
	WebElement hooksSubHeading;

	@FindBy(xpath = "//*[text()='Do you have build post hooks?']")
	WebElement hooksSubHeading2;

	@FindBy(xpath = "//input[@name='pre_hook_enabled']/../span[@class='switch-handle']")
	WebElement preHooksSwitch;

	@FindBy(xpath = "//input[@name='post_hook_enabled']/../span[@class='switch-handle']")
	WebElement postHooksSwitch;

	@FindBy(xpath = "//p[contains(.,'Add Pre Hook')]/../../..//input[@placeholder='Run Command' and string-length(@value)=0]")
	WebElement preHooksPasswordBox;

	@FindBy(xpath = "//button[@class='nowrap']")
	WebElement addNewPreHook;

	@FindBy(xpath = "(//button[@class='nowrap'])[2]")
	WebElement addNewPostHook;

	@FindBy(xpath = "//p[contains(.,'Add Post Hook')]/../../..//input[@placeholder='Run Command' and string-length(@value)=0]")
	WebElement postHooksPasswordBox;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement submitHooks;

	@FindBy(xpath = "//*[text()='Repository Details']")
	WebElement repoDetails;

	@FindBy(xpath = "//button[@title='Clear']")
	WebElement clearClickGitDropDown;

	@FindBy(xpath = "//a[@class='btn btn-submit' ][contains(@href,'/manifest/add')]")
	WebElement buildPiperCustomManifest;

	@FindBy(xpath = "//input[@name='deployment_name' and @placeholder='service-env-master-project-env']")
	WebElement actualDeploymentName;

	@FindBy(xpath = "//input[@name='service_name' and @placeholder='service-envmaster-project-env']")
	WebElement actualServiceName;

	@FindBy(xpath = "//input[@name='image_name' and @placeholder='service-test/env-master-test/project-env-test']")
	WebElement actualImageName;

	@FindBy(xpath = "//input[@class='switch-input' and @name='deploy_variable_raw_input']/..//span[@class='switch-label']")
	WebElement rawKeyValuePairSwitch;

	@FindBy(xpath = "//input[@name='env_key' and @placeholder='Name']")
	WebElement keyInputField;

	@FindBy(xpath = "//input[@name='env_value' and @placeholder='Value']")
	WebElement valueInputField;

	@FindBy(xpath = "//button[@class='transparent-btn nowrap' ][text()=' Add Row']")
	WebElement addRowButton;

	@FindBy(xpath = "//input[@name='env_key' and @placeholder='Name' and @value[not(string())]]")
	WebElement keyInputField2;

	@FindBy(xpath = "//input[@name='env_value' and @placeholder='Value' and @value[not(string())]]")
	WebElement valueInputField2;

	@FindBy(xpath = "//div[contains(@class,'MuiFormGroup-row') and @role='radiogroup']//input[@name='option' and @value='MANIFEST_HELM']")
	WebElement helmUploadType;

	@FindBy(xpath = "//input[@name='file_paths' and @placeholder='/xyz/abc.yaml']")
	WebElement fileFolderPathInput;

	@FindBy(xpath = "//input[@name='helm_release_name' and @placeholder='Enter Helm Release name']")
	WebElement hemReleaseNameInput;

	@FindBy(xpath = "//div[contains(@class,'MuiFormGroup-row') and @role='radiogroup']//span[text()='Via Git Repo']")
	WebElement valueFileUpload;

	@FindBy(xpath = "//div[@class='value-files']//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")
	WebElement valueFieldGitDropdown;

	@FindBy(xpath = "//div[@class='value-files']//button[@title='Clear']")
	WebElement clearClickValueGitDropDown;

	@FindBy(xpath = "//div[@class='value-files']//input[@name='git_url']")
	WebElement valueGitUrlInputField;

//	@FindBy(xpath = "//input[@id='git_url']")
//	List<WebElement> autoCompleteURLList1;

//	@FindBy(xpath = "//div[@class='value-files']//input[@id='git_url']")
//	List<WebElement> autoCompleteValueURLList;

	@FindBy(xpath = "//div[@class='value-files']//input[@name='file_paths' and @placeholder='/xyz/abc.yaml']")
	WebElement fileFolderValuePathInput;

	@FindBy(xpath = "//button[@class='btn btn-submit' and text()='Save & Continue']")
	WebElement saveAndContinueBtn;

	@FindBy(xpath = "//div[@class='value-files']//*[text()='Load Branches']")
	WebElement loadValueBranchesBtn;

	@FindBy(xpath = "//div[@class='value-files']//select[@name='branch_name']")
	WebElement selectValueBranchName;

	public ServiceCreationPage CreateHelmNewService(String appName, String ProjectName, String buildRadioButtonName,
			ArrayList<String> UserRoles, String JobTemplateValue, String gitURL, String BranchName, String FilePath,
			String DockerFilePath, ArrayList<String> LanguageName, String preHookPass, String EnvName, String helmKey1,
			String helmValue1, String helmKey2, String helmValue2, String helmKey3, String helmValue3,
			String UploadTypeName, String BranchName1, String folderPath, String helmReleaseName,
			String folderPathValue) {

		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));

			ui_setvalue(service_Name_SearchBox, "sets service name", ServiceHelmName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalHelmName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");

			////////////// Create a Service Environment ////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(environmentHeader, Pause.LOW));
			ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
			Select dropdown = new Select(envDropdown);
			dropdown.selectByVisibleText(ProjectName);
			// ui_wait(3);

			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(allowManualBuildYes, "Poc_QA allowManualBuildYes");
			if (allowManualDeployYes.getAttribute("value").equals("false"))
				ui_click(allowManualDeployYes, "Poc_QA allowManualDeployYes");

			ui_selectValueFromDropDownByXPath(jobTemplateDropdown, "jobTemplateDropdown");
			Select jobdropdown = new Select(jobTemplateDropdown);
			jobdropdown.selectByVisibleText(JobTemplateValue);

			for (int i = 0; i < roleGroupCheckbox.size(); i++) {
				if (UserRoles.contains(roleGroupCheckbox.get(i).getAttribute("value").trim())) {
					roleGroupCheckbox.get(i).click();
				}
			}
			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(selectJobTemplateRadioBtn, "Poc_QA selectJobTemplateRadioBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinue_Create_Page, Pause.LOW));
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
			// ui_wait(5);
			ui_IsElementDisplay(ui_waitForElementToDisplay(clickConfigBuild, Pause.MEDIUM));
			ui_click(clickConfigBuild, "Poc_QA clickConfigBuild");

			/////////// Source Details Fill ////////////////////////////
			ui_wait(3);

			ui_IsElementDisplay(ui_waitForElementToDisplay(currentStepCircle, Pause.MEDIUM));
			ui_IsElementDisplay(ui_waitForElementToDisplay(gitUrlEnterDropdown, Pause.MEDIUM));
			ui_click(gitUrlInputField, "Poc_QA gitUrlInputField");
			ui_wait(5);

			ui_click(clearClickGitDropDown, "ClicksclearField");

			ui_clearAndSetValue(gitUrlInputField, gitURL);
			ui_wait(2);
			ui_clickfromList(autoCompleteURLList, gitURL);
			ui_wait(5);

			ui_IsElementDisplay(ui_waitForElementToDisplay(loadBranchesBtn, Pause.MEDIUM));
			ui_click(loadBranchesBtn, "Poc_QA loadBranchesBtn");
			ui_wait(10);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectBranchName, Pause.MEDIUM));
			ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
			Select dropdown1 = new Select(selectBranchName);
			dropdown1.selectByVisibleText(BranchName);
			ui_wait(3);
			ui_clearAndSetValue(fillFilePath, FilePath);
			ui_clearAndSetValue(fillDockerFilePath, DockerFilePath);
			ui_IsElementDisplay(ui_waitForElementToDisplay(sourceDetailsTitle2, Pause.MEDIUM));

			ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
			ui_wait(5);

			/////////// CI Details Fill ////////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(ciDetailsHeading, Pause.MEDIUM));

			for (int i = 0; i < selectLanguage.size(); i++) {
				System.out.println(selectLanguage.get(i).getAttribute("value").trim());
				if (LanguageName.contains(selectLanguage.get(i).getAttribute("value").trim())) {

					selectLanguage.get(i).click();
				}
			}

			ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");

			/////////// ENV Details Fill ////////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(envHeading, Pause.MEDIUM));
			ui_IsElementDisplay(ui_waitForElementToDisplay(envSubHeading, Pause.MEDIUM));
			ui_click(envDetailsSwitch, "Poc_QA envDetailsSwitch");
			ui_setvalue(envName, "Poc_QA envName", EnvName);
			ui_setvalue(envValue, "Poc_QA envValue", "UAT-QA");
			ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");

			/////////// HOOKS Details Fill ////////////////////////////

			ui_click(preHooksSwitch, "Poc_QA preHooksSwitch");
			ui_setvalue(preHooksPasswordBox, "Poc_QA preHooksPasswordBox1", preHookPass);

			ui_click(addNewPreHook, "clicks on add New Hook");
			ui_setvalue(preHooksPasswordBox, "Poc_QA preHooksPasswordBox2", preHookPass);

			ui_click(postHooksSwitch, "Poc_QA postHooksSwitch");
			ui_setvalue(postHooksPasswordBox, "Poc_QA postHooksPasswordBox1", preHookPass);

			ui_click(addNewPostHook, "clicks on add New Post Hook");
			ui_setvalue(postHooksPasswordBox, "Poc_QA postHooksPasswordBox2", preHookPass);

			ui_click(submitHooks, "Poc_QA submitHooks");
			ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
			ui_click(validateDeployDetails, "Poc_QA validateDeployDetails");
			ui_IsElementDisplay(ui_waitForElementToDisplay(buildPiperCustomManifest, Pause.MEDIUM));
			ui_click(buildPiperCustomManifest, "clicks on custom manifest button under deploy details");
			String expDeploymentName = ServiceHelmName + "-" + "dev" + "-" + ProjectName;
			Assert.assertEquals(actualDeploymentName.getAttribute("value").trim(), expDeploymentName,
					"Validating expeceted and actual deployment name");
			Assert.assertEquals(actualServiceName.getAttribute("value").trim(), expDeploymentName,
					"Validating expeceted and actual service name");
			String expImageName = ServiceHelmName + "/" + "dev" + "/" + ProjectName;
			Assert.assertEquals(actualImageName.getAttribute("value").trim(), expImageName,
					"Validating expeceted and actual image name");
			ui_IsElementDisplay(ui_waitForElementToDisplay(rawKeyValuePairSwitch, Pause.MEDIUM));
			ui_click(rawKeyValuePairSwitch, "clicks on switch handle for raw key value pairs");
			ui_clearAndSetValue(keyInputField, helmKey1);
			ui_clearAndSetValue(valueInputField, helmValue1);
			ui_IsElementDisplay(ui_waitForElementToDisplay(addRowButton, Pause.MEDIUM));
			ui_click(addRowButton, "clicks on add row button for key value pairs");
			ui_clearAndSetValue(keyInputField2, helmKey2);
			ui_clearAndSetValue(valueInputField2, helmValue2);
			ui_click(addRowButton, "clicks on add row button for key value pairs");
			ui_clearAndSetValue(keyInputField2, helmKey3);
			ui_clearAndSetValue(valueInputField2, helmValue3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(helmUploadType, Pause.MEDIUM));
			ui_click(helmUploadType, "clicks on upload type");
			ui_IsElementDisplay(ui_waitForElementToDisplay(gitUrlEnterDropdown, Pause.MEDIUM));
			ui_click(gitUrlInputField, "Poc_QA gitUrlInputField");
			ui_wait(5);

			ui_click(clearClickGitDropDown, "ClicksclearField");

			ui_clearAndSetValue(gitUrlInputField, gitURL);
			ui_wait(2);
			ui_clickfromList(autoCompleteURLList, gitURL);
			ui_wait(5);

			ui_IsElementDisplay(ui_waitForElementToDisplay(loadBranchesBtn, Pause.MEDIUM));
			ui_click(loadBranchesBtn, "Poc_QA loadBranchesBtn");
			ui_wait(10);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectBranchName, Pause.MEDIUM));
			ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
			Select dropdownBranch = new Select(selectBranchName);
			dropdownBranch.selectByVisibleText(BranchName1);
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(fileFolderPathInput, Pause.MEDIUM));
			ui_clearAndSetValue(fileFolderPathInput, folderPath);
			ui_IsElementDisplay(ui_waitForElementToDisplay(hemReleaseNameInput, Pause.MEDIUM));
			ui_clearAndSetValue(hemReleaseNameInput, helmReleaseName);
			ui_IsElementDisplay(ui_waitForElementToDisplay(valueFileUpload, Pause.MEDIUM));
			ui_click(valueFileUpload, "clicks value file option");

			ui_IsElementDisplay(ui_waitForElementToDisplay(valueFieldGitDropdown, Pause.MEDIUM));
			ui_click(valueFieldGitDropdown, "value Field Git Dropdown");
			ui_wait(5);

			ui_click(clearClickValueGitDropDown, "ClicksclearField");

			ui_clearAndSetValue(valueGitUrlInputField, gitURL);
			ui_wait(2);
			ui_clickfromList(autoCompleteURLList, gitURL);
			ui_wait(5);

			ui_IsElementDisplay(ui_waitForElementToDisplay(loadValueBranchesBtn, Pause.MEDIUM));
			ui_click(loadValueBranchesBtn, "Poc_QA loadBranchesBtn");
			ui_wait(10);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectValueBranchName, Pause.MEDIUM));
			ui_selectValueFromDropDownByXPath(selectValueBranchName, "Selects Branch Name");
			Select dropdownBranch1 = new Select(selectValueBranchName);
			dropdownBranch1.selectByVisibleText(BranchName1);
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(fileFolderValuePathInput, Pause.MEDIUM));
			ui_clearAndSetValue(fileFolderValuePathInput, folderPathValue);
			ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinueBtn, Pause.MEDIUM));
			ui_click(saveAndContinueBtn, "save And Continue Btn");
		}
		return this;
	}

	public ServiceCreationPage CreateBuildXService(String appName, String ProjectName, String buildRadioButtonName,
			ArrayList<String> UserRoles, String JobTemplateValue) {

		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");

		}
		return this;

	}

	@FindBy(xpath = "//a[text()='Add Environment']")
	WebElement addNewEnvToRunningService;

	@FindBy(xpath = "//span[@class='badge badge-dev']")
	WebElement devEnvBadge;

	@FindBy(xpath = "//label//..//..//..//select")
	WebElement selectEnvDrop;

	@FindBy(xpath = "//div[@class='input-component']//label")
	WebElement cloneFromEnvValidateTxt;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()=' Next ']")
	WebElement nextBtn;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement buildPiperUIDeployConfigBtn;

//	@FindBy(xpath = "//button[@class='btn btn-submit']")
//	WebElement continueBtn;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement continueBtn;

	@FindBy(xpath = "//input[@placeholder='Image Name']")
	WebElement accessLevelImageName;

	@FindBy(xpath = "//span//input[@type='radio' and @value='PRIVATE']")
	WebElement privateAccess;

	@FindBy(xpath = "//span//input[@type='radio' and @value='PUBLIC']")
	WebElement publicAccess;

	@FindBy(xpath = "//span//input[@type='radio' and @value='PROTECTED']")
	WebElement protectedAccess;

	@FindBy(xpath = "//button//span[text()=' Add Access Level']")
	WebElement addAcessLevel;

	@FindBy(xpath = "//input[@placeholder='name'][@name='name']")
	WebElement accessName;

	@FindBy(xpath = "//input[@placeholder='4001'][@name='port']")
	WebElement port;

	@FindBy(xpath = "//input[@placeholder='4001'][@name='target_port']")
	WebElement targetPort;

	@FindBy(xpath = "//button[@class='btn btn-v2-primary btn-sm']")
	WebElement addAccessBtn;

	public ServiceCreationPage addNewEnvironmentToService(String ProjectName, ArrayList<String> UserRoles,
			String JobTemplateValue, String cloneText, String envCloneValue, String BranchName,String AccessType, String AccessName,
			String portNumber, String TargetPort) {

		ui_click(addNewEnvToRunningService, "adds new environment to running service");
		ui_IsElementDisplay(ui_waitForElementToDisplay(environmentHeader, Pause.LOW));
		String Text10 = environmentHeader.getText();
		Assert.assertEquals(Text10, "Create a Environment", "Unable to validate 'Create a Environment'");
		ui_IsElementDisplay(ui_waitForElementToDisplay(environmentSubHeader, Pause.MEDIUM));
		String Text11 = environmentSubHeader.getText();
		Assert.assertTrue(Text11.contains(
				"A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project."),
				"Unable to validate 'A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project.'");
		Assert.assertTrue(Text11.contains("To learn more about how to setup a Microservice please read"),
				"Unable to validate 'To learn more about how to setup a Microservice please read'");
		ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
		Select dropdown = new Select(envDropdown);
		dropdown.selectByVisibleText(ProjectName);
		// ui_wait(3);

		if (allowManualBuildYes.getAttribute("value").equals("false"))
			ui_click(allowManualBuildYes, "Poc_QA allowManualBuildYes");
		if (allowManualDeployYes.getAttribute("value").equals("false"))
			ui_click(allowManualDeployYes, "Poc_QA allowManualDeployYes");

//		String UserRoleGroupText = userRoleGroupText.getText();
//		softAssert.assertEquals(UserRoleGroupText,
//				"Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the",
//				"Unable to validate 'Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the'");
//		ui_selectValueFromDropDownByXPath(jobTemplateDropdown, "jobTemplateDropdown");
		Select jobdropdown = new Select(jobTemplateDropdown);
		jobdropdown.selectByVisibleText(JobTemplateValue);

		for (int i = 0; i < roleGroupCheckbox.size(); i++) {
			if (UserRoles.contains(roleGroupCheckbox.get(i).getAttribute("value").trim())) {
				roleGroupCheckbox.get(i).click();
			}
		}
		if (allowManualBuildYes.getAttribute("value").equals("false"))
			ui_click(selectJobTemplateRadioBtn, "Poc_QA selectJobTemplateRadioBtn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinue_Create_Page, Pause.LOW));
		ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(devEnvBadge, Pause.LOW));
//		ui_click(devEnvBadge, "dev environment badge");
		ui_IsElementDisplay(ui_waitForElementToDisplay(clickConfigBuild, Pause.MEDIUM));
		ui_getUIDriver().navigate().refresh();
		ui_IsElementDisplay(ui_waitForElementToDisplay(clickConfigBuild, Pause.MEDIUM));
		ui_click(clickConfigBuild, "Poc_QA clickConfigBuild");
		Assert.assertEquals(cloneFromEnvValidateTxt.getText().trim(), cloneText, "cloning text validated");
		ui_selectValueFromDropDownByXPath(selectEnvDrop, "selectEnvDrop");
		Select envDrop = new Select(selectEnvDrop);
		envDrop.selectByVisibleText(envCloneValue);
		ui_click(nextBtn, "user clicks next button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(loadBranchesBtn, Pause.MEDIUM));
		ui_click(loadBranchesBtn, "Poc_QA loadBranchesBtn");
		ui_wait(5);
		ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
		Select dropdown2 = new Select(selectBranchName);
		dropdown2.selectByVisibleText(BranchName);
		ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
		ui_wait(5);
		ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
		ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
		ui_click(submitHooks, "Poc_QA submitHooks");
		ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
		ui_click(validateDeployDetails, "Poc_QA validateDeployDetails");
		ui_IsElementDisplay(ui_waitForElementToDisplay(buildPiperUIDeployConfigBtn, Pause.MEDIUM));
		ui_click(buildPiperUIDeployConfigBtn, "clicks on buildPiperUI button");
		ui_selectValueFromDropDownByXPath(selectEnvDrop, "selectEnvDrop");
		Select envDrop1 = new Select(selectEnvDrop);
		envDrop1.selectByVisibleText(envCloneValue);
		ui_click(nextBtn, "user clicks next button");
		ui_click(addAcessLevel, "Add Access Level");
		ui_wait(2);

		if (AccessType.contains("PRIVATE")) {
			ui_click(privateAccess, "Poc_QA privateAccess");

		} else if (AccessType.contains("PUBLIC")) {

			ui_click(publicAccess, "Poc_QA publicAccess");

		} else {

			ui_click(protectedAccess, "Poc_QA protectedAccess");

		}
		ui_clearAndSetValue(accessName, AccessName);
		ui_clearAndSetValue(port, portNumber);
		ui_clearAndSetValue(targetPort, TargetPort);
		ui_click(addAccessBtn, "clicks add button");
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
//		ui_click(addConfigToDeploy, "switches config maps add to yes");
//		Select dropdown = new Select(selectDropDownConfigNames);
//		dropdown.selectByVisibleText(configName);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);

		return this;
	}
	
	@FindBy(xpath = "//button[@title='Build']")
	WebElement buildButton;
	
	@FindBy(xpath = "//button[text()='Trigger Build']")
	WebElement triggerBuild;
	
	@FindBy(xpath = "//button[contains(text(),'Trigger Build & Deploy')]")
	WebElement triggerBuildAndDeploy;
	
	public ServiceCreationPage buildTrigger() {

		ui_click(buildButton, "clicks buildButton");
		ui_wait(5);
		ui_click(triggerBuild, "clicks triggerBuild");

		return this;
	}
	
	//RK
	public ServiceCreationPage buildButton_Click() {

		ui_click(buildButton, "clicks buildButton");

		return this;
	}
	public ServiceCreationPage triggerBuild_Click() {

		ui_click(triggerBuild, "clicks triggerBuild");

		return this;
	}
    //RK
	public ServiceCreationPage CacheCheckbox_Click() {

		ui_click(cacheToggle, "clicks on cacheToggle");

		return this;
	}
	
	//RK
	@FindBy(xpath = "//span[contains(text(),'Please note You are building image in Env.')]/following-sibling::span[1]")
	WebElement environmentCheck;
	@FindBy(xpath = "//span[contains(text(),'Sub Env:')]/span")
	WebElement subEnvironmentCheck;
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement searchServiceTextBox;
	
	public ServiceCreationPage Verify_EnvironmentandSubEnvironment(String Env,String SubEnv) {
	ui_IsElementDisplay(ui_waitForElementToDisplay(environmentCheck, Pause.MEDIUM));
    String Environment=environmentCheck.getText();
    String SubEnvironment=subEnvironmentCheck.getText();
    assertEquals(Environment, Env);
    assertEquals(SubEnvironment, SubEnv);
	return this;
	}
	public ServiceCreationPage SearchServiceViaRandomStringValue(String appName,String Servicename) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_wait(3);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), "AUTOMATION-682046MU117XJPT");
		}
		return this;
	}
	
	public ServiceCreationPage switchEnvironmentTab(String Environment) {
    WebElement Tab=ui_getUIDriver().findElement(By.xpath("//span[text()='"+Environment+"']/../span[2]/following-sibling::span"));
	ui_click(Tab, "Select Environment Tab");
	return this;
}
	public ServiceCreationPage switchServiceType(String ServiceType) {
		WebElement Tab=ui_getUIDriver().findElement(By.xpath("//ul[@class='headerul']/li[text()='"+ServiceType+"']"));
		ui_click(Tab, "Select ServiceType Tab");
		return this;
	}

	
	public ServiceCreationPage SearchService(String appName,String Servicename) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_wait(3);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, "xjpt");
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		//Health Check
		ui_click(statusCheck, "Click on statusCheck");
		ui_wait(2);
		Assert.assertEquals(healthStatus.getText(), "SUCCESS");	
		ui_wait(3);
		/*
		//Build UI Verify
		Assert.assertEquals(runningBuildStatus.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
		Assert.assertEquals(ui_IsElementDisplay(buildOn), true);
		Assert.assertEquals(ui_IsElementDisplay(buildBy), true);
		*/
		//get the Value of Build Fields
		String BuildStatus=runningBuildStatus.getText();
		String BuildArtifact=buildArtifact.getText();
		String BuildcommitID=commitID.getText();
		String BuildcommitMessage=commitMessage.getText();
		String BuildOn=buildOn.getText();
		String BuildBy=buildBy.getText();	
		
		
		//-----------------Service build deploy promote history monitoring icon 
		Assert.assertEquals(ui_IsElementDisplay(build), true);
		Assert.assertEquals(ui_IsElementDisplay(deploy), true);
		Assert.assertEquals(ui_IsElementDisplay(promote), true);
		Assert.assertEquals(ui_IsElementDisplay(history), true);
		Assert.assertEquals(ui_IsElementDisplay(monitoring), true);
				
		ui_click(history, "Click on History Icon");
		switchServiceType("Deploy");
		switchServiceType("Promote");
		Assert.assertEquals("Build #1", history_buildType.getText());
		Assert.assertEquals(BuildStatus, history_buildStatus.getText());
		Assert.assertEquals(BuildOn, history_buildDateandTime.getText());
		Assert.assertEquals(BuildArtifact, history_buildArtifact.getText());
		Assert.assertEquals(BuildBy, history_buildby.getText());
		Assert.assertEquals(BuildcommitID, history_CommitID.getText());
		Assert.assertEquals(BuildcommitMessage, history_CommitMessage.getText());
		
		ui_wait(3);
		System.out.println(historyTag.getText());
		System.out.println(historyCacheorNoCache.getText());
		System.out.println(historyIsDeploy.getText());
		System.out.println(historyCustomtag.getText());
		System.out.println(historyBranchname.getText());
		System.out.println(historyActivity_MasterCode.getText());
		
		/*Assert.assertEquals(historyTag.getText(), "");
		Assert.assertEquals(historyCacheorNoCache.getText(), "");
		Assert.assertEquals(historyIsDeploy.getText(), "");
		Assert.assertEquals(historyCustomtag.getText(), "");
		Assert.assertEquals(historyBranchname.getText(), "");
		Assert.assertEquals(historyActivity_MasterCode.getText(), "");*/
		ui_click(historywindow_closeButton, "Click on historywindow_closeButton");
		
		
		//Deploy UI Verify
		Assert.assertEquals(deployManifestApplied.getText(), "SUCCESS");
		Assert.assertEquals(deployRollout.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(deployArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(deployOn), true);
		Assert.assertEquals(ui_IsElementDisplay(deployBy), true);
		Assert.assertEquals(ui_IsElementDisplay(deployUptime), true);
		Assert.assertEquals(ui_IsElementDisplay(deployRestart), true);
		
		//-----------------------------Swtich to QA Tab------------------------------------------------------
		switchEnvironmentTab("QA");
		//Build UI Verify
		Assert.assertEquals(runningBuildStatus.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
		Assert.assertEquals(ui_IsElementDisplay(buildOn), true);
		Assert.assertEquals(ui_IsElementDisplay(buildBy), true);
		//Deploy UI Verify
		Assert.assertEquals(deployManifestApplied.getText(), "SUCCESS");
		Assert.assertEquals(deployRollout.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(deployArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(deployOn), true);
		Assert.assertEquals(ui_IsElementDisplay(deployBy), true);
		Assert.assertEquals(ui_IsElementDisplay(deployUptime), true);
		Assert.assertEquals(ui_IsElementDisplay(deployRestart), true);
		
		//-----------------------------Swtich to UAT Tab------------------------------------------------------
		switchEnvironmentTab("UAT");
		//Build UI Verify
		Assert.assertEquals(runningBuildStatus.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
		Assert.assertEquals(ui_IsElementDisplay(buildOn), true);
		Assert.assertEquals(ui_IsElementDisplay(buildBy), true);
		//Deploy UI Verify
		Assert.assertEquals(deployManifestApplied.getText(), "SUCCESS");
		Assert.assertEquals(deployRollout.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(deployArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(deployOn), true);
		Assert.assertEquals(ui_IsElementDisplay(deployBy), true);
		Assert.assertEquals(ui_IsElementDisplay(deployUptime), true);
		Assert.assertEquals(ui_IsElementDisplay(deployRestart), true);
		
		//-----------------------------Swtich to PROD Tab------------------------------------------------------
		switchEnvironmentTab("PROD");
		//Build UI Verify
		Assert.assertEquals(runningBuildStatus.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
		Assert.assertEquals(ui_IsElementDisplay(buildOn), true);
		Assert.assertEquals(ui_IsElementDisplay(buildBy), true);
		//Deploy UI Verify
		Assert.assertEquals(deployManifestApplied.getText(), "SUCCESS");
		Assert.assertEquals(deployRollout.getText(), "SUCCESS");
		Assert.assertEquals(ui_IsElementDisplay(deployArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(deployOn), true);
		Assert.assertEquals(ui_IsElementDisplay(deployBy), true);
		Assert.assertEquals(ui_IsElementDisplay(deployUptime), true);
		Assert.assertEquals(ui_IsElementDisplay(deployRestart), true);
		
		}
		return this;
		}
	
	//RK
	@FindBy(xpath = "//div[@class='round-chip bg-round-blue status-font']")
	WebElement buildStatus;	
	@FindBy(xpath = "//span[text()='Build #']")
	WebElement buildRecent;	
	
	public ServiceCreationPage Verify_buildStatus(String Status) {
	ui_IsElementDisplay(ui_waitForElementToDisplay(buildStatus, Pause.MEDIUM));
    String BuildStatus=buildStatus.getText();
    assertEquals(BuildStatus, Status);
	return this;
	}
	public ServiceCreationPage buildRecentButtonClick() {
	ui_click(buildRecent, "buildRecent");
		return this;
		}
		
	@FindBy(xpath = "//input[@name='no_cache' and @class='switch-input']")
	WebElement cacheToggle;
	
	public ServiceCreationPage buildTriggerAndDeploy() {

		ui_click(buildButton, "clicks buildButton");
		ui_wait(5);
		ui_click(cacheToggle, "toggles cacheToggle yes");
		ui_wait(5);
		ui_click(triggerBuildAndDeploy, "clicks triggerBuildAndDeploy");

		return this;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Trigger Deploy ')]")
	WebElement triggerDeploy;
	
	@FindBy(xpath = "//button[@title='Deploy']")
	WebElement deployButton;
	
	public ServiceCreationPage deployService() {

		ui_click(deployButton, "clicks deployButton");
		ui_wait(5);
		ui_click(triggerDeploy, "clicks triggerDeploy");

		return this;
	}

}
