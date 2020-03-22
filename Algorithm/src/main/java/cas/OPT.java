package cas;

import java.util.LinkedList;

public class OPT {
    private LinkedList<Integer> mB;

    void pageReplacement(int[] pageString, int memBlockNum) {
        mB = new LinkedList<>();
        int maxDistIndex,willVisit,replaceIndex = -1;
        int pageFaultCount = 0, pageReplaceCount = 0;
        for (int i = 0; i < pageString.length; i++) {
            if (mB.contains(pageString[i]))
                continue;
            if (mB.size() >= memBlockNum) {
                // 查找最长时间内不被访问的页
                maxDistIndex = -1;
                for (int j = 0; j < memBlockNum; j++) {
                    willVisit = 0;
                    for (int k = i+1; k < pageString.length; k++) {
                        if (mB.get(j) == pageString[k]) {
                            if (k > maxDistIndex){
                                maxDistIndex = k;
                                replaceIndex = j;
                            }
                            willVisit = 1;
                            break;
                        }
                    }
                    if (willVisit == 0){
                        replaceIndex = j;
                        break;
                    }
                }
                mB.set(replaceIndex, pageString[i]);
                pageReplaceCount++;
            } else
                mB.add(pageString[i]);
            pageFaultCount++;
            System.out.println(mB);
        }
        System.out.println("页面置换次数: "+pageReplaceCount);
    }
    public static void main(String[] args) {
        OPT o = new OPT();
        int []b={4,3,2,1,4,3,5,4,2,3,1,5};
        o.pageReplacement(b,3);
        System.out.printf("访问页面 ");
        for(int i=0;i<12;i++)
            System.out.printf("%3d",b[i]);
        System.out.println("");
    }
}
