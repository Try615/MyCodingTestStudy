# 한빛 '이것이 코딩테스트다 with python'
# '정렬' 6-11.py
# 성적이 낮은 순서로 학생 출력하기 문제.

import sys

N = int(sys.stdin.readline().rstrip())

arr = []
for i in range(N):
    arr.append(list(sys.stdin.readline().rstrip().split()))
    arr[i][1] = int(arr[i][1])

arr.sort(key=lambda x: x[1])

for a in arr:
    print(a[0], end = ' ')