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
                position.setY(position.getY()+1);
                break;
            case 'D':
                position.setY(position.getY()-1);
                break;
            case 'L':
                position.setX(position.getX()-1);
                break;
            case 'R':
                position.setX(position.getX()+1);
                break;
            default:
                throw new IllegalArgumentException("!Invalid Move!");
        }
    }
}
