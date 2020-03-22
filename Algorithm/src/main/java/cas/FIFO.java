package cas;

import java.util.LinkedList;

public class FIFO {
    private LinkedList<Integer> mB;
    void pageReplacement(int[] pageString, int memBlockNum) {
        mB = new LinkedList<>();
        int FaultCount = 0, ReplaceCount = 0;
        for (int i = 0; i < pageString.length; i++) {
            if (mB.contains(pageString[i]))
                continue;
            if (mB.size() >= memBlockNum) {
                mB.pollFirst();
                //                mB.set(0, pageString[i]);
                ReplaceCount++;
            }
            mB.add(pageString[i]);
            FaultCount++;
            System.out.println(mB);
        }
        System.out.println("页面置换次数: "+ReplaceCount);
    }

    public static void main(String[] args) {
        FIFO f = new  FIFO();
        int []b={4,3,2,1,4,3,5,4,2,3,1,5};
        f.pageReplacement(b,3);
        System.out.printf("访问页面 ");
        for(int i=0;i<12;i++)
            System.out.printf("%3d",b[i]);
        System.out.println("");
    }
}
