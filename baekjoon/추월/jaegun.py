import sys
input = sys.stdin.readline

n = int(input())
start = []
end = []

for _ in range(n):
    start.append(input().rstrip())

for _ in range(n):
    end.append(input().rstrip())

count = 0

for i in range(n):
    if start[i] != end[i]: # 입장한 순서랑 나온 순서가 다른 경우 추월했다고 가정
        count += 1
        moved_car = start.index(end[i]) # 추월한 차량 정보
        start.insert(i, start.pop(moved_car)) # insert 함수 : i 인덱스에 값을 넣어준다.

print(count)