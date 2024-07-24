import sys
si = sys.stdin.readline
N, M = map(int, si().split())
point_list = list(map(int, si().split()))
point_list.sort()

line_list = []
for i in range(M):
    line = list(map(int, si().split()))
    line_list.append(line)

def binary_min(start, end, target):
    while start <= end:
        idx = (start + end) // 2
        mid = point_list[idx]
        
        if target > mid:
            start = idx + 1
        else:
            end = idx - 1
    return end + 1

def binary_max(start, end, target):
    while start <= end:
        idx = (start + end) // 2
        mid = point_list[idx]

        if target >= mid:
            start = idx + 1 
        else:
            end = idx - 1
    return end

# 최소값의 index와 최대값의 index를 비교하는 방법으로 문제를 해결하기
for least, largest in line_list:
    start = 0 # index
    end = len(point_list) - 1 # index
    mini = binary_min(start, end, least)
    maxi = binary_max(start, end, largest)
    print(maxi - mini + 1)