import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem22 {
    /*
    Names scores

    Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over
    five-thousand first names, begin by sorting it into alphabetical order. Then working out the
    alphabetical value for each name, multiply this value by its alphabetical position in the list
    to obtain a name score.

    For example, when the list is sorted into alphabetical order, COLIN, which is worth
    3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of
    938 × 53 = 49714.

    What is the total of all the name scores in the file?
     */
    public static final String name_file = "Problem22.txt";
    public static BigInteger nameScores(){
        List<String> names = new ArrayList<>();
        BigInteger score = new BigInteger("0"); // When I'm unsure of scale, and memory is of no consiquence, I use BigInteger.
        try{
            URL path = Problem22.class.getResource(name_file);
            File text = new File(path.getFile());
            BufferedReader reader = new BufferedReader(new FileReader(text));
            Pattern p = Pattern.compile("(\\w+)");
            for(String line; (line = reader.readLine()) != null;){
                Matcher m = p.matcher(line);
                while(m.find()){
                   names.add(m.group(1));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        Collections.sort(names);
        for(int i = 0; i<names.size(); i++){
            String name = names.get(i);
            int ith = i+1;
            long nameScore =  nameVal(name)*ith;
            //if(nameScore<0)System.out.println("overflow"); // Just checking.
            score = score.add(new BigInteger(""+nameScore));
        }

        return score;
    }

    private static int nameVal(String name){
        int score=0;
        name=name.toLowerCase();
        for(int i = 0; i<name.length(); i++){
            char c = name.charAt(i);
            score+=c-'a'+1;
        }
        return score;
    }

    public static void main(String[] args){
        System.out.println("Total of all the name scores in the file: "+nameScores());
    }
}
