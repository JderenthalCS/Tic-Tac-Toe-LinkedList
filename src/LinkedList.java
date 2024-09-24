
public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;

        //Initializing w/ empty cells (nodes)
        for(int i = 0; i<9; i++){
            //Insert empty value
            insertAtEnd("");
        }
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        // To be implemented
        Node tempNode = new Node(data);

        //If list is empty, set head to new
        if(head == null){
            head = tempNode;
            return;
        }
        //Go2 last node
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        //add new tail
        current.next = tempNode;
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        // To be implemented
        Node current = head;
        int count = 1;

        //iterate through LL for position
        while(current != null && count < position){
            current = current.next;
            count++;
        }
        //if position is found, update
        if(current !=null){
            current.data = data;
        }
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        // To be implemented
        Node current = head;
        int count = 1;

        //iterate through LL for position
        while(current != null && count < position){
            current = current.next;
            count++;
        }
        //if position is found, return data
        if(current != null){
            return current.data;
            //else return empty
        }else{
            return "";
        }
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        // To be implemented
        Node current = head;
        int count =1;
        String showValue;

        //iterate thru LL, print board in 3x3
        while(current != null){
            if(current.data.isEmpty()){
             showValue = String.valueOf(count);
            } else {
                showValue = current.data;
            }
            System.out.print(current.data + " ");

            //creates /n every 3 cells
            if(count % 3 == 0){
                System.out.println();
            }
            current = current.next;
            count++;
        }

    }

    // Method to check for a win
    public boolean checkWinCondition() {
        // To be implemented
        //All possible 3x3 tic-tac-toe winning combos
        int[][] checkWinCombo = {
                {1, 2, 3},//1 across
                {4, 5, 6},//2 across
                {7, 8, 9},//3 accross
                {1, 4, 7},// 1 vert
                {2, 5, 8},// 2 vert
                {3, 6, 9},// 3 vert
                {1, 5, 9},//top L - bot R diagnol
                {3, 5, 7}//top R - bot L diagnol
        };
        //Iterating thru each possible win combo
        for(int i=0; i< checkWinCombo.length; i++){
            int[] combos = checkWinCombo[i];

            String v1 = getPositionValue(combos[0]);
            String v2 = getPositionValue(combos[1]);
            String v3 = getPositionValue(combos[2]);

            //If three combos are both not empty, and matching then true = win!
            if(!v1.isEmpty() && v1.equals(v2) && v2.equals(v3)){
                return true;
            }
        }
        //If not false
        return false;
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        // To be implemented
        Node current = head;

        //iterate LL, check if empty
        while (current != null) {
            if (current.data.isEmpty()) {
                //if cell empty, board =!full
                return false;
            }
            current = current.next;
        }
        //if no empty cells, board = full
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        // To be implemented
        Node current = head;

        //iterate LL, reset all cells empty
        while(current != null){
            current.data = "";
            current = current.next;
        }
    }
}
