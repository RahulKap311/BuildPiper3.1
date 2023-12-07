package com.buildpiper.pages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.buildpiper.base.BasePage;
import com.buildpiper.utils.Configuration;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


/**
 * @author sagarT
 * @reviewer:
 *
 */
public class BuildPipeLinePage extends BasePage {

	String pipelineName = "BasicPipeline" + RandomStrings.generateRandomString(9);
	String schedulepipelineName = "SchedulePipeline" + RandomStrings.generateRandomString(9);
	String StageName1 = "dev" + RandomStrings.generateRandomString(7);
	String StageName2 = "qa" + RandomStrings.generateRandomString(7) + "fromdev";
	String StageName3 = "prod" + RandomStrings.generateRandomString(7) + "fromqa";
	
//	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')][contains(.,'perfeasy-app')]" )
//	WebElement poc_qaProjectLink;
	
	@FindBy(xpath = "//button//span[2][@class='flaticon-expand-arrow']/../..//li//span[contains(.,'Pipeline Overview')]" )
	WebElement pipelineOverviewLink;
	
	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[@title]")
	List<WebElement> poc_qaProjectLink;
	
	
	@FindBy(xpath = "//div[@class='service-name']//a[contains(.,'Build-pipeline')]" )
	WebElement PipelineSubject;
	
	@FindBy(xpath = "//span[@title='Run Pipeline']/button" )
	WebElement executePipeLineButton;
	
	@FindBy(xpath = "//a[@title='view logs']" )
	WebElement viewLogsLink;
	
	@FindBy(xpath = "//div[@class='md-step active md-step-log']//div[@class='md-step-circle success']/..//div[contains(.,'Post Hooks Executing')]" )
	WebElement postHookExecutingSuccessLink;
	
	@FindBy(xpath = "//button[contains(@class,'btn-link-green')][text()=' Switch to User Portal']")
	WebElement switchToUSer;
	
	@FindBy(xpath = "//button[@type='button' and @aria-controls='menu-appbar']//div//div")
	WebElement userMenuAppBar;
	
	@FindBy(xpath = "//div[@class='input-component']//input[@name='name' and @placeholder='Name']")
	WebElement searchPipeLine;
	
	@FindBy(xpath = "//button[@title='View Execution History']")
	WebElement pipeLineExecutionHistory;
	
	@FindBy(xpath = "//button[@title='Replay Pipeline']")
	WebElement reExecutePipeLineBtn;
	
	@FindBy(xpath = "//a[contains(@href,'/application/')][contains(@href,'/pipeline/')][contains(@href,'/execution/')]")
	WebElement existingPipeLine;
	
	@FindBy(xpath = "//p//span[text()='IN USE']")
	WebElement pipelineStatus;
	
	@FindBy(xpath = "//span[@class='flaticon-play-rounded-button']")
	WebElement runPipeline;
	
	@FindBy(xpath = "//div[@class='status-chip status-chip-warning' and text()=' Running ']")
	WebElement pipelineStatusAfterPlayButton;

	/**
	 * 
	 */
	public BuildPipeLinePage() {

	}
	
	public BuildPipeLinePage searchPipeline(String pipeline) {
		
		ui_wait(5);
		
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, pipeline);
		searchPipeLine.sendKeys(Keys.ENTER);
		
		return this;
	}
	
	@FindBy(xpath = "(//span[@title='Edit Pipeline']/a)[1]")
	 WebElement firstpipelineEditLink;
	@FindBy(xpath = "(//button[@title='View Execution History'])[1]")
	WebElement firstpipelineHistoryLink;
	@FindBy(xpath = "//h6[contains(text(),'Execution History of ')]")
	WebElement pipelineHistoryTitle;
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd'])[2]")
	WebElement pipelineHistoryClose;
	@FindBy(xpath = "(//button[contains(text(),'Run With Parameters')])[1]")
	WebElement firstPipelineRunwithParameter;
	@FindBy(xpath = "//span[contains(@class,'sub-heading-controller')]/span")
	WebElement parameterTagPipeline;
	@FindBy(xpath = "(//input[@name='components'])[2]")
	WebElement firstServiceCheckbox;
	@FindBy(xpath = "//*[text()='Change Branch and tag']")
	WebElement changeBranchandtagLink;
	
public BuildPipeLinePage editPipeline(String appName) {
		
	boolean projectSelection = false;
	ui_wait(5);
	ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
	for(WebElement element:poc_qaProjectLink) {
		if(element.getText().trim().equalsIgnoreCase(appName)) {
			element.click();
			projectSelection = true;
			break;
		}
	}
	if(projectSelection) {
	ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
	ui_click(firstpipelineEditLink, "first pipeline EditLink");
	ui_click(editPipelineInfo, "clicks on edit pipeline info");
	ui_IsElementDisplay(ui_waitForElementToDisplay(basicInfoText, Pause.MEDIUM));
    Assert.assertEquals(basicInfoText.getText().trim(), "Basic Info");
    ui_click(closeEditTile, "clicks on close pipeline info");
	
	}
		return this;
	}

public BuildPipeLinePage historyPipeline(String appName) {
	
	boolean projectSelection = false;
	ui_wait(5);
	ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
	for(WebElement element:poc_qaProjectLink) {
		if(element.getText().trim().equalsIgnoreCase(appName)) {
			element.click();
			projectSelection = true;
			break;
		}
	}
	if(projectSelection) {
	ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
	ui_click(firstpipelineHistoryLink, "first pipeline History Link");	
    Assert.assertEquals(ui_IsElementPresent(pipelineHistoryTitle, "5"),true);
    ui_click(pipelineHistoryClose, "pipeline History Close");	
	}
	return this;
	}

public BuildPipeLinePage RunwithParameter(String appName,String pipeline) {
	
	boolean projectSelection = false;
	ui_wait(5);
	ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
	for(WebElement element:poc_qaProjectLink) {
		if(element.getText().trim().equalsIgnoreCase(appName)) {
			element.click();
			projectSelection = true;
			break;
		}
	}
	if(projectSelection) {
	ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
	searchPipeline(pipeline);
	ui_click(firstPipelineRunwithParameter, "first Pipeline RunwithParameter");	
	Assert.assertEquals(parameterTagPipeline.getText(), "Please note: artifact tag has to be unique");
	ui_click(firstServiceCheckbox, "first Service Checkbox");
	ui_wait(3);
	ui_IsElementDisplay(ui_waitForElementToDisplay(changeBranchandtagLink, Pause.MEDIUM));
	ui_click(changeBranchandtagLink, "change Branch and tag Link");
	}
	return this;
	}
	
	@FindBy(xpath = "(//span[@class='stage-name-execution'])[1]")
	WebElement addedStageName1;
	
	@FindBy(xpath = "(//span[@class='stage-name-execution'])[2]")
	WebElement addedStageName2;
	
	@FindBy(xpath = "(//span[@class='stage-name-execution'])[3]")
	WebElement addedStageName3;
	
	public BuildPipeLinePage executeFromOverviewPage() {
		
		ui_wait(5);
		ui_click(runPipeline, "Poc_QA runPipeline");
		ui_IsElementDisplay(ui_waitForElementToDisplay(pipelineStatusAfterPlayButton, Pause.MEDIUM));
		ui_click(existingPipeLine, "clicks on pipeline hyperlink");
		ui_wait(5);
        Assert.assertEquals(addedStageName1.getText().trim(), StageName1);
        Assert.assertEquals(addedStageName2.getText().trim(), StageName2);
        Assert.assertEquals(addedStageName3.getText().trim(), StageName3);

		return this;
	}
	
	public BuildPipeLinePage buildAndValidateConsolePage(String appName, String existingPipelineName) {
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(PipelineSubject, Pause.MEDIUM));
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, existingPipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_click(pipeLineExecutionHistory, "view pipeline excution history");
		ui_IsElementDisplay(ui_waitForElementToDisplay(reExecutePipeLineBtn, Pause.MEDIUM));
		ui_click(reExecutePipeLineBtn, "view pipeline re-excution history");
//		ui_click(executePipeLineButton, "Poc_QA execution Start");
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(existingPipeLine, Pause.MEDIUM));
		ui_click(existingPipeLine, "Poc_QA execution Start");
		
		ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
		ui_click(viewLogsLink, "Poc_QA click on View Logs");
		ui_switchToNewWindow();
		ui_IsElementDisplay(ui_waitForElementToDisplay(postHookExecutingSuccessLink, Pause.MEDIUM));
		ui_click(postHookExecutingSuccessLink, "postHookExecuting click for Console Logs");
		ui_wait(10);
		List<String> consoleLogs = ui_getTextForElements("//div[@class='d-grid grid-temp-log-line']//span");
		boolean status = consoleLogs.get(0).length()>0;
		Reporter.log("Successful Validate the Console logs", status);
		}
		return this;
	}
	
	@FindBy(xpath = "//a[@class='btn btn-submit' and text()='Add Pipeline']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div//input[@name='name' and @placeholder='Give a name to the pipeline']")
	WebElement addNameToNewPipeline;
	
	@FindBy(xpath = "//select[@name='version' and @class='select']")
	WebElement selectPipelineVersionDropdown;
	
	@FindBy(xpath = "//input[@name='retention_execution_count' and @placeholder='Retention Count']")
	WebElement retentionCountField;
	
	@FindBy(xpath = "//label[@class='MuiFormControlLabel-root']/span[1]")
	List<WebElement> MUIRadioButtonsChecked;
	
	@FindBy(xpath = "//div[contains(@class,'MuiFormGroup')][@role='radiogroup']//input")
	List<WebElement> triggerTypeRadioBtn;
	
	@FindBy(xpath = "//div[@class='input-component']//input[@type='checkbox']")
	List<WebElement> pipelineAssignUserRoleCheckbox;
	
	@FindBy(xpath = "//button[contains(@class,'btn-save btn')][text()='Save']")
	WebElement savePipeline;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1']")
	WebElement muiTypographyBody;
	
	
	@FindBy(xpath = "//p[@class='pipeline-name']")
	WebElement validatePipelineName;
	
	@FindBy(xpath = "//button//div[@class='text-btn'][text()='Add New Stage']")
	WebElement addNewStageToPipeline;
	
	@FindBy(xpath = "//input[@name='name' and @placeholder='Stage name goes here']")
	WebElement stageName;
	
	@FindBy(xpath = "//div[@class='btn btn-add'][text()='ADD']")
	WebElement addStageBtn;
	
	@FindBy(xpath = "//div[@class='text-btn'][text()='Add New Job ']")
	WebElement addNewJobBtn;
	
	@FindBy(xpath = "//div[contains(@data-rbd-draggable-id,'stage-qa')]//div[@class='text-btn'][text()='Add New Job ']")
	WebElement addNewJobBtnUnderSecondStage;
	
	@FindBy(xpath = "//div[contains(@data-rbd-draggable-id,'stage-prod')]//div[@class='text-btn'][text()='Add New Job ']")
	WebElement addNewJobBtnUnderThirdStage;
	
	@FindBy(xpath = "//select[@name='task_type' and @class='select']")
	WebElement selectJobType;
	
	@FindBy(xpath = "//select[@name='env' and @class='select']")
	WebElement selectFromEnv;
	
	@FindBy(xpath = "//span[text()='automation-682046mu117xjpt']")
	WebElement serviceComponent;
	
	@FindBy(xpath = "//span[text()='automation-682046mu117xjpt']")
	WebElement serviceComponent1;
	
	@FindBy(xpath = "//select[@name='artifact_source' and @class='select']")
	WebElement selectArtifact;
	
	@FindBy(xpath = "//select[@name='target_env' and @class='select']")
	WebElement targetEnv;
	
	@FindBy(xpath = "//button[contains(@class,'btn-save')]")
	WebElement saveWorkFlowBtn;
	
	@FindBy(xpath = "//p[text()='Services for the pipeline to run on']/..//div//span")
	WebElement servicesToRunList;
	
	public BuildPipeLinePage createBasicPipeline(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser,String jobType,String fromEnv,String jobType2,String toEnv,String ArtifactName,String jobType3,String ArtifactName2,String prodEnv, String pipelineName) {
		
//		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		
		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
//		String PipelineSearch = pipelineName;
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }
//		if (triggerTypeRadioBtn.getAttribute("value").equals("Manual"))
//			ui_click(triggerTypeRadioBtn, "Poc_QA triggerTypeRadioBtn");
//        ui_wait(2);
//        ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        		//.click();        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(validatePipelineName, Pause.MEDIUM));
        String validatePipelineNameActual = validatePipelineName.getText().trim();
        Assert.assertEquals(validatePipelineNameActual, pipelineName);
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
		
		// adds first stage
		
        ui_click(addNewStageToPipeline, "adds first stage"); 
		ui_IsElementDisplay(ui_waitForElementToDisplay(stageName, Pause.MEDIUM));
        ui_setvalue(stageName, "sets first stage name", StageName1);
        ui_wait(5);
        ui_click(addStageBtn, "adds button for first stage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtn, Pause.MEDIUM));
		
		// adds build job to dev
		
        ui_click(addNewJobBtn, "clicks on new job");  
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
		Select dropdown1 = new Select(selectJobType);
		dropdown1.selectByVisibleText(jobType);
		Select dropdown2 = new Select(selectFromEnv);
		dropdown2.selectByVisibleText(fromEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
		ui_click(serviceComponent, "selects service component under the env");
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtn, Pause.MEDIUM));
        ui_click(addNewJobBtn, "clicks on new job"); 
        
        // adds deploy job to dev
        
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
		Select dropdown3 = new Select(selectJobType);
		dropdown3.selectByVisibleText(jobType2);
		Select dropdown4 = new Select(selectFromEnv);
		dropdown4.selectByVisibleText(fromEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
		ui_click(serviceComponent1, "selects service component under the env");
		Select dropdown5 = new Select(selectArtifact);
		dropdown5.selectByVisibleText(ArtifactName);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
        ui_click(addNewStageToPipeline, "adds second stage"); 
        
        // adds second stage
        
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(stageName, Pause.MEDIUM));
        ui_setvalue(stageName, "sets first stage name", StageName2);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job"); 
        
        // adds promote job from dev
        
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
		Select dropdown6 = new Select(selectJobType);
		dropdown6.selectByVisibleText(jobType3);
		Select dropdown7 = new Select(selectFromEnv);
		dropdown7.selectByVisibleText(fromEnv);
		ui_wait(3);
		//ui_IsElementDisplay(ui_waitForElementToDisplay(targetEnv, Pause.MEDIUM));
		Select dropdown8 = new Select(targetEnv);
		dropdown8.selectByVisibleText(toEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
		ui_click(serviceComponent, "selects service component under the env");
		Select dropdown9 = new Select(selectArtifact);
		dropdown9.selectByVisibleText(ArtifactName2);
        ui_click(addStageBtn, "adds button for second stage");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
//        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job"); // adds build job to qa
//		Select dropdown10 = new Select(selectJobType);
//		dropdown10.selectByVisibleText(jobType);
//		Select dropdown11 = new Select(selectFromEnv);
//		dropdown11.selectByVisibleText(toEnv);
//		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
//		ui_click(serviceComponent, "selects service component under the env");
//		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job"); 
        
        // adds deploy job to qa
        
        ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
        ui_wait(5);
		Select dropdown12 = new Select(selectJobType);
		dropdown12.selectByVisibleText(jobType2);
		Select dropdown13 = new Select(selectFromEnv);
		dropdown13.selectByVisibleText(toEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
		ui_click(serviceComponent1, "selects service component under the env");
		Select dropdown14 = new Select(selectArtifact);
		dropdown14.selectByVisibleText(ArtifactName2);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
        ui_click(addNewStageToPipeline, "adds third stage"); 
        
        // adds third stage
        
        ui_setvalue(stageName, "sets first stage name", StageName3);
        ui_wait(5);
        ui_click(addStageBtn, "adds button for third stage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderThirdStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderThirdStage, "clicks on new job");
        
        // adds promote job from qa
        
        ui_wait(5);
		Select dropdown15 = new Select(selectJobType);
		dropdown15.selectByVisibleText(jobType3);
		Select dropdown16 = new Select(selectFromEnv);
		dropdown16.selectByVisibleText(toEnv);
//		ui_IsElementDisplay(ui_waitForElementToDisplay(targetEnv, Pause.MEDIUM));
		ui_wait(5);
		Select dropdown17 = new Select(targetEnv);
		dropdown17.selectByVisibleText(prodEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
		ui_click(serviceComponent1, "selects service component under the env");
		Select dropdown18 = new Select(selectArtifact);
		dropdown18.selectByVisibleText(ArtifactName2);
		ui_click(addStageBtn, "clicks add stage btn");

		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderThirdStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderThirdStage, "clicks on new job");
        
        // adds deploy job to prod
        
        ui_wait(5);
		Select dropdown21 = new Select(selectJobType);
		dropdown21.selectByVisibleText(jobType2);
		Select dropdown22 = new Select(selectFromEnv);
		dropdown22.selectByVisibleText(prodEnv);
		ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
		ui_click(serviceComponent, "selects service component under the env");
		Select dropdown19 = new Select(selectArtifact);
		dropdown19.selectByVisibleText(ArtifactName2);
		ui_click(addStageBtn, "clicks add stage btn");
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveWorkFlowBtn, Pause.MEDIUM));
        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
        ui_wait(10);
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
        ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, pipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_wait(10);
		String validateStatusActual = pipelineStatus.getText().trim();
        Assert.assertEquals(validateStatusActual, "IN USE");
        Assert.assertEquals(servicesToRunList.getText().trim(), "automation-682046mu117xjpt");
        ui_click(pipelineHyperLink, "clicks on pipeline hyperlink");
        ui_click(editPipelineInfo, "clicks on edit pipeline info");
		ui_IsElementDisplay(ui_waitForElementToDisplay(basicInfoText, Pause.MEDIUM));
        Assert.assertEquals(basicInfoText.getText().trim(), "Basic Info");
        ui_click(closeEditTile, "clicks on close pipeline info");
        ui_wait(6);
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
        ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, pipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_wait(6);		
		ui_IsElementDisplay(ui_waitForElementToDisplay(executePipeLineButton, Pause.MEDIUM));
		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_click(executePipeLineButton, "pipeline execution Start");
//		ui_wait(2);
//		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_wait(8);
		ui_IsElementDisplay(ui_waitForElementToDisplay(pipelineHyperLink, Pause.MEDIUM));
		ui_click(pipelineHyperLink, "clicks pipeline hyperlink");
		ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
		ui_click(viewLogsLink, "Poc_QA click on View Logs");
		ui_switchToNewWindow();

		}
		return this;
	}	
//RK	
	@FindBy(xpath = "//input[@name='cron_regex' and @placeholder='Enter cron pattern only']")
	WebElement chronPattern;
	@FindBy(xpath = "//input[@name='cron_regex' and @placeholder='Enter cron pattern only' ]/following-sibling::div[@class='error-message']")
	WebElement chronPatternErrorMessage;
	@FindBy(xpath = "//span[@title='Edit Pipeline']/a")
	WebElement editSearchedpipeline;
	@FindBy(xpath = "//input[@name='manual_deploy_tag_select']/following-sibling::span[2]")
	WebElement tagformanualdeploy;
	@FindBy(xpath = "//input[@name='on_success_exit']/following-sibling::span[2]")
	WebElement terminatePipelineOnSuccess;
	@FindBy(xpath = "//input[@name='on_failure_exit']/following-sibling::span[2]")
	WebElement terminatePipelineOnFailure;
	@FindBy(xpath = "//input[@name='no_cache']/following-sibling::span[2]")
	WebElement noCache;
	@FindBy(xpath = "//input[@name='skip_task']/following-sibling::span[2]")
	WebElement skipJob;
	@FindBy(xpath = "//input[@name='mark_success_upon_skip']/following-sibling::span[2]")
	WebElement successUponSkip;
	@FindBy(xpath = "//input[@name='latest_enable']/following-sibling::span[2]")
	WebElement duplicateImage;
	@FindBy(xpath = "//input[@name='deployment_status_check']/following-sibling::span[2]")
	WebElement validateDeploymentSuccess;
	@FindBy(xpath = "//input[@name='is_linked_issue']/following-sibling::span[2]")
	WebElement mapJira;
	@FindBy(xpath = "//input[@name='open']/following-sibling::span[2]")
	WebElement conditionalRule;
	@FindBy(xpath = "//span[text()='Add Conditions']")
	WebElement addConditionButton;
	@FindBy(xpath = "//select[@name='condition_key']")
	WebElement conditionkeyDropdown;
	@FindBy(xpath = "//select[@name='condition_key']/option")
	List<WebElement> conditionkeyDropdownOption;
	@FindBy(xpath = "//button[@class='btn btn-with-icon btn-save']")
	WebElement conditionkeySaveButton;
	@FindBy(xpath = "//select[@name='operation']")
	WebElement jiraoperation;
	@FindBy(xpath = "//select[@name='issuetype']")
	WebElement issuetype;
	@FindBy(xpath = "//input[@name='issue_name']")
	WebElement issuename;
	@FindBy(xpath = "//input[@name='summary']")
	WebElement summary;	
	@FindBy(xpath = "//select[@name='issue_key']")
	WebElement issueKey;
	@FindBy(xpath = "//select[@name='status']")
	WebElement jiraStatus;
	@FindBy(xpath = "//input[@name='comment']")
	WebElement jiraComment;
	
	@FindBy(xpath = "//select[@name='method']")
	WebElement apiMethodDropdown;
	@FindBy(xpath = "//select[@name='rollback_version']")
	WebElement rollbackVersionDropdown;
	@FindBy(xpath = "//input[@name='url']")
	WebElement apiURL;
	@FindBy(xpath = "//input[@name='headers_key_value_pairs']")
	WebElement apiJSON;
	@FindBy(xpath = "//input[@name='request_timeout']")
	WebElement apirequesttimeout;
	@FindBy(xpath = "//input[@name='pipeline_suspend']/following-sibling::span[2]")
	WebElement suspandPipeline;
	@FindBy(xpath = "//input[@name='response_update_context_param']/following-sibling::span[2]")
	WebElement responseupdate_context_param;
	@FindBy(xpath = "//input[@name='cron_regex' and @placeholder='In minutes']")
	WebElement frequencySCMPipeline;
	
	public BuildPipeLinePage AddNewJobButtonClick()
	{
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtn, Pause.MEDIUM));
        ui_click(addNewJobBtn, "clicks on new job"); 
		return this;
	}
	public BuildPipeLinePage AddNewJobButtonClickUnderSecondStage()
	{
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderSecondStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderSecondStage, "clicks on new job");
		return this;
	}	
	public BuildPipeLinePage AddNewJobButtonClickUnderThirdStage()
	{
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtnUnderThirdStage, Pause.MEDIUM));
        ui_click(addNewJobBtnUnderThirdStage, "clicks on new job");
		return this;
	}	
	public BuildPipeLinePage AddNewStage(String StageName)
	{
		  ui_IsElementDisplay(ui_waitForElementToDisplay(addNewStageToPipeline, Pause.MEDIUM));
	        ui_click(addNewStageToPipeline, "adds second stage"); 
			ui_click(addStageBtn, "clicks add stage btn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(stageName, Pause.MEDIUM));
	        ui_setvalue(stageName, "sets first stage name", StageName);
			ui_click(addStageBtn, "clicks add stage btn");
		return this;
	}	
	
public BuildPipeLinePage createBuildJob(String JobType,String fromEnv,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean NoCache,Boolean SkipJob,Boolean SuccessUponSkip,Boolean DuplicateImage ) {
	 

	// adds build job to dev		
    ui_click(addNewJobBtn, "clicks on new job");  
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown1 = new Select(selectJobType);
	dropdown1.selectByVisibleText(JobType);
	Select dropdown2 = new Select(selectFromEnv);
	dropdown2.selectByVisibleText(fromEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
	ui_click(serviceComponent, "selects service component under the env");
	
	if(ConditionRuleSelectorNot.equals(true))
	{
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	Select conditionaldropdown1 = new Select(conditionkeyDropdown);
	conditionaldropdown1.selectByIndex(2);
	}
	else {
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	    //Verify no Condition Rule seen 
	Assert.assertTrue(conditionkeyDropdownOption.size()==1);
	   // ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(NoCache.equals(true)) {
		ui_click(noCache, "terminatePipelineOnSuccess");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "terminatePipelineOnSuccess");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "terminatePipelineOnSuccess");	
	}
	if(DuplicateImage.equals(true)) {
		ui_click(duplicateImage, "terminatePipelineOnSuccess");	
	}    
	ui_click(addStageBtn, "clicks add stage btn");			
		return this;
	}
public BuildPipeLinePage createDeployJob(String jobType2,String fromEnv,String ArtifactName,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean SkipJob,Boolean SuccessUponSkip,Boolean ValidateDeploymentSuccess ) {
	 

	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown3 = new Select(selectJobType);
	dropdown3.selectByVisibleText(jobType2);
	Select dropdown4 = new Select(selectFromEnv);
	dropdown4.selectByVisibleText(fromEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent1, Pause.MEDIUM));
	ui_click(serviceComponent1, "selects service component under the env");
	ui_wait(3);
	Select dropdown5 = new Select(selectArtifact);
	dropdown5.selectByVisibleText(ArtifactName);
	
    if(ConditionRuleSelectorNot.equals(true))
 	{
 	ui_click(conditionalRule, "conditionalRule");
 	ui_click(addConditionButton, "addConditionButton");
 	Select conditionaldropdown1 = new Select(conditionkeyDropdown);
 	conditionaldropdown1.selectByIndex(2);
 	}
 	else {
 	ui_click(conditionalRule, "conditionalRule");
 	ui_click(addConditionButton, "addConditionButton");
 	    //Verify no Condition Rule seen 
 	Assert.assertTrue(conditionkeyDropdownOption.size()==1);
 	   // ui_click(conditionkeySaveButton, "conditionkeySaveButton");
 	}
 	if(TerminatePipelineOnSuccess.equals(true)) {
 		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
 	}
 	if(SkipJob.equals(true)) {
 		ui_click(skipJob, "terminatePipelineOnSuccess");	
 	}
 	if(SuccessUponSkip.equals(true)) {
 		ui_click(successUponSkip, "terminatePipelineOnSuccess");	
 	}
 	if(ValidateDeploymentSuccess.equals(true)) {
 		ui_click(validateDeploymentSuccess, "terminatePipelineOnSuccess");	
 	}    

	ui_click(addStageBtn, "clicks add stage btn");
    ui_wait(3);
    return this;
	}
public BuildPipeLinePage createPromoteJob(String jobType3,String fromEnv,String toEnv,String ArtifactName2,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean SkipJob,Boolean SuccessUponSkip) {
	
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown6 = new Select(selectJobType);
	dropdown6.selectByVisibleText(jobType3);
	Select dropdown7 = new Select(selectFromEnv);
	dropdown7.selectByVisibleText(fromEnv);
	ui_wait(3);
	ui_IsElementDisplay(ui_waitForElementToDisplay(targetEnv, Pause.MEDIUM));
	Select dropdown8 = new Select(targetEnv);
	dropdown8.selectByVisibleText(toEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
	ui_click(serviceComponent, "selects service component under the env");
	Select dropdown9 = new Select(selectArtifact);
	dropdown9.selectByVisibleText(ArtifactName2);    
	if(ConditionRuleSelectorNot.equals(true))
	{
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		Select conditionaldropdown1 = new Select(conditionkeyDropdown);
		conditionaldropdown1.selectByIndex(2);
	}
	else {
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		//Verify no Condition Rule seen 
		Assert.assertTrue(conditionkeyDropdownOption.size()==1);
		// ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "terminatePipelineOnSuccess");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "terminatePipelineOnSuccess");	
	}
	ui_click(addStageBtn, "clicks add stage btn");
	ui_wait(3);
	return this;
}

public BuildPipeLinePage createAPIJob(String jobType,String Method,String URL,String JSON,String Timeout,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean SkipJob,Boolean SuccessUponSkip,Boolean SuspendPipeline,Boolean UpdateContextparameter) {
	
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown = new Select(selectJobType);
	dropdown.selectByVisibleText(jobType);
	Select dropdown1 = new Select(apiMethodDropdown);
	dropdown1.selectByVisibleText(Method);
	ui_setvalue(apiURL, "apiURL", URL);
	ui_setvalue(apiJSON, "apiURL", JSON);
	ui_setvalue(apirequesttimeout, "apiURL", Timeout);
	if(ConditionRuleSelectorNot.equals(true))
	{
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		Select conditionaldropdown1 = new Select(conditionkeyDropdown);
		conditionaldropdown1.selectByIndex(2);
	}
	else {
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		//Verify no Condition Rule seen 
		Assert.assertTrue(conditionkeyDropdownOption.size()==1);
		// ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "terminatePipelineOnSuccess");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "terminatePipelineOnSuccess");	
	}
	if(SuspendPipeline.equals(true)) {
		ui_click(suspandPipeline, "suspandPipeline");	
	}
	if(UpdateContextparameter.equals(true)) {
		ui_click(responseupdate_context_param, "suspandPipeline");	
	}
	ui_click(addStageBtn, "clicks add stage btn");
	ui_wait(3);
	return this;
}

public BuildPipeLinePage createRollbackJob(String jobType,String fromEnv,String RollbackVersion,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean SkipJob,Boolean SuccessUponSkip) {
	
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown = new Select(selectJobType);
	dropdown.selectByVisibleText(jobType);
	Select dropdown2 = new Select(selectFromEnv);
	dropdown2.selectByVisibleText(fromEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
	ui_click(serviceComponent, "selects service component under the env");
	Select dropdown1 = new Select(rollbackVersionDropdown);
	dropdown1.selectByVisibleText(RollbackVersion);
	if(ConditionRuleSelectorNot.equals(true))
	{
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		Select conditionaldropdown1 = new Select(conditionkeyDropdown);
		conditionaldropdown1.selectByIndex(2);
	}
	else {
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		//Verify no Condition Rule seen 
		Assert.assertTrue(conditionkeyDropdownOption.size()==1);
		// ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "terminatePipelineOnSuccess");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "terminatePipelineOnSuccess");	
	}
	ui_ActionMoveAndClick(addStageBtn, "clicks add stage btn");
	ui_wait(3);
	return this;
}

public BuildPipeLinePage createConfigMapJob(String JobType,String fromEnv,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean NoCache,Boolean SkipJob,Boolean SuccessUponSkip,Boolean DuplicateImage ) {
	 
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown1 = new Select(selectJobType);
	dropdown1.selectByVisibleText(JobType);
	Select dropdown2 = new Select(selectFromEnv);
	dropdown2.selectByVisibleText(fromEnv);
	System.out.println("------"+fromEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
	ui_click(serviceComponent, "selects service component under the env");
	
	if(ConditionRuleSelectorNot.equals(true))
	{
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	Select conditionaldropdown1 = new Select(conditionkeyDropdown);
	conditionaldropdown1.selectByIndex(2);
	}
	else {
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	    //Verify no Condition Rule seen 
	Assert.assertTrue(conditionkeyDropdownOption.size()==1);
	   // ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(NoCache.equals(true)) {
		ui_click(noCache, "noCache");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "skipJob");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "successUponSkip");	
	}
	if(DuplicateImage.equals(true)) {
		ui_click(duplicateImage, "duplicateImage");	
	}    
	ui_click(addStageBtn, "clicks add stage btn");			
		return this;
	}

public BuildPipeLinePage createDeploySecretsJob(String JobType,String fromEnv,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean NoCache,Boolean SkipJob,Boolean SuccessUponSkip,Boolean DuplicateImage ) {
	 	
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown1 = new Select(selectJobType);
	dropdown1.selectByVisibleText(JobType);
	Select dropdown2 = new Select(selectFromEnv);
	dropdown2.selectByVisibleText(fromEnv);
	System.out.println("------"+fromEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
	ui_click(serviceComponent, "selects service component under the env");
	
	if(ConditionRuleSelectorNot.equals(true))
	{
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	Select conditionaldropdown1 = new Select(conditionkeyDropdown);
	conditionaldropdown1.selectByIndex(2);
	}
	else {
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	    //Verify no Condition Rule seen 
	Assert.assertTrue(conditionkeyDropdownOption.size()==1);
	   // ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(NoCache.equals(true)) {
		ui_click(noCache, "noCache");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "skipJob");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "successUponSkip");	
	}
	if(DuplicateImage.equals(true)) {
		ui_click(duplicateImage, "duplicateImage");	
	}    
	ui_click(addStageBtn, "clicks add stage btn");			
		
	return this;
	}

public BuildPipeLinePage createInegratedTestingJob(String JobType,String fromEnv,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean SkipJob,Boolean SuccessUponSkip) {
	 
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown1 = new Select(selectJobType);
	dropdown1.selectByVisibleText(JobType);
	Select dropdown2 = new Select(selectFromEnv);
	dropdown2.selectByVisibleText(fromEnv);
	System.out.println("------"+fromEnv);
	ui_IsElementDisplay(ui_waitForElementToDisplay(serviceComponent, Pause.MEDIUM));
	ui_click(serviceComponent, "selects service component under the env");
	
	if(ConditionRuleSelectorNot.equals(true))
	{
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	Select conditionaldropdown1 = new Select(conditionkeyDropdown);
	conditionaldropdown1.selectByIndex(2);
	}
	else {
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	    //Verify no Condition Rule seen 
	Assert.assertTrue(conditionkeyDropdownOption.size()==1);
	   // ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "skipJob");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "successUponSkip");	
	} 
	ui_click(addStageBtn, "clicks add stage btn");			
		return this;
	}
@FindBy(xpath = "//input[@name='suspend_pipeline']/following-sibling::span[2]")
WebElement suspendpipeline;
@FindBy(xpath = "//input[@name='pipelines']/..")
List<WebElement> pipelineList;
@FindBy(xpath = "//button[text()='Run With Parameters']")
WebElement runwithparameters;
@FindBy(xpath = "//input[@name='components']/..")
List<WebElement> runwithparameter_servicelist;
@FindBy(xpath = "//button[text()='Run Pipeline']")
WebElement runpipeline;
public BuildPipeLinePage createtriggerPipelineJob(String JobType,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean Suspendpipeline,Boolean SkipJob,Boolean SuccessUponSkip) {
 	
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select dropdown1 = new Select(selectJobType);
	dropdown1.selectByVisibleText(JobType);
	ui_IsElementDisplay(ui_waitForElementToDisplay(pipelineList.get(1), Pause.MEDIUM));
	ui_click(pipelineList.get(1), "selects service component under the env");
	
	if(ConditionRuleSelectorNot.equals(true))
	{
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	Select conditionaldropdown1 = new Select(conditionkeyDropdown);
	conditionaldropdown1.selectByIndex(2);
	}
	else {
	ui_click(conditionalRule, "conditionalRule");
	ui_click(addConditionButton, "addConditionButton");
	    //Verify no Condition Rule seen 
	Assert.assertTrue(conditionkeyDropdownOption.size()==1);
	   // ui_click(conditionkeySaveButton, "conditionkeySaveButton");
	}
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");	
	}
	if(Suspendpipeline.equals(true)) {
		ui_click(suspendpipeline, "suspendpipeline");	
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "skipJob");	
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "successUponSkip");	
	}   
	ui_click(addStageBtn, "clicks add stage btn");			
		
	return this;
	}

public BuildPipeLinePage runwithParameter() {
ui_click(runwithparameters, "Click on runwithparameters");
ui_click(runwithparameter_servicelist.get(1), "Click on runwithparameters ServiceList");
ui_click(runpipeline, "Click on runpipeline");
	
return this;
}


public BuildPipeLinePage createJiraJob(String JobType,String Jiraoperation,String Issuetype,String Issuename,String Summary,Boolean ConditionRuleSelectorNot,Boolean TerminatePipelineOnSuccess,Boolean SkipJob,Boolean SuccessUponSkip,Boolean MapJira ) {
	
	ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobType, Pause.MEDIUM));
	Select jobtypedropdown = new Select(selectJobType);
	jobtypedropdown.selectByVisibleText(JobType);
	
	ui_IsElementDisplay(ui_waitForElementToDisplay(jiraoperation, Pause.MEDIUM));
	Select jiraoperationdropdown = new Select(jiraoperation);
	jiraoperationdropdown.selectByVisibleText(Jiraoperation);
	if(Jiraoperation.equals("Create Ticket"))
	{
	ui_IsElementDisplay(ui_waitForElementToDisplay(issuetype, Pause.MEDIUM));
	Select issuetypedropdown = new Select(issuetype);
	issuetypedropdown.selectByVisibleText(Issuetype);
	ui_setvalue(issuename, "issuename", Issuename);
	ui_setvalue(summary, "issuename", Summary);
	
	if(TerminatePipelineOnSuccess.equals(true)) {
		ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");
	}
	if(SkipJob.equals(true)) {
		ui_click(skipJob, "skipJob");		  
	}
	if(SuccessUponSkip.equals(true)) {
		ui_click(successUponSkip, "successUponSkip");	  
	}
	if(MapJira.equals(true)) {
		ui_click(mapJira, "mapJira");  
	}
	}
	if(Jiraoperation.equals("Change Status")) {
		Select issuetypedropdown = new Select(issueKey);
		issuetypedropdown.selectByIndex(1);
		Select jiraStatusdropdown = new Select(jiraStatus);
		jiraStatusdropdown.selectByIndex(1);
		if(TerminatePipelineOnSuccess.equals(true)) {
			ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");
		}
		if(SkipJob.equals(true)) {
			ui_click(skipJob, "skipJob");		  
		}
		if(SuccessUponSkip.equals(true)) {
			ui_click(successUponSkip, "successUponSkip");	  
		}
		if(MapJira.equals(true)) {
			ui_click(mapJira, "mapJira");  
		}
	}
	if(Jiraoperation.equals("Add Comment"))
	{
		Select issuetypedropdown = new Select(issueKey);
		issuetypedropdown.selectByIndex(1);
		ui_setvalue(jiraComment, "jiraComment", "Jira Complete");
		
		if(TerminatePipelineOnSuccess.equals(true)) {
			ui_click(terminatePipelineOnSuccess, "terminatePipelineOnSuccess");
		}
		if(SkipJob.equals(true)) {
			ui_click(skipJob, "skipJob");		  
		}
		if(SuccessUponSkip.equals(true)) {
			ui_click(successUponSkip, "successUponSkip");	  
		}
		if(MapJira.equals(true)) {
			ui_click(mapJira, "mapJira");  
		}
	}
	
	if(ConditionRuleSelectorNot.equals(true)) {
		//Select conditional Rule
		ui_click(conditionalRule, "conditionalRule");
		ui_click(addConditionButton, "addConditionButton");
		Select conditionaldropdown1 = new Select(conditionkeyDropdown);
		conditionaldropdown1.selectByIndex(2);
	}	
	ui_ActionMoveAndClick(addStageBtn, "clicks add stage btn");
	ui_ActionClick(addStageBtn, "clicks add stage btn");
	ui_wait(4);
	
	return this;
}	

	
public BuildPipeLinePage createSchedulePipeline(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser,String jobType,String fromEnv,String jobType2,String toEnv,String ArtifactName,String jobType3,String ArtifactName2,String prodEnv) {
		
//		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		
		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", schedulepipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
//		String PipelineSearch = pipelineName;
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }
     	
        ui_wait(5);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        		//.click();        	}
        }
        ui_wait(5);
        //enter wrong chron Pattern and Verify error message
        ui_setvalue(chronPattern,"Chron Pattern","7787");
        ui_click(savePipeline, "clicks on save pipeline button");
        ui_IsElementDisplay(ui_waitForElementToDisplay(chronPatternErrorMessage, Pause.MEDIUM));
        ui_wait(2);
        ui_clearAndSetValue(chronPattern, "30 14 * * *");
        ui_click(tagformanualdeploy, "Click on Tag");
        ui_click(savePipeline, "clicks on save pipeline button");
        //Search Created Pipeline
        ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
        ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, schedulepipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_wait(10);
		//Validate Pipeline Status
		String validateStatus_Actual = pipelineStatus.getText().trim();
        Assert.assertEquals(validateStatus_Actual, "IN USE");
        //Edit Created pipeline
        ui_click(editSearchedpipeline, "clicks on edit pipeline Link");
        
		// adds first stage		
        ui_click(addNewStageToPipeline, "adds first stage"); 
		ui_IsElementDisplay(ui_waitForElementToDisplay(stageName, Pause.MEDIUM));
        ui_setvalue(stageName, "sets first stage name", StageName1);
        ui_wait(5);
        ui_click(addStageBtn, "adds button for first stage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(addNewJobBtn, Pause.MEDIUM));
		//ui_click(addNewJobBtn, "clicks on new job");  
		
		// adds build job to dev
		AddNewJobButtonClick();
		createBuildJob(jobType, fromEnv, false, true, true, true, true, true);
		
        // adds deploy job to dev
		AddNewJobButtonClick();
		createDeployJob(jobType2, fromEnv, ArtifactName, true, true, true, true, true);
		
      // adds Jira job to dev
		AddNewJobButtonClick();
        createJiraJob("Jira Ticket","Create Ticket","Task","Initiating production release for services","BDS-1",true,true,true,true,true);
	
        // adds second stage
        AddNewStage(StageName2);
        
        // adds promote job from dev
        AddNewJobButtonClickUnderSecondStage();
    	createPromoteJob(jobType3, fromEnv, toEnv, ArtifactName2, true, true, true, true);
		
        // adds deploy job to qa
    	AddNewJobButtonClickUnderSecondStage();
    	createPromoteJob(jobType3, fromEnv, toEnv, ArtifactName2, true, true, true, true);
        
        // adds third stage
    	ui_wait(5);
        AddNewStage(StageName3);
        AddNewJobButtonClickUnderThirdStage();
    	
        // adds promote job from qa
        createPromoteJob(jobType3, toEnv, prodEnv, ArtifactName2, true, true, true, true);
        
        // adds deploy job to prod
		AddNewJobButtonClickUnderThirdStage();
        ui_wait(5);
        createDeployJob(jobType2, prodEnv, ArtifactName, true, true, true, true, true);
			
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveWorkFlowBtn, Pause.MEDIUM));
        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
        ui_wait(6);
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
        ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, schedulepipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_wait(6);
		String validateStatusActual = pipelineStatus.getText().trim();
        Assert.assertEquals(validateStatusActual, "IN USE");
        Assert.assertEquals(servicesToRunList.getText().trim(), "automation-682046mu117xjpt");
        ui_click(schedulepipelineHyperLink, "clicks on pipeline hyperlink");
        ui_click(editPipelineInfo, "clicks on edit pipeline info");
		ui_IsElementDisplay(ui_waitForElementToDisplay(basicInfoText, Pause.MEDIUM));
        Assert.assertEquals(basicInfoText.getText().trim(), "Basic Info");
        ui_click(closeEditTile, "clicks on close pipeline info");
        ui_wait(6);
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
        ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, schedulepipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_wait(6);
		ui_IsElementDisplay(ui_waitForElementToDisplay(executePipeLineButton, Pause.MEDIUM));
		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_wait(2);
		ui_IsElementDisplay(ui_waitForElementToDisplay(schedulepipelineHyperLink, Pause.MEDIUM));
		ui_click(schedulepipelineHyperLink, "clicks pipeline hyperlink");
		ui_wait(2);
		ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
		ui_click(viewLogsLink, "Poc_QA click on View Logs");
		ui_switchToNewWindow();

		}
		return this;
	}	

public BuildPipeLinePage createSCMPollPipeline(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser,String jobType,String fromEnv,String jobType2,String toEnv,String ArtifactName,String jobType3,String ArtifactName2,String prodEnv) {
	
//	ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
//	ui_click(userMenuAppBar, "userMenuAppBar");		
//	ui_click(switchToUSer, "switching to user account");
	
	boolean projectSelection = false;
	ui_wait(5);
	ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
	for(WebElement element:poc_qaProjectLink) {
		if(element.getText().trim().equalsIgnoreCase(appName)) {
			element.click();
			projectSelection = true;
			break;
		}
	}
	if(projectSelection) {
	ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
	ui_click(continueBtn, "clicks on add pipeline button");
	ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName);
	Select dropdown = new Select(selectPipelineVersionDropdown);
	dropdown.selectByVisibleText(versionType);
	ui_clearAndSetValue(retentionCountField, retentionCount);
//	String PipelineSearch = pipelineName;
	
	
    for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
    	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
    		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
    		break;
    	}
    }
 	
    ui_wait(2);
    for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
    	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
    		
    		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
    	}
    		//.click();        	}
    }
    ui_wait(2);
    ui_setvalue(frequencySCMPipeline,"Frequency Pattern","3");
    ui_click(savePipeline, "clicks on save pipeline button");
    //Search Created Pipeline
    ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
    ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
	ui_clearAndSetValue(searchPipeLine, pipelineName);
	searchPipeLine.sendKeys(Keys.ENTER);
	ui_wait(10);
	//Validate Pipeline Status
	String validateStatus_Actual = pipelineStatus.getText().trim();
    Assert.assertEquals(validateStatus_Actual, "IN USE");
    //Edit Created pipeline
    ui_click(editSearchedpipeline, "clicks on edit pipeline Link");
    
	// adds first stage		
    AddNewStage(StageName1); 
	
	// adds build job to dev
	AddNewJobButtonClick();
	createAPIJob(jobType, "POST","http://122.160.30.218:17901//api/v1/user/login/","{\"email\":\"opstree@opstree.com\",\"password\":\"Opstree@12345\"}","30", false, true, true, true, true, true);
	ui_wait(4);
  // adds Jira job to dev
	AddNewJobButtonClick();
    createJiraJob("Jira Ticket","Create Ticket","Task","Initiating production release for services","BDS-1",true,true,true,true,true);
    ui_wait(4);
    AddNewJobButtonClick();
    createJiraJob("Jira Ticket","Add Comment","Task","Initiating production release for services","BDS-1",true,true,true,true,true);
    ui_wait(4);
    // adds second stage
    AddNewStage(StageName2);
    AddNewJobButtonClickUnderSecondStage();
    createRollbackJob("Rollback", fromEnv,"-1", true, true, true, true);
    AddNewJobButtonClickUnderSecondStage();
   createInegratedTestingJob("Integration Testing", fromEnv, true, true, true, true);
   
   AddNewStage(StageName3);
   AddNewJobButtonClickUnderThirdStage();
   createtriggerPipelineJob("Trigger Pipeline", true, true, true, true, true);

	
	
	
	ui_IsElementDisplay(ui_waitForElementToDisplay(saveWorkFlowBtn, Pause.MEDIUM));
    ui_click(saveWorkFlowBtn, "clicks save workflow btn");
    ui_wait(10);
	ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
    ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
	ui_clearAndSetValue(searchPipeLine, pipelineName);
	searchPipeLine.sendKeys(Keys.ENTER);
	ui_wait(10);
	String validateStatusActual = pipelineStatus.getText().trim();
    Assert.assertEquals(validateStatusActual, "IN USE");
    Assert.assertEquals(servicesToRunList.getText().trim(), "automation-682046mu117xjpt");
    ui_click(pipelineHyperLink, "clicks on pipeline hyperlink");
    ui_click(editPipelineInfo, "clicks on edit pipeline info");
	ui_IsElementDisplay(ui_waitForElementToDisplay(basicInfoText, Pause.MEDIUM));
    Assert.assertEquals(basicInfoText.getText().trim(), "Basic Info");
    ui_click(closeEditTile, "clicks on close pipeline info");
	ui_wait(5);
	ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
    ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
	ui_clearAndSetValue(searchPipeLine, pipelineName);
	searchPipeLine.sendKeys(Keys.ENTER);
	ui_wait(5);
//	ui_IsElementDisplay(ui_waitForElementToDisplay(executePipeLineButton, Pause.MEDIUM));
//	ui_click(executePipeLineButton, "pipeline execution Start");
//	ui_wait(2);
//	ui_IsElementDisplay(ui_waitForElementToDisplay(pipelineHyperLink, Pause.MEDIUM));
//	ui_click(pipelineHyperLink, "clicks pipeline hyperlink");
	//ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
	//ui_click(viewLogsLink, "Poc_QA click on View Logs");
	ui_switchToNewWindow();

	}
	return this;
}	

	/**
	 * 
	 */
	
	@FindBy(xpath = "//button[@aria-label='close']")
	WebElement closeEditTile;
	
	@FindBy(xpath = "//div[text()='Basic Info']")
	WebElement basicInfoText;
	
	@FindBy(xpath = "//button[text()='Edit Basic Info ']")
	WebElement editPipelineInfo;
	
	@FindBy(xpath = "//input[@name='name' and @placeholder='Name']")
	WebElement searchPipeLineInput;
	
	@FindBy(xpath = "//button[@class='btn btn-submit'][text()='Refresh']")
	WebElement refreshpipelinePage;

	@FindBy(xpath = "//a[contains(text(),'BasicPipeline')]")
	WebElement pipelineHyperLink;
	@FindBy(xpath = "//a[contains(text(),'SchedulePipeline')]")
	WebElement schedulepipelineHyperLink;
	
	public BuildPipeLinePage executeBasicPipeline(String appName,String pipelineNameArg) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLineInput, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLineInput, pipelineNameArg);
		searchPipeLineInput.sendKeys(Keys.ENTER);
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(executePipeLineButton, Pause.MEDIUM));
		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_wait(2);
//		ui_click(executePipeLineButton, "pipeline execution Start");
//		ui_wait(2);
//		ui_click(executePipeLineButton, "pipeline execution Start");
		ui_IsElementDisplay(ui_waitForElementToDisplay(pipelineHyperLink, Pause.MEDIUM));
		ui_click(pipelineHyperLink, "clicks pipeline hyperlink");
		ui_IsElementDisplay(ui_waitForElementToDisplay(viewLogsLink, Pause.MEDIUM));
		ui_click(viewLogsLink, "Poc_QA click on View Logs");
		ui_switchToNewWindow();
//		ui_IsElementDisplay(ui_waitForElementToDisplay(postHookExecutingSuccessLink, Pause.MEDIUM));
//		ui_click(postHookExecutingSuccessLink, "postHookExecuting click for Console Logs");
//		ui_wait(10);
//		List<String> consoleLogs = ui_getTextForElements("//div[@class='d-grid grid-temp-log-line']//span");
//		boolean status = consoleLogs.get(0).length()>0;
//		Reporter.log("Successful Validate the Console logs", status);
		}
		return this;
	}
	
	String PipelineYAMLFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testfiles\\upload\\UploadYAML\\JiraPipeline.yml";
	
	@FindBy(xpath = "//label[@for='file-input']//span[text()='upload']")
	WebElement uploadYAML;
	
	public BuildPipeLinePage createJiraPipeline(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser) {
		
		String pipelineName1 = "AdvanceJiraPipeline" + RandomStrings.generateRandomString(9);
//		String StageName1 = "dev" + RandomStrings.generateRandomString(7);
//		String StageName2 = "qa" + RandomStrings.generateRandomString(7);
//		String StageName3 = "prod" + RandomStrings.generateRandomString(7);
//		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
//		ui_click(userMenuAppBar, "userMenuAppBar");		
//		ui_click(switchToUSer, "switching to user account");
		
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
        ui_wait(5);
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName1);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);

        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }
//		if (triggerTypeRadioBtn.getAttribute("value").equals("Manual"))
//			ui_click(triggerTypeRadioBtn, "Poc_QA triggerTypeRadioBtn");
       // ui_wait(2);
        //ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(validatePipelineName, Pause.MEDIUM));
        String validatePipelineNameActual = validatePipelineName.getText().trim();
        Assert.assertEquals(validatePipelineNameActual, pipelineName1);
		ui_IsElementDisplay(ui_waitForElementToDisplay(uploadYAML, Pause.MEDIUM));
        ui_click(uploadYAML, "clicks on upload YAML");
		ui_wait(5);
		ui_FileUpload(Configuration.get("browser"), PipelineYAMLFilePath);
		ui_wait(15);
		ui_getUIDriver().switchTo().defaultContent();

        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
		}
		return this;
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-dismissible')]//p")
	WebElement errorMessage;
	
	public BuildPipeLinePage createBasicPipelineNegativeTest4(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser, String existingPipelineName) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", existingPipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
		
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }

       // ui_wait(2);
        //ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveWorkFlowBtn, Pause.MEDIUM));
        ui_click(saveWorkFlowBtn, "clicks save workflow btn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(errorMessage, Pause.MEDIUM));
		Assert.assertEquals("There are no jobs in this stage, No stage added", errorMessage.getText().trim());
		}
	    return this;
   }
	
	@FindBy(xpath = "//input[@name='retention_execution_count' and @placeholder='Retention Count' and @class='error']")
	WebElement errorMessage2;
	
	public BuildPipeLinePage createBasicPipelineNegativeTest5(String appName,String versionType,String retentionCount,String triggerType,ArrayList<String>pipelineUser) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(userMenuAppBar, Pause.MEDIUM));
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		ui_wait(4);
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_wait(4);
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
		ui_click(continueBtn, "clicks on add pipeline button");
		ui_setvalue(addNameToNewPipeline, "Gives unique name to pipeline", pipelineName);
		Select dropdown = new Select(selectPipelineVersionDropdown);
		dropdown.selectByVisibleText(versionType);
		ui_clearAndSetValue(retentionCountField, retentionCount);
		
		
		
        for (int i = 0; i < triggerTypeRadioBtn.size(); i++) {
        	if (triggerType.contains(triggerTypeRadioBtn.get(i).getAttribute("value").trim()) && !(MUIRadioButtonsChecked.get(i).getAttribute("class").contains("Mui-checked"))) {
        		ui_click(triggerTypeRadioBtn.get(i),"Selecting the Radio button named as -"+triggerTypeRadioBtn.get(i).getAttribute("value").trim());
        		break;
        	}
        }

        //ui_wait(2);
        //ui_MoveToElement(muiTypographyBody, "moving to muiTypographyBodyn");
       
        ui_wait(2);
        for (int i = 0; i < pipelineAssignUserRoleCheckbox.size(); i++) {
        	if (pipelineUser.contains(pipelineAssignUserRoleCheckbox.get(i).getAttribute("value").trim())) {
        		
        		ui_ActionMoveAndClick(pipelineAssignUserRoleCheckbox.get(i),"Clicking on radio Button-"+pipelineAssignUserRoleCheckbox.get(i));
        	}
        }
        ui_wait(2);
        ui_click(savePipeline, "clicks on save pipeline button");
		ui_IsElementDisplay(ui_waitForElementToDisplay(errorMessage2, Pause.MEDIUM));
		}
        return this;
	}
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-danger')]//span[contains(text(),'Manage Failures')]")
	WebElement manageFailurePopUp;
	
	public BuildPipeLinePage managePopupTest(String appName, String existingPipelineName) {
		ui_click(userMenuAppBar, "userMenuAppBar");		
		ui_click(switchToUSer, "switching to user account");
		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for(WebElement element:poc_qaProjectLink) {
			if(element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if(projectSelection) {
		ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(PipelineSubject, Pause.MEDIUM));
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
		ui_clearAndSetValue(searchPipeLine, existingPipelineName);
		searchPipeLine.sendKeys(Keys.ENTER);
		ui_click(pipeLineExecutionHistory, "view pipeline excution history");
		ui_IsElementDisplay(ui_waitForElementToDisplay(reExecutePipeLineBtn, Pause.MEDIUM));
		ui_click(reExecutePipeLineBtn, "view pipeline re-excution history");
//		ui_click(executePipeLineButton, "Poc_QA execution Start");
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(existingPipeLine, Pause.MEDIUM));
		ui_click(existingPipeLine, "Poc_QA execution Start");
		ui_IsElementDisplay(ui_waitForElementToDisplay(manageFailurePopUp, Pause.MEDIUM));
		ui_click(manageFailurePopUp, "manage Failure PopUp");
		
		}
		return this;
	}
	
	@FindBy(xpath = "//div[@class='service-name']/a")
	WebElement searchPipelinehyperlink;
	@FindBy(xpath = "//a[@title='view logs']/following-sibling::div[1]")
	List<WebElement> buildStatus;
	@FindBy(xpath = "//div[@class='service']")
	List<WebElement> serviceName;
	@FindBy(xpath = "//span[@class='tag-image border-bottom']")
	WebElement buildBranch;
	
	public BuildPipeLinePage FindStatusandBranch(String appName,String pipelinename) {
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
			ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
			searchPipeline(pipelinename);
			ui_click(searchPipelinehyperlink, "search Pipeline hyperlink");
			ui_wait(5);
			for(int i=0;i<jobdrops.size();i++) {
				ui_click(jobdrops.get(i), "Expend Job");
				ui_wait(2);
			}
//			for(int i=0;i<buildStatus.size();i++) {
//			 System.out.println(buildStatus.get(i).getText());
//				ui_wait(2);
//			}
			for(int i=0;i<jobdrops.size();i++) {
				System.out.println("--"+buildStatus.get(i).getText());
				System.out.println("------"+serviceName.get(i).getText());
				ui_wait(1);
				ui_click(jobdrops.get(i), "");
				ui_wait(2);
				System.out.println(buildBranch.getText());
			}
		}
		
		return this;
	}
	
	@FindBy(xpath = "//label[text()='Change Branch and tag']")
	WebElement changeBranchAndTag;

	@FindBy(xpath = "//select[@name='dev.demo-app.build.branch']")
	WebElement changeBranchDemoService;

	@FindBy(xpath = "//select[@name='dev.salary.build.branch']")
	WebElement changeBranchSalaryService;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBranch;
	
	@FindBy(xpath = "//a[text()='Preprod-pipeline']")
	WebElement pipelineHyp;
	
	@FindBy(xpath = "//div[@class='flaticon-expand-button']")
	List<WebElement> jobdrops;
	
	@FindBy(xpath = "//span[@class='tag-image border-bottom']")
	List<WebElement> branchOne;
	
	@FindBy(xpath = "//div[@class=' flaticon-thumb-up-button']")
	List<WebElement> thumbsUp;
	
	@FindBy(xpath = "//input[@name='comment']")
	WebElement inputCommentOne;
	
	@FindBy(xpath = "//button[text()='Approve']")
	WebElement buttonApprove;
	
	@FindBy(xpath = "//div[contains(@class,'green-text')]")
	List<WebElement> greenTextStatus;

	public BuildPipeLinePage RunPipelinePreProd(String appName, String PipelineName, String branchOne,
			String branchTwo) {

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

			// --------------------------------------Search for pipelinePreProd-------------------
			ui_click(pipelineOverviewLink, "Poc_QA pipelineOverviewLink");
			ui_wait(5);
			ui_IsElementDisplay(ui_waitForElementToDisplay(searchPipeLine, Pause.MEDIUM));
			ui_clearAndSetValue(searchPipeLine, PipelineName);
			searchPipeLine.sendKeys(Keys.ENTER);
			ui_click(runwithparameters, "Click on runwithparameters");
			ui_wait(2);

			// --------------------------------------Select Service one for change branch----------
			ui_click(runwithparameter_servicelist.get(2), "Click on runwithparameters ServiceList");
			ui_wait(5);
			Select dropdown = new Select(changeBranchDemoService);
			dropdown.selectByVisibleText(branchOne);
			ui_click(saveBranch, "Click on runwithparameters ServiceList");
			ui_wait(5);

			// --------------------------------------Select Service two for change branch-----------
			ui_click(runwithparameter_servicelist.get(5), "Click on runwithparameters ServiceList");
			ui_wait(5);
			Select dropdown2 = new Select(changeBranchSalaryService);
			dropdown2.selectByVisibleText(branchTwo);
			ui_click(saveBranch, "Click on runwithparameters ServiceList");
			ui_wait(5);
			
			// ---------------------------------------Manage Pop-up ---------------------------------
			ui_click(pipelineHyp, "Click on pipeline hyperlink");
			ui_click(jobdrops.get(1), "Click on jobDropOne");
			ui_wait(5);
			ui_click(jobdrops.get(1), "Click on jobDropOne");
			ui_wait(5);
			ui_click(jobdrops.get(1), "Click on jobDropOne");
			ui_wait(5);
			ui_IsElementDisplay(ui_waitForElementToDisplay(manageFailurePopUp, Pause.MEDIUM));
			ui_click(manageFailurePopUp, "manage Failure PopUp");
			//TODO
			ui_click(jobdrops.get(2), "Click on jobDropOne");
			ui_wait(5);
			ui_click(jobdrops.get(2), "Click on jobDropOne");
			ui_wait(5);
			
			// ---------------------------------------Jira Create ---------------------------------
			ui_click(thumbsUp.get(1), "Click on jobDropOne");
			ui_IsElementDisplay(ui_waitForElementToDisplay(inputCommentOne, Pause.MEDIUM));
			ui_clearAndSetValue(inputCommentOne, "Jira Auto Test Ticket is created");
			ui_click(buttonApprove, "Click on jobDropOne");
			ui_wait(5);
			ui_click(jobdrops.get(3), "Click on jobDropOne");
			ui_wait(5);
			ui_click(jobdrops.get(3), "Click on jobDropOne");
			//TODO
			ui_wait(5);
			ui_click(greenTextStatus.get(12), "Click on jobDropOne");
			
			// ---------------------------------------Jira Approval Question ----------------------
			ui_click(thumbsUp.get(2), "Click on jobDropOne");
		}
		return this;
	}

	
	public void fetchlogs(String baseurl,String Pipelinename) {
		  
		// String baseurl="http://122.160.30.218:17901";
		   //String Pipelinename="test_api_logs";
		   
		   //----------------------------------Login API----------------------
			RequestSpecification requestSpec=RestAssured.given();
			requestSpec.baseUri(baseurl);
			requestSpec.basePath("/api/v1/user/login/");
			JSONObject logincredential=new JSONObject();
			logincredential.put("email", "opstree@opstree.com");
			logincredential.put("password", "Opstree@12345");
			requestSpec.contentType(ContentType.JSON);
			requestSpec.body(logincredential.toJSONString());
			io.restassured.response.Response res=requestSpec.post();
			String body=res.getBody().asString();
			JsonPath jsonpath=new JsonPath(body);
			String access=jsonpath.get("access");
			Assert.assertEquals(res.getStatusCode(), 200);
			//System.out.println(res.getBody().asString());
			//System.out.println(res.getStatusCode());
			//System.out.println(access);
			
			
			//-----------------------------------Activity API----------------
			
			RequestSpecification requestSpec2=RestAssured.given();
			requestSpec2.baseUri(baseurl);
			requestSpec2.basePath("/api/v1/project/1/pipeline/recent/activity/").param("name", Pipelinename);
			requestSpec2
			       .header("Authorization","Bearer "+access)
			       .contentType(ContentType.JSON);
			
			io.restassured.response.Response res2=requestSpec2.get();
			String body2=res2.getBody().asString();
			
			JsonPath jsonpath2=new JsonPath(body2);
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> lasttrigger = new ArrayList<String>();
			id=jsonpath2.get("results.id");
			lasttrigger=jsonpath2.get("results.last_trigger.id");
			
			String StageinstanceidArray[]=id.toString().replace("[", "").replace("]", "").split(",");
			String lasttriggerArray[]=lasttrigger.toString().replace("[", "").replace("]", "").split(",");
			
			String triggerid=StageinstanceidArray[0];
			String stageid=lasttriggerArray[0];
			Assert.assertEquals(res2.getStatusCode(), 200);
			//System.out.println(res2.getStatusCode());
			//System.out.println(res2.getBody().asString());	
			//System.out.println("triggerid:"+triggerid);
			//System.out.println("stageid:"+stageid);
			
			
			//-----------------------------------Stage API-----------------------------------------
				RequestSpecification requestSpec3=RestAssured.given();
				requestSpec3.baseUri(baseurl);
				requestSpec3.basePath("/api/v1/pipeline/"+triggerid+"/trigger/"+stageid+"/stage/");
				requestSpec3
				       .header("Authorization","Bearer "+access)
				       .contentType(ContentType.JSON);
				
				io.restassured.response.Response res3=requestSpec3.get();
				String body3=res3.getBody().asString();
				
				JsonPath jsonpath3=new JsonPath(body3);
				ArrayList<String> stage_instanceid = new ArrayList<String>();
				ArrayList<String> task_instanceid = new ArrayList<String>();
				stage_instanceid=jsonpath3.get("stage_instance.id");
				task_instanceid=jsonpath3.get("stage_instance.task_instance.id");
				
				
				String taskidArray[]=stage_instanceid.toString().replace("[", "").replace("]", "").split(",");
				String task_instanceidArray[]=task_instanceid.toString().replace("[", "").replace("]", "").split(",");
				
				String taskid=taskidArray[0];
				String taskinstanceid=task_instanceidArray[0];
				Assert.assertEquals(res3.getStatusCode(), 200);
				//System.out.println(res3.getStatusCode());
				//System.out.println(res3.getBody().asString());	
				//System.out.println("taskid:"+taskid);
				//System.out.println("taskinstanceid:"+taskinstanceid);
				
			
			//--------------------------------------Task API--------------------------------------
			Integer task1=Integer.parseInt(taskinstanceid)+1;
			Integer task2=Integer.parseInt(taskinstanceid)+2;
			String[] ar1= {taskinstanceid,task1.toString(),task2.toString()};
			for(int t=0;t<ar1.length;t++) {	
			RequestSpecification requestSpec4=RestAssured.given();
			requestSpec4.baseUri(baseurl);
			requestSpec4.basePath("/api/v1/pipeline/"+triggerid+"/trigger/"+stageid+"/stage/"+taskid+"/task/"+ar1[t]+"/");
			requestSpec4
			       .header("Authorization","Bearer "+access)
			       .contentType(ContentType.JSON);
			
			io.restassured.response.Response res4=requestSpec4.get();
			String body4=res4.getBody().asString();
			
			JsonPath jsonpath4=new JsonPath(body4);
			ArrayList<String> global_task_id = new ArrayList<String>();
			global_task_id=jsonpath4.get("component_task_instance.information.global_task_id");
			String global_task_idArray[]=global_task_id.toString().replace("[", "").replace("]", "").split(",");
			
			String task_id=global_task_idArray[0];
			Assert.assertEquals(res4.getStatusCode(), 200);
			//System.out.println(res4.getStatusCode());
			//System.out.println(res4.getBody().asString());			
			//System.out.println("task_id:"+task_id);

			//-----------------------------------Logs API-----------------------------------------
				RequestSpecification requestSpec5=RestAssured.given();
				requestSpec5.baseUri(baseurl);
				requestSpec5.basePath("/api/v1/default/celery/task/status/").param("task_id", task_id);
				requestSpec5
				       .header("Authorization","Bearer "+access)
				       .contentType(ContentType.JSON);
				
				io.restassured.response.Response res5=requestSpec5.get();
				String body5=res5.getBody().asString();
				
				JsonPath jsonpath5=new JsonPath(body5);
				ArrayList<String> subtask = new ArrayList<String>();
				ArrayList<String> discription = new ArrayList<String>();
				subtask=jsonpath5.get("sub_task_status.activity_sub_task");
				discription=jsonpath5.get("sub_task_status.description");
				String subtaskArray[]=subtask.toString().replace("[", "").replace("]", "").split(",");
				String discriptionArray[]=discription.toString().replace("[", "").replace("]", "").split(",");
				Map<String, String> map	= new HashMap<String, String>();
				Assert.assertEquals(res5.getStatusCode(), 200);
				//System.out.println(res5.getStatusCode());
				for(int i=0;i<subtaskArray.length-1;i++) {
					String logs=subtaskArray[i];
					String logs_discription=discriptionArray[i];
					map.put(logs, logs_discription);
				}
				System.out.println(map);
				
				/*for (Map.Entry<String, String> entry : map.entrySet()) {
				   
				    if(entry.getKey().equals("Build Docker Image")) {
				    	Assert.assertEquals(entry.getValue(), "Successfully 6786786 cmd");
				    }
				    if(entry.getKey().equals("Pre Hooks Executing")) {
				    	Assert.assertEquals(entry.getValue(), "Successfully executed cmd");
				    }
				    if(entry.getKey().equals("Push docker image")) {
				    	Assert.assertEquals(entry.getValue(), "Successfully executed cmd");
				    }
				    if(entry.getKey().equals("Cloning Repository")) {
				    	Assert.assertEquals(entry.getValue(), "Successfully executed cmd");
				    }
				}*/
			}

		
			}

}
