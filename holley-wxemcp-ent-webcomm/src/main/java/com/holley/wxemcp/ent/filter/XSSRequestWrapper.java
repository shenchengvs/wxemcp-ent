package com.holley.wxemcp.ent.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    private static Pattern p1 = Pattern.compile("(.*?)", Pattern.CASE_INSENSITIVE);
    private static Pattern p2 = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern p3 = Pattern.compile("", Pattern.CASE_INSENSITIVE);
    private static Pattern p4 = Pattern.compile("", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern p5 = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern p6 = Pattern.compile("e­xpression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern p7 = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
    private static Pattern p8 = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
    private static Pattern p9 = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripXSS(values[i]);
        }
        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return stripXSS(value);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripXSS(value);
    }

    private String stripXSS(String value) {
        if (value != null) {
            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
            // avoid encoded attacks.
            // value = ESAPI.encoder().canonicalize(value);
            // Avoid null characters
            // value = value.replaceAll("", "");
            // Avoid anything between script tags
            value = p1.matcher(value).replaceAll("");
            // Avoid anything in a src="http://www.yihaomen.com/article/java/..." type of e­xpression
            value = p2.matcher(value).replaceAll("");
            // Remove any lonesome tag
            value = p3.matcher(value).replaceAll("");
            // Remove any lonesome tag
            value = p4.matcher(value).replaceAll("");
            // Avoid eval(...) e­xpressions
            value = p5.matcher(value).replaceAll("");
            // Avoid e­xpression(...) e­xpressions
            value = p6.matcher(value).replaceAll("");
            // Avoid javascript:... e­xpressions
            value = p7.matcher(value).replaceAll("");
            // Avoid vbscript:... e­xpressions
            value = p8.matcher(value).replaceAll("");
            // Avoid onload= e­xpressions
            value = p9.matcher(value).replaceAll("");
        }
        return value;
    }

    private String sqlValidate(String value) {
        if (value == null) {
            return value;
        }
        String temp = value;
        String[] badStrs = { "and", "exec" };
        // String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|"
        // + "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
        // "table|from|grant|use|group_concat|column_name|"
        // + "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
        // + "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加
        for (int i = 0; i < badStrs.length; i++) {
            Pattern scriptPattern = Pattern.compile(badStrs[i], Pattern.CASE_INSENSITIVE);
            Matcher m = scriptPattern.matcher(temp);
            if (m.find()) {
                temp = m.replaceAll("");
                break;
            }

        }

        return temp;
    }
}
