package com.dfundata.fund.schedule.utils;

import java.io.*;

/**
 * @author ly
 * @date 2020-02-24 14:13
 * @description 读取文件工具类
 */
public class FileUtils {

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }

    public static String readFile(String filePath) {
        StringBuffer sb = new StringBuffer();
        try {
            FileUtils.readToBuffer(sb, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
