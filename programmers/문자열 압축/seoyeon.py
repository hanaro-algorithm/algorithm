def solution(s):
    answer = []
    for i in range(1, len(s)+1) :
        x = ''
        cnt = 1
        tmp = s[:i]
        for j in range(i, len(s)+i, i) :
            if tmp == s[j : i+j] :
                cnt += 1
            else :
                if cnt != 1 :
                    x = x + str(cnt) + tmp
                else :
                    x = x + tmp
                tmp = s[j : i+j]
                cnt = 1
        answer.append(len(x))
    return min(answer)