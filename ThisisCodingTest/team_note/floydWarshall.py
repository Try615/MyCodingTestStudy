# 한빛 '이것이 코딩테스트다 with python'
# '최단 경로' 9-3.py
# 플로이드 워셜 알고리즘 소스코드.

# 모든 지점에서 다른 모든 지점까지의 최단 경로

import time

INF = int(1e9)

n, m = map(int, input().split())

graph = [[INF] * (n+1) for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c

st = time.time()

for a in range(1, n+1):
    graph[a][a] = 0

# 거쳐가는 중간 노드 번호.
for i in range(1, n+1):
    # 출발 노드.
    for j in range(1, n+1):
        # 도착 노드.
        for k in range(1, n+1):
            graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])

for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            print('infinite', end=' ')
        else:
            print(graph[a][b], end=' ')
    print()
print('time : ', time.time() - st)