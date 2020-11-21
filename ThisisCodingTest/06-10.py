# 한빛 '이것이 코딩테스트다 with python'
# '정렬' 6-10.py
# 위에서 아래로 문제.

import sys

N = int(sys.stdin.readline().rstrip())

arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline().rstrip()))

arr.sort(reverse=True)

for i in range(N):
    print(arr[i], end=' ')