package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;
import java.util.List;

public class DataWaterDetail {
	private String hm;
	private String hh;
	private String phone;
	private String linkman;
	private String billTime;// yyyy-MM
	// 往月
	private BigDecimal ztFee;
	private BigDecimal fee;
	private BigDecimal usableMoney;
	// 当月
	private BigDecimal used;
	private BigDecimal total;
	private BigDecimal freeze;
	private BigDecimal usable;

	private List<DetailWaterVo> datas;

	public String getHm() {
		return hm;
	}

	public void setHm(String hm) {
		this.hm = hm;
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getBillTime() {
		return billTime;
	}

	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}

	public BigDecimal getZtFee() {
		return ztFee == null ? ztFee : ztFee.setScale(2);
	}

	public void setZtFee(BigDecimal ztFee) {
		this.ztFee = ztFee;
	}

	public BigDecimal getFee() {
		return fee == null ? fee : fee.setScale(2);
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getUsableMoney() {
		return usableMoney == null ? usableMoney : usableMoney.setScale(2);
	}

	public void setUsableMoney(BigDecimal usableMoney) {
		this.usableMoney = usableMoney;
	}

	public BigDecimal getUsed() {
		return used == null ? used : used.setScale(2);
	}

	public void setUsed(BigDecimal used) {
		this.used = used;
	}

	public BigDecimal getTotal() {
		return total == null ? total : total.setScale(2);
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getFreeze() {
		return freeze == null ? freeze : freeze.setScale(2);
	}

	public void setFreeze(BigDecimal freeze) {
		this.freeze = freeze;
	}

	public BigDecimal getUsable() {
		return usable == null ? usable : usable.setScale(2);
	}

	public void setUsable(BigDecimal usable) {
		this.usable = usable;
	}

	public List<DetailWaterVo> getDatas() {
		return datas;
	}

	public void setDatas(List<DetailWaterVo> datas) {
		this.datas = datas;
	}
}
