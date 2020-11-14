# 한빛 '이것이 코딩테스트다 with python'
# 기타 알고리즘 B-2.py
# 암호 만들기.

import time
import sys
from itertools import combinations

L, C = map(int, sys.stdin.readline().rstrip().split())
# 처음 sort위치를 조합 쪽에서 하려고 고생했음.
# 그냥 처음 리스트를 정렬해서 조합하면 정렬된 순서대로 처리.
list_char = sorted(sys.stdin.readline().rstrip().split())
start = time.time()

candidiates = list(combinations(list_char, L))

VOW = ['a', 'e', 'i', 'o', 'u']
CON = ['b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z']
password = []
for c in candidiates:
    vowel = False
    consonant = False
    consonant2 = False
    for i in c:
        if i in VOW:
            vowel = True
        elif consonant is False and i in CON:
            consonant = True
        elif consonant is True and i in CON:
            consonant2 = True
    
        if vowel == consonant == consonant2 == True:
            password.append(c)
            break

for p in password:
    print("".join(p))
print("time : ", time.time() - start)

# 답안 예시
"""
vowels = ('a', 'e', 'i', 'o', 'u')
l, c = map(int, input().split())

array = input().split()
array.sort()

for password in combinations(array, l):
    count = 0
    for i in password:
        if i in vowels:
            count += 1
    # 예제 답안은 모음의 갯수를 카운트하는 것으로 전체 암호 길이 중 필요한 자음 길이 2를 뺀 값보다 모음의 수가 작으면 조건 만족으로 처리. 모든 면에서 더욱 좋다.
    if count >= 1 and count <= l-2:
        print(''.join(password))
"""