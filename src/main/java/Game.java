import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> person = new ArrayList<>();

    public void register(Player player) {
        person.add(player);

    }

    public int round(String playerName1, String playerName2) {

        if (test(playerName1, playerName2)) {

        } else {
            throw new NotRegisteredException("" +
                    "Игрок не зарегистрирован на турнир");
        }

        Player player1 = null;
        Player player2 = null;
        for (Player player : person) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }


    //System.out.println("Игроки зарегистрированы. Начинается турнир");
    public boolean test(String playerName1, String playerName2) {
        if (this.checkName(playerName1) && this.checkName(playerName2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkName(String name) {
        for (Player player : person) {
            if (name.equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    public String[] findAll() {
        String[] name = new String[person.size()];
        {
            int i = 0;
            for (Player player : person) {
                name[i] = player.getName();
                i++;
            }
        }
        return name;
    }
}

//    public Player getByName(String name) {
//        ArrayList<Player> found = new ArrayList<Player>(
//                this.person.stream().filter((el) -> {
//            return el.getName().equals(name);}));





