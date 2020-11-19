# 크루스칼 알고리즘
# 최소 신장 트리 알고리즘이라고도 함.
# 신장 트리는 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프.
# 그리디 알고리즘의 일종으로 가장 적은 비용으로 모든 노드를 연결.

def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())
parent = [0] * (v+1)

# 모든 간선을 담을 리스트와 초종 비용을 담을 변수
edges = []
result = 0

for i in range(1, v+1):
    parent[i] = i

for _ in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)
print(parent)
# 전체를 find 돌리면 모든 노드가 1로 하나의 그래프를 만듬을 확인할 수 있다.
for i in range(1, v+1):
    find_parent(parent, i)
print(parent)