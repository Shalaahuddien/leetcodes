class Solution {
    List<List<String>> res = new LinkedList<>();
    String str;
    public List<List<String>> partition(String s) {
        str = s;
        dfs(new LinkedList<>(), 0);
        return res;
    }
    private void dfs(List<String> list, int start)
    {
        if(start == str.length())
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start + 1; i <= str.length(); i++)
        {
            String sub = str.substring(start, i);
             if(isPalindrome(sub))
            {
                list.add(sub);
                dfs(list, i);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        int n = s.length();
        for(int i = 0; i < (n/2); ++i)
        {
            if(s.charAt(i) != s.charAt(n - i - 1))
            {
                return false;
            }
        }
        return true;
    }
}