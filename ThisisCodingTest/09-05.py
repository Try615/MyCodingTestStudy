# 한빛 '이것이 코딩테스트다 with python'
# '최단 경로' 9-5.py
# 전보 문제.

# 노드의 수와 간선의 수를 보면 플루이드 워셜은 베제해야함.

import heapq
import sys
import time
input = sys.stdin.readline

INF = int(1e9)

N, M, C = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))

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
            cost = dist + n[1]

            if distance[n[0]] > cost:
                distance[n[0]] = cost
                heapq.heappush(q, (cost, n[0]))
    return distance

result = dijkstra(C)

num_city = N-1
num_time = 0

for i in range(1, N+1):
    if result[i] == INF:
        num_city -= 1
    else:
        num_time = max(num_time, result[i])

print(num_city, num_time)