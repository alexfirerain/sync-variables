import static java.lang.Thread.interrupted;

public class Toy implements Runnable {
    private Box box;

    public Toy(Box box) {
        this.box = box;
    }

    public void turnBoxOff() {
        System.out.println("Игрушка выключает тумблер");
        // с доступом через метод:
        box.turnOff();

//      // с прямым доступом к переменной:
//        box.toggleOn = false;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            // с доступом через метод:
            if (box.isToggleOn())
                turnBoxOff();

//        // с прямым доступом к переменной:
//            if (box.toggleOn)
//                 box.toggleOn = false;
        }
        System.out.println("Игрушка выключается.");
    }
}
