# 삽입 정렬 (insertion sort)
# 필요할 때만 위치를 바꾸므로 데이터가 거의 정렬되어 있을 때 효율적.
# 시간복잡도 O(N^2). 
# best case로 거의 정렬된 경우 O(N)

import time

data = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
start = time.time()

for i in range(1, len(data)):
    for j in range(i, 0, -1):
        if data[j] < data[j-1]:
            data[j], data[j-1] = data[j-1], data[j]
        else:
            break
print(data)
print('time : ', time.time() - start)