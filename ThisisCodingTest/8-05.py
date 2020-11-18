# 한빛 '이것이 코딩테스트다 with python'
# 'DP'' 8-5.py
# 1로 만들기 문제.

# 이전 greedy 문제 '1이 될때까지'랑 유사하게 풀려다 고생함.

x = int(input())

dp = [0] * 30001

for i in range(2, x+1):
    dp[i] = dp[i-1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2] +1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3] +1)
    if i % 5 == 0:
        dp[i] = min(dp[i], dp[i//5] +1)
    print('dp[', i, '] : ', dp[i])

print(dp[x])