import traceback
class segment:
	def __init__(self,):
		self.dict = []
		self.result1 = ""
		self.result2 = ""
		self.MM_result = []
		self.RMM_result = []

	def readDict(self):
		try:
			file = open('chineseDic.txt','r',encoding='utf-8')
			lines = file.readlines()
			file.close()
			for line in lines:
				if line == '\n':
					continue
				# 以","切分，只获取词语部分并添加到dict列表中
				words = line.strip('\n').split(",")
				self.dict.append(words[0])
		except Exception as e:
			traceback.print_exc()

	# 正向最大匹配算法 source为句子, Le为 MaxLen, npos为开始时指针的位置(npos=0)
	def MM(self, source, Le, npos):
		leng = len(source)
		if npos+1 > leng:                # 当指针位置超出句子长度时，退出
			return
		while (npos+Le) > leng:          # 当正向截取的下一段词超出句子总长度，则控制 Le - 1
			Le = Le - 1
		substr = source[npos:npos+Le]    # 截取句子中 从npos到 npos+Le 的词句为 substr，判断若
		if substr in self.dict:          # substr 词典dict中，则添加进 MM_result列表中作为一个分词，
			npos = npos + Le             # 指针位置正向移动 Le 个单位
			self.result1 = self.result1 + substr + "/"
			self.MM_result.append(substr)
			Le = 4                              # Le 重新赋值为 4, 并进行下一次的匹配
			self.MM(source,Le,npos)
		else:                               # 若 substr 不在词典dict中, Le=Le-1, 并进行下一次的匹配
			if Le >= 1:
				Le = Le - 1
				self.MM(source,Le,npos)

	# 逆向最大匹配算法 source为句子, Le为 MaxLen, npos为开始时指针的位置(从句末开始, npos=len(source))
	def RMM(self, source, Le, npos):
		if npos-1 < 0:                         # 如果指针位置来到了句首，则退出
			return
		while (npos-Le) < 0:                   # 当逆向截取的下一段词超出了句首，则控制 Le - 1
			Le = Le - 1
		substr = source[npos-Le:npos]          # 截取句子中 从npos-Le到 npos 的词句为 substr，判断若
		if substr in self.dict:                # substr 词典dict中，则添加进 RMM_result列表中作为一个分词，
			npos = npos - Le                   # 指针位置逆向移动 Le 个单位
			self.RMM_result.append(substr)
			Le = 4                             # Le 重新赋值为 4, 并进行下一次的匹配
			self.RMM(source,Le,npos)
		else:                                  # 若 substr 不在词典dict中, Le=Le-1, 并进行下一次的匹配
			if Le >= 1:
				Le = Le - 1
				self.RMM(source,Le,npos)

	# 由于运行RMM函数后，得到的结果列表 RMM_result里的分词是反过来的，需要 get_result2()函数矫正
	def get_result2(self):
		self.RMM_result.reverse()
		for word in self.RMM_result:
			self.result2 += word + "/"
		return self.result2

	def get_result1(self):
		return self.result1

	# resultword()函数用来处理选择正向逆向最大匹配后的结果
	def resultword(self, list1, list2, result1, result2):
		if len(list1) != len(list2):                     # 原则1: 如果正反向分词结果词数不同，则取分词数量较少的那个；
			if len(list1) > len(list2):
				return result2
			else:
				return result1
		else:                                        # 原则2: 如果分词结果词数相同：
			FSingle = 0
			BSingle = 0
			if result1 == result2:                   # 分词结果相同，就说明没有歧义，可返回任意一个；
				return result1
			else:                                    # 分词结果不同，返回其中单字较少的那个。
				for i in range(len(list1)):
					if len(list1[i]) == 1:
						FSingle += 1
					if len(list2[i]) == 1:
						BSingle += 1
				if BSingle > FSingle:
					return result1
				else:
					return result2

def get_Result(sentence,MaxLen):
	s = segment()
	s.readDict();
	# str1 = "对外经济技术合作与交流不断扩大。"
	# str1 = "幼儿园地节目"
	pos = 0
	# MaxLen = 4
	# s.MM(sentence,MaxLen,pos)
	s.RMM(sentence,MaxLen,len(sentence))
	s.MM(sentence,MaxLen,pos)
	s.get_result2()
	result3 = s.resultword(s.MM_result,s.RMM_result,s.result1,s.result2)
	return s.result1,s.result2,result3

# results = get_Result("对外经济技术合作与交流不断扩大。",4)
results = get_Result("幼儿园地节目",4)
print("正向最大匹配:",results[0])
print("逆向最大匹配:",results[1])
print("双向最大匹配:",results[2])
print("MM_RMM.py上输出的结果:",results)