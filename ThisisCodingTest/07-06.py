# 한빛 '이것이 코딩테스트다 with python'
# '이진 탐색' 7-6.py
# 떡볶이 떡 만들기 문제.

import sys
import time
#"""
N, M = map(int, sys.stdin.readline().rstrip().split())
dduck = list(map(int, sys.stdin.readline().rstrip().split()))
start2 = time.time()

rest_dduck = 0
start = 0
end = max(dduck)
mid = 0

while start <= end:
    rest_dduck = 0
    mid = (start + end) // 2
    MANY = False
    LITTLE = False

    for i in range(N):
        rest_dduck += (dduck[i] - mid if dduck[i] >= mid else 0)
    
    if rest_dduck == M:
        break
    elif rest_dduck > M:
        start = mid + 1
        MANY = True
        LITTLE = False
    else:
        end = mid - 1
        MANY = False
        LITTLE = True
    

while MANY:
    rest_dduck = 0
    mid += 1

    for i in range(N):
        rest_dduck += (dduck[i] - mid if dduck[i] >= mid else 0)
    
    if rest_dduck < M:
        mid -= 1
        break

while LITTLE:
    rest_dduck = 0
    mid -= 1

    for i in range(N):
        rest_dduck += (dduck[i] - mid if dduck[i] >= mid else 0)

    if rest_dduck > M:
        break

print(mid)
print('time : ', time.time()-start2)
#"""

# 답안 예시
# 파라메트릭 서치(parametric search) 유형. 최적화 문제를 결정(bool) 문제로 바꾸어 해결하는 기법. 
# 원하는 조건을 만족하는 가장 알맞는 값을 찾는 문제에 주로 사용. ex) 범위 내에서 조건을 만족하는 가장 큰 값을 찾아라.
"""
n, m = list(map(int, sys.stdin.readline().rstrip().split()))
arr = list(map(int, sys.stdin.readline().rstrip().split()))
start2 = time.time()

start = 0
end = max(arr)

result = 0
while start <= end:
    total = 0
    mid = (start + end) // 2
    
    for x in arr:
        if x > mid:
            total += x - mid

    if total < m:
        end = mid - 1
    # 떡의 양이 충분한 경우, 덜 자르기.
    else:
        # 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result 기록.
        # 이 생각을 못해서 따로 while을 둬서 계산하는 낭비를 함.
        result = mid
        start = mid + 1

print(result)
print('time : ', time.time() - start2)
"""