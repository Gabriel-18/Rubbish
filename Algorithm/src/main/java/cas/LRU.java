package cas;

import java.util.LinkedList;

public class LRU {
    private LinkedList<Integer> mB;

    void pageReplacement(int[] pageString, int memBlockNum) {
        mB = new LinkedList<>();
        int pageFaultCount = 0, pageReplaceCount = 0;
        for (int i = 0; i < pageString.length; i++) {
            if (mB.contains(pageString[i])){
                mB.addLast(mB.remove(mB.indexOf(pageString[i])));
                continue;
            }else if (mB.size() >= memBlockNum) {
                mB.pollFirst();
                pageReplaceCount++;
            }
            mB.addLast(pageString[i]);
            pageFaultCount++;
            System.out.println(mB);
        }
        System.out.println("页面置换次数: "+pageReplaceCount);
    }
    public static void main(String[] args) {
        LRU l = new LRU();
        int []b={4,3,2,1,4,3,5,4,2,3,1,5};
        l.pageReplacement(b,3);
        System.out.printf("访问页面 ");
        for(int i=0;i<12;i++)
            System.out.printf("%3d",b[i]);
        System.out.println("");
    }
}
