package com.holley.wxemcp.ent.model.def;

import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthDetailOther;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRuleOther;

public class DetailWaterVo extends PpfCustomerFeeMonthDetailOther {
	private String pointname;
	private PpfPriceRuleOther pricerule;
	private String ownername;
	
	public String getPointname() {
		return pointname;
	}

	public void setPointname(String pointname) {
		this.pointname = pointname;
	}

	public PpfPriceRuleOther getPricerule() {
		return pricerule;
	}

	public void setPricerule(PpfPriceRuleOther pricerule) {
		this.pricerule = pricerule;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
}
