# 선택 정렬 예시
# 시간 복잡도 O(N^2)

import time

data = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
start = time.time()
#"""
for i in range(len(data)):
    min_index = i
    for j in range(i+1, len(data)):
        if data[min_index] > data[j]:
            min_index = j
    data[min_index], data[i] = data[i], data[min_index]

print(data)  
print('for^2 time : ', time.time() - start)
#"""

# 궁금해서 min과 index로 스왑핑하는 방식을 해봤지만 역시 시간상 어리석은 짓. 선택 정렬 필요한 일 있으면 그냥 for문에 단순 연산하자.
"""
for i in range(len(data)):
    min_data = min(data[i:])
    idx = data.index(min_data)
    data[i], data[idx] = data[idx], data[i]

print(data)
print('min, index time : ', time.time() - start)
"""