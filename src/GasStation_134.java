public class GasStation_134 {
    public static void main(String[] args) {
        GasStation_134 test =new GasStation_134();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new  int[]{3,4,5,1,2};

        int i=test.canCompleteCircuit(gas,cost);
        System.out.println(i);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] temp = new int[length];

        for (int i = 0; i < length; i++) {
            temp[i] = gas[i] - cost[i];
        }
//        int start = 0;
//        int i = start;

        for (int start = 0; start < length; start++) {
            if (temp[start] < 0) {
                continue;
            }
            int sum = 0;
            int k = start;

            for (int i = 0; i < length; i++) {

                sum += temp[k];
                if (sum < 0) {
                    break;
                }
                k=(k+1)%length;
            }
            if (sum >= 0) {
                return start;
            }

        }
        return -1;
    }
}
