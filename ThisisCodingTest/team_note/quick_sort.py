# 퀵 정렬 (quick sort)
# 평균적인 시간복잡도 O(NlogN). worst case는 O(N^2)
# 리스트의 첫 원소를 피벗으로 삼는 호머 분할 방식으로 구현.
# 이 경우 worst case는 '이미 정렬되어 있는 경우'

import time

data = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
start = time.time()
"""
def quick_sort(arr, start, end):
    # 원소가 1개인 경우 종료.
    if start >= end:
        return
    
    pivot = start
    left = start + 1
    right = end
    # left와 right가 엇갈릴 때까지.
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복.
        while left <= end and arr[left] <= arr[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을 때까지 반복.
        while right > start and arr[right] >= arr[pivot]:
            right -= 1
        # 엇갈렸다면 작은 데이터와 피벗을 교체.
        if left > right:
            arr[pivot], arr[right] = arr[right], arr[pivot]
        # 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체.
        else:
            arr[left], arr[right] = arr[right], arr[left]
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 재귀를 통해 각각 정렬 수행.
    quick_sort(arr, start, right-1)
    quick_sort(arr, left+1, end)

quick_sort(data, 0, len(data)-1)
print(data)
print('time : ', time.time() - start)
"""


# 파이썬스러운 퀵 정렬
"""
def quick_sort(arr):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료.
    if len(arr) <= 1:
        return arr

    pivot = arr[0]
    tail = arr[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(data))
print('time : ', time.time() - start)
"""

# 내 입맛대로 수정해보기.

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    
    pivot = arr[0]
    tail = arr[1:]

    left_side, right_side = [], []
    # 리스트 컴프리핸션을 두번 사용하느니 한번 돌면서 피벗과 비교해도 되지 않을까.
    for x in tail:
        if x <= pivot:
            left_side.append(x)
        else:
            right_side.append(x)

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(data))
print('time : ', time.time() - start)