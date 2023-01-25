package Island.Location.AliveOrganism.Animals.Moving;

public class Move {
    protected final MoveDirection direction;
    protected final int countOfSteps;

    public Move(MoveDirection direction, int countOfSteps) {
        this.direction = direction;
        this.countOfSteps = countOfSteps;
    }

    public MoveDirection getDirection() {
        return direction;
    }

    public int getCountOfSteps() {
        return countOfSteps;
    }
}
