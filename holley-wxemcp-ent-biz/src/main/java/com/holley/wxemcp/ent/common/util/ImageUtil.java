package com.holley.wxemcp.ent.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;

public final class ImageUtil {

    /**
     * 判断文件是否是图片，如果是，返回true，否则，返回false
     * 
     * @param file 需要验证的File文件
     * @return true or false
     * @throws IOException
     */
    public static Boolean fileIsImage(File file) throws Exception {
        // 将文件转换成输入流
        try {
            InputStream is = new FileInputStream(file);
            // 用image IO读取文件，如果文件file不是图片，则为null
            BufferedImage image = ImageIO.read(is);
            if (image != null) { // 如果image不为空，则说明file文件是图片
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("必须上传图片类型文件!");
        }
        return false;
    }

    /**
     * @param srcfile 源文件
     * @param dist 存储地址
     * @return
     */
    public static boolean createThumbnailSmall(File srcfile, String dist) {
        try {
            if (!srcfile.exists()) {
                return false;
            }

            BufferedImage image = ImageIO.read(srcfile);
            FileOutputStream os = new FileOutputStream(dist);
            // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
            // encoder.encode(image);
            ImageIO.write(image, "jpeg", os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Map<String, Object> uploadImg(File upload, Object id, String servletRealPath) throws Exception {
        // Globals.IMG_HEAD_URL
        Map<String, Object> map = new HashMap<String, Object>();
        String imgPathName = "";
        String destFileName = "";
        String realFileName = "";
        String realUrl = "";
        String msg = "success";
        String url = "";
        String imgSuffix = ".jpg";
        if (upload == null) {
            msg = "上传图片为空！！";
        } else if (!ImageUtil.fileIsImage(upload)) {
            msg = "必须上传图片类型文件！！";
        }
        if ("success".equals(msg)) {
            if (id instanceof Date) {
                Date date = (Date) id;
                imgPathName = WxemcpEntGlobals.IMG_FILEPATH + date.getTime() + imgSuffix;
            } else {
                imgPathName = WxemcpEntGlobals.IMG_FILEPATH + id + imgSuffix;
            }
            destFileName = servletRealPath + "/" + WxemcpEntGlobals.IMG_FILENAME;
            realUrl = WxemcpEntGlobals.IMG_PATH + File.separator + WxemcpEntGlobals.IMG_FILENAME + File.separator + imgPathName;
            realFileName = destFileName + "/" + imgPathName;
            realUrl = realUrl.replaceAll("\\\\", "/");
            File f = new File(destFileName);
            if (!f.exists()) {
                f.mkdirs();
            }
            if (ImageUtil.createThumbnailSmall(upload, realFileName)) {
                url = realUrl;
            } else {
                msg = "上传图片失败！！";
            }
        }
        map.put("msg", msg);
        map.put("url", url);
        return map;
    }

    // public static Map<String, Object> uploadDoc(File doc, int id, String docType, String servletRealPath) throws
    // Exception {
    // Map<String, Object> map = new HashMap<String, Object>();
    // String msg = "success";
    // String docName = "";
    // if (doc != null) {
    // if (Globals.TYPE_DOC.equals(docType)) {
    // docName = Globals.KEY_PILE_TEMP_DOC + id + Globals.TYPE_DOC;
    // } else if (Globals.TYPE_PDF.equals(docType)) {
    // docName = Globals.KEY_PILE_TEMP_DOC + id + Globals.TYPE_PDF;
    // }
    // String realFileName = servletRealPath + File.separator + Globals.DOC_PILE_TEMP_FILE + File.separator + docName;
    // File file = new File(realFileName);
    // String url = Globals.IMG_DATA_FILE + File.separator + Globals.DOC_PILE_TEMP_FILE + File.separator + docName;
    // if (!file.exists()) {
    // file.getParentFile().mkdirs();
    // }
    // url = url.replaceAll("\\\\", "/");
    // map.put("url", url);
    // FileUtil.copyFile(doc, file);
    // } else {
    // msg = "上传文件不能为空！！";
    // }
    // map.put("msg", msg);
    // return map;
    // }

}
