package com.ssafy.day0317;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int result = 0;
		int[] gear = new int[4];
		for(int i=0; i<4; i++) {
			gear[i] = btd(br.readLine());
		}
		
		int rotate = Integer.parseInt(br.readLine());
		
		for(int i=0; i<rotate; i++) {
			int gear1_3 = (gear[0] & (1<<5)) != 0? 1:0;
			int gear2_9 = (gear[1] & (1<<1)) != 0? 1:0;
			int gear2_3 = (gear[1] & (1<<5)) != 0? 1:0;
			int gear3_9 = (gear[2] & (1<<1)) != 0? 1:0;
			int gear3_3 = (gear[2] & (1<<5)) != 0? 1:0;
			int gear4_9 = (gear[3] & (1<<1)) != 0? 1:0;
			
			boolean g1_g2 = (gear1_3 != gear2_9)? true: false;
			boolean g2_g3 = (gear2_3 != gear3_9)? true: false;
			boolean g3_g4 = (gear3_3 != gear4_9)? true: false;
			
			st = new StringTokenizer(br.readLine(), " ");
			int target = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			switch(target) {
			case 1:
				if(direction == 1) {
					gear[0] = rightTurn(gear[0]);
					if(g1_g2) {
						gear[1] = leftTurn(gear[1]);
						if(g2_g3) {
							gear[2] = rightTurn(gear[2]);
							if(g3_g4) {
								gear[3] = leftTurn(gear[3]);
							}
						}
					}
				}else {
					gear[0] = leftTurn(gear[0]);
					if(g1_g2) {
						gear[1] = rightTurn(gear[1]);
						if(g2_g3) {
							gear[2] = leftTurn(gear[2]);
							if(g3_g4) {
								gear[3] = rightTurn(gear[3]);
							}
						}
					}
				}
				break;
			case 2:
				if(direction == 1) {
					gear[1] = rightTurn(gear[1]);
					if(g1_g2) {
						gear[0] = leftTurn(gear[0]);
					}
					if(g2_g3) {
						gear[2] = leftTurn(gear[2]);
						if(g3_g4) {
							gear[3] = rightTurn(gear[3]);
						}
					}
				}else {
					gear[1] = leftTurn(gear[1]);
					if(g1_g2) {
						gear[0] = rightTurn(gear[0]);
					}
					if(g2_g3) {
						gear[2] = rightTurn(gear[2]);
						if(g3_g4) {
							gear[3] = leftTurn(gear[3]);
						}
					}
				}
				break;
			case 3:
				if(direction == 1) {
					gear[2] = rightTurn(gear[2]);
					if(g3_g4) {
						gear[3] = leftTurn(gear[3]);
					}
					if(g2_g3) {
						gear[1] = leftTurn(gear[1]);
						if(g1_g2) {
							gear[0] = rightTurn(gear[0]);
						}
					}
				}else {
					gear[2] = leftTurn(gear[2]);
					if(g3_g4) {
						gear[3] = rightTurn(gear[3]);
					}
					if(g2_g3) {
						gear[1] = rightTurn(gear[1]);
						if(g1_g2) {
							gear[0] = leftTurn(gear[0]);
						}
					}
				}
				break;
			case 4:
				if(direction == 1) {
					gear[3] = rightTurn(gear[3]);
					if(g3_g4) {
						gear[2] = leftTurn(gear[2]);
						if(g2_g3) {
							gear[1] = rightTurn(gear[1]);
							if(g1_g2) {
								gear[0] = leftTurn(gear[0]);
							}
						}
					}
				}else {
					gear[3] = leftTurn(gear[3]);
					if(g3_g4) {
						gear[2] = rightTurn(gear[2]);
						if(g2_g3) {
							gear[1] = leftTurn(gear[1]);
							if(g1_g2) {
								gear[0] = rightTurn(gear[0]);
							}
						}
					}
				}
				break;
			default:
				break;
			}
		}
		
		for(int i=0; i<4; i++) {
			result += resultCount(gear[i]) * Math.pow(2, i);
		}
		System.out.println(result);
		br.close();
	}
	
	static int btd(String s) {
		int result = 0;
		for(int i=0; i<8; i++) {
			if(s.charAt(i) == '1') {
				result += (int)Math.pow(2, 7-i);
			}
		}
		return result;
	}
	
	static int resultCount(int gear) {
		if((gear & (1<<7)) != 0) {
			return 1;
		}
		return 0;
	}
	
	static int rightTurn(int gear) {
		int mlb = gear & (1<<0);
		gear >>>= 1;
		if(mlb != 0) {
			gear |= (1 << 7);
		}
		
		return gear;
	}
	
	static int leftTurn(int gear) {
		int msb = gear & (1<<7);
		gear <<= 1;
		if(gear >= Math.pow(2, 8)) {
			gear -= (int)Math.pow(2, 8);
		}
		if(msb != 0) {
			gear |= (1 << 0);
		}
		
		return gear;
	}
}
