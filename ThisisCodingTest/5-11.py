# 한빛 '이것이 코딩테스트다 with python'
# 'DFS/BFS' 5-11.py
# 미로 탈출 문제.

import time
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
maze = []
for i in range(N):
    maze.append(list(map(int, sys.stdin.readline().rstrip())))

start = time.time()

def bfs(maze, first, count):
    global N, M
    graph = deque([[first, count]])
    visited = [[False for _ in range(M)] for _ in range(N)]

    while graph:
        node, c = graph.popleft()
        x, y = node[0], node[1]

        visited[x][y] = True
        if maze[x][y] == 0:
            continue
        elif maze[x][y] == 1:
            maze[x][y] = c
        else:
            maze[x][y] = min(maze[x][y], c)
        c += 1
        
        # bfs로 같은 depth 순으로 방문.
        if x-1 >= 0 and visited[x-1][y] == False:
            graph.append([[x-1, y], c])
        if x+1 < N and visited[x+1][y] == False:
            graph.append([[x+1, y], c])
        if y-1 >= 0 and visited[x][y-1] == False:
            graph.append([[x, y-1], c])
        if y+1 < M and visited[x][y+1] == False:
            graph.append([[x, y+1], c])

bfs(maze, [0,0], 1)

print(maze[N-1][M-1])
print('time : ', time.time() - start)
# 답안에 비교해서 별도의 방문 함수도 사용하여 메모리적으로도 낭비가 심했다. 답안 식으로 구현하도록 후에 다시 시도해보자.

# 답안 예시
"""

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

start = time.time()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            
            if graph[nx][ny] == 0:
                continue
            # 처음 방문하는 경우만 갱신. 
            # bfs로 같은 depth 순으로 방문하므로 처음 방문보다 늦으면 최적 경로가 아니므로 고려 안한다.
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

    return graph[n-1][m-1]

print(bfs(0,0))
print("time : ", time.time() - start)
"""