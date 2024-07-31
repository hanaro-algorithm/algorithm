import heapq
import sys

n = int(sys.stdin.readline())

heap = []

for i in range(n):
    num = int(sys.stdin.readline())
    if num != 0:
        # 힙을 (절댓값, 기존값)으로 구성
        heapq.heappush(heap, (abs(num), num))
    else:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)