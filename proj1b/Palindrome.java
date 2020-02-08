public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        if(word!=null){
            LinkedListDeque<Character> chars=new LinkedListDeque<>();
            for(int N=word.length()-1;N>-1;N--)
                chars.addFirst(word.charAt(N));
            return chars;
        }
        return null;
    }
    public boolean isPalindrome(String word){
        word.toLowerCase();
        Deque d=wordToDeque(word);
            return isPalindrome(d);
    }
    private boolean isPalindrome(Deque d){
        if(d.size()==0||d.size()==1)
            return true;
        else if(((Character)d.removeFirst()).compareTo((Character) d.removeLast())==0)
            return isPalindrome(d);
        else return false;
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        word.toLowerCase();
        Deque d=wordToDeque(word);
        return isPalindrome(d,cc);
    }
    private boolean isPalindrome(Deque d,CharacterComparator cc){
        //CharacterComparator offByOne= new OffByOne();
        if(d.size()==0||d.size()==1)
            return true;
        else if(cc.equalChars((char)d.removeFirst(),(char)d.removeLast()))
            return isPalindrome(d,cc);
        else return false;
    }
}
