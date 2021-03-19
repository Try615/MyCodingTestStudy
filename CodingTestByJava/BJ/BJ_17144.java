import java.io.*;
import java.util.StringTokenizer;

public class BJ_17144 {
	static int R, C, T;
	static int[] dr = {0, 1, 0, -1, 0};
	static int[] dc = {1, 0, -1, 0, 1};
	static int[][] field;
	static int[][] diffusion;
	
	static boolean acFirst = false;
	static int acFirstRow;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		field = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j] == -1 && !acFirst) {
					acFirstRow = i;
					acFirst = true;
				}
			}
		}
		
		while(T > 0) {
			diffusion = new int[R][C];
			
			for(int i=0; i< R; i++) {
				for(int j=0; j<C; j++) {
					if(field[i][j] > 0) {
						int count = 0;
						for(int dir=0; dir<4; dir++) {
							int ar = i + dr[dir];
							int ac = j + dc[dir];
							
							if(ar < 0 || ar >= R || ac < 0 || ac >= C || field[ar][ac] == -1) {
								continue;
							}
							
							diffusion[ar][ac] += field[i][j] / 5;
							count++;
						}
						diffusion[i][j] += field[i][j] - (field[i][j]/5)*count;
					}else if(field[i][j] == -1) {
						diffusion[i][j] = -1;
					}
				}
			}
			field = diffusion;
			
			int dir = 4;
			int ar = acFirstRow;
			int ac = 0;
			int tempSwap = 0;
			int temp = 0;
			while(dir > 0) {
				ar = ar + dr[dir];
				ac = ac + dc[dir];
				
				if(ar < 0 || ar >= R || ac < 0 || ac >= C || field[ar][ac] == -1) {
					ar = ar - dr[dir];
					ac = ac - dc[dir];
					dir--;
					continue;
				}
				
				tempSwap = field[ar][ac];
				field[ar][ac] = temp;
				temp = tempSwap;
			}
			
			dir = 0;
			ar = acFirstRow+1;
			ac = 0;
			tempSwap = 0;
			temp = 0;
			while(dir < 4) {
				ar = ar + dr[dir];
				ac = ac + dc[dir];
				
				if(ar < 0 || ar >= R || ac < 0 || ac >= C || field[ar][ac] == -1) {
					ar = ar - dr[dir];
					ac = ac - dc[dir];
					dir++;
					continue;
				}
				
				tempSwap = field[ar][ac];
				field[ar][ac] = temp;
				temp = tempSwap;
			}		
			
			T--;
		}
		
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(field[i][j] > 0) {
					result += field[i][j];
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
