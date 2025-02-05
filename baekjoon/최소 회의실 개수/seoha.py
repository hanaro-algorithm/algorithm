import sys
import heapq

input = sys.stdin.readline

N = int(input())
times = [list(map(int, input().split())) for _ in range(N)]

times.sort()
heap = []

result = 1
heapq.heappush(heap, times[0][1])
for i in range(1,N):
    if times[i][0] >= heap[0]:
        heapq.heappop(heap)
    else:
        result += 1
    heapq.heappush(heap, times[i][1])
print(result)