public class Box {
    // для доступа через метод:
    private volatile boolean toggleOn;
    public boolean isToggleOn() {
        return toggleOn;
    }

//    // с прямым доступом к переменной:
//    boolean toggleOn;

    public Box(boolean toggleOn) {
        this.toggleOn = toggleOn;
    }

    public void turnOn() {
        if (!toggleOn) {
            toggleOn = true;
            System.out.println("Тумблер включён!");
        } else {
            System.out.println("Попытка включить уже включённое.");
        }
    }

    public void turnOff() {
        if (toggleOn) {
            toggleOn = false;
            System.out.println("Тумблер выключен!");
        } else {
            System.out.println("Попытка выключить уже выключенное.");
        }
    }
}
