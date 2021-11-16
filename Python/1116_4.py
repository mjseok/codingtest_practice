def checkDecimal(n): #소수인지 아닌지 확인
    
    for i in range(2,n):
        if n%i==0:
            return False
    return True

def solution(nums):
    answer = 0
    for i in range(0,len(nums)-2):
        for j in range(i+1,len(nums)-1):
            for k in range(j+1,len(nums)):
                if checkDecimal(nums[i]+nums[j]+nums[k]) : answer+=1
    return answer

print(solution([1,2,7,6,4]))