import java.io.*;
import java.util.*;

// 백준 16946. 벽 부수고 이동하기 4.
// DFS.
public class BJ_16946 {
	static int N, M;
	static int[][] map;
	static int[][] preCalc;
	static int[][] area;
	static boolean[][] visited;
	static int numWall;
	static int count;

	static List<Integer> list = new ArrayList<>();
	static Deque<Pos> dq = new LinkedList<Pos>();

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		area = new int[N][M];
		preCalc = new int[N][M];
		visited = new boolean[N][M];
		numWall = 0;
		count = 0;

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - 48;
				if (map[i][j] == 1) {
					numWall++;
				}
			}
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (flag) {
				break;
			}
			for (int j = 0; j < M; j++) {
				if (flag) {
					break;
				}
				if (map[i][j] == 0 && !visited[i][j]) {
					dfs(i, j);

					while (!dq.isEmpty()) {
						Pos node = dq.poll();
						preCalc[node.r][node.c] = count;
						area[node.r][node.c] = numWall;
					}
					count = 0;
					numWall--;

					if (numWall == 0) {
						flag = true;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int ar = i + dr[dir];
						int ac = j + dc[dir];

						if (ar < 0 || ar >= N || ac < 0 || ac >= M || list.contains(area[ar][ac])) {
							continue;
						}

						map[i][j] += preCalc[ar][ac];
						list.add(area[ar][ac]);
					}
					list.clear();
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]%10);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static void dfs(int row, int col) {

		visited[row][col] = true;
		count++;
		dq.add(new Pos(row, col));

		for (int dir = 0; dir < 4; dir++) {
			int ar = row + dr[dir];
			int ac = col + dc[dir];

			if (ar < 0 || ar >= N || ac < 0 || ac >= M || visited[ar][ac] || map[ar][ac] != 0) {
				continue;
			}

			dfs(ar, ac);
		}
	}
}
