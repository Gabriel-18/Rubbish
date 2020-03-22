package cas;

import java.util.LinkedList;

public class NRU {
    private LinkedList<Integer> mB;
    private int[] accessed;
    private int[] modified;

    void pageReplacement(int[] pageString, int[] modifyStatus, int memBlockNum) {
        int index;
        mB = new LinkedList<>();
        accessed = new int[memBlockNum];
        modified = new int[memBlockNum];
        int pageFaultCount = 0, pageReplaceCount = 0;
        for (int i = 0; i < pageString.length; i++) {
            if (mB.contains(pageString[i])){
                index = mB.indexOf(pageString[i]);
                accessed[index] = 1;
                if (modified[index]==0)
                    modified[index]=modifyStatus[i];
                continue;
            } else if (mB.size() >= memBlockNum) {
                index=-1;
                while (true){
                    for (int j = 0; j < accessed.length; j++) {
                        if (accessed[j] == 0 && modified[j]==0){
                            index=j;
                            break;
                        }
                    }
                    if (index >= 0)
                        break;
                    for (int j = 0; j < accessed.length; j++) {
                        if (accessed[j] == 0 && modified[j]==1){
                            index = j;
                            break;
                        }
                        accessed[j]=0;
                    }
                    if (index >= 0)
                        break;
                }
                mB.set(index,pageString[i]);
                pageReplaceCount++;
            } else{
                mB.addLast(pageString[i]);
                index = mB.size()-1;
            }
            accessed[index] = 1;
            modified[index]=modifyStatus[i];
            pageFaultCount++;
            System.out.println(mB);
        }
        System.out.println("页面置换次数: "+pageReplaceCount);
    }
    public static void main(String[] args) {

        NRU n = new  NRU();
        int []b={4,3,2,1,4,3,5,4,2,3,1,5};
        int []c = {1,1,1,1,1,1,1,1,1,1,1,1};
        n.pageReplacement(b,c,3);
        for(int i=0;i<12;i++)
            System.out.printf("%3d",b[i]);
        System.out.println("");
    }
}
