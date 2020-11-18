# 한빛 '이것이 코딩테스트다 with python'
# 'DP'' 8-7.py
# 바닥 공사 문제.

# 전형적인 타일링 문제.

import time

N = int(input())

start = time.time()

dp = [0] * 1001
dp[1] = 1
dp[2] = 3

for i in range(3, N+1):
    dp[i] = dp[i-1] + dp[i-2]*2

print(dp[N] % 796796)
print('time : ', time.time() - start)