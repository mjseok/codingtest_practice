def solution(priorities, location):
    answer = 0 #프린트 한 횟수
    while priorities:
        length=len(priorities)
        cur=priorities.pop(0)
        location-=1
        for j in priorities:
            if cur<j:
                priorities.append(cur)
                if location==-1:
                    location=length-1
                break
        if length!=len(priorities):
            answer+=1
        if location==-1:
            return answer
    return answer
print(solution([1, 1, 9, 1, 1, 1],0))