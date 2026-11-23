import java.util.*;
import java.io.*;

public class Main {

	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int P = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Room> rooms = new ArrayList<>();

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();
			Player player = new Player(nickname, level);

			boolean flag = true;
			for (Room room : rooms) {
				if (room.isStared)
					continue;

				boolean rst = room.addPlayer(player);

				if (rst) {
					flag = false;
					break;
				}
			}
			if (flag) {
				rooms.add(new Room(player));
			}
		}

		for (Room room : rooms) {
			room.printRoom();
		}
	}

	public static class Room {
		public boolean isStared;
		private List<Player> players;
		private int level;

		public boolean addPlayer(Player player) {
			if (Math.abs(player.level - level) <= 10) {
				players.add(player);
				updateStatus();
				return true;
			}
			return false;
		}

		private boolean updateStatus() {
			if (players.size() == M) {
				isStared = true;
				return true;
			}
			isStared = false;
			return false;
		}

		public void printRoom() {
			if (isStared)
				System.out.println("Started!");
			else
				System.out.println("Waiting!");

			Collections.sort(players, (o1, o2) -> o1.nickname.compareTo(o2.nickname));
			for (Player player : players) {
				System.out.printf("%d %s\n", player.level, player.nickname);
			}
		}

		public Room(Player player) {
			players = new ArrayList<>();
			players.add(player);
			level = player.level;
			updateStatus(); 
		}
	}

	public static class Player {
		public String nickname;
		public int level;

		Player(String nickname, int level) {
			this.nickname = nickname;
			this.level = level;
		}

		public Player of(String nickname, int level) {
			return new Player(nickname, level);
		}
	}
}
