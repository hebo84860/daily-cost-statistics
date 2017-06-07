package com.yeapoo.statistics.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 用户角色等级
 * @author hebo
 * @ date 2017-06-07
 */
public enum UserRole {

	DEFAULT("",""),          //空枚举
	ADMIN("0","管理员"),
	FIRST_DISTRIBUTION("1","一级分销商"),
	SECOND_DISTRIBUTION("2","二级分销商"),
	THIRD_DISTRIBUTION("3","三级分销商");

	private String code;
	private String cnName;

	UserRole(String code, String cnName){
		this.code = code;
		this.cnName = cnName;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getCnName() {
	    return cnName;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public static String getCnName(String code){
		for (UserRole bean : UserRole.values()) {
			if (bean.getCode().equals(code)) {
				return bean.cnName;
			}
		}
		return "";
	}

}

