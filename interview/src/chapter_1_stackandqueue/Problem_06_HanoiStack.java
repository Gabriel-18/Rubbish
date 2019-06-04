package chapter_1_stackandqueue;

public class Problem_06_HanoiStack {
    public static int hanoiProblem(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right,
                               String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from" + from + " to" + to);
                return 1;
            } else {
                System.out.println("Move 1 from" + from + " to" + mid);
                System.out.println("Move 1 from" + mid + "to" + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left)) || to.equals(left) ? right : left ;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from" + from + " to" + to );
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            return 0;
        }
    }
}
