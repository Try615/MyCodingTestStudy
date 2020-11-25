# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-9.py
# 문자열 압축 문제
# https://programmers.co.kr/learn/courses/30/lessons/60057

# 사고가 막혀서 우선 하나 단위 압축을 구현해 봄.

s = input()

leng_s = len(s)

result = []
count = 1
previous = s[0]
for i in range(1, leng_s):        
    if previous == s[i]:
        count += 1
    else:
        if count > 1:
            result.append(str(count))
        count = 1
        result.append(previous)
        previous = s[i]

    if i == leng_s-1:
        if count != 1:
            result.append(str(count))
        result.append(s[i])

print(''.join(result))

leng_result = len(result)

print('compression : ', leng_s - leng_result)