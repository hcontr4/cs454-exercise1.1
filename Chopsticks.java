class Chopsticks {
    /*
     * represent chopsticks as Objects in array to use synchronized blocks,
     * philosophers then sit between chopsticks i.e. chopstick on left of
     * first philosopher is chopsticks[0] and right is chopsticks[1]
     */
    private Object[] chopsticks;
    private int n;

    public Chopsticks(int n) {
        chopsticks = new Object[n];
        for (int i = 0; i < n; i++) {
            chopsticks[i] = new Object();
        }

        this.n = n;
    }

    public void eat(int philosopher) throws InterruptedException {

        /*
         * Every philosopher will try to pick up the chopstick on their
         * left first to use as leftChopstick, EXCEPT the last philosopher.
         * He will try to make the leftChopstick the chopstick to his right.
         */
        int leftChopstick  = Math.min(philosopher, (philosopher + 1) % n);
        int rightChopstick = Math.max(philosopher, (philosopher + 1) % n);

       // try to access leftChopstick
        synchronized (chopsticks[leftChopstick]) {
            // if leftChopstick was available, try to access right
            synchronized (chopsticks[rightChopstick]) {
                // congrats you can eat
                System.out.println("Philosopher " + philosopher + " is eating with chopsticks " + leftChopstick + " and " + rightChopstick);
                // yum, philosopher is eating
                Thread.sleep(1000);
            }
        }
    }
}
