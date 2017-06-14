from data import kor_data2
import os
import time
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
import tensorflow as tf
import kor_Seq2Seq
import numpy as np
import data_utils
import time, threading
import urllib.response
import urllib.request
import urllib.parse
import requests
#import url

limit = {
        'maxq' : 25,
        'minq' : 1,
        'maxa' : 25,
        'mina' : 1
        }

#print( "Lodaing trained parameter...")
trained_data_path = 'data/'
metadata, idx_q, idx_a = kor_data2.load_data(PATH=trained_data_path)
#print("load_data 실")
#print("idx_q",idx_q)
#print("metadata",metadata)
(trainX, trainY), (testX, testY), (validX, validY) = data_utils.split_dataset(idx_q, idx_a)

xseq_len = trainX.shape[-1]
yseq_len = trainY.shape[-1]
print("xseq_len",xseq_len)
print("yseq_len",yseq_len)
batch_size = 30
xvocab_size = len(metadata['idx2w'])
yvocab_size = xvocab_size
emb_dim = 500

#print("x_len",xseq_len)
#print("y_len",yseq_len)
#print( "Building seq2seq...")

model = kor_Seq2Seq.Seq2Seq(   xseq_len=xseq_len,
                               yseq_len=yseq_len,
                               xvocab_size=xvocab_size,
                               yvocab_size=yvocab_size,
                               num_layers=3,
                               emb_dim=emb_dim,
                               ckpt_path='data/',
                               )
#print( "Restoring session...")
#sess = model.restore_last_session()
val_batch_gen = data_utils.rand_batch_gen(validX, validY, 32)
train_batch_gen = data_utils.rand_batch_gen(trainX, trainY, batch_size)

sess = model.restore_last_session()


def send(message):

    #print("client",message)

    #print("send실행됐지롱!")
    print(message)
    data_len =limit['maxq']
    print('1')

    q_refine_list = (kor_data2.disintegration_kor(message))[0]

    print('2')
    print(q_refine_list)
    #print("q_refine_list",q_refine_list)
    idx_q = np.zeros([data_len, limit['maxq']], dtype=np.int32)
    print('3')
    message_tokenized = q_refine_list.split(' ')
    indices = kor_data2.pad_seq(message_tokenized, metadata['w2idx'], limit['maxq'])
    print("messagetokenized",message_tokenized)
    #print("indices",indices)
    #print("np.array",np.array(indices))
    #idx_q = idx_q+np.array(indices).reshape(1,limit['maxq']) #maxq행 1열 행렬만들기
    idx_q = idx_q + np.array(indices).reshape(1,limit['maxq'])
    print("idx_q",idx_q)
    output = model.predict(sess, idx_q)
    print("output_origin",output)
    print("output",output[0])
    output_decoded = data_utils.decode(sequence=output[0], lookup=metadata['idx2w'], separator=' ').split(' ')
    reply = ' '.join(output_decoded).replace('unk', '')
    #print("출력되라")
    print(reply)
    return reply



def server():

        while True:
                ### Suspend ###

            path = 'http://52.78.94.234/kakaomsg2.php'  # the url you want to POST to
            req = urllib.request.Request(path)
            req.add_header("Content-type", "application/x-www-form-urlencoded")
            page = urllib.request.urlopen(req).read()
            state = page.decode('utf-8')
            #print("state타입",type(state))
            print(state)

            if(state == '1'):
                #print "url은 이거다",car_picture_url

                data = {'state': '0'}
                path = "http://52.78.94.234/kakaomsg.php"
                resq = requests.get(path, data=data)
                print(resq.status_code)


                #time.sleep(2)
               # print("2second later")

              #  print("state",1)
                path = 'http://52.78.94.234/kakaosend2.php'  # the url you want to POST to
                req = urllib.request.Request(path)
                req.add_header("Content-type", "application/x-www-form-urlencoded")
                kakao=urllib.request.urlopen(req).read()##msg read
                kakao =kakao.rstrip()
                print("orgin_kakao_type",type(kakao))
                print("origin_kakao",kakao)
                kakao = kakao.decode('utf-8')
                #kakao = kakao.strip('\n')
                #kakao = kakao.rstrip()

                #time.sleep(2)

                print(kakao)
                print("kakao type",type(kakao))

                if (kakao == '안녕 한성봇'):
                    data = {'msg': '안녕?'}
                    path = "http://52.78.94.234/kakaopy.php"
                    resq = requests.post(path, data=data)
                    print(resq.status_code)
                    print("-------------------------------------")

                elif(kakao != ''):
                    print("들어오나")
                    msg=send(kakao)

                    #msg ="영대 이자식아"
                    #time.sleep(10)

                    if(msg == ''):
                        data = {'msg': '무슨 말을 하는거야'}
                        path = "http://52.78.94.234/kakaopy.php"
                        resq = requests.post(path, data=data)
                        print(resq.status_code)
                        print("-------------------------------------")


                    else :
                        data = {'msg': msg}
                        path = "http://52.78.94.234/kakaopy.php"
                        resq = requests.post(path, data=data)
                        print("-------------------------------------")
                        print(resq.status_code)
                        data = {'state': '1'}
                        path = "http://52.78.94.234/state.php"
                        resq = requests.post(path, data=data)
                        print(resq.status_code)







    #print("start")

   # while True:
    #    msg= input()
     #   send(msg)
      #  print("end")

#MyExample().start()
if __name__ =="__main__":

    while True:
     print("input message!")
     msg = input()
     send(msg)


    #server()










