# 한빛 '이것이 코딩테스트다 with python'
# '구현' 4-2.py

import time

n = int(input())
inc_3 = 0

start = time.time()

# 시간에 따른 3이 포함된 횟수 계산.
# 조건 상 시간에만 변동이 있으므로 가능한 방법.
# 실행 시간은 완전탐색에 비교가 안될 정도로 빠름.
if 0 <= n < 3:
  inc_3 = 1575*(n+1)
elif n < 13:
  inc_3 = 1575*(n+1-1) + 3600
elif n < 23:
  inc_3 = 1575*(n+1-2) + 7200
elif n == 23:
  inc_3 = 1575*(n+1-3) + 10800
else:
  print('wrong input')

print(inc_3)
print('time : ', time.time() - start)

# 답안 예시
"""
n = int(input())

start = time.time()
# 완전 탐색으로 구현.
# 데이터 개수 100만개 이하는 완전탐색 고려해볼만함.
count = 0
for i in range(n+1):
  for j in range(60):
    for k in range(60):
      if '3' in str(i) + str(j) + str(k):
        count += 1
print(count)
print('time : ', time.time() - start)
"""