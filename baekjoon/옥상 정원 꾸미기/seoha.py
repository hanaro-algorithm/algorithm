import sys

N = int(input())
heights = []
result=0

for i in range(N):
    heights.append(int(sys.stdin.readline().rstrip()))

stack = []
result = 0

for height in heights:
  while stack and stack[-1]<=height:
    stack.pop()
  stack.append(height)

  result += len(stack)-1

print(result)

"""
스택 사용 X -> 시간 초과

import sys

N = int(input())
heights = []
result=0

for i in range(N):
    heights.append(int(sys.stdin.readline().rstrip()))

for i in range(len(heights)):
    for j in range(i+1, len(heights)):
        if heights[i]<=heights[j]:
            result+=j-i-1
            break
        elif j == len(heights)-1 and heights[i]>heights[j]:
            result += len(heights) - i - 1


print(result)"""