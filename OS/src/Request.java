public class Request {
    private int id;//请求号，唯一标识一个请求
    private int number;//欲访问的磁道号
    private int flag;//是否已被调度的标记，初始为0，表示为被调度。
    public Request(){//空白构造器
        this.id=0;
        this.number=0;
        this.flag=0;
    }
    public Request(int id,int num){//带参构造器
        this.id=id;
        this.number=num;
        this.flag=0;
    }
    public void setId(int id){
        this.id=id;
    }

    //以下是一系列set和get方法
    public int getId(){
        return this.id;
    }

    public void setNumber(int number){
        this.number=number;
    }
    public int getNumber(){
        return this.number;
    }

    public void setFlag(int flag){
        this.flag=flag;
    }
    public int getFlag(){
        return this.flag;
    }
}
