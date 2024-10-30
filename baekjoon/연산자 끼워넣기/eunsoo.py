import sys
input = sys.stdin.readline
n = int(input())
num = list(map(int, input().split()))
op = list(map(int, input().split()))

minN = 1000000000
maxN = -1*1000000000

def dfs(depth, result, plus, minus, mul, div):
    global minN, maxN
    if depth == n:
        minN = min(minN, result)
        maxN = max(maxN, result)
        return

    if plus > 0:
        dfs(depth+1, result + num[depth], plus-1, minus, mul, div)
    if minus > 0:
        dfs(depth+1, result - num[depth], plus, minus-1, mul, div)
    if mul > 0:
        dfs(depth+1, result * num[depth], plus, minus, mul-1, div)
    if div > 0:
        if result > 0:
            dfs(depth+1, result // num[depth], plus, minus, mul, div-1)
        else:
            dfs(depth+1, -1*(-1*result // num[depth]), plus, minus, mul, div-1)


dfs(1,num[0],op[0], op[1], op[2], op[3])
print(maxN)
print(minN)