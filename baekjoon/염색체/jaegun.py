import sys
input = sys.stdin.readline

def solution(T, cases):
    check = ['A', 'B', 'C', 'D', 'E', 'F']
    condition = ['A', 'F', 'C']
    results = []

    for case in cases:
        case = list(case.rstrip())
        cnt = 0

        if case[0] in check:
            cnt += 1
            if case[0] not in condition:
                case.pop(0)

            for j in range(3):
                if len(case) > 0 and case[0] == condition[j]:
                    cnt += 1
                    while len(case) > 0 and case[0] == condition[j]:
                        case.pop(0)

        if cnt == 4 and len(case) == 0:
            results.append("Infected!")
        elif cnt == 4 and len(case) == 1 and case[0] in check:
            results.append("Infected!")
        else:
            results.append("Good")

    return results


T = int(input())
cases = [input().rstrip() for _ in range(T)]

results = solution(T, cases)
for result in results:
    print(result)