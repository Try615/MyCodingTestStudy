# 리스트에 순차적으로 접근해야 할 때 2개의 점의 위치를 기록하면서 처리하는 알고리즘.

# '특정한 값을 가지는 부분 연속 수열 찾기'
# 양의 정수로만 리스트가 구성된다면, end 포인터가 이동하면 합계가 커지며, start 포인터가 이동하면 합계가 작아지는 것을 이용하여 풀 수 있다. 음수 데이터가 포함될 경우 불가.

import time

n = 5
m = 5
data = [1, 2, 3, 2, 5]

count = 0
interval_sum = 0
end = 0

for start in range(n):
    while interval_sum < m and end < 5:
        interval_sum += data[end]
        end += 1

    if interval_sum == m:
        count += 1
    interval_sum -= data[start]

print(count)

# '정렬되어 있는 두 리스트의 합집합' 문제
# 병합정렬과 같은 일부 알고리즘에서도 사용.
start = time.time()
n, m = 3, 4
a = [1, 3, 5]
b = [2, 4, 6, 8]

result = [0] * (n+m)
i, j, k = 0, 0, 0

while i < n or j < m:
    if j >= m or (i < n and a[i] <= b[j]):
        result[k] = a[i]
        i += 1
    else:
        result[k] = b[j]
        j += 1
    k += 1

for i in result:
    print(i, end=' ')
print('\ntwo pointer. time : ', time.time() - start)