# math 라이브러리 기본 함수

import math
import time

# factorial
print(math.factorial(5))

# 제곱근
print(math.sqrt(7))

# 최대공약수 GCD
print(math.gcd(14, 21))

# pi 와 자연상수 e
print(math.pi)
print(math.e)


# 제곱 함수 pow와 연산자 ** 의 속도 차이 궁금

start1 = time.time()

print(math.pow(20, 20))
print("case pow. time : ", time.time() - start1)

start2 = time.time()

print(20 ** 20)
print("case **. time : ", time.time() - start2)

# ** 연산자가 미묘하게 더 빠름을 확인.