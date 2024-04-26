n = int(input())
lst = list(map(int, input().split(' ')))

lst.sort(reverse=True)
count = 0
idx = 0
while True:
    if idx > len(lst) - 1:
        break

    needs = lst[idx] # 데려 가야할 사람 수
    count += 1  # 모둠 카운트하기
    idx += needs # 다음 체크할 사람 index

print(count)