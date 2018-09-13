package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class DataFee extends PageBase {

	public DataFee(int totalProperty, int pageIndex, int limit) {
		super(totalProperty, pageIndex, limit);
	}

	private Integer arrearageUserCount;
	private List<FeeVo> datas;

	public Integer getArrearageUserCount() {
		return arrearageUserCount;
	}

	public void setArrearageUserCount(Integer arrearageUserCount) {
		this.arrearageUserCount = arrearageUserCount;
	}

	public List<FeeVo> getDatas() {
		return datas;
	}

	public void setDatas(List<FeeVo> datas) {
		this.datas = datas;
	}

}
