# 2차원 리스트 전체를 순환하는 것과 0인 부분만을 index()로 찾아서 방문하는 것의 속도 차가 궁금해서 속도를 비교해봄.
# 큰 차이가 없어서 혼란. index()는 O(N)일텐데 아직 고민중.

import time

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

count = 0
start1 = time.time()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            count += 1
print('n^2 array time : ', time.time() - start1)

start2 = time.time()
for i in range(n):
    while 0 in graph[i]:
        a = graph[i].index(0)
        graph[i][a] = 1
print('index time : ', time.time() - start2)