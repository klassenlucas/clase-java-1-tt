package ejercicios;

import java.util.*;

public class RadixSort {
    public static void radixSort(int[] arr) {
        String strArr[] = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(strArr,'0');

        int maxLen = StringUtil.maxLength(strArr);
        for(int i = 0; i<maxLen; i++) {
            realocateValuesInLists(strArr,i);
        }

        int sortedArr [] = StringUtil.toIntArray(strArr);

        for (int i = 0; i<arr.length; i++) {
            arr[i] = sortedArr[i];
        }
    }

    public static void realocateValuesInLists(String strArr[], int pos) {
        HashMap<String, ArrayList<String>> lists = createEmptyLists(10);
        for (String key: lists.keySet()) {
            String listNum = getListNumber(key);
            for (String n: strArr) {
                String lastNum = getValueFromPosition(n,pos+1);
                if(listNum.equals(lastNum)) {
                    ArrayList<String> list = lists.get(key);
                    list.add(n);
                    lists.put(key,list);
                }
            }
        }
        generateArrFromMap(strArr,lists);
    }

    public static void generateArrFromMap(String strArr[], HashMap<String,ArrayList<String>> m) {
        ArrayList<String> auxList = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : m.entrySet()) {
            if(!entry.getValue().isEmpty()) {
                for (String n: entry.getValue()) {
                    auxList.add(n);
                }
            };
        }

        for (int i =0; i< strArr.length; i++) {
            strArr[i] = auxList.get(i);
        }

    }

    public static String getListNumber(String s) {
        return s.substring(s.length()-1);
    }

    public static String getValueFromPosition(String s, int p) {
        return String.valueOf(s.charAt(s.length()-p));
    }

    public static HashMap<String, ArrayList<String>> createEmptyLists(int numberOfLists){
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i<numberOfLists; i++){
            map.put("L"+i, new ArrayList<String>());
        }
        return map;
    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};

        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}