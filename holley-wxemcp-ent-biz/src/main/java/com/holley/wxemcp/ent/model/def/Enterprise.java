package com.holley.wxemcp.ent.model.def;

import com.holley.wxemcp.ent.common.constants.EnterpriseGradEnum;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;

public class Enterprise extends ObjEnterprise {

    private String cityname;
    private String businessname;
    private String gradeStr;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getGradeStr() {
        return gradeStr;
    }

    public void setGradeStr(String gradeStr) {
        this.gradeStr = gradeStr;
    }

    public String getGradeName() {
        Short grade = getGrade();
        return grade == null ? "" : EnterpriseGradEnum.getText(grade);
    }

}
