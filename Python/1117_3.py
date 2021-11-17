def solution(N):
    ans = 0
    while N:
        if N%2==1:
            ans+=1
        N//=2
    return ans
#print(solution(5000))