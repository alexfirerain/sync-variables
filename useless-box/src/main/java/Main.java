public class Main {
    public static void main(String[] args) {
        Box box = new Box(false);
        Thread user = new Thread(new User(7, 1500, 6000, box));
        Thread toy = new Thread(new Toy(box));
        user.start();
        toy.start();
        try {
            user.join();
        } catch (InterruptedException e) {
            System.out.println("Неожиданное прерывание программы симуляции.");
        }
        toy.interrupt();
    }
}
