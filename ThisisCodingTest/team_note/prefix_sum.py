# 구간 합 계산을 효율적으로 하기 위한 방법.
# 접두사 합(prefix sum)이란 리스트의 맨 앞부터 특정 위치까지의 합을 구해 놓은 것.
# N 크기의 리스트에서 구간 합을 구하라는 쿼리를 M번 하면 매번 계산시 O(NM). 접두사 합 사용시 O(N+M)

# 예시

n = 5
data = [10, 20, 30, 40, 50]

# 접두사 합 배열 계산
sum_value = 0
prefix_sum = [0]
for i in data:
    sum_value += i
    prefix_sum.append(sum_value)

# 구간 합 계산 [left, right]
# 여기서 data의 수 위치를 0 시작이 아닌 첫번째로 삼은 것 유의.
left = 3
right = 4
print(prefix_sum[right] - prefix_sum[left-1])