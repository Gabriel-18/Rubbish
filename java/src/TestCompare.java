import  java.util.Arrays;

class  Student  implements Comparable {
private  String  name;
private  float  height,  weight,  score;

public  Student(String  name,  float  height,  float  weight,  float  score)  {
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.score = score;
        }

public  String  getName()  {
        return  name;
        }

public  void  setName(String  name)  {
        this.name  =  name;
        }

public  float  getHeight()  {
        return  height;
        }

public  void  setHeight(float  height)  {
        this.height  =  height;
        }

public  float  getWeight()  {
        return  weight;
        }

public  void  setWeight(float  weight)  {
        this.weight  =  weight;
        }

public  float  getScore()  {
        return  score;
        }

public  void  setScore(float  score)  {
        this.score  =  score;
        }

public  void  speak()  {


        }

@Override
public  int  compareTo(Object  o)  {
    Student s = (Student) o;
    if (this.height * 0.3 + this.weight * 0.3 + this.score * 0.4 - s.height * 0.3 - s.weight * 0.3 - s.score * 0.4 >= 0) {
        return 1;
    } else {
        return -1;
    }
        }

@Override
public  String  toString()  {
    return "Student [name="+name+",height="+height+",weight="+weight+",score="+score+"]";
        }
        }

public  class  TestCompare  {
    public  static  void  main(String[]  args)  {
        int  i;
        Student  ps[]  =  new  Student[6];
        ps[0]  =  new  Student("zhangsan",  170,  110,  95);
        ps[1]  =  new  Student("lisi",  168,  120,  75);
        ps[2]  =  new  Student("wangwu",  165,  115,  88);
        ps[3]  =  new  Student("zhaoliu",  172,  121,  90);
        ps[4]  =  new  Student("zhouqi",  160,  100,  85);
        ps[5]  =  new  Student("zhengba",  166,  119,  70);
        System.out.println("array  sort  before:");
        for  (i  =  0;  i  <  ps.length;  i++)  {
            ps[i].speak();
        }

         //  call  sort  method
        System.out.println("\narray  sort  after:");
        for  (i  =  0;  i  <  ps.length;  i++)  {
            System.out.println(ps[i]);
        }
    }
}
