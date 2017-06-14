from konlpy.tag import Twitter
from pprint import pprint
import nltk
import itertools
import numpy as np
import pickle


twitter = Twitter()
filename = "KakaoTalk_QnA2.txt"

VOCAB_SIZE=7000

limit = {
        'maxq' : 177,
        'minq' : 1,
        'maxa' : 177,
        'mina' : 1
        }

UNK = 'unk'


def read_lines(filename):
    return open(filename, encoding='utf-8', errors='ignore').read().split('\n')[:-1]


def refine_data(doc):
    return twitter.pos(doc, norm=True, stem=True)

def refine_line(line):
    for i in range(len(line)):
        line[i]= refine_data(line[i])
    return line


"""
token = [t for d in list for t in d[0]]
print(len(token))
print(list)

text= nltk.Text(token, name='mmsc')
print(len(text.tokens))
pprint(text.vocab().most_common(5))

"""

def filter_data(sequence): #질문과 대답을 filter한다.
    filter_q, filter_a = [] , []   # question과 answer을 나누기
    #raw_data_len =len(sequence)//2
    print(len(sequence))
    for i in range(0, len(sequence),2):
        #qlen , alen = len(sequence[i].split(' ')), len(sequence[i+1].split(' '))
        filter_q.append(sequence[i])
        filter_a.append(sequence[i+1])

    return filter_q, filter_a

"""
qlines, alines = filter_data(lines)
print("qlineS",qlines)
qtokenized = [wordlist.split(' ') for wordlist in qlines]
atokenized = [wordlist.split(' ') for wordlist in alines]
print("qtokenized" ,qtokenized)
"""

def zero_pad(qtokenized, atokenized, w2idx):
    # num of rows
    data_len = len(qtokenized)

    print("q_indices", qtokenized[0])
    print("a_indices", atokenized[0])

    # numpy arrays to store indices
    idx_q = np.zeros([data_len, limit['maxq']], dtype=np.int32)
    idx_a = np.zeros([data_len, limit['maxa']], dtype=np.int32)

    for i in range(data_len):
        q_indices = pad_seq(qtokenized[i], w2idx, limit['maxq'])
        a_indices = pad_seq(atokenized[i], w2idx, limit['maxa'])

        #print(len(idx_q[i]), len(q_indices))
        #print(len(idx_a[i]), len(a_indices))
        idx_q[i] = np.array(q_indices)
        idx_a[i] = np.array(a_indices)

    return idx_q, idx_a

def pad_seq(seq, lookup, maxlen):
    indices = []
    for word in seq:
        if word in lookup:
            indices.append(lookup[word])
        else:
            indices.append(lookup[UNK])
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
    print("idex2word:", index2word)
    # word2index
    word2index = dict([(w, i) for i, w in enumerate(index2word)])
    print("word2index", word2index)
    return index2word, word2index, freq_dist


def process_data():

    lines = read_lines(filename)
    print(type(lines))
    qlines, alines = filter_data(lines) #q,a를 나눈다. refine_data: twitter.pos
    q_refine_list = refine_line(qlines) #refine_line : 하나의 배열로 저장한다.
    print(type(q_refine_list))
    print(q_refine_list)
    a_refine_list = refine_line(alines)
    print("q_refine",q_refine_list[0])
    print("a_refine",a_refine_list[0])

    #token = [t for d in list for t in d[0]]
    idx2w, w2idx, freq_dist = index_(q_refine_list + a_refine_list , vocab_size=VOCAB_SIZE)
    idx_q,idx_a = zero_pad(q_refine_list, a_refine_list,w2idx)
    np.save('idx_q.npy',idx_q)
    np.save('idx_a.npy',idx_a)

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

#qlines, alines =filter_data(line)

"""
train_docs = refine_data(line)
text=nltk.Text(train_docs, name="ms")
print(train_docs)
print(train_docs)
print(line)
print(len(train_docs))  #token의 갯수
print(text.vocab())
pprint
(text.vocab().most_common(10)) # 가장 많이 사용하는 10개의 토큰
"""
#pprint(train_docs)
# 잘 들어갔는지 확인



"""

# 헬 조사를 뺀 동사와 명사로만 이루어진 문장만들기

def tokenize2(sentences):
    disintegrated_sentence = pos_tagger.pos(sentences,norm=True, stem=True)
    inputData=[]
    original_sentence = pos_tagger(sentences)

    for w, t in disintegrated_sentence:
        if t not in ['KoreanParticle', 'Punctuation']:
            inputData.append(w)


        return ' '.join(inputData)

    print(inputData)
"""



