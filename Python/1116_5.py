def solution(progresses, speeds):
    answer = []
    term=[]
    ans=1
    num=0
    for p,s in zip(progresses,speeds):
        mok,namuji=divmod(100-p,s)
        if namuji==0:
            term.append(mok)
        else:
            term.append(mok+1)
    num=term[0]
    for i in range(1,len(term)):
        if num>=term[i]:
            ans+=1
        else:
            num=term[i]
            answer.append(ans)
            ans=1
        if i==len(term)-1:
            answer.append(ans)
    return answer
