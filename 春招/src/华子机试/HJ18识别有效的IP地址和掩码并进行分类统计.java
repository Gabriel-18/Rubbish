package 华子机试;

import java.util.Scanner;

/**
 * 1、如果是0...* 或 127...* 跳过
 * 2、如果掩码错误，直接错误+1，扫描下一个 掩码错了没有必要继续统计了
 * 3、如果掩码正确，判断ip，如果ip错误，错误+1
 * 4、如果ip正确，判断ip类型
 * 5、
 * 如果是A类型， A++ 如果是私人ip，privateIp++
 * 如果是B类型， B++ 如果是私人ip，privateIp++
 * 如果是C类型， C++ 如果是私人ip，privateIp++
 * 如果是D类型， D++
 * 如果是E类型， E++
 */
public class HJ18识别有效的IP地址和掩码并进行分类统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ipAndMask = new String[2];
        String[] ipArr = new String[4];
        int A = 0, B = 0, C = 0, D = 0, E = 0, errIpOrMask = 0, privateIp = 0;
        while (in.hasNextLine()) {
            ipAndMask = in.nextLine().split("\\~");

            ipArr = ipAndMask[0].split("\\.");
            //类似于【0.*.*.*】和【127.*.*.*】忽略，这个条件要放在最前面，否则错误掩码会统计多
            int a = Integer.parseInt(ipArr[0]);
            int b = Integer.parseInt(ipArr[1]);
            if (a == 0 || a == 127) {
                continue;//跳过
            }

            if (!isValidMask(ipAndMask[1])) { //判断掩码是否有效
                errIpOrMask++;
                //System.out.println(ipAndMask[1]);//输出错误掩码
            } else {
                if (!isValidIp(ipAndMask[0])) {
                    errIpOrMask++;
                    //System.out.println(ipAndMask[0]);//输出错误ip
                } else {
                    if (a >= 1 && a <= 126) {
                        if (a == 10) {
                            privateIp++;
                            A++;
                        } else {
                            A++;
                        }
                    }
                    if (a >= 128 && a <= 191) {
                        if (a == 172 && (b >= 16 && b <= 31)) {
                            privateIp++;
                            B++;
                        } else {
                            B++;
                        }
                    }
                    if (a >= 192 && a <= 223) {
                        if (a == 192 && b == 168) {
                            privateIp++;
                            C++;
                        } else {
                            C++;
                        }
                    }
                }
                if (a >= 224 && a <= 239) {
                    D++;
                }
                if (a >= 240 && a <= 255) {
                    E++;
                }
            }
        }
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + errIpOrMask + " " + privateIp);
    }

    public static boolean isValidMask(String mask) {
        if (!isValidIp(mask)) {
            return false;
        }
        String[] maskTable = mask.split("\\.");
        //mask转为32位2进制字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maskTable.length; i++) {
            maskTable[i] = Integer.toBinaryString(Integer.parseInt(maskTable[i]));
            if (maskTable[i].length() < 8) {//不足8位补齐0
                for (int j = 0; j < 8 - maskTable[i].length(); j++) {
                    sb.append("0");//补完零
                }
                sb.append(maskTable[i]);//再添加转换的2进制串
            } else {
                sb.append(maskTable[i]);//刚好8位直接添加，因为之前已经判断过ip的有效性，所以不可能超过8位
            }
        }
        //最后一个1在第一个0之前，有效，否则无效
        // 判断掩码的标准
        return sb.toString().lastIndexOf("1") < sb.toString().indexOf("0");
    }

    public static boolean isValidIp(String ip) {
        String[] ipTable = ip.split("\\.");
        if (ipTable.length != 4) {
            return false;
        }
        for (String s : ipTable) {
            // ip合法性判断
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }
}