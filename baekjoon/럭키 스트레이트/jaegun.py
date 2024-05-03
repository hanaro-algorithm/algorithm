N = input()

num_len = int(len(N) / 2)

left = N[0:num_len]
right = N[num_len:]
left_sum = 0

for i in range(num_len):
    left_str = left[i]
    left_sum += int(left_str)

right_sum = 0
for i in range(num_len, ):
    right_str = right[i]
    right_sum += int(right_str)

if left_sum == right_sum:
    print("LUCKY")
else :
    print("READY")