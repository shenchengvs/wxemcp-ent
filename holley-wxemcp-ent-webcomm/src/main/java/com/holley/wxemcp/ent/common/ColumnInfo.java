package com.holley.wxemcp.ent.common;

public class ColumnInfo {

    private int     id;
    private String  dataIndex;
    private String  header;
    private boolean hidden;
    private String  align = "right";

    public ColumnInfo() {

    }

    public ColumnInfo(String header, String dataIndex) {
        this.header = header;
        this.dataIndex = dataIndex;
    }

    public ColumnInfo(String header, String dataIndex, String align) {
        this.header = header;
        this.dataIndex = dataIndex;
        this.align = align;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

}
