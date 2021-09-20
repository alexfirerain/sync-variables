public class User implements Runnable {
    final private int ATTEMPTS_NUMBER;
    final private int MIN_ATTEMPT_PERIOD;
    final private int MAX_ATTEMPT_PERIOD;
    final private Box toy;              // с точки зрения пользователя, коробка в целом является игрушкой

    public User(int attempts_number,
                int min_attempt_period,
                int max_attempt_period,
                Box toy) {
        ATTEMPTS_NUMBER = attempts_number;
        MIN_ATTEMPT_PERIOD = min_attempt_period;
        MAX_ATTEMPT_PERIOD = max_attempt_period;
        this.toy = toy;
    }

    private void restBetweenAttempts() {
        long period = (long) ((
                (MAX_ATTEMPT_PERIOD - MIN_ATTEMPT_PERIOD) * Math.random()
                              ) + MIN_ATTEMPT_PERIOD);
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            System.out.println("Нежданное прерывание работы пользователя.");
        }
    }

    private void turnBoxOn() {
        System.out.println("Пользователь включает тумблер.");
        // доступ через метод:
        toy.turnOn();

//        // с прямым доступом к переменной:
//        toy.toggleOn = true;
    }

    @Override
    public void run() {
        int attempts_count = 0;
        while (attempts_count < ATTEMPTS_NUMBER) {
            restBetweenAttempts();
            turnBoxOn();
            attempts_count++;
        }
        System.out.println("Пользователь прекратил попытки.");
    }
}
