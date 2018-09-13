package com.holley.wxemcp.ent.frame.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.cache.WxEmcpEntCacheUtil;

public class ImageCodeAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private InputStream       imageStream;

    // 生成验证码方法
    public String createCode() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output);

        WxEmcpEntCacheUtil.setImgValidateCode(getSessionId(), code);

        try {
            imageStream = new ByteArrayInputStream(output.toByteArray());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        // int width = 70;
        // int height = 25;
        int width = 100;
        int height = 50;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 25);
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        // Color color = new Color(66, 2, 82);
        Color color = new Color(255, 255, 255);
        g.setColor(color);
        // g.setBackground(new Color(226, 226, 240));
        // g.setBackground(new Color(10, 80, 168));
        g.setBackground(new Color(79, 128, 174));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }

    public InputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(InputStream imageStream) {
        this.imageStream = imageStream;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
