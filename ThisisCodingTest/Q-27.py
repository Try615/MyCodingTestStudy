# 한빛 '이것이 코딩테스트다 with python'
# '이진 탐색 문제' Q-27.py
# 정렬된 배열에서 특정 수의 개수 구하기 문제

from bisect import bisect_right, bisect_left

N, x = map(int, input().split())
data = list(map(int, input().split()))

right = bisect_right(data, x)
left = bisect_left(data, x)

result = right - left if right - left != 0 else -1
print(result)