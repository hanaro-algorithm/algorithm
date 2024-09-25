import sys

input = sys.stdin.readline

N, M = map(int, input().split())
idol_info = {}
for _ in range(N):
    team = input().rstrip()
    num = int(input())
    memeber = [input().rstrip() for _ in range(num)]
    memeber.sort()
    idol_info[team] = memeber

for _ in range(M):
    answer = input().rstrip()
    q = int(input()) # 0: 팀 이름, 1: 멤버 이름

    if q == 0:
        for name in idol_info[answer]:
            print(name)
    if q == 1:
        for k, v in idol_info.items():
            if answer in v:
                print(k)