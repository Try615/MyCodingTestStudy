# 한빛 '이것이 코딩테스트다 with python'
# 'DP'' 8-4.py
# 피보나치 수열 반복.
# 반복문을 이용한 DP는 작은 문제부터 답을 도출한다고하여 바텀업 방식.

import time
start = time.time()

dp = [0] * 100

dp[1] = dp[2] = 1
n = 99

for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[99])
print('start : ', time.time() - start)