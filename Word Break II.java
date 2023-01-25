class Solution {
    Set<String> dict;
    char[] arr;
    Map <String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.dict = new HashSet<>(wordDict);
        this.arr = s.toCharArray();
        return dfs(0, arr.length);
    }
    private List<String> dfs(int start, int end)
    {
        if(start == end) return new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();

        String key = " " + start + "," + end;
        if(cache.containsKey(key)) return cache.get(key);
        //Iterate throught all the splits
        for(int i = start; i < end; i++)
        {
            sb.append(arr[i]);
            String curStr = sb.toString();
            if(dict.contains(curStr))
            {
                List<String> remainStrs = dfs(i + 1, end);
                if(end -(i+1) > 0 && remainStrs.size() == 0) continue;
                genCombinations(res, curStr, remainStrs);
            }
        }
        cache.put(key, res);
        return res;
    }
    private void genCombinations(List<String> res, String curStr, List<String> remainStrs)
    {
        if(remainStrs.size() == 0)
        {
            res.add(curStr);
        }
        else
        {
            for(String subStr : remainStrs)
            {
                StringBuilder sb = new StringBuilder();
                sb.append(curStr);
                sb.append(" ");
                sb.append(subStr);
                res.add(sb.toString());
            }
        }
    }
}