import sys
input = sys.stdin.readline

N = int(input())
X = list(map(int, input().split()))

sorted_X = list(set(X))
sorted_X.sort()
dic = {}

for i in range(len(sorted_X)):
    dic[sorted_X[i]] = i

for num in X:
    print(dic[num], end = ' ')