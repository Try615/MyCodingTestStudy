import heapq

# 일반적으로 heapsort의 시간복잡도는 O(NlogN)
def minheapsort(iterable):
    h = []
    result = []
    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, value)
        print(h)
    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기.
    for i in range(len(h)):
        result.append(heapq.heappop(h))
        print(h)
    return result

result = minheapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print('result : ', result)

# 파이썬에서는 max heap 자체 제공 안함.
# min heap을 이용한 heapq의 부호를 바꾼 것으로 max heap.

def maxheapsort(iterable):
    h = []
    result = []

    for value in iterable:
        heapq.heappush(h, -value)
        print(h)
    
    for i in range(len(h)):
        result.append(-heapq.heappop(h))
        print(h)
    return result

result = maxheapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print('result : ', result)