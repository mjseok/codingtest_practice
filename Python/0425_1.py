from collections import Counter
from itertools import combinations



def solution(orders, course):
    answer = []
    
    for k in course:
        candidate=[]
        for order in orders:
            for item in combinations(order,k):
                res=''.join(sorted(item))
                candidate.append(res)
        sorted_candidate=Counter(candidate).most_common()
        answer+=[menu for menu,cnt in sorted_candidate if cnt>=2 and cnt==sorted_candidate[0][1]]
    answer=sorted(answer)
    return answer
    
print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]))