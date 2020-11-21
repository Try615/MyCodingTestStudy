# 한빛 '이것이 코딩테스트다 with python'
# '그래프 이론' 10-9.py
# 커리큘럼 문제.

# 위상 정렬
# 문제를 풀고도 아직 이해 안가는 부분 : 선수 강의가 2개 이상일 경우 그 두 강의의 수강 시간을 다 더해야 듣고자 하는 강의의 최소 시간이 되는거 아닌가? 문제와 예시, 답은 가장 오래걸리는 선수과목 수강시간으로만 처리해서 푸는데 이해가 안됐음.

from collections import deque
import time
import sys
import copy
input = sys.stdin.readline

N = int(input())

indegrees = [0] * (N+1)
running_time = [0] * (N+1)
graph = [[] for _ in range(N+1)]

for i in range(1, N+1):
    lecture = i
    info = list(map(int, input().split()))
    run_time, pre_lectures = info[0], info[1:-1]
    running_time[lecture] = run_time

    for p in pre_lectures:
        graph[p].append(lecture)
        indegrees[lecture] += 1
  
st = time.time()
#"""
def topology_sort():
    q = deque()

    for i in range(1, N+1):
        if indegrees[i] == 0:
            q.append(i)

    while q:
        node = q.popleft()

        for n in graph[node]:
            indegrees[n] -= 1
            # 처음 코드 짤 때, 이곳에서 시간을 더해줘서 선수과목이 중복될 때마다 선수과목의 시간이 더 중첩되는 오류 발생.
            #result[n] += running_time[node]
            if indegrees[n] == 0 :
                running_time[n] += running_time[node]
                q.append(n)

topology_sort()

for i in range(1, N+1):
    print(running_time[i])
print('time : ', time.time() - st)
#"""
# 답안 예시 방식 일부분.
"""
result = copy.deepcopy(running_time)

def topology_sort():
    q = deque()

    for i in range(1, N+1):
        if indegrees[i] == 0:
            q.append(i)

    while q:
        node = q.popleft()

        for n in graph[node]:
            indegrees[n] -= 1
            # 매번 진입차수를 줄일 때마다 해당 노드의 강의 시간을 계산해서 더 오래 걸리는 경우를 남김.
            # 내 코드와 동작 결과는 같고 임의로 테스트케이스를 만들어 동작시켜도 같음.
            result[n] = max(result[n], result[node] + running_time[n])

            if indegrees[n] == 0 :
                q.append(n)

topology_sort()

for i in range(1, N+1):
    print(result[i])
print('time : ', time.time() - st)
"""