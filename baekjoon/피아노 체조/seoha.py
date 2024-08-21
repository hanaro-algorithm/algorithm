import sys

input = sys.stdin.readline

N = int(input())
level = list(map(int, input().rstrip().split()))
Q = int(input())

prefix_sum = [0]
sum=0

#실수 횟수 누적합 저장하기
for i in range(1, N):
    if level[i] < level[i - 1]:
        sum+=1
    prefix_sum.append(sum)

for _ in range(Q):
    x, y = map(int, input().split())
    print(prefix_sum[y-1] - prefix_sum[x-1])