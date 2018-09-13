package com.holley.wxemcp.ent.model.def;

import java.util.List;

import com.holley.wxemcp.ent.model.obj.ObjSubeuu;

public class SubEuuFirst extends ObjSubeuu {
	private List<ObjSubeuu> childList;

	public List<ObjSubeuu> getChildList() {
		return childList;
	}

	public void setChildList(List<ObjSubeuu> childList) {
		this.childList = childList;
	}

}
