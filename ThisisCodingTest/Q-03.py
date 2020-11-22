# 한빛 '이것이 코딩테스트다 with python'
# '그리디 문제' Q-3.py
# 문자열 뒤집기 문제

import time

S = list(map(int, input()))

st = time.time()

sub = -1
group1 = 0
group0 = 0
for num in S:
    # 현재 값이 이전 값과 다르면 현재 값 그룹+1
    if sub != num:
        if num == 0:
            group0 += 1
        else:
            group1 += 1
        sub = num

# 그룹 수가 적은 쪽을 그룹 수만큼 뒤집기.
print(min(group0, group1))
print('time : ', time.time() - st)