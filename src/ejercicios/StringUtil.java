package ejercicios;

import java.util.Arrays;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String replicatedString = "";
        for(int i = 0; i < n ; i++) {
            replicatedString += c;
        }
        return replicatedString;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        String finalString = "";
        for(int i = 0; i<n - s.length(); i++) {
            finalString += c;
        }
        finalString += s;
        return finalString;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String strArr[] = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        return strArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int intArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.valueOf(arr[i]);
        }

        return intArr;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxLength=0;

        for (String n:arr) {
            if(n.length() > maxLength) maxLength = n.length();
        };

        return maxLength;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        for(int i = 0; i< arr.length; i++) {
            arr[i] = lpad(arr[i],maxLength(arr),c);
        }
    }
}
