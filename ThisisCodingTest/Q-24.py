# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-24.py
# 안테나 문제
# https://www.acmicpc.net/problem/18310

# 전체 리스트에서 중간 인덱스에 위치한 값이 전체적으로 최소 거리.
import sys
input = sys.stdin.readline

N = int(input())

houses = list(map(int, input().split()))
houses.sort()
# 중복되는 집 주소가 많은 경우 안될것이라 잘못 생각했다가 헤맴.
print(houses[(N-1)//2])

# 완전 탐색 방식.
# N의 최댓값이 200,000이므로 실제 답안은 될 수 없음.
# 시간 복잡도 넘겨버림.
"""
import sys
input = sys.stdin.readline

N = int(input())

houses = list(map(int, input().split()))
houses.sort()

temps = []
for i in range(N):
    temp = 0
    for j in range(N):
        temp += abs(houses[i] - houses[j])
    temps.append((temp, i))
temps.sort()
result = houses[temps[0][1]]

print(result)
"""