# 한빛 '이것이 코딩테스트다 with python'
# '구현' 4-1.py

import time

n = int(input())
list_command = input().split()
num_command = len(list_command)
pos = [1,1]
start = time.time()

while num_command > 0:
  command = list_command.pop(0)
  
  if command == 'R':
    if pos[1] < n:
      pos[1] += 1
  elif command == 'L':
    if pos[1] > 1:
      pos[1] -= 1
  elif command == 'U':
    if pos[0] > 1:
      pos[0] -= 1
  elif command == 'D':
    if pos[0] < n:
      pos[0] += 1
  num_command -= 1

print(pos[0], pos[1])
print("time : ", time.time() - start)

# 답안 예시
"""
n = int(input())
x, y = 1, 1
plans = input().split()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

# 내 코드에 비해 짧으며 파이썬스럽다.
for plan in plans:
  for i in range(len(move_types)):
    if plan == move_types[i]:
      nx = x + dx[i]
      ny = y + dy[i]
    if nx < 1 or nx > n or ny < 1 or ny > n:
      continue
    
    x, y = nx, ny

print(x, y)
"""