package com.xiayu.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author xuhongyu
 * @create 2021-12-09 10:36 上午
 */
public class CompressTest {

    public static void main(String[] args) throws IOException {
        resizeImage("/Users/xiayu/Pictures/壁纸/43vvmv.jpg", "/Users/临时文件/image/", 3840, 111, true);
    }

    /**
     * 图片缩放
     * @param srcPath 原图片路径
     * @param desPath 转换大小后图片路径
     * @param width   转换后图片宽度
     * @param height  转换后图片高度
     */
    public static void resizeImage(String srcPath, String desPath, int width, int height, boolean scale) throws IOException {
        File srcFile = new File(srcPath);
        Image srcImg = ImageIO.read(srcFile);

        if (scale) {
            int widthOld = srcImg.getWidth(null);
            int heightOld = srcImg.getHeight(null);
            if (widthOld >= width && heightOld >= height) {
                double oldScale = (double)widthOld / heightOld;

                double newScale = (double) width / height;
                if (oldScale > newScale) {
                    height = (int) (height * (newScale / oldScale));
                }
                if (oldScale < newScale) {
                    width =(int) (width * (oldScale /newScale ));
                }
            } else {
                width = widthOld;
                height = heightOld;
            }
        }


        BufferedImage buffImg = null;
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //使用TYPE_INT_RGB修改的图片会变色
        buffImg.getGraphics().drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        String filePath = "";
        if (srcFile.getName().contains("#")) {
            filePath = srcFile.getName().replace("#", "");
        } else {
            filePath = srcFile.getName();
        }
        ImageIO.write(buffImg, "PNG", new File(desPath + filePath));
    }

}
