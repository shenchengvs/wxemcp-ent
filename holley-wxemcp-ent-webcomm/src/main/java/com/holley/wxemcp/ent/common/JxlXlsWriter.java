package com.holley.wxemcp.ent.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;

public class JxlXlsWriter extends AbstractXlsWriter {

    private static JxlXlsWriter writer;
    private WritableWorkbook    workbook;
    private WritableSheet       sheet;
    private WorkbookSettings    workbookSettings = new WorkbookSettings();

    public static JxlXlsWriter getInstance() throws WriteException {
        if (writer == null) {
            writer = new JxlXlsWriter();
        }
        return writer;
    }

    public void writeNumCell(int row, short col, double value) throws RowsExceededException, WriteException {
        Number number = new Number(col, row, value);
        sheet.addCell(number);
    }

    public void writeNumCell(int row, short col, double value, WritableCellFormat cellFormat) throws RowsExceededException, WriteException {
        Number number = new Number(col, row, value, cellFormat);
        sheet.addCell(number);
    }

    public void writeStringCell(int row, short col, String value) throws RowsExceededException, WriteException {
        Label label = new Label(col, row, value);
        sheet.addCell(label);
    }

    public void writeStringCell(int row, short col, String value, WritableCellFormat cellFormat) throws RowsExceededException, WriteException {
        Label label = new Label(col, row, value, cellFormat);
        sheet.addCell(label);
    }

    public void writeCell(int row, short col, Object value) throws Exception {
        if (value != null && NumberUtils.isDigits(value.toString())) {
            double dNum = Double.parseDouble(String.valueOf(value));
            writeNumCell(row, col, dNum);
        } else {
            writeStringCell(row, col, String.valueOf(value));
        }
    }

    @Override
    public void addTitle(String title, int colCount) throws Exception {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10);

        WritableCellFormat headerStyle = new WritableCellFormat(font); // 单元格样式
        headerStyle.setAlignment(Alignment.CENTRE); // 设置对齐方式
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置对齐方式

        jxl.write.Label label_head = new jxl.write.Label(0, row, title, headerStyle);
        sheet.mergeCells(0, row, colCount, row);
        sheet.addCell(label_head);

        row++;
    }

    @Override
    public void addTitle(String title, int colCount, boolean isBold) throws Exception {

        WritableFont font = new WritableFont(WritableFont.TIMES, 15);
        if (isBold) {
            font.setBoldStyle(WritableFont.BOLD);// 粗字体
        }
        WritableCellFormat contentStyle = new WritableCellFormat(font); // 单元格样式
        contentStyle.setAlignment(Alignment.CENTRE); // 设置对齐方式
        contentStyle.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置对齐方式

        Label label = new Label(0, row, title, contentStyle);
        sheet.mergeCells(0, row, colCount - 1, row);
        sheet.addCell(label);

        row++;
    }

    @Override
    public void writeHeaderCell(int row, short col, Object value) throws Exception {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10);
        font.setBoldStyle(WritableFont.BOLD);// 粗字体

        WritableCellFormat headerStyle = new WritableCellFormat(font); // 单元格样式
        headerStyle.setAlignment(Alignment.CENTRE); // 设置对齐方式
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置对齐方式
        headerStyle.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.BLACK);// 设置边框的颜色和样式
        headerStyle.setBackground(Colour.GREY_25_PERCENT); // 背景色

        sheet.setColumnView(col, 15); // 设置初始化宽度15

        if (value != null && NumberUtils.isDigits(value.toString())) {
            double dNum = Double.parseDouble(String.valueOf(value));
            writeNumCell(row, col, dNum, headerStyle);
        } else {
            writeStringCell(row, col, value == null ? "" : String.valueOf(value), headerStyle);
        }
    }

    @Override
    public void writeContentCell(int row, short col, Object value, boolean colorSet) throws Exception {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10);
        if (!colorSet) {
            font.setColour(Colour.BLACK);
        } else {
            font.setColour(Colour.RED);
        }

        WritableCellFormat contentStyle = new WritableCellFormat(font); // 单元格样式
        contentStyle.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置对齐方式
        contentStyle.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);// 设置边框的颜色和样式

        // 自适应页面宽度
        if (value != null) {
            int length = value.toString().length();
            int width = sheet.getColumnWidth(col);// .getColumnView(col).getSize();
            if (length >= 20 && width < 45) {
                sheet.setColumnView(col, 45);
            } else if (length >= 10 && width < 20) {
                sheet.setColumnView(col, 20);
            }
        }

        // 是否全文本导出
        if (StringUtils.equals(this.getExportType(), Globals.EXPORT_TEXT)) {
            writeStringCell(row, col, value == null ? "" : String.valueOf(value), contentStyle);
        } else {
            // 数字类型的设置excel单元格为数字类型
            if (value != null && NumberUtils.isNumber(value.toString().trim())) {
                contentStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
                double dNum = Double.parseDouble(String.valueOf(value).trim());
                writeNumCell(row, col, dNum, contentStyle);
            } else if (value instanceof Date) {
                writeStringCell(row, col, DateUtil.DateToLongStr((Date) value), contentStyle);
            } else {
                writeStringCell(row, col, value == null ? "" : String.valueOf(value), contentStyle);
            }
        }
    }

    @Override
    public void end() {
        try {
            workbook.write();
            workbook.close();
        } catch (WriteException e) {
            // LogHandler.error(this, e);
            e.printStackTrace();
        } catch (IOException e) {
            // LogHandler.error(this, e);
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        start(null);
    }

    @Override
    public void start(String sheetName) {
        if (StringUtil.isEmpty(sheetName)) {
            sheetName = "sheet 1";
        }
        try {
            workbookSettings.setUseTemporaryFileDuringWrite(true);
            if (getEncoding() != null) {
                workbookSettings.setEncoding(getEncoding());
            }
            // String tempExcelPath = Globals.COMMONREPORTBASEDIR;
            String tempExcelPath = WxemcpEntGlobals.EXCEL_TEMP_PATH;
            File tempFile = new File(tempExcelPath);
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }
            workbookSettings.setTemporaryFileDuringWriteDirectory(tempFile);// 临时文件夹的位置
            workbook = Workbook.createWorkbook(getOut(), workbookSettings);
            sheet = workbook.createSheet(sheetName, 0);
        } catch (IOException e) {
            e.printStackTrace();
            // LogHandler.error(this, e);
        }
    }

    /**
     * 导入图片
     * 
     * @param col 图片左上角相对excel位置（列位置）
     * @param row 图片左上角相对excel位置（行位置）
     * @param overcols 图片占据的列数
     * @param overrows 图片占据的行数
     * @param image 图片
     * @throws Exception
     */
    @Override
    public void addImage(double col, double row, double overcols, double overrows, BufferedImage image) throws Exception {
        ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", imageStream);// jxl只识别png
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] tagInfo = imageStream.toByteArray();
        WritableImage wimage = new WritableImage(col, row, overcols, overrows, tagInfo);
        sheet.addImage(wimage);
    }
}
