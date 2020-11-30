# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-23.py
# 국영수 문제
# https://www.acmicpc.net/problem/10825

N = int(input())

students = []
for _ in range(N):
    students.append(input().split())
    
students.sort(key = lambda x: (-int(x[1]), int(x[2]), (-int(x[3])), x[0]))
print(students)

for student in students:
    print(student[0])