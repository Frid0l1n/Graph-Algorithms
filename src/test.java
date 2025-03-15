public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        
        String[] papers = new String[n];
        for (int i = 0; i < n; i++) {
            String a = In.readWord();
            papers[i] = a;
        }
        
        // Create graph
        Map<String, List<String>> E = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, Integer> outDegree = new HashMap<>();
        
        for (String paper: papers) {
          String u = paper.substring(0, 2);
          String v = paper.substring(1, 3);
          
          E.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
          outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
          inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }
        
        System.out.println(E.toString());
        
        // Check Euler path conditions 
        String start = "";
        String end = "";
        int startCount = 0;
        int endCount = 0;
        
        for (String node: E.keySet()) {
          int out = outDegree.getOrDefault(node, 0);
          int in = inDegree.getOrDefault(node, 0);
          
          if (out - in == 1) {
            start = node;
            startCount++;
          } else if (in - out == 1) {
            end = node;
            endCount++;
          } else if (in != out) {
            Out.println("no");
            return;
          }
        } 
        
        if (startCount > 1 || endCount > 1) {
          Out.println("no");
          return;
        }
        
        
        // Pick arbitrary start if the graph is a cycle
        if (start.equals("")) {
          start = E.keySet().iterator().next();
        }
        
        // DFS for recreating the graph
        List<String> path = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);
        
        while(!stack.isEmpty()) {
          String node = stack.peek();
          
          if (E.containsKey(node) && !E.get(node).isEmpty()) {
            stack.push(E.get(node).remove(E.get(node).size() - 1));
          } else {
            path.add(stack.pop());
          }
        }
        
        if (path.size() == n + 1) {
          Out.println("yes");
        } else {
          Out.println("no");
        }
        
    }