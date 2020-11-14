# 이진 탐색 (binary_search)
# 시간복잡도 O(logN)

# 재귀를 이용한 이진 탐색
def binary_search_recursion(arr, target, start, end):
    if start > end:
        return None
    mid = (start+end) // 2

    if arr[mid] == target:
        return mid
    # 중간 값보다 찾고자 하는 값이 작은 경우 왼쪽.
    elif arr[mid] > target:
        return binary_search_recursion(arr, target, start, mid-1)
    # 중간 값보다 찾고자 하는 값이 큰 경우 오른쪽.
    else:
        return binary_search_recursion(arr, target, mid+1, end)

n, target = list(map(int, input().split()))
data = list(map(int, input().split()))

result = binary_search_recursion(data, target, 0, n-1)
if result == None:
    print("NOT IN")
else:
    print(result+1, '번째 원소')

# 반복문을 이용한 이진 탐색
def binary_search_repeat(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

n, target = list(map(int, input().split()))
data = list(map(int, input().split()))

result = binary_search_repeat(data, target, 0, n-1)
if result == None:
    print("NOT IN")
else:
    print(result+1, '번째 원소')