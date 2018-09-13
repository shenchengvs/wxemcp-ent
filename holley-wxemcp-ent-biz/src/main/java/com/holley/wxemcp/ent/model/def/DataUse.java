package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class DataUse extends PageBase {

	public DataUse(int totalProperty, int pageIndex, int limit) {
		super(totalProperty, pageIndex, limit);
	}

	private Integer rtuCount;
	private Integer onlineRtuCount;
	private Integer pointCount;
	private Integer unRealCount;
	private List<UseVo> datas;

	public Integer getRtuCount() {
		return rtuCount;
	}

	public void setRtuCount(Integer rtuCount) {
		this.rtuCount = rtuCount;
	}

	public Integer getOnlineRtuCount() {
		return onlineRtuCount;
	}

	public void setOnlineRtuCount(Integer onlineRtuCount) {
		this.onlineRtuCount = onlineRtuCount;
	}

	public Integer getPointCount() {
		return pointCount;
	}

	public void setPointCount(Integer pointCount) {
		this.pointCount = pointCount;
	}

	public Integer getUnRealCount() {
		return unRealCount;
	}

	public void setUnRealCount(Integer unRealCount) {
		this.unRealCount = unRealCount;
	}

	public List<UseVo> getDatas() {
		return datas;
	}

	public void setDatas(List<UseVo> datas) {
		this.datas = datas;
	}

}
