//package com.xiayu.utils;
//
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
///**
// * Description:
// *  图片相关工具类
// * @version v1.0.0
// * @Author xiayu
// * @Date 2020/5/2 13:53
// */
//public class ImageUtils {
//
////    public static void main(String[] args) {
////        String iamgeFilePath = "E:\\桌面\\壁纸\\438760.jpg";
////        String s = GetImageStr(iamgeFilePath);
////        System.out.println(s);
////        boolean b = GenerateImage( s,"C:\\Users\\xiayu\\Desktop\\图片1.jpg");
////        System.out.println(b);
////    }
//
//    /**
//     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//     * @param imgFilePath
//     * @return
//     */
//    public static String GetImageStr(String imgFilePath) {
//        byte[] data = null;
//        // 读取图片字节数组
//        try {
//            InputStream in = new FileInputStream(imgFilePath);
//            data = new byte[in.available()];
//            in.read(data);
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
//    }
//
//    /**
//     *  对字节数组字符串进行Base64解码并生成图片
//     * @param imgStr
//     * @param imgFilePath
//     * @return
//     */
//    public static boolean GenerateImage(String imgStr, String imgFilePath) {
//        if (imgStr == null){
//            // 图像数据为空
//            return false;
//        }
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            // Base64解码
//            byte[] bytes = decoder.decodeBuffer(imgStr);
//            for (int i = 0; i < bytes.length; ++i) {
//                if (bytes[i] < 0) {// 调整异常数据
//                    bytes[i] += 256;
//                }
//            }
//            // 生成jpeg图片
//            OutputStream out = new FileOutputStream(imgFilePath);
//            out.write(bytes);
//            out.flush();
//            out.close();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * 内容转化为二维码信息
//     * @param content  内容
//     * @param response
//     * @param fileName 文件名称
//     * @return 图片地址
//     */
//    public static String createQRCode(String content,String fileName ,HttpServletResponse response){
//        BitMatrix qRcodeImg ;
//        String qRcodeImgUrl = null;
//        try {
//            // 生成二维码
//            qRcodeImg = QRCodeUtils.generateQRCodeStream(content, response);
//            // 将二维码输出到页面中
//            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(qRcodeImg);
//            String fileUrl = "C:\\Users\\xiayu\\Desktop\\" +fileName+".png";
//            FileUtil.createFile(fileUrl);
//            File file = new File(fileUrl);
//            ImageIO.write(bufferedImage,"png",file);
//            qRcodeImgUrl = fileUrl;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return qRcodeImgUrl;
//    }
//}
