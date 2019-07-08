import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class DiaoDu {
    Work work;
    Request[] request;
    int begin;//磁头初始位置
    DecimalFormat df = new DecimalFormat("0.000");
    public DiaoDu(Work work){//构造器，接收一个作业
        this.work=work;
        request=work.getRandomRequest();
        //磁头初始位置设为所允许访问磁道号范围的中间值。
        //如若磁道访问允许范围为100~300，则磁头初始位置在200处。
        begin=(work.getStart()+work.getEnd())/2;
    }

    public void FCFS(){//先来先服务算法
        begin=(work.getStart()+work.getEnd())/2;
        Request[] req=request;
        System.out.println("磁道号区间："+work.getStart()+"到"+work.getEnd());
        System.out.println("磁头初始时所在磁道号："+begin);

        double sum=0;
        System.out.println("请求号        被访问的下一个磁道号               移动距离");
        for(Request r:req){
            System.out.println("--"+r.getId()+"----------------"+r.getNumber()+"-----------------"+Math.abs(begin-r.getNumber())+"--");
            sum+=Math.abs(begin-r.getNumber());
            begin=r.getNumber();
        }
        System.out.println("***********平均寻道长度为："+df.format(sum/req.length)+"************");
    }


    public void SSTF(){//最短寻道优先
        begin=(work.getStart()+work.getEnd())/2;
        Request[] req=request;
        System.out.println("磁道号区间："+work.getStart()+"到"+work.getEnd());
        System.out.println("磁头初始时所在磁道号："+begin);

        int t=0;
        double sum=0;
        System.out.println("请求号        被访问的下一个磁道号               移动距离");
        for(int i=0;i<req.length;i++){
            int temp=work.getEnd();
            for(int j=0;j<req.length;j++){
                if(Math.abs(req[j].getNumber()-begin)<temp&&req[j].getFlag()==0){
                    temp=Math.abs(req[j].getNumber()-begin);
                    t=j;
                }
            }
            System.out.println("--"+req[t].getId()+"----------------"+req[t].getNumber()+"-----------------"+temp+"--");
            begin=req[t].getNumber();
            req[t].setFlag(1);
            sum+=temp;
        }
        System.out.println("***********平均寻道长度为："+df.format(sum/req.length)+"***********");
    }



    public void SCAN(){//扫描算法
        begin=(work.getStart()+work.getEnd())/2;
        Request[] req=request;
        int direction;//磁头运动方向方向
        System.out.println("设定磁头初始化运动方向（1：磁道号增大方向    -1：磁道号减小方向）：");
        direction=new Scanner(System.in).nextInt();
        System.out.println("磁道号区间："+work.getStart()+"到"+work.getEnd());
        System.out.println("磁头初始时所在磁道号："+begin);
        if(direction==1)
            System.out.println("磁头初始运动方向： 磁道号增大方向");
        else
            System.out.println("磁头初始运动方向： 磁道号减小方向");

        Map<Integer,Request> map=new HashMap<Integer,Request>();
        TreeSet<Integer> ts1=new TreeSet<Integer>();
        TreeSet<Integer> ts2=new TreeSet<Integer>();
        for(Request r:req){
            if(r.getNumber()>=begin){
                map.put(r.getNumber(), r);
                ts1.add(r.getNumber());
            }
            else{
                map.put(r.getNumber(), r);
                ts2.add(r.getNumber());
            }
        }


        System.out.println("请求号        被访问的下一个磁道号               移动距离");
        double sum=0;
        if(direction==1){

            for(int temp:ts1){
                System.out.println("--"+map.get(temp).getId()+"----------------"+temp+"-----------------"+Math.abs(temp-begin));
                sum+=Math.abs(temp-begin);
                begin=temp;
            }
            for(int temp:ts2.descendingSet()){
                System.out.println("--"+map.get(temp).getId()+"----------------"+temp+"-----------------"+Math.abs(temp-begin));
                sum+=Math.abs(temp-begin);
                begin=temp;
            }

        }

        else{
            for(int temp:ts2.descendingSet()){
                System.out.println("--"+map.get(temp).getId()+"----------------"+temp+"-----------------"+Math.abs(temp-begin));
                sum+=Math.abs(temp-begin);
                begin=temp;
            }
            for(int temp:ts1){
                System.out.println("--"+map.get(temp).getId()+"----------------"+temp+"-----------------"+Math.abs(temp-begin));
                sum+=Math.abs(temp-begin);
                begin=temp;
            }
        }
        System.out.println("***********平均寻道长度为："+df.format(sum/req.length)+"***********");
    }
}
