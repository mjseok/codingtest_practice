def solution(n):
    answer = -1
    if n==1:
        return 4
    for i in range(1,n):
        if n%i==0 and n//i==i:
            return (i+1)*(i+1)
    
    return answer
print(solution(1))