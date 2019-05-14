public class Player {
    private Position position;
    private Position firstPosition;

    private boolean[][] visible;
    private int teamId;

    public void setTeamID(int teamNum) {
        this.teamId = teamNum;
    }

    public int getTeamID() {
        return this.teamId;
    }

    public enum Move {
        UP, DOWN, LEFT, RIGHT
    }

    public Player(Position position, int mapSize){
        this.position = position;
        this.firstPosition = position.clone();

        this.visible = new boolean[mapSize][mapSize];
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
                throw new IllegalArgumentException("Invalid Move!");
        }
    }

    public void setVisible(Position position, boolean v) {
        this.visible[position.x][position.y] = v;
    }

    public void setVisible(int x, int y, boolean v) {
        this.visible[x][y] = v;
    }

    public boolean isVisible(Position position) {
        return this.visible[position.x][position.y];
    }

    public boolean isVisible(int x, int y) {
        return this.visible[x][y];
    }
}
