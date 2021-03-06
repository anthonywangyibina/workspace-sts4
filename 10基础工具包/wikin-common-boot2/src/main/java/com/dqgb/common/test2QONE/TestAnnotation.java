package com.dqgb.common.test2QONE;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @描述
 * @文件名:TestAnnotation.java
 * @版权:Copyright 2018 版权所有：大庆金桥信息技术工程有限公司成都分公司
 * @描述:编写每个测试方法上的注解，用于关联编写人、方法主题、方法内容
 * @修改人:技术部-文章
 * @修改时间:2018年8月3日 上午9:57:17
 * @修改内容:新增
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {

	public String user();// 方法编写人id

	public String title();// 标题

	public String content();// 描述

	public String jobId();// 任务id

	public String stage();// 检出阶段

	public String modulesId();// 模板id

	public String qualityReportId();// 质量报告id

	public String bugLevel();// bug级别

	public String priority();// 优先级

	public String severity();// 严重程度

}
