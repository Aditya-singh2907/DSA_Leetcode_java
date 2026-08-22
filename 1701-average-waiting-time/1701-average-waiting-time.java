class Solution {
    public double averageWaitingTime(int[][] customers) {
        if(customers.length == 1) {
            return customers[0][1];
        }
        double time = 1, wait = 0;
        for(int i=0; i<customers.length; i++) {
            double curr = customers[i][0];
            if(time < curr) {
                time = curr;
            }
            time += customers[i][1];
            wait += (time-curr);
        }
        return (wait/customers.length);
    }
}