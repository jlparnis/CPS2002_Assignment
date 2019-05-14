import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private Position position;

    private int teamId;

    private boolean visible;

    public boolean notified = false;

    Position getPosition() {
        return position;
    }

    public void setVisible(Position position, boolean visible) {
        this.position = position;
        this.visible = visible;

        if(observers.size() > 0) {
            notifyAllObservers();
        }
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamId() {
        return teamId;
    }

    private void notifyAllObservers() {
        notified = false;

        observers.get(teamId).update();

        notified = true;
    }

    public void attach(PlayerObserver playerObserver) {
        observers.add(playerObserver);
    }
}
