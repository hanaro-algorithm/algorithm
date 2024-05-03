def solution(s):
    result = []
    if len(s) == 1:
        return 1
    for i in range(1, (len(s) // 2) + 1):
        a=''
        count=1
        temp= s[:i]

        for j in range(i, len(s), i):
            if temp == s[j:i+j]:
                count+=1
            else:
                if count != 1:
                    a+=str(count)+temp
                else:
                    a+=temp
                temp = s[j:j + i]
                count = 1
        if count != 1:
            a+=str(count)+temp
        else:
            a+=temp
        result.append(len(a))
    return min(result)

print(solution("aabbaccc"))
print(solution("abcabcabcabcdededededede"))