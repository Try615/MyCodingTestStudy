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