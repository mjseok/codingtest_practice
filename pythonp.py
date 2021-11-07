def solution(lottos, win_nums):
    answer = []
    zeronum=0
    same=0
    for i in lottos:
        if i in win_nums:
            same+=1
        if i==0:
            zeronum+=1
    if zeronum+same==0:
        answer.append(6)
    else:
        answer.append(7-(zeronum+same))
    if same==0:
        answer.append(6)
    else:
        answer.append(7-same)

    return answer

print(solution([44, 1, 0, 0, 31, 25],[31, 10, 45, 1, 6, 19]))