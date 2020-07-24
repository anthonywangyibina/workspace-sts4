package com.dqgb.jpa.util;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.*;

/**
 * 单一查询条件封装类
 *@className SimpleExpression
 *@author :yangxi
 *@Description  
 *@date 2020年2月6日 下午12:33:11
 */
@Data
public class SimpleExpression implements Criterion{

    private String fieldName;       //属性名
    private Object value;           //对应值
    private Operator operator;      //计算符

    protected SimpleExpression(String fieldName, Object value, Operator operator) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path expression;
        if(fieldName.contains(".")){
            String[] names = StringUtils.split(fieldName, ".");
            if(names==null) return null;
            expression = root.get(names[0]);
            for (int i = 1; i < names.length; i++) {
                expression = expression.get(names[i]);
            }
        }else{
            expression = root.get(fieldName);
        }
        switch (operator) {
            case EQ:
                return builder.equal(expression, value);
            case NE:
                return builder.notEqual(expression, value);
            case LIKE:
                return builder.like((Expression<String>) expression, "%" + value + "%");
            case LT:
                return builder.lessThan(expression, (Comparable) value);
            case GT:
                return builder.greaterThan(expression, (Comparable) value);
            case LTE:
                return builder.lessThanOrEqualTo(expression, (Comparable) value);
            case GTE:
                return builder.greaterThanOrEqualTo(expression, (Comparable) value);
            case IN:
            	String[] ids = value.toString().split(",");
            	List<String> idList = Arrays.asList(ids);
        		List<List<String>> lists = groupList(idList, 1000);
        		List<Predicate> cbList = new ArrayList<Predicate>();
        		lists.stream().forEach(idL -> cbList.add(builder.and(root.get(fieldName).in(idL))));
        		return builder.or(cbList.toArray(new Predicate[0]));
            default:
                return null;
        }
    }

    /*
   	 * List分割
   	 */
   	private  List<List<String>> groupList(List<String> list, int batchSize) {
   		List<List<String>> listGroup = new ArrayList<List<String>>();
   		int listSize = list.size();
   		// 子集合的长度
   		int toIndex = batchSize;
   		for (int i = 0; i < list.size(); i += batchSize) {
   			if (i + batchSize > listSize) {
   				toIndex = listSize - i;
   			}
   			List<String> newList = list.subList(i, i + toIndex);
   			listGroup.add(newList);
   		}
   		return listGroup;
   	}

}