# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-11.py
# 뱀 문제
# https://www.acmicpc.net/problem/3190

from collections import deque

N = int(input())
K = int(input())

# 게임판
field = [[0 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(K):
    x, y = map(int, input().split())
    # 사과의 위치를 1로 표기.
    field[x][y] = 1

L = int(input())

snake_mv = []
for _ in range(L):
    t, c = input().split()
    snake_mv.append([int(t), c])

# 뱀의 좌표 이동
move_x = [0, 1, 0, -1]
move_y = [1, 0, -1, 0]
dx, dy = 0, 0
snake_pos = [1, 1]
# 뱀의 몸통을 기억할 큐.
snake = deque()
snake.append(snake_pos)

order_idx = 0
game_time = 0

while True:
    if game_time == snake_mv[order_idx][0]:
        if snake_mv[order_idx][1] == 'L':
            dx = dx-1 if dx > 0 else 3
            dy = dy-1 if dy > 0 else 3
        else:
            dx = dx+1 if dx < 3 else 0
            dy = dy+1 if dy < 3 else 0
        if order_idx != L-1:
            order_idx += 1

    x = snake_pos[0] + move_x[dx]
    y = snake_pos[1] + move_y[dy]
    
    game_time += 1

    # 게임판을 벗어나는 경우
    if x < 1 or x >= N+1 or y < 1 or y >= N+1:
        break
    
    # 뱀의 몸통과 부딫치는 경우
    if [x, y] in snake:
        break

    # 사과를 먹는 경우, 큐에서 POP하지 않음.
    snake.append([x, y])
    if field[x][y] != 1:
        snake.popleft()

    snake_pos[0] = x
    snake_pos[1] = y    


print(game_time)


# 답안 예시
"""
n = int(input())
k = int(input())

data = [[0]* (n+1) for _ in range(n+1)]
info = []

for _ in range(k):
    a, b = map(int, input().split())
    data[a][b] = 1

l = int(input())
for _ in range(l):
    x, c = input().split()
    info.append((int(x), c))
    
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(direction, c):
    if c == 'L':
        # 내 코드는 if문으로 처리한 것에 비해 나머지 연산으로 인덱싱 하는 것이 더 효과적으로 보인다.
        direction = (direction - 1) % 4
    else:
        direction = (direction + 1) % 4
    return direction

def simulate():
    x, y = 1, 1
    # 뱀의 위치를 맵상에서 2로 여김.
    data[x][y] = 2 
    # 내 코드는 dx, dy로 인덱스를 나눈 것에 비해 하나의 변수로 처리한 것이 더 좋아보인다.
    direction = 0
    time = 0
    index = 0
    q = [(x, y)]
    
    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]

        # 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면.
        if 1 <= nx and nx <= n and 1 <= ny and ny <= n and data[nx][ny] != 2:
            if data[nx][ny] == 0:
                data[nx][ny] = 2
                q.append((nx, ny))
                # 예시에선 일반 리스트를 사용하여 pop(0)으로 선입선출 처리.
                px, py = q.pop(0)
                data[px][py] = 0
            if data[nx][ny] == 1:
                data[nx][ny] = 2
                q.append((nx, ny))
        else:
            time += 1
            break

        x, y = nx, ny
        time += 1

        if index < l and time == info[index][0]:
            direction = turn(direction, info[index][1])
            index += 1

    return time

print(simulate())
"""