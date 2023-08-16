//DARAGH DOWNES 22351159
//CAYLUM HURLEY 22356363
//DARRAGH QUINN 22359621
//JOE CONSIDINE 22344977

public class DictionaryDriver {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java DictionaryDriver <filepath> <shortest> <longest>");

        }

        String filepath = args[0];
        int shortest = Integer.parseInt(args[1]);
        int longest = Integer.parseInt(args[2]);
        Dictionary dictionary = new Dictionary(filepath, shortest, longest);

        String word = "EPIC";
        String word2 = "BRASS";
        System.out.println(dictionary.words);

        if(dictionary.inDictionary(word)){
            System.out.println(word +", exists in the dictionary.");
        }
        else{
            System.out.println(word +", does not exist in the dictionary.");
        }

        if(dictionary.add(word)){
            System.out.println(word +", has been added to the dictionary.");
        }
        else{
            System.out.println(word +", has not been added to the dictionary.");

        }

        if(dictionary.inDictionary(word2)){
            System.out.println(word2 +", exists in the dictionary.");
        }
        else{
            System.out.println(word2 +", does not exist in the dictionary.");
        }

        if(dictionary.add(word2)){
            System.out.println(word2 +", has been added to the dictionary.");
        }
        else{
            System.out.println(word2 +", has not been added to the dictionary.");

        }

        System.out.println("Here is a random word from the dictionary: " + dictionary.nextWord());

        dictionary.add("HELLO");
        dictionary.add("HELLO"); //duplicate words trying to be added
        dictionary.add("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        dictionary.add("EGG");
        dictionary.add("egg");
        dictionary.add("Egg");
        dictionary.add("eGG                            ");
        System.out.println(dictionary.words);







    }
}