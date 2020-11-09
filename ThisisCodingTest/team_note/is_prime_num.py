# 어느 숫자 x가 소수인지 판별.

import math

def is_prime_num(x):
    if x == 0 or x == 1:
        return False
    # x의 제곱근까지의 검색으로 O(x^1/2)까지 시간복잡도 감소.
    for i in range(2, int(math.sqrt(x)) +1):
        if x % i == 0:
            return False
    return True
        
print(is_prime_num(4))
print(is_prime_num(17))

# 소수의 정의는 '2보다 큰 자연수에서'라는 조건이 있음.
# 1과 0을 위 함수로 소수가 아니다 판정하려면 간단한 예외처리. 
print(is_prime_num(1))
print(is_prime_num(0))