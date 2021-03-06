package com.dqgb.common.test2QONE;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dqgb.common.response.ResponseData;

public class AssertDQGB {

	public static List<ErrorTestInformation> recordError(Long expectedResult, Long actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		return expectedResult != actualResult
				? recordError(String.valueOf(expectedResult), String.valueOf(actualResult), informations, methodName,
						classes)
				: informations;
	}

	public static List<ErrorTestInformation> recordError(double expectedResult, double actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		return expectedResult != actualResult
				? recordError(String.valueOf(expectedResult), String.valueOf(actualResult), informations, methodName,
						classes)
				: informations;
	}

	public static List<ErrorTestInformation> recordError(int expectedResult, int actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		return expectedResult != actualResult
				? recordError(String.valueOf(expectedResult), String.valueOf(actualResult), informations, methodName,
						classes)
				: informations;
	}

	public static List<ErrorTestInformation> recordError(float expectedResult, float actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		return expectedResult != actualResult
				? recordError(String.valueOf(expectedResult), String.valueOf(actualResult), informations, methodName,
						classes)
				: informations;
	}

	public static List<ErrorTestInformation> recordError(char expectedResult, char actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		return expectedResult != actualResult
				? recordError(String.valueOf(expectedResult), String.valueOf(actualResult), informations, methodName,
						classes)
				: informations;
	}

	public static List<ErrorTestInformation> recordError(boolean expectedResult, boolean actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		return expectedResult != actualResult
				? recordError(String.valueOf(expectedResult), String.valueOf(actualResult), informations, methodName,
						classes)
				: informations;
	}

	@SuppressWarnings("finally")
	public static List<ErrorTestInformation> recordError(ResponseData expectedResult, ResponseData actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		try {
			if (!(expectedResult.getRspCode().equals(actualResult.getRspCode())
					&& expectedResult.getRspMsg().equals(actualResult.getRspMsg())
					&& expectedResult.getData().equals(actualResult.getData()))) {
				informations = recordError(true, false, informations, methodName, classes);
			}
		} catch (Exception e) {
			informations = recordError(true, false, informations, methodName, classes);
		} finally {
			return informations;
		}
	}

	/**
	 * 
	 * @Title recordError
	 * @author :技术部-文章
	 * @Description 比对期待结果和实际结果，若不符合，则记录为错误信息，稍后发到QONE
	 * @date 2018年8月6日 下午3:26:47
	 * @param expectedResult
	 *            期待结果
	 * @param actualResult
	 *            实际结果
	 * @param informations
	 *            错误信息对象
	 * @param methodName
	 *            测试方法名称
	 * @param classes
	 *            测试类
	 * @return List<ErrorTestInformation>
	 */
	public static List<ErrorTestInformation> recordError(String expectedResult, String actualResult,
			List<ErrorTestInformation> informations, String methodName, Class classes) {
		if (!actualResult.equals(expectedResult)) {
			Map<String, String> map = getAnnotation(classes, methodName);
			if (null != map) {
				ErrorTestInformation errorInformation = new ErrorTestInformation();
				errorInformation.setUser(Integer.valueOf(map.get("user")));
				errorInformation.setTitle(map.get("title"));
				errorInformation.setContent(map.get("content"));
				errorInformation.setJobId(Integer.valueOf(map.get("jobId")));// 任务id
				errorInformation.setStage(Integer.valueOf(map.get("stage")));// 检出阶段
				errorInformation.setModulesId(Integer.valueOf(map.get("modulesId")));// 模板id
				errorInformation.setQualityReportId(Integer.valueOf(map.get("qualityReportId")));// 质量报告id
				errorInformation.setEnviroment("");// 环境
				errorInformation.setBugLevel(Integer.valueOf(map.get("bugLevel")));// bug级别
				errorInformation.setPriority(Integer.valueOf(map.get("priority")));// 优先级
				errorInformation.setSeverity(Integer.valueOf(map.get("severity")));// 严重程度
				errorInformation.setAdditionalInformation("");
				errorInformation.setOperateStep("");
				informations.add(errorInformation);
			}
		}
		return informations;
	}

	/**
	 * 
	 * @Title getAnnotation
	 * @author :技术部-文章
	 * @Description 获取测试方法上的注解信息
	 * @date 2018年8月6日 下午3:23:54
	 * @param classes
	 *            获得要调用的类
	 * @param methodName
	 *            测试方法名
	 * @return Map<String, String>：user-测试类编写人编码，title-方法主题，content-方法具体内容
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getAnnotation(Class classes, String methodName) {
		try {
			// 获得要调用的方法，output是要调用的方法名字，new Class[]{}为所需要的参数。空则不是这种
			Method method = classes.getMethod(methodName, new Class[] {});
			// 是否有类型为MyAnnotation的注解
			if (method.isAnnotationPresent(TestAnnotation.class)) {
				// 获得注解
				TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
				// 调用注解的内容
				Map<String, String> map = new HashMap<String, String>();
				map.put("user", annotation.user());// 方法编写人id
				map.put("title", annotation.title());// 标题
				map.put("content", annotation.content());// 方法内容
				map.put("jobId", annotation.jobId());// 任务id
				map.put("stage", annotation.stage());// 检出阶段
				map.put("modulesId", annotation.modulesId());// 模板id
				map.put("qualityReportId", annotation.qualityReportId());// 质量报告id
				map.put("enviroment", "");// 环境
				map.put("bugLevel", annotation.bugLevel());// bug级别
				map.put("priority", annotation.priority());// 优先级
				map.put("severity", annotation.severity());// 严重程度
				map.put("additionalInformation", "");// 附加信息
				map.put("operateStep", "");// 操作步骤
				return map;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
