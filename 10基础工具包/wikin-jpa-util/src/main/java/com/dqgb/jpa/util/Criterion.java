package com.dqgb.jpa.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
/**
 * 操作类型定义
 *@className Criterion
 *@author :yangxi
 *@Description  
 *@date 2020年2月6日 下午12:37:35
 */
public interface Criterion {
     enum Operator {
        EQ, NE, LIKE, GT, LT, GTE, LTE, IN, AND, OR
    }

     Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}