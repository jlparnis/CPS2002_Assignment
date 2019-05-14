import java.util.ArrayList;
import java.util.List;

public class PlayerObserver extends Observer{

    List<Player> teamMembers;

    PlayerObserver(Subject subject, List<Player> teamMembers) {
        this.teamMembers = teamMembers;
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if(teamMembers != null) {
            for (int i = 0; i < teamMembers.size(); i++) {
                teamMembers.get(i).setVisible(subject.getPosition(), true);
            }
        }
    }
}
