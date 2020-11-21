# 한빛 '이것이 코딩테스트다 with python'
# '최단 경로' 9-4.py
# 미래 도시 문제.

# 다익스트라

import heapq
import time
import sys
input = sys.stdin.readline
#"""
INF = int(1e9)

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))

X, K = map(int, input().split())

st = time.time()

def dijkstra(start):
    distance = [INF] * (N+1)
    q = []

    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, node = heapq.heappop(q)
        
        if distance[node] < dist:
            continue

        for n in graph[node]:
            cost = n[1] + dist
            if cost < distance[n[0]]:
                distance[n[0]] = cost
                heapq.heappush(q, (cost, n[0]))
    return distance

front = dijkstra(1)
back = dijkstra(K)

if front[K] == INF or back[X] == INF:
    print(-1)
else:
    print(front[K] + back[X])
print('time : ', time.time() - st)
#"""

# 답안 예시
# 플로이드 워셜 알고리즘.
'''
INF = int(1e9)

n, m = map(int, input().split())
graph = [[INF] * (n+1) for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

x, k = map(int, input().split())

st = time.time()

for a in range(1, n+1):
    graph[a][a] = 0

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

distance = graph[a][k] + graph[k][x]

if distance >= INF:
    print(-1)
else:
    print(distance)
print('time : ', time.time() - st)
'''