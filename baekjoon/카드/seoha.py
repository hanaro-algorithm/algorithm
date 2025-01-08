import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
cards = defaultdict(int)

for _ in range(N):
    num = int(input())
    cards[num] += 1

sorted_cards = sorted(cards.items(), key = lambda x : (-x[1], x[0]))

print(sorted_cards[0][0])