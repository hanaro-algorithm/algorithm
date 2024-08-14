from itertools import combinations

n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]

combArr = list(combinations([i for i in range(0,m)],3))

result = 0
for comb in combArr:
    s = 0
    for arr in data:
        s += max(arr[comb[0]],arr[comb[1]],arr[comb[2]])
    result = max(result,s)

print(result)