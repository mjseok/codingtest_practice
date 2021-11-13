def gcd(x,y):
    while y:
        x,y=y,x%y
    return x
def solution(w,h):
    answer=w*h-(w+h-gcd(w,h))
    return answer