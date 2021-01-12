# 한빛 '이것이 코딩테스트다 with python'
# '정렬 문제' Q-25.py
# 실패율 문제
# https://programmers.co.kr/learn/courses/30/lessons/42889

# 우선순위 큐 이용.
from collections import deque

def solution(N, stages):
    stages.sort()
    stages = deque(stages)
    result = []

    for i in range(1, N+1):
        users = len(stages)
        fails = 0
        while stages and stages[0] == i:
            node = stages.popleft()            
            fails += 1
        fail_percent = fails / users if fails != 0 else 0
        result.append((fail_percent, i))

    # sort 방법 유용한듯. 잘익힌듯.
    result.sort(key = lambda x : (-x[0], x[1]))
    result = list(map(lambda x : x[1], result))
    return result