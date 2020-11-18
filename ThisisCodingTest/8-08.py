# 한빛 '이것이 코딩테스트다 with python'
# 'DP'' 8-8.py
# 효율적인 화폐 구성 문제.

# 그리디에서 다뤘던 거스름돈 문제와 유사. 화폐 단위에서 큰 단위가 작은 단위의 배수가 아닐 경우 이처럼 DP 이용.

import sys
import time

N, M = map(int, sys.stdin.readline().rstrip().split())
kinds = []
for _ in range(N):
    kinds.append(int(sys.stdin.readline().rstrip()))

start = time.time()
# 해당 액수에 필요한 최소 화폐 개수를 저장하는 dp 테이블
# dp[M] = 'M원에 필요한 최소 화폐 개수'
dp = [0] + [10001]* M

# 화폐 종류를 순환.
for i in range(N):
    for j in range(kinds[i], M+1):
        # 'j - (화폐종류)'원에 필요한 화폐 개수 + 1
        dp[j] = min(dp[j], dp[j - kinds[i]] + 1)
        #print(kinds[i], ' ', j)
        #print(dp)

if dp[M] == 10001:
    print(-1)
else:
    print(dp[M])