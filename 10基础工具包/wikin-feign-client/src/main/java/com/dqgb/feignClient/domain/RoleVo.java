package com.dqgb.feignClient.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :技术部-zhangjs
 * @className Role
 * @Description
 * @date 2019/9/30 11:08
 */
@Data
@Accessors(chain = true)
public class RoleVo {
    private String roleId;
    private String sortOrder="asc";
    private String sort="createTime";
    private String sortDerect="DESC";
    private String sortProperty="createTime";
    private String dir="ASC";
}
