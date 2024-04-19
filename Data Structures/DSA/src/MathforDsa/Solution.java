package MathforDsa;

class Solution {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","bar"));
    }
    public static boolean isIsomorphic(String s, String t) {
        char[] arr = new char[256]; // Using 256 to handle extended ASCII characters

        for (int i = 0; i < s.length(); i++) {
            int indexVal = s.charAt(i);
            char numVal = t.charAt(i);

            if(arr[indexVal]!='\0' && arr[indexVal]!=numVal){
                return false;
            }else {
                arr[indexVal] = numVal;
            }
        }
        return true;
    }
}