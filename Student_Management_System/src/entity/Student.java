package entity;

public class Student  {
    private String name;
    private String id;
    private int Chinese;
    private int Math;
    private int total;

    @Override
    public String toString() {
        return "Student: " +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", Chinese=" + Chinese +
                ", Math=" + Math +
                ", total=" + total;
    }

    public Student(String name, String id, int chinese, int math, int total) {
        setName(name);
        setId(id);
        setChinese(chinese);
        setMath(math);
        total += getTotal();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setChinese(int chinese) {
        if (chinese > 100 || chinese < 0) {
            this.Chinese = 0;
        } else {
            Chinese = chinese;
        }
        total = this.getChinese() + this.getMath();
    }

    public void setMath(int math) {
        if (math > 100 || math < 0) {
            this.Math = 0;
        } else {
            Math = math;
        }
        total = this.getChinese() + this.getMath();
    }

    public int getChinese() {
        return Chinese;
    }

    public int getMath() {
        return Math;
    }

}
