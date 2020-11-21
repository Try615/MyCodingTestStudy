# 위상 정렬

# 차례가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘
# 방향 그래프의 모든 노드를 '방향성에 거스르지 않도록 순서대로 나열하는 것'

# 시간복잡도 O(노드 수 + 간선 수) = O(V+E)

from collections import deque

v, e = map(int, input().split())
# 진입 차수 0으로 초기화.
indegree = [0] * (v+1)
graph = [[] for i in range(v+1)]

for _ in range(e):
    a, b = map(int, input().split())
    # 노드 a에서 b로 이동 가능.
    graph[a].append(b)
    # 이동되는 곳으로 진입 차수 1 증가.
    indegree[b] += 1

def topology_sort():
    result = []
    q = deque()

    # 처음 진입차수가 0인 노드를 큐에 삽입.
    for i in range(1, v+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        result.append(now)

        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
    
    for i in result:
        print(i, end = ' ')
    
topology_sort()