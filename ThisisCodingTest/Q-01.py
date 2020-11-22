# 한빛 '이것이 코딩테스트다 with python'
# '그리디 문제' Q-1.py
# 모험가 길드 문제

N = int(input())

adventurer = list(map(int, input().split()))
adventurer.sort()

make_group = 0
result = 0

for i in range(N):
    make_group += 1
    fear = adventurer[i]

    # 모인 사람 수가 공포도보다 크거나 같아지면 그룹 생성.
    if make_group >= fear:
        make_group = 0
        result += 1

print(result)