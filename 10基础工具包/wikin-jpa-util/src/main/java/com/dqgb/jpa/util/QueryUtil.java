package com.dqgb.jpa.util;



import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件组装类,支持多个and条件连接查询
 *@className QueryUtil
 *@author :yangxi
 *@Description  
 *@date 2020年2月6日 下午12:38:41
 */
public class QueryUtil<T> implements Specification<T> {
    private static final long serialVersionUID = -1693502719868886705L;

    private List<Criterion> criterions = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (!criterions.isEmpty()) {
            List<Predicate> predicates = new ArrayList<>();
            for(Criterion c : criterions){
                predicates.add(c.toPredicate(root, query,builder));
            }
            // 将所有条件用 and 联合起来
            int size = predicates.size();
            if (size > 0) {
                return builder.and(predicates.toArray(new Predicate[size]));
            }
        }
        return builder.conjunction();
    }
    /**
     * 增加简单条件表达式
     */
    public QueryUtil<T> add(Criterion criterion){
        if(criterion!=null){
            criterions.add(criterion);
        }
        return this;
    }
}
