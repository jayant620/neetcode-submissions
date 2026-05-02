class TimeMap {

    class Pair{
        int timeStamp;
        String value;

        public Pair(int t, String v){
            this.timeStamp = t;
            this.value = v;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list==null) return "";
        String result = "";
        int l=0;
        int r=list.size()-1;
        while(l<=r){
            int m= l+(r-l)/2;
            if(list.get(m).timeStamp<=timestamp){
                result = list.get(m).value;
                l = m+1;
            } else{
                r = m-1;
            }
        }
        return result;
    }
}
