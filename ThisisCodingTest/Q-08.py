# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-8.py
# 문자열 재정렬 문제

S = input()

number = 0
char = []

for n in S:
    if 48 <= ord(n) <= 57:
        number += int(n)
    else:
        char.append(n)

char.sort()
# 입력 리스트에 숫자가 없을때 0을 안넣도록 주의..
if number > 0:
    char.append(number)

for i in char:
    print(i, end='')

# 답안 예시
# ord() 함수를 통한 아스키 값으로 숫자, 문자 판별할 필요 없음.
# 숫자 판별 함수 isdigit()
# 문자 판별 함수 isaplha()

"""
    for n in S:
        if n.isdigit():
            number += int(n)
        else:
            char.append(n)
"""

# 출력 함수 다른 방법도 리마인드하기.
"""
    # 단, join()을 쓰기 위해선 마지막 숫자를 str()해줄 필요 있음. 
    print(''.join(char))
"""