package Island.Location.AliveOrganism.Animals.Moving;

public enum MoveDirection {
    UP("Вверх"),
    DOWN("Вниз"),
    LEFT("Влево"),
    RIGHT("Вправо");

    private final String info;

    MoveDirection(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
