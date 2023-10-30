import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Game {
    void start(int maxKeystrokes);
    String processAction(char action);
}

class FlightSimple implements Game {
    private String name;
    private int speed;
    private int altitude;
    private int maxKeystrokes;
    private int keystrokes;

    public FlightSimple(String name) {
        this.name = name;
    }

    @Override
    public void start(int maxKeystrokes) {
        this.speed = 0;
        this.altitude = 0;
        this.maxKeystrokes = maxKeystrokes;
        this.keystrokes = 0;
    }

    @Override
    public String processAction(char action) {
        if (keystrokes >= maxKeystrokes) {
            return "Game Over";
        }

        switch (action) {
            case 'R':
                speed++;
                break;
            case 'L':
                if (speed > 0) {
                    speed--;
                } else {
                    return "Lost";
                }
                break;
            case 'U':
                if (speed > 2) {
                    altitude++;
                }
                break;
            case 'D':
                if (altitude > 0) {
                    altitude--;
                } else {
                    return "Lost";
                }
                break;
        }

        keystrokes++;

        if (altitude == 0 && speed == 0) {
            return "Won";
        }

        return "None";
    }
}

class RandomWalk implements Game {
    private String name;
    private int row;
    private int col;
    private int maxKeystrokes;
    private int keystrokes;

    public RandomWalk(String name) {
        this.name = name;
    }

    @Override
    public void start(int maxKeystrokes) {
        this.row = 10;
        this.col = 10;
        this.maxKeystrokes = maxKeystrokes;
        this.keystrokes = 0;
    }

    @Override
    public String processAction(char action) {
        if (keystrokes >= maxKeystrokes) {
            return "Game Over";
        }

        switch (action) {
            case 'R':
                if (col < 19) {
                    col++;
                } else {
                    return "Lost";
                }
                break;
            case 'L':
                if (col > 0) {
                    col--;
                }
                break;
            case 'U':
                if (row > 0) {
                    row--;
                    if (row == 0) {
                        return "Won";
                    }
                } else {
                    return "Won";
                }
                break;
            case 'D':
                if (row < 19) {
                    row++;
                } else {
                    return "Lost";
                }
                break;
        }

        keystrokes++;
        return "None";
    }
}


public class GameConsole {
    private List<Game> games;

    public GameConsole() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void playGames() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length < 2) {
                continue;
            }

            String gameName = tokens[0];
            int maxKeystrokes = Integer.parseInt(tokens[1]);

            Game currentGame = findGameByName(gameName);
            if (currentGame == null) {
                System.out.println("Invalid game: " + gameName);
                continue;
            }

            currentGame.start(maxKeystrokes);

            String actions = scanner.nextLine();
            char[] actionArray = actions.toCharArray();
            String result = playGame(currentGame, actionArray);

            System.out.println(gameName + ": " + result);
        }

        scanner.close();
    }

    private Game findGameByName(String name) {
        for (Game game : games) {
            if (game.getClass().getSimpleName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    private String playGame(Game game, char[] actions) {
        for (char action : actions) {
            String result = game.processAction(action);
            if (!result.equals("None")) {
                return result;
            }
        }
        return "Game Over";
    }

    public static void main(String[] args) {
        GameConsole console = new GameConsole();
        console.addGame(new FlightSimple("FlightSimple"));
        console.addGame(new RandomWalk("RandomWalk"));
        console.playGames();
    }
}
