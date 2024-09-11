import sys

input=sys.stdin.readline

N = int(input().rstrip())

start = [input().rstrip() for _ in range(N)]
end = [input().rstrip() for _ in range(N)]
result = 0

for i, start_car_number in enumerate(start):
    for j, end_car_number in enumerate(end):
        if start_car_number == end_car_number:
            start_set = set(start[i:])
            end_set = set(end[j:])
            if len(end_set - (start_set&end_set)) != 0:
                result += 1

print(result)
