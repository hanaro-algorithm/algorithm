import sys

doc = sys.stdin.readline().strip()
word = sys.stdin.readline().strip()
i = 0
count = 0

while i < len(doc):
    if doc[i:i+len(word)] == word:
        count += 1
        i += len(word)
    else:
        i += 1

print(count)