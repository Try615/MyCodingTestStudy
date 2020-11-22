# 한빛 '이것이 코딩테스트다 with python'
# '그리디 문제' Q-2.py
# 곱하기 혹은 더하기 문제

import time

S = list(map(int, input()))

st = time.time()

result = S[0]
for num in S[1:]:
    # 0일때 덧셈 연산. 나머진 곱셈.
    # 1일때도 곱셈이 아닌 덧셈을 해야 +1이 되는 것 유의.
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)
print('time : ', time.time() - st)