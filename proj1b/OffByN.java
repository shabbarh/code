public class OffByN implements CharacterComparator {
    int Off;
    public OffByN(int N){
        Off=N;
    }
    public boolean equalChars(char x,char y){
        if(x-y==Off||y-x==Off)
            return true;
        else return false;
    }
}
