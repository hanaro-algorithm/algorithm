import sys
input = sys.stdin.readline

def bs(arr, k):
    start = 0
    end = len(arr) - 1
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == k:
            return 1
        elif arr[mid] < k:
            start = mid + 1
        else:
            end = mid - 1
    return 0

T = int(input())
for _ in range(T):
    N = int(input())
    note1 = list(map(int, input().split()))
    M = int(input())
    note2 = list(map(int, input().split()))

    note1 = list(set(note1))
    note1.sort()

    for n in note2:
        print(bs(note1, n))
