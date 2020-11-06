# 한빛 '이것이 코딩테스트다 with python'
# 'DFS/BFS' 5-10.py
# 음료수 얼려먹기 문제.

from collections import deque
import time
#"""
n, m = map(int, input().split())

icetool = []
for i in range(n):
    icetool.append(list(map(int, input())))

start = time.time()
def bfs(graph, x, y):
    # 2차원 배열이 아닌 1차원 배열로 넣어서 x,y좌표가 따로 떨어진 문제 경험.
    queue = deque([[x, y]])
    graph[x][y] = 1

    while queue:
        node = queue.popleft()
        x = node[0]
        y = node[1]
        
        # row와 col을 x, y로 처리하다보니 헷갈린 문제 경험.
        if x-1 >= 0 and graph[x-1][y] == 0:
            queue.append([x-1, y])
            graph[x-1][y] = 1
        if x+1 < n and graph[x+1][y] == 0:
            queue.append([x+1, y])
            graph[x+1][y] = 1
        if y-1 >= 0 and graph[x][y-1] == 0:
            queue.append([x, y-1])
            graph[x][y-1] = 1
        if y+1 < m and graph[x][y+1] == 0:
            queue.append([x, y+1])
            graph[x][y+1] = 1
    
    return 1

count = 0
for i in range(n):
    while 0 in icetool[i]:
        x, y = i, icetool[i].index(0)
        count += bfs(icetool, x, y)

print(count)
# bfs 방식 입력 예시 15x14 속도 0.00031....
print('time : ', time.time() - start)

#"""
# 답안 예시
"""

n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

start = time.time()
def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False

    if graph[x][y] == 0:
        graph[x][y] = 1

        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)
# dfs 입력 예시 15x14 속도 : 0.000663....
print('time : ', time.time() - start)
"""