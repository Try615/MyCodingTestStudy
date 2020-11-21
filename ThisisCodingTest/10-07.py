# 한빛 '이것이 코딩테스트다 with python'
# '그래프 이론' 10-7.py
# 팀 결성 문제.

# 서로소 집합

n, m = map(int, input().split())

parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

graph = []
for _ in range(m):
    c, a, b = map(int, input().split())
    graph.append((c, a, b))

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

for i in range(m):
    order, a, b = graph[i]

    if order == 0:
        union_parent(parent, a, b)
    elif order == 1:
        if find_parent(parent, a) == find_parent(parent, b):
            print('YES')
        else:
            print('NO')