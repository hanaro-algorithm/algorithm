import sys
input = sys.stdin.readline

N, M = map(int, input().split())

girl_groups = {}

for _ in range(N):
    group_name = input().strip()
    group_members = []
    for _ in range(int(input())):
        group_members.append(input().strip())

    # 딕셔너리에 그룹 멤버들 리스트 담기
    girl_groups[group_name] = sorted(group_members)

for _ in range(M):
    quiz_name = input().strip()
    quiz_type = int(input())

    if quiz_type == 0: # 그룹 멤버 이름
        for member in girl_groups[quiz_name]:
            print(member)
    else:
        for name, members in girl_groups.items():
            if quiz_name in members:
                print(name)
                break