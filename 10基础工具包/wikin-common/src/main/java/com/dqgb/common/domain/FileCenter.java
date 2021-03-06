package com.dqgb.common.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件对象类
 * 
 * @author wenzhang
 *
 */
public class FileCenter implements Comparable {

	/**
	 * 主键ID，fastDFS返回的文件id
	 */
	@ApiModelProperty(value = "主键ID，fastDFS返回的文件id")
	private String id;

	/**
	 * 文件名称
	 */
	@ApiModelProperty(value = "文件名称")
	private String name;

	/**
	 * 文件类型
	 */
	@ApiModelProperty(value = "文件类型")
	private String type;

	/**
	 * 文件大小，默认kb为单位
	 */
	@ApiModelProperty(value = "文件大小，默认kb为单位")
	private String size;

	/**
	 * 文件上级目录id
	 */
	@ApiModelProperty(value = "文件上级目录id")
	private String catalogId;

	/**
	 * 文件下载次数
	 */
	@ApiModelProperty(value = "文件下载次数")
	private Integer downloadCount;

	/**
	 * 文件开始上传时间
	 */
	@ApiModelProperty(value = "文件开始上传时间")
	private Date uploadTimeStart;

	/**
	 * 文件上传结束时间
	 */
	@ApiModelProperty(value = "文件上传结束时间")
	private Date uploadTimeEnd;

	/**
	 * 文件最后一次修改时间
	 */
	@ApiModelProperty(value = "文件最后一次修改时间")
	private Date modifyTime;

	/**
	 * 文件创建人
	 */
	@ApiModelProperty(value = "文件创建人")
	private String createUser;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 是否允许删除
	 */
	@ApiModelProperty(value = "是否允许删除")
	private Integer isDeleted;

	/**
	 * 文件分类
	 */
	@ApiModelProperty(value = "文件分类")
	private String fileClassify;

	/**
	 * storage服务器组名
	 */
	@ApiModelProperty(value = "storage服务器组名")
	private String groupName;

	/**
	 * 按文件大小分类
	 */
	@ApiModelProperty(value = "按文件大小分类")
	private String sizeClassify;

	/**
	 * 文件描述
	 */
	@ApiModelProperty(value = "文件描述")
	private String description;

	/**
	 * 文件描述
	 */
	@ApiModelProperty(value = "业务id")
	private String businessId;

	/**
	 * 无参构造器
	 */
	public FileCenter() {
		super();
	}

	/**
	 * 有参构造器
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param size
	 * @param catalogId
	 * @param downloadCount
	 * @param uploadTimeStart
	 * @param uploadTimeEnd
	 * @param modifyTime
	 * @param createUser
	 * @param createTime
	 * @param isDeleted
	 * @param fileClassify
	 * @param groupName
	 * @param sizeClassify
	 * @param description
	 * @param businessId
	 */
	public FileCenter(String id, String name, String type, String size, String catalogId, Integer downloadCount,
			Date uploadTimeStart, Date uploadTimeEnd, Date modifyTime, String createUser, Date createTime,
			Integer isDeleted, String fileClassify, String groupName, String sizeClassify, String description,
			String businessId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.size = size;
		this.catalogId = catalogId;
		this.downloadCount = downloadCount;
		this.uploadTimeStart = uploadTimeStart;
		this.uploadTimeEnd = uploadTimeEnd;
		this.modifyTime = modifyTime;
		this.createUser = createUser;
		this.createTime = createTime;
		this.isDeleted = isDeleted;
		this.fileClassify = fileClassify;
		this.groupName = groupName;
		this.sizeClassify = sizeClassify;
		this.description = description;
		this.businessId = businessId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public Integer getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}

	public Date getUploadTimeStart() {
		return uploadTimeStart;
	}

	public void setUploadTimeStart(Date uploadTimeStart) {
		this.uploadTimeStart = uploadTimeStart;
	}

	public Date getUploadTimeEnd() {
		return uploadTimeEnd;
	}

	public void setUploadTimeEnd(Date uploadTimeEnd) {
		this.uploadTimeEnd = uploadTimeEnd;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getFileClassify() {
		return fileClassify;
	}

	public void setFileClassify(String fileClassify) {
		this.fileClassify = fileClassify;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSizeClassify() {
		return sizeClassify;
	}

	public void setSizeClassify(String sizeClassify) {
		this.sizeClassify = sizeClassify;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	@Override
	public String toString() {
		return "FileCenter [id=" + id + ", name=" + name + ", type=" + type + ", size=" + size + ", catalogId="
				+ catalogId + ", downloadCount=" + downloadCount + ", uploadTimeStart=" + uploadTimeStart
				+ ", uploadTimeEnd=" + uploadTimeEnd + ", modifyTime=" + modifyTime + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", isDeleted=" + isDeleted + ", fileClassify=" + fileClassify
				+ ", groupName=" + groupName + ", sizeClassify=" + sizeClassify + ", description=" + description
				+ ", businessId=" + businessId + "]";
	}

	@Override
	public int compareTo(Object o) {
		try {
			if (o instanceof FileCenter) {
				FileCenter emp = (FileCenter) o;
				// 按照时间排序
				if (emp.getCreateTime().getTime() > this.createTime.getTime()) {
					return 1;
				} else if (emp.getCreateTime().getTime() < this.createTime.getTime()) {
					return -1;
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			return 0;
		}
		throw new ClassCastException("对象不能转换为FileCenter对象...");
	}

}
