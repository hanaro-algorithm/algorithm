import sys
input = sys.stdin.readline

n, k = map(int, input().split())
seats = list(input())

answer = 0

for i in range(n):
    if seats[i] == 'P':
        for j in range(i-k, i+k+1):
            if 0 <= j <=n and seats[j] == 'H':
                answer += 1
                seats[j] = ''
                break

print(answer)