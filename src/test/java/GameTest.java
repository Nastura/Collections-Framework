import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameTest {

    Player player1 = new Player(1, "Кирилл", 15);
    Player player2 = new Player(2, "Леон", 30);
    Player player3 = new Player(3, "Тая", 15);
    Player player4 = new Player(4, "Люси", 45);
    Player player5 = new Player(4, "Денис", 13);
    Player player6 = new Player(4, "Филипп", 13);
    Player player7 = new Player(4, "Алексей", 33);
    Game game = new Game();

    @Test  // 1. Успешная регистрация игроков
    public void successfulPlayerRegistration() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        boolean test = game.person.isEmpty();
        Assertions.assertFalse(test);
    }

    @Test  // 2. Оба игрока не зарегистрированы на турнир
    public void notSuccessfulPlayerRegistration() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Владислав", "Марат"));
    }

    @Test // 3. Сила 2 игрока больше чем у игрока 1
    public void firstTwo() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 2;
        int actual = game.round("Кирилл", "Леон");
        Assertions.assertEquals(expected, actual);
    }

    @Test // 4. Сила 1 игрока больше чем у игрока 2
    public void firstOne() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 1;
        int actual = game.round("Люси", "Тая");
        Assertions.assertEquals(expected, actual);
    }

    @Test // 5. Силы равны
    public void nikya() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 0;
        int actual = game.round("Кирилл", "Тая");
        Assertions.assertEquals(expected, actual);
    }


    @Test // 6. 1 игрок зарегестрирован, 2 игрок нет,
    public void oneNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Кирилл", "Люси"));
    }


    @Test  //7. 1 не зарег, 2 игрок да.
    public void twoNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Люси", "Леон"));
    }


    @Test  // 8 вывести список всех имен игроков зарегистрированных
    public void findAllName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        String[] expected = {"Кирилл", "Леон", "Тая","Денис", "Филипп", "Алексей" };
        String[] actual = game.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //9. 1 не зарег, 2 игрок да.
    public void getName() {
        game.register(player1);
        String expected = "Кирилл";
        String actual = player1.getName();
        Assertions.assertEquals(expected, actual);
    }
    @Test //10. 1 не зарег, 2 игрок да.
    public void getId() {
        game.register(player1);
        int expected = 1;
        int actual = player1.getId();
        Assertions.assertEquals(expected, actual);
    }
    @Test //11
    public void getStrength() {
        game.register(player1);
        int expected = 15;
        int actual = player1.getStrength();
        Assertions.assertEquals(expected, actual);
    }

    @Test //12
    public void setStrength() {
        game.register(player1);
        player1.setStrength(20);
        int expected = 20;
        int actual = player1.getStrength();
        Assertions.assertEquals(expected, actual);
    }

    @Test //13
    public void setId() {
        game.register(player1);
        player1.setId(20);
        int expected = 20;
        int actual = player1.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test //14
    public void setName() {
        game.register(player1);
        player1.setName("Ник");
        String expected = "Ник";
        String actual = player1.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test  //15
    public void compare() {
        GameComporator gameComporator = new GameComporator();
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = gameComporator.compare(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test  // 16
    public void gameComporator() {
        GameComporator gameComporator = new GameComporator();
        game.register(player4);
        game.register(player2);
        int expected = -1;
        int actual = gameComporator.compare(player4, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test  // 17
    public void nikyaPlayer() {
        GameComporator gameComporator = new GameComporator();
        game.register(player1);
        game.register(player3);
        int expected = 0;
        int actual = gameComporator.compare(player1, player3);
        Assertions.assertEquals(expected, actual);
    }

}