package IO;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        //listAllFiles(new File("D:\\code\\Java\\CS-Notes\\java\\src\\access"));
        copyFile("D:\\code\\Java\\CS-Notes\\java\\src\\IO\\Test.java","D:\\code\\Java\\CS-Notes\\java\\src\\IO\\a.txt");
        //FileInputStream fileInputStream = new FileInputStream(filePath);
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        String str1 = "中文";
        //byte[] bytes = str1.getBytes("UTF-8");
        //String str2 = new String(bytes, "UTF-8");
        //System.out.println(str2);

        byte[] bytes = str1.getBytes();
        String str2 = new String(bytes, "UTF-16");
        System.out.println(str2);

    }
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }

        in.close();
        out.close();
    }

}
