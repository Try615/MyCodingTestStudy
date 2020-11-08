from bisect import bisect_right, bisect_left

# 값이 [left_value, right_value]인 데이터 개수 반환 함수
# bisect 함수들은 시간복잡도 O(logN)이므로
# count_by_range 함수도 O(logN)의 시간복잡도로 계산.
def count_by_range(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index - left_index

a = [1, 2, 3, 3, 3, 3, 4, 4, 8, 9]

print(count_by_range(a, 4, 4))
print(count_by_range(a, -1, 3))