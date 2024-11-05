import sys
input = sys.stdin.readline

N,K = map(int, input().split())
visited = [False for _ in range(N+1)]
visited[0] = True
visited[1] = True
cnt = 0
result = 0

while True:
    for i in range(2, N+1):
        if not visited[i]:
            visited[i] = True
            cnt+=1
            if cnt == K:
                result = i
                break

        for j in range(i*2,N+1,i):
            if not visited[j]:
                visited[j] = True
                cnt+=1
                if cnt == K:
                    result = j
                    break
    if cnt >= K:
        break

print(result)