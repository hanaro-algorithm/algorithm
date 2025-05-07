import java.util.*;

public class Main {

    static class Player {
        int level;
        String nickname;

        Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static class Room {
        int baseLevel;
        List<Player> players = new ArrayList<>();

        Room(int baseLevel) {
            this.baseLevel = baseLevel;
        }

        boolean canJoin(Player player, int maxSize) {
            return players.size() < maxSize &&
                    Math.abs(player.level - baseLevel) <= 10;
        }

        void addPlayer(Player player) {
            players.add(player);
        }

        void printRoom(int maxSize) {
            if (players.size() == maxSize) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            players.sort(Comparator.comparing(p -> p.nickname));
            for (Player p : players) {
                System.out.println(p.level + " " + p.nickname);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int M = sc.nextInt();

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            int level = sc.nextInt();
            String nickname = sc.next();
            Player newPlayer = new Player(level, nickname);

            boolean joined = false;
            for (Room room : rooms) {
                if (room.canJoin(newPlayer, M)) {
                    room.addPlayer(newPlayer);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                Room newRoom = new Room(level);
                newRoom.addPlayer(newPlayer);
                rooms.add(newRoom);
            }
        }

        for (Room room : rooms) {
            room.printRoom(M);
        }
    }
}
