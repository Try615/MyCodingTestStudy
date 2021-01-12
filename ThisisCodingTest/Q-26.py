# 한빛 '이것이 코딩테스트다 with python'
# '정렬 문제' Q-26.py
# 카드 정렬하기 문제
# https://www.acmicpc.net/problem/1715

import heapq
import sys
input = sys.stdin.readline

N = int(input())

decks = []
for _ in range(N):
    heapq.heappush(decks, int(input()))

result = 0
while len(decks) > 1:
    first = heapq.heappop(decks)
    second = heapq.heappop(decks)
    sum_val = first + second
    result += sum_val
    # 작은 카드뭉치끼리의 합인데 서로 더해진 것이 가장 작지 않은 경우를 잊어서 처음에 틀림.
    heapq.heappush(decks, sum_val)
    

if result <= 2100000000:
    print(result)