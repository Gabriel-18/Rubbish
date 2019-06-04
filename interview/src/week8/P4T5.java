package week8;

class  Bank  {
    public  float  interest()  {
        return  0;
    }
    public  float  amount(){
        return  0;
    }
    public  void  sum(){
        System.out.println("Bank");
    }
}
class  SBI  extends  Bank  {

    public  float  interest()  {
        return  8.2f;
    }
    public  float  amount(){
        return  2000.0f;
    }
    public  void  sum(){
        double sums = interest() * amount();
        System.out.println("SBI  :  "  +  sums);
    }
}
class  ICICI  extends  Bank  {
    public  float  interest()  {
        return  7.9f;
    }
    public  float  amount(){
        return  300.0f;
    }
    public  void  sum(){
        double sums = interest() * amount();
        System.out.println("ICICI  :  "  +  sums);
    }
}
class  AXIS  extends  Bank  {
    public  float  interest()  {
        return  8.9f;
    }
    public  float  amount(){
        return  5000.0f;
    }
    public  void  sum(){
        double sums = interest() * amount();
        System.out.println("AXIS  :  "  +  sums);
    }
}
public  class  P4T5  {
    public  static  void  main(String  args[])  {
        Bank  b;
        b  =  new  SBI();
        b.sum();
        b  =  new  ICICI();
        b.sum();
        b  =  new  AXIS();
        b.sum();
    }
}