import synthesizer.*;
public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString strings[]=new GuitarString[keyboard.length()];
        for(int i=0;i<37;i++) {
            double frequency = 440 * Math.pow(2, (i - 24) / 12);
            strings[i]=new GuitarString(frequency);
        }
        while(true){
            if(StdDraw.hasNextKeyTyped()){
                char key=StdDraw.nextKeyTyped();
                int indexOfGuitarString=keyboard.indexOf(key);
                if(indexOfGuitarString!=-1)
                    strings[indexOfGuitarString].pluck();
            }
        }
    }
}
