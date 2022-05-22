public class Simplest_Form
{
    public static void main(){
        int[] numbers = {105, 87142, 95, 12987120, 7194, 9, 3 ,5, 124325, 1234, 212, 9238};       
        LinkedList list = new LinkedList(numbers); 
        Node buckets[] = new Node[10];
        for(int i = 0; i< buckets.length;i++){
            buckets[i] = new Node();
        }

        int places = 1;
        while(!(firstRowFull(buckets[0], 10))){ // stop when the first row is full, which is increasing order
            for(int i = 0; i<=9; i++){
                Node start = buckets[i];
                while(start != null && start.getMyValue() != null){
                    list.add( (int)start.getMyValue() ); // add to the list when it found one
                    start = start.getNext();
                }
                buckets[i].setMyValue(null); // empty the row of the bucket
                buckets[i].setNext(null);
            }

            Node curr = list.getFront();        
            while(curr != null){  // traverse the bucket Node
                int digit =  ((int) curr.getMyValue() / places) % 10; // get the digit 
                if(buckets[digit].getMyValue() == null){ // first insertion when it is empty
                    buckets[digit] = new Node(curr.getMyValue());
                }else{
                    Node base = buckets[digit];
                    while(base.getNext() != null){
                        base = base.getNext();
                    }
                    base.setNext(new Node(curr.getMyValue()));                
                }           
                curr = curr.getNext();
            }
            list.clear(); // empty the list after distributing     
            places*=10;  
        }
        list.setFront(buckets[0]);
        System.out.println(list);
    }

    public static boolean firstRowFull(Node firstRow, int ListSize){
        int NodeSize = 0;
        Node curr = firstRow;
        while(curr != null && curr.getMyValue() != null){
            NodeSize++;
            curr = curr.getNext();
        }
        return NodeSize == ListSize;
    }
}
