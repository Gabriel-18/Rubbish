package week9;



import  java.util.Scanner;
public  class  Student  {
    private  String  name,  id;
    private  int  score;

    public Student(String n, String s, int sc) {
        this.name = n;
        this.id = s ;
        if (sc >= 0 && sc <= 100) {
            this.score = sc;
        } else {
            this.score = 0;
        }

    }


    public  static  void  main(String[]  args)  {
        Scanner  in  =  new  Scanner(System.in);
        String  n,  s;
        int  sc;
        n  =  in.nextLine();
        s  =  in.nextLine();
        sc  =  in.nextInt();
        Student  stu  =  new  Student(n,  s,  sc);
        System.out.println(stu);
        stu.setScore(sc  +  50);
        System.out.println(stu);
    }

    private void setScore(int i) {
        if (i >= 0 && i <= 100 ) {
            score = i;
        }else {
            System.out.println("score input error");
        }
    }

    @Override
    public String toString() {
        return "name="+ name  +
                ",id=" + id  +
                ",score=" + score ;
    }
}