def solution(skill, skill_trees):
    answer=0
    have=[]
    for i in skill_trees:
        have=[]
        flag=True
        for j in i:
            if j in skill:
                have.append(j)
        for h in range(0,len(have)):
            if have[h]!=skill[h]:
                flag=False
                break
        if flag==True:
            answer+=1

    return answer