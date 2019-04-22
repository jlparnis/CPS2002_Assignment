public class Player {
    private Position position;

    public Player(){

    }

    public Player(Position position){
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void move(char move){
        switch (move){
            case 'U':
                position.y = position.y + 1;
                break;
            case 'D':
                position.y = position.y - 1;
                break;
            case 'L':
                position.x = position.x - 1;
                break;
            case 'R':
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
