import sys

# input(). 상대적으로 느림.
data = input()

# readline(). input()에 비해 빠름.
# 많은 케이스를 입력받을 경우 readline을 사용.
# readline을 사용하면 입력된 문자열의 마지막에 줄바꿈 기호가
# 포함되므로 입력되는 문자열 오른쪽 끝을 제거하는 rstrip() 같이 사용.
data = sys.stdin.readline().rstrip()