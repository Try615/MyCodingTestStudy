# 2차원 리스트(행렬) 시계방향 90도 회전
def rotate_a_matrix_by_90_degree(a):
    row_length = len(a)
    col_length = len(a[0])

    res = [[0]*row_length for _ in range(col_length)]
    for r in range(row_length):
        for c in range(col_length):
            res[c][row_length-1-r] = a[r][c]
    return res

# 2차원 리스트(행렬) 반시계방향 90도 회전
def rotate_a_matrix_by_270_degree(a):
    row_length = len(a)
    col_length = len(a[0])

    res = [[0]*row_length for _ in range(col_length)]
    for r in range(row_length):
        for c in range(col_length):
            res[col_length-1-c][r] = a[r][c]
    return res

a = [
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12]
]

print(rotate_a_matrix_by_90_degree(a))
print(rotate_a_matrix_by_270_degree(a))