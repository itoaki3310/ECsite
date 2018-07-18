package com.internousdev.leisurepass.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.leisurepass.util.CommonUtility;
import com.internousdev.leisurepass.util.SearchConditionLoader;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private String placeId;
	private String categoryId;
	private String placeName;
	private String categoryName;

	private Map<String, Object> session;

	public String execute() {


		if (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {
			// ログインしていない場合は一時的にユーザーIDをランダムで設定
			 CommonUtility commonUtility = new CommonUtility();
			 session.put("tempUserId", commonUtility.randomValue());
		}

		if(!session.containsKey("logined")) {
			// 未ログイン
			session.put("logined", 0);
		}

		SearchConditionLoader loader = new SearchConditionLoader();
		loader.execute(session);

		return SUCCESS;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}