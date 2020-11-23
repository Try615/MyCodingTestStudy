# 한빛 '이것이 코딩테스트다 with python'
# '그리디 문제' Q-4.py
# 만들 수 없는 금액 문제

N = int(input())
coins = list(map(int, input().split()))
coins.sort()

# 해답 도움. 손에 잡힐듯하면서 구현이 안됨.
# '1부터 target -1 까지의 모든 금액을 만들 수 있는 상태'
target = 1
for coin in coins:
    # 만들 수 없는 금액을 찾았을 때 종료.
    if target < coin:
        break
    target += coin

print(target)