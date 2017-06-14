# In[1]:

import tensorflow as tf
import numpy as np
import sys

# preprocessed data
from data import kor_data2
import data_utils
import kor_Seq2Seq



print("Loading trained parameter")
# load data from pickle and npy files
metadata, idx_q, idx_a = kor_data2.load_data(PATH='data/')
# path의 트위터 data에서
# metadata , idx_q, idx_a 리턴 값받는다.

(trainX, trainY), (testX, testY), (validX, validY) = data_utils.split_dataset(idx_q, idx_a)

#print("metadata",metadata)
#print("idx_q", idx_q)
#print("idx_a",idx_a)
print("trainx",trainX)
print("trainy",trainY)
print("validx",validX)
print("validy",validY)
# parameters 
xseq_len = trainX.shape[-1]
yseq_len = trainY.shape[-1]
#print("xseq_len",xseq_len)
#print("yseq_len",yseq_len)
batch_size = 30
xvocab_size = len(metadata['idx2w'])
yvocab_size = xvocab_size
print("xvocab_size",xvocab_size)
emb_dim = 500




# In[7]:
print("Building seq2seq...")

model = kor_Seq2Seq.Seq2Seq(xseq_len=xseq_len,
                            yseq_len=yseq_len,
                            xvocab_size=xvocab_size,
                            yvocab_size=yvocab_size,
                            num_layers=3,
                            emb_dim = emb_dim,
                            ckpt_path='data/'
                            )


# In[8]:

val_batch_gen = data_utils.rand_batch_gen(validX, validY, 30)
train_batch_gen = data_utils.rand_batch_gen(trainX, trainY, batch_size)

print("val_batch",val_batch_gen)
print("train_batch",train_batch_gen)

# In[9]:
#print("Restoring session..")
#sess = model.restore_last_session()
sess = model.train(train_batch_gen, val_batch_gen)
#sess.close()


