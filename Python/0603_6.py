def solution(s):
    answer = ''
    for idx,val in enumerate(s):
        
        if idx==0 and val.isalpha():
            answer+=s[idx].upper()
        elif s[idx-1]==' ' and val.isalpha():
            answer+=s[idx].upper()
        elif val!=' ':
            answer+=s[idx].lower()
        else:
            answer+=' '
    return answer