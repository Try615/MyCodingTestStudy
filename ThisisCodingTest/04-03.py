# 한빛 '이것이 코딩테스트다 with python'
# '구현' 4-3.py

import time

n = input()
start = time.time()
x, y = n[0], int(n[1])
count = 0

chartoint = ['x', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
for i in range(1, 9):
  if chartoint[i] == x:
    x = i
    break

dx = [2, 2, -2, -2, 1, -1, 1, -1]
dy = [1, -1, 1, -1, 2, 2, -2, -2]

for i in range(8):
  nx = x + dx[i]
  ny = y + dy[i]

  if nx > 8 or ny > 8 or nx < 1 or ny < 1:
    continue
  
  count += 1

print(count)
print('time : ', time.time() - start)

# 답안 예시
"""
input_data = input()
row = int(input_data[1])
# ord('a') = 97 을 이용해서 유니코드로 계산.
# for 문 돌린 코드에 비해 간결.
column = int(ord(input_data[0])) - int(ord('a')) + 1

steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (1, 2), (-1, 2), (1, -2), (-1, -2)]

result = 0
for step in steps:
  next_row = row + step[0]
  next_column = column + step[1]
  
  if next_row >= 1 and next_column >= 1 and next_row <= 8 and next_column <= 8:
    result += 1
print(result)
"""