package com.dqgb.common.test2QONE;

public class ErrorTestInformation {

	private Integer user;// 方法编写人id

	private String content;// 方法内容

	private String enviroment;// 环境

	private Integer jobId;// 任务id

	private Integer bugLevel;// bug级别

	private Integer priority;// 优先级

	private Integer severity;// 严重程度

	private Integer stage;// 检出阶段

	private String additionalInformation;// 附加信息

	private Integer modulesId;// 模板id

	private String operateStep;// 操作步骤

	private Integer qualityReportId;// 质量报告id

	private String title;// 标题

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getBugLevel() {
		return bugLevel;
	}

	public void setBugLevel(Integer bugLevel) {
		this.bugLevel = bugLevel;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public Integer getModulesId() {
		return modulesId;
	}

	public void setModulesId(Integer modulesId) {
		this.modulesId = modulesId;
	}

	public String getOperateStep() {
		return operateStep;
	}

	public void setOperateStep(String operateStep) {
		this.operateStep = operateStep;
	}

	public Integer getQualityReportId() {
		return qualityReportId;
	}

	public void setQualityReportId(Integer qualityReportId) {
		this.qualityReportId = qualityReportId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ErrorTestInformation [user=" + user + ", content=" + content + ", enviroment=" + enviroment + ", jobId="
				+ jobId + ", bugLevel=" + bugLevel + ", priority=" + priority + ", severity=" + severity + ", stage="
				+ stage + ", additionalInformation=" + additionalInformation + ", modulesId=" + modulesId
				+ ", operateStep=" + operateStep + ", qualityReportId=" + qualityReportId + ", title=" + title + "]";
	}

}
