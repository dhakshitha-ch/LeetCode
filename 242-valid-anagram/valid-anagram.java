class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
          HashMap<Character, Integer> map2 = new HashMap<>();
          
        if (s.length() != t.length()) {
            return false;
        }

    for (int i = 0; i < s.length(); i++) {

    char c = s.charAt(i);
    map1.put(c, map1.getOrDefault(c, 0) + 1);
   }
   for (int i = 0; i < t.length(); i++) {
    char c = t.charAt(i);
    map2.put(c, map2.getOrDefault(c, 0) + 1);
   }
if (map1.equals(map2)) {
    return true;
}
else
{
    return false;
}
    }
}