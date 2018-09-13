package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class DataQuery extends PageBase {

	public DataQuery(int totalProperty, int pageIndex, int limit) {
		super(totalProperty, pageIndex, limit);
	}
	
	private List<QueryVo> datas;

	public List<QueryVo> getDatas() {
		return datas;
	}

	public void setDatas(List<QueryVo> datas) {
		this.datas = datas;
	}
	
}
