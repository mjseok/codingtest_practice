def check(place):
    for i in range(0,5):
        place[i]=list(place[i])
    
    for i in range(0,5):
        for j in range(0,5):
            if place[i][j]=='P':
                #상
                if i>=1 and place[i-1][j]=='P':
                    return False
                if i>=2 and place[i-1][j]=='O' and place[i-2][j]=='P':
                    return False
                #하
                if i+1<5 and place[i+1][j]=='P':
                    return False
                if i+2<5 and place[i+1][j]=='O' and place[i+2][j]=='P':
                    return False
                #좌
                if j>=1 and place[i][j-1]=='P':
                    return False
                if j>=2 and place[i][j-1]=='O' and place[i][j-2]=='P':
                    return False
                #우
                if j+1<5 and place[i][j+1]=='P':
                    return False
                if j+2<5 and place[i][j+1]=='O' and place[i][j+2]=='P':
                    return False

                #상좌
                if i>=1 and j>=1 and place[i-1][j-1]=='P':
                    if place[i-1][j]=='O' or place[i][j-1]=='O':
                        return False
                #상우
                if i>=1 and j+1<5 and place[i-1][j+1]=='P':
                    if place[i-1][j]=='O' or place[i][j+1]=='O':
                        return False
                #하좌
                if i+1<5 and j>=1 and place[i+1][j-1]=='P':
                    if place[i+1][j]=='O' or place[i][j-1]=='O':
                        return False
                #하우     
                if i+1<5 and j+1<5 and place[i+1][j+1]=='P':
                    if place[i+1][j]=='O' or place[i][j+1]=='O':
                        return False  
    return True


def solution(places):
    answer = []
    for place in places:
        if check(place):
            answer.append(1)
        else:
            answer.append(0)
    return answer