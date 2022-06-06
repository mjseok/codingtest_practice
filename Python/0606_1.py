from heapq import *

def solution(scoville,K):
    answer=0
    heapify(scoville)
    while scoville:
        if scoville[0]>=K:
            return answer
        if len(scoville)==1:
            if scoville[0]<=K:
                return -1
        one=heappop(scoville)
        two=heappop(scoville)
        new=one+two*2
        heappush(scoville,new)
        answer+=1     
    return -1

