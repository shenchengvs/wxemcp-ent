package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class DataReal extends PageBase {
	public DataReal(int totalProperty, int pageIndex, int limit) {
        super(totalProperty, pageIndex, limit);
    }

    private List<RealVo> datas;

	public List<RealVo> getDatas() {
		return datas;
	}

	public void setDatas(List<RealVo> datas) {
		this.datas = datas;
	}
    
}
