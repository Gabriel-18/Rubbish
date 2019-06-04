package week8;

interface StartStop { // 接口的方法声明


    //① 根据程序上下文，完成这里的语句

    void stop();

    void start();
}

class Elevator implements StartStop {

    public void start() {

        System.out.println("运行");

    }

    public void stop() {

        System.out.println("停止");

    }  }

class Conference implements StartStop {

    public void start() {

        System.out.println("开会");

    }

    public void stop() {

        System.out.println("会议结束");

    }  }

public class TestStartStop {

    public static void main(String[] args) {

        StartStop[] ss = { new Elevator(), new Conference() };

        for (int i = 0; i < ss.length; i++) {  //② 空白处要求控制循环遍历数组，并正常结束

            ss[i].start();

            ss[i].stop();

        }

        System.out.println("程序结束");

    }  }