package com.dqgb.feignClient.domain;

import lombok.Data;

import java.util.Date;

/**
 * 文件基础信息
 *
 * @author :技术部-zhangjs
 * @className FileInfo
 * @Description
 * @date 2019/10/9 9:08
 */
@Data
//自动维护创建时间和修改时间
public class FileInfo {
	/**
	 * 文件id
	 * 
	 */
	private String id;

    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件后缀
     */
    private String extName;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件关联的业务Id
     */
    private String businessId;

    /**
     * fastDfs文件的组
     */
    private String fastDfsGroup;
    /**
     * 文件的父id
     */
    private String pid;
    /**
     * 文件在FastDFS中的id
     */
    private String path;
    /**
     * 系统编码
     */
    private String sysCode;
    /**
     * 系统名称
     */
    private String sysName;
    /**
     * 附件组id
     */
    private String attachGroupId;

    public FileInfo() {
    }

    public FileInfo(String name) {
        this.name = name;
    }

    public FileInfo(String name, String businessId) {
        this.name = name;
        this.businessId = businessId;
    }
}
