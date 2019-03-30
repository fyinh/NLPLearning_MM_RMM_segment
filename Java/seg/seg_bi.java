/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seg;

/**
 *
 * @author 高佬_
 */
public class seg_bi {
    seg_RMM s=new seg_RMM();
    seg_only a = new seg_only();
    
    public seg_bi(){
        s.readDict();
        a.readDict();
    }
    public static void main(String[] args)
    {
        seg_bi f = new seg_bi();
        System.out.print(f.check_right("我正在上自然语言处理课."));
    }
    public String get_MMresult(){
        return a.getResult();
    }
    public String get_RMMresult(){
        return s.getResult();
    }
    public String get_result(){
        return a.getResult();
    }
    public boolean check_right(String source){
        int rmm_l = source.length();
        s.RMM(source, 4, rmm_l-1);
        a.MM(source, 4, 0);
        return (s.getResult().equals(a.getResult()));
 
    }
    
}
