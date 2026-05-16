class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        //Build adjacency list
        for(int[] courses: prerequisites){
            int course = courses[0];
            int prereq = courses[1];

            adjList.get(prereq).add(course);
            inDegree[course]++;
        }
        // Find the Starter Courses (In-Degree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.offer(i);
        }

        int courseTaken=0;
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            courseTaken++;
            for(int dependent: adjList.get(currentCourse)){
                inDegree[dependent]--;
                if(inDegree[dependent]==0){
                    queue.offer(dependent);
                }
            }
        }
        return numCourses == courseTaken;
    }
}
