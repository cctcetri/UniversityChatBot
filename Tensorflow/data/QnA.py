#-*- coding: utf-8 -*-
import csv
f = open('/home/hong/PycharmProjects/test/YoungDae.txt',"r")
r = open('/home/hong/PycharmProjects/test/YoungDae2.txt',"w")
while True:
    lines = f.readlines()
    i=0
    state = "Q" #질문상태(Q/A)
    for line in lines:
        line = line.replace(' ', '').replace('\n', '')
        if line[0:4].__eq__("2017") or line[0:4].__eq__("2016"):
            if line[18:][line[18:].find(':')-1:line[18:].find(':')].__eq__('대'):
                print(line[18:][line[18:].find(':')+1:])
                if state.__eq__("Q"):
                    r.write('')
                else:
                    r.write('\n')
                state = "Q"
                r.write(line[18:][line[18:].find(':')+1:].replace(' ', ''))
            elif line[18:][line[18:].find(':')-1:line[18:].find(':')].__eq__('님'):
                print(line[18:][line[18:].find(':')+1:])
                if state.__eq__("A"):
                    r.write('')
                else:
                    r.write('\n')
                state = "A"
                r.write(line[18:][line[18:].find(':')+1:].replace(' ', ''))
        elif line[0:1].__eq__(''):
            print('공백!!')
            continue
        else:
            if (state.__eq__("Q")):
                r.write(line[line.find(':') + 1:].replace(' ', ''))
            elif (state.__eq__("A")):
                r.write(line[line.find(':') + 1:].replace(' ', ''))

            continue
    break
f.close()
r.close()

#
# for i in range(1,11):
#     data = "%d번째 줄입니다.\n" %i
#     f.write(data)
#