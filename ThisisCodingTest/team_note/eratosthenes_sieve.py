# 하나의 숫자가 소수인지 확인하는 것이 아닌
# 자연수 N 이하의 수 중 소수를 찾을 때 사용하는 에라토스테네스의 체

import math

n = 1000
# n+1로 배열의 idx와 자연수를 맞춰줌. 생각하기 용이.
# 0과 1을 미리 False로 선언할지, 나중에 처리할지는 알아서.
arr = [False for _ in range(2)] + [True for _ in range(n-1)] 
# 에라토스테네스의 체
# 시간복잡도 O(NloglogN)
# 다만 메모리를 N만큼 할당해야한다는 공간복잡도 문제.
# 예로써 10억 범주 안의 소수를 찾는다고 하면 메모리 감당안됨.
# 에라토스테네스의체를 이용해야 하는 문제는 보통 N이 1,000,000 이내로 주어지는 경우가 많음.
for i in range(2, int(math.sqrt(n))+1):
    if arr[i] == True:
        j = 2
        while i*j <= n:
            arr[i*j] = False
            j += 1

for i in range(2, n+1):
    if arr[i]:
        print(i, end=' ')
