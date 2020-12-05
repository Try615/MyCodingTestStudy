# 한빛 '이것이 코딩테스트다 with python'
# '이진 탐색 문제' Q-28.py
# 고정점 찾기 문제

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

def binary_search(arr, start, end):
    while start <= end:
        mid = (start + end) // 2
        target = mid

        if target == arr[mid]:
            return mid
        elif target > arr[mid]:
            start = mid + 1
        else:
            end = mid - 1
    return -1

result = binary_search(data, 0, N-1)
print(result)