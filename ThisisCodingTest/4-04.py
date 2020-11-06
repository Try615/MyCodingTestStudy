# 한빛 '이것이 코딩테스트다 with python'
# '구현' 4-4.py

import time
#"""
n, m = map(int, input().split())
row, col, v = map(int, input().split())

field = [[] for _ in range(n)]

for i in range(n):
    field[i] = list(map(int, input().split()))
# 방문을 하나의 리스트에 다른 값으로 처리.
field[row][col] = 2

start = time.time()
land = 1

while True:
    if v <= 0:
        v = 3
    else:
        v -= 1 
    
    if v == 0:
        if field[row-1][col] == 0:
            row -= 1
        elif field[row-1][col] == 1:
            if field[row+1][col] != 1:
                row += 1
    elif v == 1:
        if field[row][col+1] == 0:
            col += 1
        elif field[row][col+1] == 1:
            if field[row][col-1] != 1:
                col -= 1
    elif v == 2:
        if field[row+1][col] == 0:
            row += 1
        elif field[row+1][col] == 1:
            if field[row-1][col] != 1:
                row -= 1
    elif v == 3:
        if field[row][col-1] == 0:
            col -= 1
        elif field[row][col-1] == 1:
            if field[row][col+1] != 1:
                col += 1

    if field[row][col] == 0:
        land += 1
        field[row][col] = 2

    if field[row+1][col] != 0 and field[row-1][col] != 0 and field[row][col+1] != 0 and field[row][col-1] != 0:
        break

print(land)
print('time : ', time.time() - start)
#"""
# 답안 예시
"""
n, m = map(int, input().split())

# 방문을 별개의 리스트 d로 처리.
d = [[0]*m for _ in range(n)]
x, y, direction = map(int, input().split())
d[x][y] = 1

array = []
for i in range(n):
    array.append(list(map(int, input().split())))

start = time.time()

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3

count = 1
turn_time = 0

while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        turn_time = 0
        print(x, y)
        continue
    else:
        turn_time += 1
    
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]
        if array[nx][ny] == 0:
            x = nx
            y = ny
            print(x, y)
        else:
            break
        turn_time = 0
    
print(count)
print('time : ', time.time() - start)
"""