import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
arr.sort()

start = 0
end = N - 1
result = []
result_sum = sys.maxsize

while start < end:
    temp = arr[start] + arr[end]
    if abs(temp) < result_sum:
        result = [arr[start], arr[end]]
        result_sum = abs(temp)

    if temp == 0:
        break
    elif temp < 0: # 현재 합이 음수면 start를 증가시켜서 음수값 작아지게
        start += 1
    else:
        end -= 1

print(result[0], result[1])