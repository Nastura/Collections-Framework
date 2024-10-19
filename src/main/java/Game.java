import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> person = new ArrayList<>();

    public void register(Player player) {
        person.add(player);

    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        boolean check1 = checkName(playerName1);
        boolean check2 = checkName(playerName2);

        if (!check1 && check2) {
            throw new NotRegisteredException("" +
                    "Игрок с именем " + playerName1 + " не зарегистрирован на турнир");
        } else if (check1 && !check2) {
            throw new NotRegisteredException("" +
                    "Игрок с именем " + playerName2 + " не зарегистрирован на турнир");
        } else if (!check1 && !check2) {
            throw new NotRegisteredException("" +
                    "Игроки с именами " + playerName1 + " и " + playerName2 + " не зарегистрирован на турнир");
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





