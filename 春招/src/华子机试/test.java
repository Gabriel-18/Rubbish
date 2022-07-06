package 华子机试;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        for(int i = 0;i<16;i++){
            String f = Integer.toHexString(i);
            String a = Integer.toBinaryString(i);
            map.put(f,a);
            if(i>=10){
                map.put(f.toUpperCase(),a);
            }
        }
        System.out.println(map);
    }
}
