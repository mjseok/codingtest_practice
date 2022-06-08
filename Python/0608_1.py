n=int(input())
p=list(map(int,input().split())) #셍산
c=list(map(int,input().split())) #주문
store=0#재고
value=100
money=0 #판매금액
day=n
for i in range(n):
    store+=p[i]
    #판매가능할때
    if store>=c[i]:
        money+=value*c[i]
        store-=c[i]
        value=100
    else:
        value-=20
    if value==0:
        day=i
        break
    
    print(store)

print(round(money/day,2))



    
