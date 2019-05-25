package dao;

import entity.Student;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class studentDao {
    //输入学号、姓名、成绩
    public void add() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("D:\\code\\Java\\CS-Notes\\Student_Management_System\\src\\stud.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        //录入状态标识
        boolean isRecord = true;
        TreeSet treeSet =  new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getTotal() - o2.getTotal();
            }
        });

        String a = null;
        while(isRecord){
            System.out.println("输入姓名");
            String name = br.readLine();
            System.out.println("输入学号");
            String id = br.readLine();
            System.out.println("输入语文");
            int Chinese = Integer.valueOf(br.readLine());
            System.out.println("输入数学");
            int Math = Integer.valueOf(br.readLine());

            Student student = new Student(name, id, Chinese, Math,0);


            treeSet.add(student);

            System.out.println("停止输入,按#,否则请按空格");
             a = br.readLine();
            if (a.equals("#")) {
                isRecord = false;

            }

        }
        for (Object student : treeSet) {
            System.out.println(student);
            bw.write(student.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
    //输出文件
    void output() throws IOException {
        FileWriter fw = new FileWriter("D:\\code\\Java\\CS-Notes\\Student_Management_System\\src\\stud.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.close();
    }
}
