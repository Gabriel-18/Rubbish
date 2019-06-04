package week8;


class  Father
{
    protected  String  name;
    private  int  age;

    public  String  getName()  {
        return  name;
    }

    public  void  setName(String  name)  {
        this.name  =  name;
    }

    public  int  getAge()  {
        return  age;
    }

    public  void  setAge(int  age)  {
        this.age  =  age;
    }

    public  void  method()
    {
        System.out.println("I  am  a  father");
    }

    public  void  getInfo()  {
        System.out.println("my  name  is:"  +  getName());
        System.out.println("my  age  is:"  +  getAge());
    }
}
class  Son  extends  Father
{
    public  void  method()
    {
        System.out.println("I  am  the  elder  son  "+name);
    }
    public  void  method2()
    {
        System.out.println("I  am  the  younger  son  "+name);
    }
}
public  class  P4T4
{
    public  static  void  main(String[]  args)
    {
        Father  son  =  new  Son();
        son.setName("Jack");
        son.setAge(15);
        son.getInfo();
        son.method();

        son.setName("Aaron");
        son.setAge(8);
        Son son1 = (Son) son;
        son1.getInfo();
        son1.method2();
        //Collection;;
    }
}