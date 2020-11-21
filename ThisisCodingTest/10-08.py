# 한빛 '이것이 코딩테스트다 with python'
# '그래프 이론' 10-8.py
# 도시 분할 계획 문제.

# 크루스칼 알고리즘.

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

edges = []
result = 0
divide_town = 0
parent = [0] * (N+1)
for i in range(1, N+1):
    parent[i] = i

for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))
edges.sort()

def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a > b:
        parent[a] = b
    else:
        parent[b] = a

for edge in edges:
    # cost로 오름차순된 간선 순으로 처리.
    cost, a, b = edge
    
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
        # 최소 유지비를 가진 2개의 마을 = 하나의 신장트리에서 제일 유지비가 큰 도로를 없애서 1개의 집으로 이루어진 마을로 만듬.
        divide_town = cost

print(result - divide_town)