import konlpy




def disintegration_kor(sentence):

    disintegrated_sentence = konlpy.tag.Twitter().pos(sentence, norm=True, stem=True)
    original_sentence = konlpy.tag.Twitter().pos(sentence)
    inputData = []
    outputData = []
    is_asking = False
    #disinte_message = twitter.pos(message, norm=True,stem=True)
    for w, t in disintegrated_sentence:
        if t not in ['Eomi', 'Josa', 'Number', 'KoreanParticle', 'Punctuation']:
            inputData.append(w)
    for w, t in original_sentence:
        if t not in ['Number', 'Punctuation']:
            outputData.append(w)
    if original_sentence[-1][1] == 'Punctuation' and original_sentence[-1][0] == "?":
        if len(inputData) != 0 and len(outputData) != 0:
            is_asking = True  # To extract ask-response raw data
    print( type(' '.join(inputData)), ' '.join(outputData), is_asking)
    #print(type(' ').join(inputData), type(' '.join(outputData)))

disintegration_kor("안녕하세요 제이름은 박민수입니다.")