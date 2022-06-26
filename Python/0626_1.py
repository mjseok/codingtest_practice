def solution(jobs):
    n=len(jobs)
    answer,start = 0,0
    jobs=sorted(jobs,key=lambda x:x[1])
    while jobs:
        for i in range(len(jobs)):
            if jobs[i][0]<=start:
                start+=jobs[i][1]
                answer+=(start-jobs[i][0]) #실제 수행 시간 - 요청한 시간
                jobs.pop(i)
                break
            if len(jobs)-1 == i:
                start+=1

    return answer//n