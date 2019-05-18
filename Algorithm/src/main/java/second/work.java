package second;

import java.util.ArrayList;

public class work {

    public static int [][]arr = new int[10][10];//邻接矩阵；
    public static int []visited = new int[10];//记录已访问的顶点
    public static ArrayList<ver> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //两岸情况，可能出现的10种状态；顶点
        arrayList.add(new ver(0,0,0,0,"man,wolf,vegetable,sheep||NULL(初始)"));
        arrayList.add(new ver(0,1,0,0,"man,sheep,vegetable||wolf"));
        arrayList.add(new ver(0,0,1,0,"man,wolf,vegetable||sheep"));
        arrayList.add(new ver(1,1,1,0,"vegetable||man,wolf,sheep"));
        arrayList.add(new ver(1,1,0,1,"sheep||man,wolf,vegetable"));
        arrayList.add(new ver(1,0,1,1,"wolf||man,sheep,vegetable"));
        arrayList.add(new ver(1,0,1,0,"wolf,vegatable||man,sheep"));
        arrayList.add(new ver(0,1,0,1,"man,sheep||wolf,vegetable"));
        arrayList.add(new ver(0,0,0,1,"man,wolf,sheep||vegetable"));
        arrayList.add(new ver(1,1,1,1,"NULL||man,wolf,vegetable,sheep(过河成功)"));
        //初始化邻接矩阵;
        for(int i = 0;i < 10;i++) {
            for(int j = 0;j < 10;j++) {
                arr[i][j] = 0;
            }
        }
        //判断每次农夫是否一定过河，过河时所带的物品是否小于=1 ；过河前，过河后,取值是否相等；获取邻接矩阵
        for(int i = 0;i < 10;i++) {//获取值
            int tempWolf = arrayList.get(i).thing.wolf;
            int tempSheep = arrayList.get(i).thing.sheep;
            int tempMan = arrayList.get(i).thing.man;
            int tempVegetable = arrayList.get(i).thing.vegetable;
            for(int j = 0;j < 10;j++) {
                int tempMan_ = arrayList.get(j).thing.man;
                int tempWolf_ = arrayList.get(j).thing.wolf;
                int tempSheep_ = arrayList.get(j).thing.sheep;
                int tempVegetable_ = arrayList.get(j).thing.vegetable;
                if(tempMan != tempMan_ && (Math.abs(tempWolf - tempWolf_)+Math.abs(tempSheep - tempSheep_)+
                        Math.abs(tempVegetable - tempVegetable_)<=1)) {
                    arr[i][j] = 1;//点与点是否连通；
                }
            }
        }
        System.out.println("每次过河后，两边情况：");
        visited[0] = 1;//已访问零顶点
        dfs(1,10);
    }
    public static void print(int end) {//记录
        int []temp = new int[10];
        int num = 0;
        int i = end;
        while(i != 1) {//重后往前记录之前访问过的点
            temp[num] = visited[i-1];
            i = temp[num];
            num++;
        }
        for(int j = num - 1;j > 0;j--) {
            System.out.println(arrayList.get(temp[j]-1).outPut);
        }
        System.out.println(arrayList.get(9).outPut);
        System.out.println("过河成功");
    }
    private static void dfs(int start, int end) {
        if(start == end) {
            print(end);//结束条件
        }
        for(int i = 0;i <10 ;i++) {
            if(arr[start-1][i] > 0 && visited[i] == 0) {
                visited[i] = start;
                dfs(i+1,end);
                visited[i] = 0;
            }
        }
    }

}
//顶点
class ver {
    Thing thing = new Thing();
    String outPut;
    public ver(int manState,int wolfState,int sheepState, int vegetableState,String outPut) {
        thing.man = manState;
        thing.wolf = wolfState;
        thing.sheep = sheepState;
        thing.vegetable = vegetableState;
        this.outPut = outPut;
    }
}


class Thing {
    public int man;
    public int wolf;
    public int sheep;
    public int vegetable;

}
