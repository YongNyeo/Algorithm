def solution(n):
    num = list(map(str,format(n,'b')))
    cnt1 = num.count('1')
    while(True):
        n +=1
        num = list(map(str,format(n,'b')))
        cnt = num.count('1')
        if cnt == cnt1:
            break
    return n