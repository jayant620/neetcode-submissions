class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            // Edge goes FROM prerequisite TO course
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        // 2. Find the Starter Courses
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.offer(i);
        }
        int[] order = new int[numCourses];
        int index=0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            order[index++] = course;

            for(int dependent: graph.get(course)){
                inDegree[dependent]--;
                if(inDegree[dependent]==0){
                    queue.offer(dependent);
                }
            }
        }

        return index==numCourses ? order : new int[0];
    }
}
