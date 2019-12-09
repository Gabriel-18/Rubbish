package acm;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int groupCounts;
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        String[] strings = new String[3];
        strings[0] = "Case_+\\d:";
        strings[1] = "\\d+";
        strings[2] = "[\\d_+]*\\d";
        groupCounts = in.nextInt();
        in.nextLine();
        for(int i=0; i<groupCounts; i++){
            ArrayList<String> list = new ArrayList<String>();
            lists.add(list);
            Input(lists.get(i));
        }
        for(int i=0; i<groupCounts; i++){
            if(isOK(lists.get(i),strings)){
                System.out.println("Accepted!");
            }
            else
                System.out.println("Presentation Error!");
        }
    }
    public static void Input(ArrayList<String> list){
        for (int i=0; i<3; i++){
            list.add(in.nextLine());
        }
    }
    public static boolean isOK(ArrayList<String> list,String[] strings){
        for (int i=0; i<3; i++){
            if(!Pattern.matches(strings[i],list.get(i))){
                return false;
            }
        }
        return true;
    }
}
