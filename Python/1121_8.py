def solution(price, money, count):
    answer = -1
    need=0
    for i in range(count):
        need+=(i+1)*price
    answer=need-money
    if answer<0:
        answer=0
    return answer
print(solution(3,20,4))