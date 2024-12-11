def next_permutation(arr):
    k = -1 
    for i in range(len(arr) - 2, -1, -1):
        if arr[i] < arr[i + 1]:
            k = i
            break
    if k == -1: return

    l = -1
    for i in range(len(arr) - 1, k, -1):
        if arr[k] < arr[i]:
            l = i
            break

    arr[k], arr[l] = arr[l], arr[k]
    arr[k + 1:] = arr[k + 1:][::-1]

for _ in range(int(input())):
    word = list(input())
    next_permutation(word)
    print(''.join(word))