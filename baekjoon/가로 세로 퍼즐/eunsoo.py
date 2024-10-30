from itertools import combinations, permutations

words = [input().rstrip() for _ in range(6)]
words = sorted(words)

def puzzle(arr):
    puzz = []
    for i in range(3):
        p = ''
        puzz.append(''.join(arr[i]))
        for j in range(3):
            p += arr[j][i]
        puzz.append(p)
    return puzz

answer = []
for c in combinations(words, 3):
    for p in permutations(c):
        result = []
        for pp in p:
            result.append(list(map(str,pp)))
        pu = puzzle(result)
        if words == sorted(pu):
            a = ""
            for i in range(3):
                a += ''.join(result[i])
            answer.append(a)

if answer:
    answer = sorted(answer)
    print(answer[0][:3])
    print(answer[0][3:6])
    print(answer[0][6:9])
else:
    print(0)