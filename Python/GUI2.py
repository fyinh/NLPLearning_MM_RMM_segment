# -*- coding: UTF-8 -*-

from tkinter import *
import MM_RMM as MR

def f1():
    def getContent():
        sentence = s.get(0.0, END) # get输入文本框的内容
        Maxlen = ss.get(0.0, END)
        Maxlen = int(Maxlen)
        result = MR.get_Result(sentence,Maxlen)
        print('在GUI2.py上输出的结果:',result)
        s1.insert(INSERT,result[0])
        s2.insert(INSERT,result[1])
        s3.insert(INSERT,result[2])

    top2 = Tk()
    top2.maxsize(1200,800)
    top2.minsize(800,600)
    top2.title("正向逆向最大匹配分词算法")

    l1 = Label(top2, text="MM_RMM算法", relief="groove", font=("Arial", 30), fg="purple")
    l1.pack()
    l2 = Label(top2,height=1)
    l2.pack()

    l3 = Label(top2, text="请输入一个句子： ", font=("Arial", 12), fg="MediumOrchid")
    l3.pack()

    s = Text(top2, width=50, height=3, font=("Arial", 15))
    s.pack()
    l2 = Label(top2, height=1)
    l2.pack()

    ll3 = Label(top2, text="Maxlen： ", font=("Arial", 12), fg="MediumOrchid")
    ll3.pack()

    ss = Text(top2, width=5, height=1, font=("Arial", 15))
    ss.pack()
    l2 = Label(top2, height=1)
    l2.pack()

    b1 = Button(top2, text="MM_RMM", font=("Arial", 17), width=10, bg="Plum", fg="white",command=getContent)
    b1.pack()

    l4 = Label(top2, text="正向匹配分词结果： ", font=("Arial", 12), fg="MediumOrchid")
    l4.pack()
    s1 = Text(top2, width=50, height=3, font=("Arial", 10))
    s1.pack()
    l2 = Label(top2, height=1)
    l2.pack()

    l5 = Label(top2, text="逆向匹配分词结果： ", font=("Arial", 12), fg="MediumOrchid")
    l5.pack()
    s2 = Text(top2, width=50, height=3, font=("Arial", 10))
    s2.pack()
    l2 = Label(top2, height=1)
    l2.pack()
    
    l6 = Label(top2, text="双向匹配分词结果： ", font=("Arial", 12), fg="MediumOrchid")
    l6.pack()
    s3 = Text(top2, width=50, height=3, font=("Arial", 10))
    s3.pack()
    top2.mainloop()

def main():
    f1()

if __name__ == "__main__":
    main()