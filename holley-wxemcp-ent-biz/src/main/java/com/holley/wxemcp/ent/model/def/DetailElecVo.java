package com.holley.wxemcp.ent.model.def;

import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthDetail;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRule;

public class DetailElecVo extends PpfCustomerFeeMonthDetail {
	private String pointname;
	private PpfPriceRule pricerule;
	private String ownername;

	public String getPointname() {
		return pointname;
	}

	public void setPointname(String pointname) {
		this.pointname = pointname;
	}

	public PpfPriceRule getPricerule() {
		return pricerule;
	}

	public void setPricerule(PpfPriceRule pricerule) {
		this.pricerule = pricerule;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

}
