# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-10.py
# 자물쇠와 열쇠 문제
# https://programmers.co.kr/learn/courses/30/lessons/60059

# 경험적으로 카카오 문제가 역시 어렵다.
# 프로그래머스의 다른 분들의 답안을 봐도 어렵다.
# 후에 카카오 문제만 다시 풀어도 실력 확인되겠다 느낌.

# 답안 도움.
# 키 회전
def rotate_by_90_degree(A):
    row = len(A)
    col = len(A[0])

    res = [[0 for _ in range(row)] for _ in range(col)]
    for r in range(row):
        for c in range(col):
            res[c][row-1 - r] = A[r][c]
    return res

# 키 검증
def unlock(lock):
    leng = len(lock) // 3
    for x in range(leng, leng*2):
        for y in range(leng, leng*2):
            if lock[x][y] != 1:
                return False
    return True

def solution(key, lock):
    M = len(key)
    N = len(lock)
    # 자물쇠를 3배로 키워서 키를 이동하면서 매칭하는 방식.
    field = [[0] * (3*N) for _ in range(3*N)]
    for i in range(N):
        for j in range(N):
            field[N+i][N+j] = lock[i][j]

    # 열쇠를 90씩 4번 회전.
    for change in range(4):
        key = rotate_by_90_degree(key)

        # 인덱싱을 2N+M까지 하므로 3N까지 range할 수 없다.
        for i in range(2*N):
            for j in range(2*N):
                for x in range(M):
                    for y in range(M):
                        field[x+i][y+j] += key[x][y]

                if unlock(field):
                    return True

                for x in range(M):
                    for y in range(M):
                        field[x+i][y+j] -= key[x][y]
    return False