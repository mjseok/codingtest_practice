def right(s):
    check=[]
    for i in s:
        if i=='(':
            check.append(i)
        else:
            if len(check)==0:
                return False
            check.pop()
    if len(check)==0:
        return True
    return False
def balance(s):
    n=0
    for idx,val in enumerate(s):
        if val=='(':
            n+=1
        if val==')':
            n-=1
        if n==0:
            return idx
def solution(p):
    answer=''
    if len(p)==0 or right(p):
        return p
    v=p[balance(p)+1:]
    u=p[:balance(p)+1]
    if right(u):
        answer=solution(v)
        answer=answer+u
    else:
        answer+='('
        answer+=solution(v)
        answer+=')'
        u=list(u[1:-1])
        for i in range(len(u)):
            if u[i]=='(':
                u[i]=')'
            else:
                u[i]='('
        answer+="".join(u)
    return answer
