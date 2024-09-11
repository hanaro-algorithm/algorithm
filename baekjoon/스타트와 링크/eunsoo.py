import sys
input = sys.stdin.readline

N = int(input())
data = [list(map(int,input().split())) for _ in range(N)]
visited = [False] * N
result = sys.maxsize

def solution(x,cnt):
    global result
    if cnt == N//2:
        start, link = 0,0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    start += data[i][j]
                elif not visited[i] and not visited[j]:
                    link += data[i][j]
        result = min(result, abs(start-link))
        return
    else:
        for k in range(x,N):
            if not visited[k]:
                visited[k] = True
                solution(k+1,cnt+1)
                visited[k] = False

solution(0,0)
print(result)