package com.holley.emcp.model.ppf;

import java.util.HashMap;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;

public class TemplateData {

    private String       touser;
    private String       template_id;
    private String       url;
    private String       topcolor;
    private TemplateItem data;

    public static TemplateData New() {
        return new TemplateData();
    }

    private TemplateData() {
        this.data = new TemplateItem();
    }

    public String getTouser() {
        return touser;
    }

    public TemplateData setTouser(String touser) {
        this.touser = touser;
        return this;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public TemplateData setTemplate_id(String template_id) {
        this.template_id = template_id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public TemplateData setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public TemplateData setTopcolor(String topcolor) {
        this.topcolor = topcolor;
        return this;
    }

    public TemplateItem getData() {
        return data;
    }

    public TemplateData add(String key, String value, String color) {
        data.put(key, new Item(value, color));
        return this;
    }

    /**
     * 直接转化成jsonString
     * 
     * @return {String}
     */
    public String build() {
        return JSON.toJSONString(this);
    }

    public class TemplateItem extends HashMap<String, Item> {

        private static final long serialVersionUID = -3728490424738325020L;

        public TemplateItem() {
        }

        public TemplateItem(String key, Item item) {
            this.put(key, item);
        }
    }

    public class Item {

        private Object value;
        private String color;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Item(Object value, String color) {
            this.value = value;
            this.color = color;
        }
    }
}
