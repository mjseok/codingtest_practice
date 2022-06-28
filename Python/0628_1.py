def solution(s):
    answer=[]
    
    for char in s:
        while answer and answer[-1]<char:
            answer.pop()
        answer.append(char)
    return ''.join(answer)
print(solution("xyb"))

