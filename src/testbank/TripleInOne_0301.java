package testbank;



public class TripleInOne_0301 {

    private int stacksize = 0;
    private int stackone_peek;
    private int stackone_bottom;
    private int stacktwo_peek;
    private int stacktwo_bottom;
    private int stackthree_peek;
    private int stackthree_bottom;

    private int[] array;

    public TripleInOne_0301(int stackSize) {
        array = new int[stackSize*3];
         stacksize=stackSize ;
        stackone_bottom = 0;
        stackone_peek = -1;
        stacktwo_bottom = stackSize;
        stacktwo_peek = stackSize-1;
        stackthree_bottom = stackSize*2;
        stackthree_peek = stackSize*2-1;
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0) {
            if (stackone_peek + 1 == stacktwo_bottom) {
                return;
            }
            else {
                int pos = ++stackone_peek ;
                array[pos] = value;
            }
        } else if (stackNum == 1) {
            if (stacktwo_peek + 1 == stackthree_bottom) {
                return;
            } else {
                int pos = ++stacktwo_peek ;
                array[pos] = value;
            }
        }
        else {
            if (stackthree_peek +1 == stacksize * 3) {
                return;
            } else {
                int pos = ++stackthree_peek ;
                array[pos] =value;
            }
        }
    }

    public int pop(int stackNum) {
        if (stackNum == 0) {
            if (stackone_peek == -1) {
                return -1;
            } else {
                return array[stackone_peek--];
            }
        } else if (stackNum == 1) {
            if (stacktwo_peek == stacktwo_bottom - 1) {
                return -1;
            } else {
                return array[stacktwo_peek--];
            }
        } else {
            if (stackthree_peek == stackthree_bottom - 1) {
                return -1;
            } else {
                return array[stackthree_peek--];
            }
        }
    }

    public int peek(int stackNum) {
        if (stackNum == 0) {
            if (stackone_peek == -1) {
                return -1;
            } else {
                return array[stackone_peek];
            }
        } else if (stackNum == 1) {
            if (stacktwo_peek == stacktwo_bottom - 1) {
                return -1;
            } else {
                return array[stacktwo_peek];
            }
        } else {
            if (stackthree_peek == stackthree_bottom - 1) {
                return -1;
            } else {
                return array[stackthree_peek];
            }
        }
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0) {
            if (stackone_peek == -1) {
                return true;
            }
        } else if (stackNum == 1) {
            if (stacktwo_peek == stacktwo_bottom - 1) {
                return true;
            }
        } else {
            if (stackthree_peek == stackthree_bottom- 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TripleInOne_0301 test =new TripleInOne_0301(9);
        test.push(2,1);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);
        test.push(2,2);

    }

}
