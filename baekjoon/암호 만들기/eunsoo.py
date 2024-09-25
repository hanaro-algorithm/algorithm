import sys
input = sys.stdin.readline

l,c = map(int, input().split())
data = sorted(list(map(str,input().split())))
visited = [False for _ in range(c)]
selected = []
answer = ''

def solution(depth, start):
    global answer
    if depth == l:
        if 0 < sum(selected.count(x) for x in 'aeiou') < l-1:
            for s in selected:
                answer += s
            answer += "\n"
    for i in range(start,c):
        if visited[i]: continue
        selected.append(data[i])
        visited[i] = True
        solution(depth+1,i+1)
        selected.pop()
        visited[i] = False

solution(0,0)
print(answer)