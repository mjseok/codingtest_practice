T=int(input())

zero=[1,0,1]
one=[0,1,1]

def fibo2(num):
    length=len(zero)
    if length<=num:
        for i in range(length,num+1):
            zero.append(zero[i-1]+zero[i-2])
            one.append(one[i-1]+one[i-2])
    print(int(zero[num]),int(one[num]))

for i in range(T):
    N=int(input())
    fibo2(N)