package 高频面试题.leetcode;

public class _468验证IP地址 {
    class Solution {
        public String validIPAddress(String IP) {
            // 会尽可能分割
            // 并且不会遗弃尾部空串
            // 这样可以先用字符串长度判断
            String[] IP4Arr = IP.split("\\.",-1);
            if(IP4Arr.length == 4){
                return isIP4Arr(IP4Arr);
            }

            String[] IP6Arr = IP.split(":",-1);
            if(IP6Arr.length == 8){
                return isIP6Arr(IP6Arr);
            }

            return "Neither";
        }

        public String isIP4Arr(String[] IP4Arr){
            for(String ip : IP4Arr){
                //位数：1 - 3
                if(ip.length() > 3 || ip.length() <= 0){
                    return "Neither";
                }

                for(int i = 0 ;i < ip.length();++i){
                    if(!Character.isDigit(ip.charAt(i))){
                        return "Neither";
                    }
                }
                int num = Integer.parseInt(ip);
                // num 范围
                // 以及前导0问题
                if(num > 255 || String.valueOf(num).length() != ip.length()){
                    return "Neither";
                }
            }
            return "IPv4";
        }

        public String isIP6Arr(String[] IP6Arr){
            for(String ip : IP6Arr){
                //位数： 1 - 4
                if(ip.length() > 4 || ip.length() <= 0){
                    return "Neither";
                }
                for (int i = 0; i < ip.length(); ++i) {

                    char c = ip.charAt(i);
                    // 做排除法简单
                    if (!Character.isDigit(c) && !('a' <= c && c <= 'f') && !('A' <= c && c <= 'F')) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}
