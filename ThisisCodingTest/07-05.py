# 한빛 '이것이 코딩테스트다 with python'
# '이진 탐색' 7-5.py
# 부품 찾기 문제.

import sys
import time
#"""
N = int(sys.stdin.readline().rstrip())
N_list = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
M_list = list(map(int, sys.stdin.readline().rstrip().split()))
start = time.time()
#"""
# 계수 정렬 방식
#"""
count_list = [0] * 1000001

for i in N_list:
    count_list[i] += 1

for j in M_list:
    if count_list[j] == 0:
        print('no', end=' ')
    else:
        print('yes', end=' ')
print()
print('time : ', time.time() - start2)
#"""
# 이진 탐색 방식
"""
def binary_search(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

N_list.sort()

for j in M_list:
    result = binary_search(N_list, j, 0, N-1)
    if result == None:
        print('no', end=' ')
    else:
        print('yes', end=' ')
print('time : ', time.time() - start)
"""

# 답안 예시 (계수 정렬)
"""
n = int(sys.stdin.readline().rstrip())
arr = [0] * 1000001

# 입력과 동시에 계수 리스트에 카운팅하는 방식이 내 코드보다 좋다.
for i in sys.stdin.readline().rstrip().split():
    arr[int(i)] += 1

m = int(sys.stdin.readline().rstrip())
x = list(map(int, sys.stdin.readline().rstrip().split()))
start = time.time()

for i in x:
    if arr[i] == 0:
        print('no', end=' ')
    else:
        print('yes', end=' ')
print('time : ', time.time()-start)
"""

# 답안 예시 (집합 자료형 이용)
# 단순히 특정 데이터가 있는지 검사할 때에는 집합 효과적.
"""
n = int(sys.stdin.readline().rstrip())
arr = set(map(int, sys.stdin.readline().rstrip().split()))

m = int(sys.stdin.readline().rstrip())
x = list(map(int, sys.stdin.readline().rstrip().split()))
start = time.time()
for i in x:
    # arr는 집합 자료형이므로 in 연산자는 O(1)
    if i in arr:
        print('yes', end=' ')
    else:
        print('no', end=' ')
print('time : ', time.time() - start)
"""