public class Player {
    private Position position;
    private Position firstPosition;

    public enum Move {
        UP, DOWN, LEFT, RIGHT
    }

    public Player(Position position){
        this.position = position;
        this.firstPosition = position.clone();
    }

    public void resetStartingPos() {
        position.x = firstPosition.x;
        position.y = firstPosition.y;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void move(Move m){
        switch (m){
            case UP:
                position.y = position.y + 1;
                break;
            case DOWN:
                position.y = position.y - 1;
                break;
            case LEFT:
                position.x = position.x - 1;
                break;
            case RIGHT:
                position.x = position.x + 1;
                break;
            default:
                throw new IllegalArgumentException("!Invalid Move!");
        }
    }

    public int same(int n) {
        return n;
    }
}
