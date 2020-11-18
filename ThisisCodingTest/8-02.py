# 한빛 '이것이 코딩테스트다 with python'
# 'DP'' 8-2.py
# 피보나치 수열 재귀.
# 재귀를 이용한 DP는 큰 문제를 해결학 위해 작은 문제를 호출한다고하여 탑다운 방식.

import time

start = time.time()
# 메모이제이션
d = [0] * 100

def fibo(N):
    if N == 1 or N == 2:
        return 1

    if d[N] != 0:
        return d[N]
    else:
        d[N] = fibo(N-1) + fibo(N-2)
        return d[N]

print(fibo(99))
print('time :', time.time() - start)