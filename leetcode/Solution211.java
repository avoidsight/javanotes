package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author menmenz
 * @version 1.0
 * @date 10/19/21 3:41 PM
 */
public class Solution211 {
    private Set<String> dictionary;
    public Solution211() {
        dictionary = new HashSet();
    }

    public void addWord(String word) {
        dictionary.add(word);
    }

    public boolean search(String word) {
        int len = word.length();
        for(String r:dictionary) {
            if(len == r.length()){
                for(int i = 0; i<len;i++){
                    if(word.charAt(i) == '.' || word.charAt(i) == r.charAt(i)){
                        if(i == len -1) {
                            return true;
                        }
                        continue;
                    }else{
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
