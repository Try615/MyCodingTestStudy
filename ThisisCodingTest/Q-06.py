# 한빛 '이것이 코딩테스트다 with python'
# '그리디 문제' Q-6.py
# 무지의 먹방 라이브 문제
# https://programmers.co.kr/learn/courses/30/lessons/42891

# 1차.
# 효율성은 무시하고 정확성 우선으로 구현 시도.
# 정확도 테스트 케이스 32/32
# 효율성 테스트 케이스 0/8
def solution(food_times, k):
    answer = 0
    len_food = len(food_times)
    idx = 0
    check = False
    
    for _ in range(k):
        while True:
            if idx >= len_food:
                if check == False:
                    return -1
                else:
                    idx = 0
                    check = False
            
            if food_times[idx] > 0:
                food_times[idx] -= 1
                idx += 1
                check = True
                break
            else:
                idx += 1
                
    for i in range(len_food):
        answer = (idx + i) % len_food
        if food_times[answer] > 0:
            return answer+1
            
    return -1


# 답안 예시

# 우선순위 큐를 이용함.
#"""
import heapq

def solution(food_times, k):
    # 전 음식을 먹는데 필요한 시간보다 k가 크거나 같다면 -1.
    if sum(food_times) <= k:
        return -1

    num_food = len(food_times)
    h = []
    for i in range(num_food):
        # 음식 섭취 시간을 우선순위.
        heapq.heappush(h, (food_times[i], i+1))

    # 현재까지 먹기 위해 사용한 시간 합.
    sum_time = 0
    # 이전에 음식을 다 먹기 위해 사용한 시간.
    previous = 0

    # 현재까지 음식을 먹은 시간 + (이번 음식의 남은 양을 다 먹기 위해 필요한 시간 * 순회해야할 음식의 개수)
    while sum_time + ((h[0][0] - previous) * num_food) <= k:
        t, _ = heapq.heappop(h)
        # 이번 음식의 남은 양을 다 먹기 위해 필요한 시간.
        sum_time = (t - previous) * num_food
        # 다 먹은 음식 개수 제외.
        num_food -= 1
        # 이전에 먹은 음식 시간 설정.
        previous = t

    result = sorted(q, key = lambda x : x[1])
    return result[(k - sum_time) % num_food][1]
#"""