import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Work {
    private int start;//允许访问的磁道号范围的起始磁道号
    private int end;//允许访问的磁道号范围的终止磁道号
    //即请求可请求访问的磁道号在start与end之间
    private int num;//所要产生的磁盘访问请求数量
    public Work(){//不带参构造器
        this.start=0;
        this.end=0;
        this.num=0;
    }
    public Work(int start,int end,int num){//带参构造器
        this.start=start;
        this.end=end;
        this.num=num;
    }
    public int getStart(){
        return this.start;
    }
    public int getEnd(){
        return this.end;
    }

    public Request[] getRandomRequest(){//产生磁盘访问请求的方法
        Request req[]=new Request[num];//数组声明num个请求
        Random random=new Random();
        Set<Integer> set=new HashSet<Integer>();
        while(true){//为num个请求依次生成要访问的磁道号，放入set集合
            set.add((int)(random.nextInt(end-start)+start));
            if(set.size()==num)
                break;
        }
        int i=0;
        //将set集合中的数取出依次付给各请求。使用set的目的是让num个访问请求要访问的磁道号各不同。
        for(int temp:set){
            req[i]=new Request(i+1,temp);
            i++;
        }
        return req;
    }
}
