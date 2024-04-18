n, m = list(map(int, input().split(' ')))
lst = [num for num in range(1, n+1)]

for _ in range(m):
    start, end = list(map(int, input().split(' ')))
    start_idx, end_idx = start - 1, end - 1
    lst[start_idx:end_idx+1] = lst[start_idx:end_idx+1][::-1]

print(' '.join(list(map(str, lst))))
