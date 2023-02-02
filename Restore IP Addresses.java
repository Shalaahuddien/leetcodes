class Solution {
    List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if(n == 0) return res;
        dfs(new StringBuilder(), s, 4);
        return res;
    }
    private void dfs(StringBuilder str, String s, int sections)
    {
        int n = s.length();
        if(n == 0 && sections == 0)
        {
            res.add(str.substring(0, str.length() - 1).toString());
            return;
        }
        if(n > 0 && sections == 0) return;
        if(n == 0 && sections > 0) return;

        StringBuilder sb = new StringBuilder();
        int min = Math.min(s.length(), 3);
        for(int i = 0; i < min; i++)
        {
            sb.append(s.charAt(i));
            int val = Integer.parseInt(sb.toString());
            //validate the value
            if(sb.length() == 2 && val < 10) continue;
            if(sb.length() == 3 && val < 100) continue;
            if(sb.length() == 3 && val > 255) continue;

            //try all combination for the string
            StringBuilder temp = new StringBuilder(str);
            str.append(sb.toString());
            str.append(".");
            dfs(str, s.substring(i + 1, s.length()), sections - 1);
            //reset our current string for the next dfs
            str = temp;
        }
    }
}
