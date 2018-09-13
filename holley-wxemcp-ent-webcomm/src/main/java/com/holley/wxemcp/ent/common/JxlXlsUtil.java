package com.holley.wxemcp.ent.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import org.apache.commons.beanutils.BeanUtils;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.file.FileUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;

public class JxlXlsUtil {

    private boolean             encodingFileName = true;
    private String              encoding         = "UTF-8";
    private HttpServletRequest  request;
    private HttpServletResponse response;

    public JxlXlsUtil(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void downloadFile(String fileName) {
        downloadFile(fileName, -1);
    }

    public String encodeFileName(String fileName) {
        String agent = getRequest().getHeader("USER-AGENT");
        fileName = fileName.replaceAll("\n|\r", " ").trim();
        if (null != agent) {
            try {
                agent = agent.toUpperCase();
                if (agent.indexOf("MSIE") != -1) {
                    fileName = URLEncoder.encode(fileName, "UTF8");
                } else if (agent.indexOf("MOZILLA") != -1) {
                    fileName = new String((fileName).getBytes("utf-8"), "ISO8859-1");
                    // fileName = "=?UTF-8?B?" + (new String(BytesUtils.toBase64Chars(fileName.getBytes("UTF-8")))) +
                    // "?=";
                }
            } catch (UnsupportedEncodingException e) {
                // do nothing
            }
        }
        return fileName;
    }

    private void initAttachmentHeader() {
        getResponse().setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        getResponse().setHeader("Content-Type", "application/force-download");
        getResponse().setHeader("Content-Type", "application/octet-stream");
        getResponse().setHeader("Content-Type", "application/download");
        getResponse().setHeader("Cache-Control", "private, max-age=0, must-revalidate");
        getResponse().setHeader("Pragma", "public");
    }

    public void downloadFile(String fileName, long length) {
        initAttachmentHeader();
        if (isEncodingFileName()) {
            fileName = encodeFileName(fileName);
        }
        getResponse().setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        if (length >= 0) {
            getResponse().setHeader("Content-Length", String.valueOf(length));
        }
    }

    public List<ColumnInfo> parseColumnInfo(String columnId) {
        String columnInfoJsonString = getRequest().getParameter(columnId);
        List<ColumnInfo> columnInfoList = new LinkedList<ColumnInfo>();
        /*
         * JSONArray jsonArray = JSONArray.fromObject(columnInfoJsonString); JSONObject jsonObject; for (int i = 0; i <
         * jsonArray.size(); i++) { jsonObject = jsonArray.getJSONObject(i); ColumnInfo columnInfo = new ColumnInfo();
         * columnInfo.setDataIndex((String) jsonObject.get("dataIndex")); columnInfo.setHeader((String)
         * jsonObject.get("header")); columnInfo.setHidden((Boolean) jsonObject.get("hidden") == null ? false :
         * (Boolean) jsonObject.get("hidden")); columnInfoList.add(columnInfo); }
         */
        return columnInfoList;
    }

    public void exportXLS(List<?> data, Class<?> beanClass) throws IOException, WriteException {
        List<ColumnInfo> columnInfoList = parseColumnInfo("columnInfo");

        // String[] properiesName = new String[len];
        /*
         * String[] headsName = new String[len]; for (int i = 0; i < len; i++) { ColumnInfo colInfo = (ColumnInfo)
         * columnInfoList.get(i); properiesName[i] = colInfo.getDataIndex(); headsName[i] = colInfo.getHeader(); }
         */
        Field[] fields = beanClass.getDeclaredFields();
        int len = fields.length;
        String[] headsName = new String[len];
        String[] properiesName = new String[len];
        List flist = new ArrayList();
        for (int i = 0; i < len; i++) {
            headsName[i] = "" + i;
            properiesName[i] = fields[i].getName();
        }
        exportXLS(data, properiesName, headsName, beanClass);
    }

    /**
     * @param data
     * @param beanClass
     * @param aName
     * @param pName
     * @throws IOException
     * @throws WriteException 处理编码的转化如：0:否、1:是
     */
    public void exportXLS(List<?> data, Class<?> beanClass, String[] aName, String[] pName) throws IOException, WriteException {
        List<ColumnInfo> columnInfoList = parseColumnInfo("columnInfo");

        int len = columnInfoList.size();

        String[] properiesName = new String[len];
        String[] headsName = new String[len];
        for (int i = 0; i < len; i++) {
            ColumnInfo colInfo = (ColumnInfo) columnInfoList.get(i);
            String strPName = "";
            for (int j = 0; j < aName.length; j++) {
                if (aName[j].equals(colInfo.getDataIndex())) {
                    strPName = pName[j];
                    break;
                }
            }
            if ("".equals(strPName)) {
                properiesName[i] = colInfo.getDataIndex();
            } else {
                properiesName[i] = strPName;
            }
            headsName[i] = colInfo.getHeader();
        }

        exportXLS(data, properiesName, headsName, beanClass);
    }

    public void exportXLSfromMaps(List<?> data) throws IOException, WriteException {
        exportXLS(data, Map.class);
    }

    public void exportXLS(List<?> data, String[] properiesName, String[] headsName, Class<?> beanClass) throws IOException, WriteException {
        // String fileName = getRequest().getParameter("fileName");
        String fileName = DateUtil.DateToNosec10Str(new Date());

        if (getRequest().getParameter("fileName") != null) { // 可以后台修改文件名
            fileName = getRequest().getParameter("fileName") + "(" + fileName + ")";
        }
        downloadFile(fileName + ".xls");

        OutputStream out = getResponse().getOutputStream();
        AbstractXlsWriter xlsw = (AbstractXlsWriter) JxlXlsWriter.getInstance();

        // String title = (String) getRequest().getAttribute("title"); // 如果导出需要标题，可以设置reqeust
        String title = ""; // 如果导出需要标题，可以设置reqeust
        String exportType = (String) getRequest().getAttribute(Globals.EXPORT_TYPE); // 导出类型

        try {
            xlsw.init();
            xlsw.setOut(out);
            xlsw.setEncoding(getEncoding());
            // xlsw.setExportType(exportType == null ? Globals.EXPORT_DEFAULT : exportType);
            xlsw.setExportType(exportType == null ? Globals.EXPORT_TEXT : exportType);

            xlsw.start(fileName);
            if (!StringUtil.isEmpty(title)) {
                xlsw.addTitle(title, headsName.length);
            }
            xlsw.addHeader(headsName);

            if (beanClass == null || Map.class.isAssignableFrom(beanClass)) {
                for (int i = 0, len = data.size(); i < len; i++) {
                    Map record = (Map) data.get(i);
                    xlsw.addRow(map2Array(record, properiesName));
                }
            } else {
                for (int i = 0, len = data.size(); i < len; i++) {
                    Object record = data.get(i);
                    xlsw.addRow(bean2Array(record, properiesName, beanClass));
                }
            }
        } catch (Exception e) {

        } finally {
            xlsw.end();
            xlsw.close();
            out.flush();
            out.close();
        }
    }

    @SuppressWarnings("unchecked")
    public Object[] map2Array(Map map, String[] properiesName) {
        int len = properiesName.length;
        Object[] objs = new Object[len];
        for (int i = 0; i < len; i++) {
            objs[i] = map.get(properiesName[i]);
        }
        return objs;
    }

    @SuppressWarnings("unchecked")
    public Object[] bean2Array(Object bean, String[] properiesName, Class beanClass) {
        int len = properiesName.length;
        Object[] objs = new Object[len];

        for (int i = 0; i < len; i++) {
            try {

                objs[i] = BeanUtils.getProperty(bean, properiesName[i]);
            } catch (Exception e) {
                // TODO nothing
            }
        }
        return objs;
    }

    /**
     * 具有2个表头的Excel
     *
     * @param data1
     * @param data2
     * @param properiesName1
     * @param properiesName2
     * @param headsName1
     * @param headsName2
     * @param beanClass1
     * @param beanClass2
     * @throws IOException
     * @throws WriteException
     */
    public void exportXLS(List<?> data1, List<?> data2, String[] properiesName1, String[] properiesName2, String[] headsName1, String[] headsName2, Class<?> beanClass1,
                          Class<?> beanClass2) throws IOException, WriteException {
        String fileName = getRequest().getParameter("fileName");
        downloadFile(fileName + ".xls");

        OutputStream out = getResponse().getOutputStream();
        AbstractXlsWriter xlsw = (AbstractXlsWriter) JxlXlsWriter.getInstance();
        try {
            xlsw.init();
            xlsw.setOut(out);
            xlsw.setEncoding(getEncoding());
            xlsw.start(fileName);
            xlsw.addHeader(headsName1);
            if (beanClass1 == null || Map.class.isAssignableFrom(beanClass1)) {
                for (int i = 0, len = data1.size(); i < len; i++) {
                    Map record = (Map) data1.get(i);
                    xlsw.addRow(map2Array(record, properiesName1));
                }
            } else {
                for (int i = 0, len = data1.size(); i < len; i++) {
                    Object record = data1.get(i);
                    xlsw.addRow(bean2Array(record, properiesName1, beanClass1));
                }
            }
            xlsw.addHeader(headsName2);
            if (beanClass2 == null || Map.class.isAssignableFrom(beanClass2)) {
                for (int i = 0, len = data2.size(); i < len; i++) {
                    Map record = (Map) data2.get(i);
                    xlsw.addRow(map2Array(record, properiesName2));
                }
            } else {
                for (int i = 0, len = data2.size(); i < len; i++) {
                    Object record = data2.get(i);
                    xlsw.addRow(bean2Array(record, properiesName2, beanClass2));
                }
            }
        } catch (Exception e) {

        } finally {
            xlsw.end();
            xlsw.close();
        }
    }

    /**
     * 具有2个表头的Excel
     *
     * @param data1
     * @param data2
     * @param properiesName1
     * @param properiesName2
     * @param headsName1
     * @param headsName2
     * @param beanClass1
     * @param beanClass2
     * @throws IOException
     * @throws WriteException
     */
    public void exportXLS(List<?> data1, List<?> data2, String[] properiesName1, String[] properiesName2, String[] headsName1, String[] headsName2, Class<?> beanClass1,
                          Class<?> beanClass2, double col, double row, double overcols, double overrows, BufferedImage image) throws IOException, WriteException {
        String fileName = getRequest().getParameter("fileName");
        downloadFile(fileName + ".xls");

        OutputStream out = getResponse().getOutputStream();
        AbstractXlsWriter xlsw = (AbstractXlsWriter) JxlXlsWriter.getInstance();
        try {
            xlsw.init();
            xlsw.setOut(out);
            xlsw.setEncoding(getEncoding());
            xlsw.start(fileName);
            xlsw.addHeader(headsName1);
            if (beanClass1 == null || Map.class.isAssignableFrom(beanClass1)) {
                for (int i = 0, len = data1.size(); i < len; i++) {
                    Map record = (Map) data1.get(i);
                    xlsw.addRow(map2Array(record, properiesName1));
                }
            } else {
                for (int i = 0, len = data1.size(); i < len; i++) {
                    Object record = data1.get(i);
                    xlsw.addRow(bean2Array(record, properiesName1, beanClass1));
                }
            }
            xlsw.addHeader(headsName2);
            if (beanClass2 == null || Map.class.isAssignableFrom(beanClass2)) {
                for (int i = 0, len = data2.size(); i < len; i++) {
                    Map record = (Map) data2.get(i);
                    xlsw.addRow(map2Array(record, properiesName2));
                }
            } else {
                for (int i = 0, len = data2.size(); i < len; i++) {
                    Object record = data2.get(i);
                    xlsw.addRow(bean2Array(record, properiesName2, beanClass2));
                }
            }

            xlsw.addImage(col, row, overcols, overrows, image);
        } catch (Exception e) {

        } finally {
            xlsw.end();
            xlsw.close();
        }
    }

    /**
     * @param file
     * @param colomn
     * @return
     */
    public static String readExcel(File file, int colomn) {
        StringBuffer sb = new StringBuffer();
        Workbook wb = null;
        try {
            // 构造Workbook（工作薄）对象
            wb = Workbook.getWorkbook(file);

            if (wb == null) {
                return null;
            }
            Sheet[] sheet = wb.getSheets();

            if (sheet != null && sheet.length > 0) {
                for (int i = 0; i < sheet.length; i++) {
                    int rowNum = sheet[i].getRows();
                    for (int j = 0; j < rowNum; j++) {
                        Cell[] cells = sheet[i].getRow(j);
                        if (cells != null && cells.length > 0 && cells.length >= colomn) {
                            String cellValue = cells[colomn - 1].getContents();
                            sb.append(cellValue + ",");
                            // for (int k = 0; k < cells.length; k++) {
                            // // 读取当前单元格的值
                            // String cellValue = cells[k].getContents();
                            // sb.append(cellValue + "\t");
                            // }
                        }
                    }
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 最后关闭资源，释放内存
            if (wb != null) {
                wb.close();
            }
        }
        return sb.toString();
    }

    public void exportAndSaveXLS(List<?> data, Class<?> beanClass) throws IOException, WriteException {
        List<ColumnInfo> columnInfoList = parseColumnInfo("columnInfo");

        int len = columnInfoList.size();
        String[] properiesName = new String[len];
        String[] headsName = new String[len];
        for (int i = 0; i < len; i++) {
            ColumnInfo colInfo = (ColumnInfo) columnInfoList.get(i);
            properiesName[i] = colInfo.getDataIndex();
            headsName[i] = colInfo.getHeader();
        }
        String fileName = getRequest().getParameter("fileName");
        buildReport(properiesName, headsName, fileName, data, beanClass);
    }

    public void buildReport(String[] properiesName, String[] headsName, String filename, List<?> data, Class<?> beanClass) {
        String directory = WxemcpEntGlobals.COMMONREPORTBASEDIR + "\\13030100";
        AbstractXlsWriter xlsw = null;
        File file = new File(directory, filename + ".xls");
        FileOutputStream out = null;
        try {
            if (file.exists()) {
                FileUtil.forceDeleteOnExit(file);
            }
            FileUtil.createFile(file);
            xlsw = (AbstractXlsWriter) JxlXlsWriter.getInstance();
            out = new FileOutputStream(file);
            xlsw.init();
            xlsw.setOut(out);
            xlsw.setEncoding("UTF-8");
            xlsw.start(filename);
            xlsw.addHeader(headsName);

            for (int i = 0, len = data.size(); i < len; i++) {
                Object record = data.get(i);
                xlsw.addRow(bean2Array(record, properiesName, beanClass));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            xlsw.end();
            xlsw.close();
            xlsw = null;
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportXLSfromMaps(List<?> data, String[] properiesName, String[] headsName) throws IOException, WriteException {
        exportXLS(data, properiesName, headsName, Map.class);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public boolean isEncodingFileName() {
        return encodingFileName;
    }

    public void setEncodingFileName(boolean encodingFileName) {
        this.encodingFileName = encodingFileName;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
