/**
 * @file Nouredeen Hammad Project1
 * @description This algorithm re-arranges rotated text, compares it with the 
 * dictionary and counts the number of repetitions of each word.
 * @assignment Project 1
 * @date 3/12/2021 -> 13/12/2021
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package Project1;

public class Project1 {

    public static void printArray(String[] array) {
        for (int i = 1; i < array.length + 1; i++) {
            System.out.print(array[i - 1] + " ");
            if (i % 10 == 0) {
                System.out.println("");
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 1; i < array.length + 1; i++) {
            System.out.print(array[i - 1] + "\t");
            if (i % 10 == 0) {
                System.out.println("");
            }
        }
    }

    public static String rotateLeft1(String text) {
        String rotatedText = "";
        char temp = text.charAt(0);
        for (int i = 0; i < text.length() - 1; i++) {
            rotatedText += text.charAt(i + 1);
        }
        rotatedText += temp;

        return rotatedText;
    }

    public static boolean stringEquals(String str1, String str2) {
        boolean isEqual = false;
        if (str1.length() == str2.length()) {
            //for each letter
            for (int i = 0; i < str1.length(); i++) {
                //checking characters in a non-case sensitive way
                if (str1.charAt(i) == str2.charAt(i) 
                        || str1.charAt(i) == str2.charAt(i) - 32
                        || str1.charAt(i) == str2.charAt(i) + 32) {
                    isEqual = true;
                } else {
                    isEqual = false;
                    break;
                }
            }
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    public static String[] stringToArray(String text) {
        //Counting the number of words in the string
        int wordCounter = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCounter++;
            }
        }

        String[] processedArray = new String[wordCounter];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            String temp = "";

            if (text.charAt(i) != ' ' && text.length() + 1 >= i) {
                while (text.charAt(i) != ' ') {
                    temp += text.charAt(i);
                    if (text.length() - 1 == i) {
                        break;
                    } else {
                        i++;
                    }

                }
                processedArray[j++] = temp;
            }
        }
        return processedArray;
    }

    public static String[] rearrangeAndCount(String[] mixed, String[] dict, int[] repeatCount) {
        String[] rearrangedTextArray = new String[mixed.length];

        //each word in mixed text
        for (int i = 0; i < mixed.length; i++) { 
            //checks if the array index i is still empty
            while (rearrangedTextArray[i] == null) {
                //each word in dictionary
                for (int j = 0; j < dict.length; j++) { 

                    if (stringEquals(mixed[i], dict[j])) {
                        rearrangedTextArray[i] = dict[j];
                        repeatCount[j]++;
                        break;
                    }
                }
                mixed[i] = rotateLeft1(mixed[i]);
            }
        }

        return rearrangedTextArray;
    }

    public static void main(String[] args) {
        String mixedText = "onteM Ne si a merfor health esortr and nedplan "
                + "unitycomm in het sU atest fo rkansasA nope omfr 9011 to the "
                + "d-1930smi It asw owned nda by liamWil eHop arveyH a ncialfina "
                + "ttheoris dan riterw ni eth kOzar llshi fo the iteWh iverR "
                + "leyval east of sRoger no the edge of averBe eLak woT of sit "
                + "hotels Missouri Row nda maOklaho Row ewer eth estlarg log "
                + "ngsbuildi in eth rldwo at the etim and aOklahom tower si neo "
                + "fo het rliestea xamplese of a storymulti- ncreteco restructu "
                + "The ortres was otn a alfinanci uccesss edu ni rtpa ot "
                + "entmanagem ylest dan yshortl eraft ish thdea the typroper swa "
                + "dsol ffo heT remainder fo het esortr and town asw stalmo "
                + "ompletelyc mergedsub rafte erBeav Lake was atedcre in 1964 "
                + "heT erelysev zedvandali Oklahoma wRo werto is het yonl "
                + "emainingr ructurest atth anc eb seen at alnorm kela lsleve "
                + "heT area on eth edge of averBe Lake llsti erredref ot sa Monte"
                + " eN edown and gedmana by het tedUni States yArm orpsC of "
                + "sEngineer esserv nlymai as a tboa ampr";

        String dictionary = "1901 1964 Arkansas army Beaver corps engineers "
                + "Harvey harveys Hope It lake Missouri Monte Ne Oklahoma Ozark "
                + "River Rogers row rows states the two Us united White William "
                + "a after almost and area as at be boat buildings by can "
                + "community completely concrete created death due earliest east "
                + "edge examples financial former from health hills his hotels "
                + "in is its lake largest levels log mainly managed management "
                + "mid-1930s multi-story normal not of off on one only open "
                + "operated owned part planned property ramp referred remainder "
                + "remaining resort seen serves severely shortly sold state still "
                + "structure style submerged success that the theorist time to "
                + "tower town valley vandalized was were world writer";

        String[] dictionaryArray = stringToArray(dictionary);       
        String[] mixedTextArray = stringToArray(mixedText);
        
        int[] count = new int[dictionaryArray.length];

        System.out.println("The corrected text:");
        printArray(rearrangeAndCount(mixedTextArray, dictionaryArray, count));

        System.out.println("");
        System.out.println("");
        
        System.out.println("The repetition count for each dictionary word:");
        printArray(count);

    }

}
