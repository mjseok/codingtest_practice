def solution(id_list, report, k):
    answer = [0]*len(id_list)
    report=list(set(report))
    dict={}
    stop={}
    stop_list=[]
    idx=0
    for id in id_list:
        dict[id]=[]
        stop[id]=0
    for singo in report:
        x,y=singo.split()
        stop[y]+=1
        if y not in dict[x]:
            dict[x].append(y)
        if stop[y]>=k and y not in stop_list:
            stop_list.append(y)
    for key,value in dict.items():
        for v in value:
            if v in stop_list:
                answer[idx]+=1
        idx+=1

    return answer

print(solution(["con", "ryan"],["ryan con", "ryan con", "ryan con", "ryan con"],3))