# 한빛 '이것이 코딩테스트다 with python'
# 'DFS/BFS' 5-8.py
# DFS 예제

# DFS 메소드 정의
# 인접 리스트 사용
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end= ' ')
    
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9

dfs(graph, 1, visited)  