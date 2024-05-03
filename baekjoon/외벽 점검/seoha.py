from itertools import permutations as p

def solution(n, weak, dist):
    miny = 9
    wn = len(weak)
    weak += list(map(lambda x: x+n, weak))
    for seq in p(dist):
        for i in range(wn):
            lm = i+wn-1
            cur = i
            for cnt, d in enumerate(seq, start=1):
                clm = weak[cur] + d
                while cur <= lm and weak[cur] <= clm:
                    cur += 1
                if lm < cur:
                    if cnt == 1:
                        return cnt
                    miny = min(cnt, miny)
                    break
    return -1 if miny == 9 else miny