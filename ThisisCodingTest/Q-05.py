# 한빛 '이것이 코딩테스트다 with python'
# '그리디 문제' Q-5.py
# 볼링공 고르기 문제

from itertools import combinations
import time

N, M = map(int, input().split())
weights = list(map(int, input().split()))

st = time.time()

# 조합
case_all = list(combinations(weights, 2))
result = 0
for case in case_all:
    # 무게가 같지 않은 경우 카운트.
    if case[0] != case[1]:
        result += 1

print(result)
print('time : ', time.time() - st)


# 답안 예시
# 시간복잡도 상으로 훨씬 좋음.
N, M = map(int, input().split())
data = list(map(int, input().split()))

# 무게 1부터 10까지의 볼링공의 개수를 담는 리스트
arr = [0] * 11

for x in data:
    arr[x] += 1

result = 0
for i in range(1, M+1):
    # 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외.
    N -= arr[i]
    # B가 선택하는 경우의 수와 곱하기
    result += arr[i] * N

print(result)