class Solution {
    public String findOrder(String[] words) {
        Map<Character, Integer> inDeg = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                inDeg.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        int n = words.length;
        for(int i = 0; i < n - 1; ++i){
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return "";
            }
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0 ; j < len; ++j){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2){
                    if(!graph.get(c1).contains(c2)){
                        inDeg.put(c2, inDeg.get(c2) + 1);
                        graph.get(c1).add(c2);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        
        for(Map.Entry<Character, Integer> entry : inDeg.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }
        StringBuilder order = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            order.append(curr);
            for(char nbr : graph.get(curr)){
                inDeg.put(nbr, inDeg.get(nbr) - 1);
                if(inDeg.get(nbr) == 0){
                    q.add(nbr);
                }
            }
        }
        if(order.length() != inDeg.size()){
            return "";
        }
        return order.toString();
        
    }
}