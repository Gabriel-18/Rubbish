package second;


public class Tester1 {
    class boatState {
        public boatState() {
        }

        private int person;
        private int wolf;
        private int sheep;
        private int cabbage;

        public boatState(int person, int wolf, int sheep, int cabbage) {
            this.person = person;
            this.wolf = wolf;
            this.sheep = sheep;
            this.cabbage = cabbage;
        }
    }

    class bankState { //河岸的状态
        int person;
        int wolf;
        int sheep;
        int cabbage;
        public bankState() {
        }
        public bankState(int person, int wolf, int sheep, int cabbage) {
            this.person = person;
            this.wolf = wolf;
            this.sheep = sheep;
            this.cabbage = cabbage;
        }

        void display() {
            System.out.println(String.valueOf(person) + wolf + sheep + cabbage );
        }

        /**
         * 终点
         * @return
         */
        boolean compareToEnd() {
            if(person == 0 && wolf == 0 && sheep == 0 && cabbage == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        /**
         * 不符合要求
         * @return
         */
        boolean notAllow() {
            if (person == 0 && ((wolf == 1 && sheep == 1 && cabbage == 1 )
                    || (wolf == 1 && sheep == 1) || (sheep == 1 && cabbage == 1)))
            {
                return true;
            }
            else
            {
                if ((person != 0 && person != 1) || (wolf != 0 && wolf != 1)
                        || (sheep != 0 && sheep != 1) || (cabbage != 0 && cabbage != 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        /**
         *     confirm the state has never appeared
         */
        boolean compareToAppear(bankState temp) {
            if (person == temp.person && wolf == temp.wolf
                    && sheep == temp.sheep && cabbage == temp.cabbage) {
                return true;
            }
            else {
                return false;
            }
        }
        //the new state of bankA
        void newState(bankState tempState, boatState tempBoat) {
            if (person == 1)
            {
                tempState.person = person - tempBoat.person;
                tempState.wolf = wolf - tempBoat.wolf;
                tempState.sheep = sheep - tempBoat.sheep;
                tempState.cabbage = cabbage - tempBoat.cabbage;
            }
            if (person == 0)
            {
                tempState.person = person + tempBoat.person;
                tempState.wolf = wolf + tempBoat.wolf;
                tempState.sheep = sheep + tempBoat.sheep;
                tempState.cabbage = cabbage + tempBoat.cabbage;
            }
        }

        /**
         * //the state of bankB
         * @param tempB
         */
        void otherState(bankState tempB) {
            tempB.person = 1 - person;
            tempB.wolf = 1 - wolf;
            tempB.sheep = 1 - sheep;
            tempB.cabbage = 1 - cabbage;
        }
    }

    final int record = 20;
    bankState[] stateA = new bankState[20];
    bankState[] stateB = new bankState[20];
    boatState[] boat = new boatState[4];
    void x() {
        x(boat,stateA, stateB);
    }
    void x(boatState[] boat, bankState[] stateA, bankState[] stateB) {
        //初始化
        stateA[0] = new bankState (1, 1, 1, 1);
       for (int i = 1;i < 20; i++) {
           stateA[i] = new bankState(0,0,0,0);
       }
        for (int i = 0;i < 20; i++) {
            stateB[i] = new bankState(0,0,0,0);
        }
        boat[0] = new boatState(1, 0, 0, 0);
        boat[1] = new boatState(1, 1, 0, 0);
        boat[2] = new boatState(1, 0, 1, 0);
        boat[3] = new boatState(1, 0, 0, 1);
    }

    void crossriver(int time)
    {
        if (stateA[time].compareToEnd())
        {
            System.out.println("\"成功!\"");
            for (int num = 0; num <= time; num++)
            {
                stateA[num].display();
            }
            return;
        }
        if (stateA[time].notAllow() || stateB[time].notAllow())
        {
            return;
        }
        for (int i = 0; i < time; i++)
        {
            if (stateA[time].compareToAppear(stateA[i]))
            {
                return;
            }
        }
        for (int j = 0; j < 4; j++)
        {
            stateA[time].newState(stateA[time + 1], boat[j]);
            stateA[time + 1].otherState(stateB[time + 1]);
            crossriver(time + 1);
        }

    }
    public static void main(String[] args) {
        Tester1 tester1 = new Tester1();
        tester1.x();
        tester1.crossriver(0);
    }

}