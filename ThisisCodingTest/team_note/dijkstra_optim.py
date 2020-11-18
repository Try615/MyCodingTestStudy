# 한빛 '이것이 코딩테스트다 with python'
# '최단 경로' 9-2.py
# 개선된 다익스트라 알고리즘 소스코드.

# 이 코드는 최단 거리만을 측정. 최단 경로를 알고 싶다면 코드 수정 필요.

import sys
import heapq
import time

input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

st = time.time()

def dijkstra(start):
    q = []

    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue
        
        for i in graph[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (distance[i[0]], i[0]))

dijkstra(start)

for i in range(1, n+1):
    if distance[i] == INF:
        print('infinite')
    else:
        print(distance[i])
print('time : ', time.time() - st)