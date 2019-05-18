package second;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    /**
     * Solves the sheep-cabbage-wolf riddle and prints out its solution
     */
    public static void solveSheepCabbageWolf(){
        sheepCabbageWolf(false, false, false, false, new LinkedList<String>());
    }
    /**
     * Solves the sheep-cabbage-wolf riddle and prints out its solution (the actual worker method)
     * @param sheep true if the sheep is on the right bank, false otherwise
     * @param cabbage true if the cabbage is on the right bank, false otherwise
     * @param wolf true if the wolf is on the right bank, false otherwise
     * @param farmer true if the farmer (boat) is on the right bank, false otherwise
     * @param solution partial solution
     * @return false if the partial solution is invalid
     */
    private static boolean sheepCabbageWolf(boolean sheep, boolean cabbage, boolean wolf, boolean farmer, Deque<String> solution) {
        if (sheep && cabbage && wolf && farmer) {
            printSolution(solution);
            return true;
        }
        if (!checkConsistency(sheep, cabbage, wolf, farmer)) {
            return false;
        }
        if (solution.isEmpty() || !solution.peek().equals("boatman")) {
            solution.addFirst("boatman");
            if (sheepCabbageWolf(sheep, cabbage, wolf, !farmer, solution)) {
                return true;
            }
            solution.pop(); //backtrack
        }
        if (sheep == farmer && (solution.isEmpty() || !solution.peek().equals("sheep"))) {
            solution.addFirst("sheep");
            if (sheepCabbageWolf(!sheep, cabbage, wolf, !farmer, solution)) {
                return true;
            }
            solution.pop(); //backtrack
        }
        if (cabbage == farmer && (solution.isEmpty() || !solution.peek().equals("cabbage"))) {
            solution.addFirst("cabbage");
            if (sheepCabbageWolf(sheep, !cabbage, wolf, !farmer, solution)) {
                return true;
            }
            solution.pop(); //backtrack
        }
        if (wolf == farmer && (solution.isEmpty() || !solution.peek().equals("wolf"))) {
            solution.addFirst("wolf");
            if (sheepCabbageWolf(sheep, cabbage, !wolf, !farmer, solution)) {
                return true;
            }
            solution.pop(); //backtrack
        }
        return false;
    }

    /**
     * Check consistency of the partial solution
     * @param sheep if the sheep is on the right bank, false otherwise
     * @param cabbage if the cabbage is on the right bank, false otherwise
     * @param wolf if the wolf is on the right bank, false otherwise
     * @param farmer if the farmer is on the right bank, false otherwise
     * @return true if the solution is consistent, false otherwise
     */
    private static boolean checkConsistency(boolean sheep, boolean cabbage, boolean wolf, boolean farmer) {
        if (sheep == cabbage && sheep != farmer) {
            return false;
        } else if (sheep == wolf && sheep != farmer) {
            return false;
        }
        return true;
    }

    /**
     * Prints out the solution of the sheep-cabbage-wolf problem
     * @param solution
     */
    private static void printSolution(Deque<String> solution) {
        while (!solution.isEmpty()) {
            System.out.print(solution.pollLast() + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        solveSheepCabbageWolf();
    }

}
