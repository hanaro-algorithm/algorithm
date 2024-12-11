N = int(input())
fruit = list(map(int, input().split()))

left = 0
fruit_count = {}
max_len = 0

for right in range(N):
    if fruit[right] in fruit_count:
        fruit_count[fruit[right]] += 1
    else:
        fruit_count[fruit[right]] = 1
    
    while len(fruit_count) > 2:
        fruit_count[fruit[left]] -= 1
        if fruit_count[fruit[left]] == 0:
            del fruit_count[fruit[left]]
        left += 1
    
    max_len = max(max_len, right-left+1)

print(max_len)