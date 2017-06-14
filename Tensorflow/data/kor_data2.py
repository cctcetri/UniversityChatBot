from konlpy.tag import Twitter
import nltk
import itertools
import numpy as np
import pickle
import random
import sys

twitter =Twitter()
filename = "ex.txt"


VOCAB_SIZE=3000

limit = {
        'maxq' : 25,
        'minq' : 1,
        'maxa' : 25,
        'mina' : 1
        }

UNK = 'unk'

#VOCAB_SIZE=6000
import random
import sys

def ddefault():
    return 1


def disintegration_kor(message):
    disinte_message = twitter.pos(message, norm=True,stem=True)
    original_sentence = twitter.pos(message)
    inputData = []
    outputData = []

    for w, t in disinte_message:
        if t not in ['Eomi', 'Josa','Punctuation']:
            inputData.append(w)
    for w, t in original_sentence:
        if t not in ['Number', 'Punctuation']:
            outputData.append(w)
    return ' '.join(inputData), ' '.join(outputData)
    # return 값으로  str값이 반환된다.
'''
 read lines from file
     return [list of lines]
'''


def read_lines(filename):
    return open(filename, encoding='utf-8', errors='ignore').read().split('\n')[:-1]


#
def refine_line(line):
    for i in range(len(line)):
        line[i] = (disintegration_kor(line[i]))[0]

    return line
    #print("type",type[line[0]])

#   return line

'''
 split sentences in one line
  into multiple lines
    return [list of lines]
'''



'''
 remove anything that isn't in the vocabulary
    return str(pure ta/en)
'''


'''
 read list of words, create index to word,
  word to index dictionaries
    return tuple( vocab->(word, count), idx2w, w2idx )
'''
def index_(tokenized_sentences, vocab_size):

    #token = [t for d in list for t in d[0]]
    #print(len(token))
    #print(list)
    print("token: ",tokenized_sentences)

    freq_dist = nltk.FreqDist(itertools.chain(*tokenized_sentences))
    #text= nltk.Text(tokenized_sentences, name='mmsc')
    #print(len(text.tokens))
    vocab = freq_dist.most_common(vocab_size)
    index2word = ['_'] + [UNK] + [x[0] for x in vocab]
    print("idex2word:", index2word)
    # word2index
    word2index = dict([(w, i) for i, w in enumerate(index2word)])
    print("word2index", word2index)
    return index2word, word2index, freq_dist

'''
 filter too long and too short sequences
    return tuple( filtered_ta, filtered_en )
'''

def filter_data(sequence): #질문과 대답을 filter한다.
    filtered_q, filtered_a = [] , []   # question과 answer을 나누기
    raw_data_len =len(sequence)//2
    print(len(sequence))
    for i in range(0, len(sequence),2):
        qlen , alen = len(sequence[i].split(' ')), len(sequence[i+1].split(' '))
        #if i==152:
        #    print ("alen",sequence[i])
        if qlen >= limit['minq'] and qlen <= limit['maxq']:
            if alen >= limit['mina'] and alen <= limit['maxa']:
                filtered_q.append(sequence[i])
                filtered_a.append(sequence[i + 1])

    filt_data_len = len(filtered_q)
    filtered = int((raw_data_len - filt_data_len) * 100 / raw_data_len)
    print(str(filtered) + '% filtered from original data')

    return filtered_q, filtered_a

"""
qlines, alines = filter_data(lines)
print("qlineS",qlines)
qtokenized = [wordlist.split(' ') for wordlist in qlines]
atokenized = [wordlist.split(' ') for wordlist in alines]
print("qtokenized" ,qtokenized)
"""

def filter_kor(qtokenized, atokenized, w2idx):

    data_len = len(qtokenized)

    filtered_q, filtered_a = [],[]
    for qline, aline in zip(qtokenized,atokenized):
        kor_count_q=len([w for w in qline if w not in w2idx])
        kor_count_a=len([w for w in aline if w not in w2idx])
        if(kor_count_a <= 2):
            if kor_count_q >0:
                if kor_count_q/len(qline)>0.2 :
                    pass

            filtered_q.append(qline)
            filtered_a.append(aline)

    return filtered_q ,filtered_a

def zero_pad(qtokenized, atokenized, w2idx):
    # num of rows
    data_len = len(qtokenized)
    data_len2 =len(atokenized)
    #print("data_len",data_len)
    # numpy arrays to store indices
    idx_q = np.zeros([data_len, limit['maxq']], dtype=np.int64)
    idx_a = np.zeros([data_len, limit['maxa']], dtype=np.int64)
    print("print test")
    print (atokenized[24])
    for i in range(data_len):
        q_indices = pad_seq(qtokenized[i], w2idx, limit['maxq'])
        a_indices = pad_seq(atokenized[i], w2idx, limit['maxa'])

        #print(len(idx_q[i]), len(q_indices))
        #print(len(idx_a[i]), len(a_indices))
        idx_q[i] = np.array(q_indices)
        idx_a[i] = np.array(a_indices)
        #print(i)

    return idx_q, idx_a

def pad_seq(seq, lookup, maxlen):
    indices = []
    for word in seq:
        if word in lookup:
            indices.append(lookup[word])
        else:
            indices.append(lookup[UNK])
            print("unk",lookup[UNK])
    return indices + [0]*(maxlen - len(seq))


def index_(tokenized_sentences, vocab_size):

    #token = [t for d in list for t in d[0]]
    #print(len(token))
    #print(list)
    print("token: ",tokenized_sentences)
    freq_dist = nltk.FreqDist(itertools.chain(*tokenized_sentences))
    #text= nltk.Text(tokenized_sentences, name='mmsc')
    #print(len(text.tokens))
    vocab = freq_dist.most_common(vocab_size)
    index2word = ['_'] + [UNK] + [x[0] for x in vocab]
    #print("idex2word:", index2word)
    # word2index
    word2index = dict([(w, i) for i, w in enumerate(index2word)])
    #print("word2index", word2index)
    return index2word, word2index, freq_dist


def process_data():

    lines = read_lines(filename)

    print('\n:: Sample from read(p) lines')
    print(lines[120:124])
    qlines, alines = filter_data(lines) #q,a를 나눈다. refine_data: twitter.pos
    q_refine_list = refine_line(qlines) #refine_line : 하나의 배열로 저장한다.
    a_refine_list = refine_line(alines)
    print(q_refine_list[150])
    print(a_refine_list[150])

    #print(a_refine_list.sort())
    #print("q_refine",q_refine_list[0])
    #print("a_refine",a_refine_list[0])
    #token = [t for d in list for t in d[0]]
    qtokenized = [wordlist.split(' ') for wordlist in q_refine_list]
    atokenized = [wordlist.split(' ') for wordlist in a_refine_list]
    #qtokenized = [[w.strip() for w in wordlist.split(' ') if w] for wordlist in q_refine_list]
    #atokenized = [[w.strip() for w in wordlist.split(' ') if w] for wordlist in a_refine_list]
    idx2w, w2idx, freq_dist = index_(qtokenized + atokenized , vocab_size=VOCAB_SIZE)
    qtokenized,atokenized = filter_kor(qtokenized,atokenized,w2idx)
    print("qtok",qtokenized)
    print("atok",atokenized)
    idx_q,idx_a = zero_pad(qtokenized, atokenized,w2idx)
    np.save('idx_q.npy',idx_q)
    np.save('idx_a.npy',idx_a)

    unk_count = (idx_q == 1).sum() + (idx_a == 1).sum()
    # count of words

    word_count = (idx_q > 1).sum() + (idx_a > 1).sum()
    # % unknown

    print('% unknown : {}'.format(100 * (unk_count / word_count)))

    print("인덱스q", idx_q)
    print("인덱스a", idx_a)
    metadata = {

        'w2idx' : w2idx,
        'idx2w' : idx2w,
        'limit' : limit,
        'freq_dist' :freq_dist
    }
    print(metadata)
    with open('metadata.pkl', 'wb+') as f:
        pickle.dump(metadata, f)
        f.close()


def load_data(PATH='data/'):
    # read data control dictionarie
    with open(PATH + 'metadata.pkl', 'rb+') as f:
        metadata = pickle.load(f)
        f.close()

    # read numpy arrays
    idx_q = np.load(PATH + 'idx_q.npy')
    idx_a = np.load(PATH + 'idx_a.npy')

    return metadata, idx_q, idx_a
   # atokenized = [wordlist.split(' ') for wordlist in a_refine_list]
    #print(qtokenized)
    #print(atokenized)


if __name__ =="__main__":
    process_data()
    print("kor_data complete")
