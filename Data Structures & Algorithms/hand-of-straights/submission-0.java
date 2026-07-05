class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;

        TreeMap<Integer, Integer> card = new TreeMap<>();
        for(int x: hand){
            card.put(x, card.getOrDefault(x, 0) + 1);
        }

        while(!card.isEmpty()){
            int firstCard = card.firstKey();
            for(int i=0;i<groupSize;i++){
                int currentCard = firstCard + i;
                if(!card.containsKey(currentCard)){
                    return false;
                }
                card.put(currentCard, card.get(currentCard)-1);
                if(card.get(currentCard)==0){
                    card.remove(currentCard);
                }
            }
        }
        return true;
    }
}
