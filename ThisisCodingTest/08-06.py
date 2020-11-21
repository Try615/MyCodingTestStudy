# 한빛 '이것이 코딩테스트다 with python'
# 'DP'' 8-6.py
# 개미 전사 문제.

import time

N = int(input())
arr = [0] + list(map(int, input().split()))

start = time.time()

dp = [0] * (N+1)
dp[1] = arr[1]
dp[2] = max(arr[1], arr[2])

for i in range(3, N+1):
    # 점화식
    dp[i] = max(dp[i-2]+arr[i], dp[i-1])

print(dp[N])
print('time : ', time.time() - start)