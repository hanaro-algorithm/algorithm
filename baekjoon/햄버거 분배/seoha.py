import sys

input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
burger = list(input().rstrip())

result = 0

for index, a in enumerate(burger):
    if burger[index] == 'P':
        for j in range(index - K, index + K + 1):
            if -1 < j < N:
                if burger[j] == 'H':
                    burger[j] = '-'
                    result += 1
                    break

print(result)