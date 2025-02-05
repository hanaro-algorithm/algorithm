import sys
input = sys.stdin.readline

N = int(input())
drinks = list(map(int, input().split()))

drinks.sort(reverse=True)
result = drinks[0]

for i in range(1, N):
    result += drinks[i]/2

if result == int(result):
    print(int(result))
else:
    print(result)