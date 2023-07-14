import java.util.ArrayList;
import java.util.List;

public class Team extends ObjectPlus4{
    private String name;
    private List<Player> teamPlayers;


    public Team(String name) {
        super();
        setName(name);
        this.teamPlayers = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", teamPlayers=" + teamPlayers.toString() +
                '}';
    }
}
