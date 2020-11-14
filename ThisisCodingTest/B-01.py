# 한빛 '이것이 코딩테스트다 with python'
# 기타 알고리즘 B-1.py
# 소수 구하기.
import sys
import math
import time

N, M = map(int, sys.stdin.readline().rstrip().split())
start = time.time()

def sieve(M):
    table = [True for _ in range(M+1)]
    table[0] = table[1] = False

    for i in range(2, int(math.sqrt(M))+1):
        if table[i]:
            j = i*i
            while j <= M:
                table[j] = False
                j += i
    return table

result = sieve(M)
for i in range(N, M+1):
    if result[i]:
        print(i)
print('time : ', time.time() - start)