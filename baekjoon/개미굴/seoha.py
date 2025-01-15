import sys
input = sys.stdin.readline

N = int(input())

def add(dic, arr):
    if len(arr) == 0:
        return

    if arr[0] not in dic:
        dic[arr[0]] = {}
    add(dic[arr[0]], arr[1:])


def printTree(dic, leng):
    for i in sorted(dic.keys()):
        print("--"*leng+i)
        printTree(dic[i],leng+1)

a = [list(map(str, input().split())) for _ in range(N)]
dic = {}

for i in a:
    i = i[1:]
    add(dic, i)

printTree(dic, 0)