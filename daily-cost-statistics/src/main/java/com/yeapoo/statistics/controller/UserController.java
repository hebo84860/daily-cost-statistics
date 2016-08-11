package com.yeapoo.statistics.controller;

import com.yeapoo.statistics.constant.CodeEnum;
import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.param.UpdatePasswordParam;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.service.IUserService;
import com.yeapoo.statistics.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	/**
	 * 跳转新增会员页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String addUser(){
		logger.info(" to add user start");
		return "user/add_user";
	}

	/**
	 * 跳转密码修改页
	 * @return
	 */
	@RequestMapping("/toModify")
	public String toModifyPassword(Model model){
		logger.info(" to modify password start");
		model.addAttribute("nav", ConstantEnum.MODIFY_PASSWORD.getCodeInt());
		return "user/modify_password";
	}
	/**
	 * 重置密码
	 * @return
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public String modifyPassword(HttpServletRequest request, @RequestBody UpdatePasswordParam param){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			logger.info("modify password start param = {}");
			if (StringUtils.isNotBlank(param.getUsername()) && StringUtils.isNotBlank(param.getNewPassword())
					&& StringUtils.isNotBlank(param.getOldPassword())){
				if (userService.isPasswordValid(param.getOldPassword(), param.getUsername())){
					UserEntity user = userService.getUserEntityByUserName(param.getUsername());
					if (user!=null){
						user.setPassword(param.getNewPassword());
						if (userService.updateUser(user)){
							request.getSession().removeAttribute("user");
							result.put("code", CodeEnum.SUCCESS.getCodeInt());
							result.put("msg", CodeEnum.SUCCESS.getValueStr());
						}else {
							result.put("code", CodeEnum.UPDATE_FAIL.getCodeInt());
							result.put("msg", CodeEnum.UPDATE_FAIL.getValueStr());
						}
					}
				}else {
					result.put("code", CodeEnum.ACCOUNT_PASSWORD_ERROR.getCodeInt());
					result.put("msg", CodeEnum.ACCOUNT_PASSWORD_ERROR.getValueStr());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", CodeEnum.SYSTEM_ERROR.getCodeInt());
			result.put("msg", CodeEnum.SYSTEM_ERROR.getValueStr());
		}
		logger.info("modify password end result = {}", result);
		return  JsonUtil.getJSONString(result);
	}

	/**
	 * 验证账号是否重复
	 * @return
	 */
	@RequestMapping("/ajaxValidUserNameRepeat")
	@ResponseBody
	public BaseSingleResponse ajaxValidUserNameRepeat(String username){
		BaseSingleResponse baseSingleResponse = new BaseSingleResponse();
		try {
			UserEntity userEntity = userService.getUserEntityByUserName(username);
			if (userEntity!=null){
				baseSingleResponse.setCode(CodeEnum.ACCOUNT_EXIST);
			}
		} catch (Exception e) {
			baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
			e.printStackTrace();
		}

		return baseSingleResponse;
	}

	/**
	 * 新增或修改会员
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Map<String, Object> save(String paramsJson){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			logger.info(" save start paramsJson={}",paramsJson);
			Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
			if (!paramsMap.containsKey("username") || !paramsMap.containsKey("password")){
				map.put("code", CodeEnum.PARAMS_ERROR.getCodeInt());
				map.put("msg", CodeEnum.PARAMS_ERROR.getValueStr());
				return map;
			}
			UserEntity user = userService.getUserEntityByUserName(paramsMap.get("username").toString());
			if (user!=null){
				map.put("code", CodeEnum.ACCOUNT_EXIST.getCodeInt());
				map.put("msg", CodeEnum.ACCOUNT_EXIST.getValueStr());
				return map;
			}
			UserEntity paramUser = getUserFromMap(paramsMap);
			if (userService.addUser(paramUser)){
				map.put("code", CodeEnum.SUCCESS.getCodeInt());
				map.put("msg", CodeEnum.SUCCESS.getValueStr());
			}else {
				map.put("code", CodeEnum.SAVE_FAIL.getCodeInt());
				map.put("msg", CodeEnum.SAVE_FAIL.getValueStr());
			}

		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", CodeEnum.SYSTEM_ERROR.getCodeInt());
			map.put("msg", CodeEnum.SYSTEM_ERROR.getValueStr());
		}
		logger.info("save user end result={}", map);
		return map;
	}

	private UserEntity getUserFromMap(Map<String, Object> paramsMap) {
		UserEntity user = new UserEntity();
		user.setUsername(paramsMap.get("username").toString());
		user.setPassword(paramsMap.get("password").toString());
		if (paramsMap.containsKey("email"))
			user.setEmail(paramsMap.get("email").toString());
		if (paramsMap.containsKey("realname"))
			user.setRealname(paramsMap.get("realname").toString());
		return user;
	}


}
