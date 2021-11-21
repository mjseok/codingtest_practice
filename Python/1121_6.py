def solution(sizes):
    answer = 0
    ver=[]
    hor=[]
    for card in sizes:
        x,y=max(card[0],card[1]),min(card[0],card[1])
        hor.append(x)
        ver.append(y)
    answer=max(hor)*max(ver)
    return answer
print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))