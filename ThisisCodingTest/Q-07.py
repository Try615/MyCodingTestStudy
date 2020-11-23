# 한빛 '이것이 코딩테스트다 with python'
# '구현 문제' Q-7.py
# 럭키 스트레이트 문제

N = list(map(int, input()))
half = len(N) // 2

front = sum(N[:half])
back = sum(N[half:])

if front == back:
    print('LUCKY')
else:
    print('READY')