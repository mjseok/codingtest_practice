from itertools import combinations

def solution(relation):
    answer = 0
    row=len(relation)
    col=len(relation[0])
    allKey=[]
    for i in range(col):
        allKey.extend(combinations(range(col),i+1))
    both=[]
    for i in allKey:
        unique=[tuple([val[key] for key in i])for val in relation]
        if len(set(unique))==row:
            flag=True
            for x in both:
                if set(x).issubset(set(i)):
                    flag=False
                    break
            if flag:
                both.append(i)
                answer+=1
    
    return answer
print(solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]))