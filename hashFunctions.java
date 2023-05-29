import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

// Name: Zachary Mitchell
// Class: Section 3
// Term: Spring
// Instructor: Waqas Majeed
// Assignment: 7 Hash Table



public class hashFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

        int[][] Table = new int[50][2];
        int loop = 0;
        do {
            System.out.println("-----MAIN MENU--------------------------------------\n" +
                    "1. Run HF1 (Division method with Linear Probing)\n" +
                    "2. Run HF2 (Division method with Quadratic Probing)\n" +
                    "3. Run HF3 (Division method with Double Hashing)\n" +
                    "4. Run HF4 (Student Designed HF)\n" +
                    "5. Exit program\n" +
                    "Enter option number");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    HF1(Table, keys);
                    printHashTable(Table);
                    System.out.println(" ");
                    sumProbes(Table);
                    System.out.println(" ");
                    break;
                case 2:
                    HF2(Table, keys);
                    printHashTable(Table);
                    System.out.println(" ");
                    sumProbes(Table);
                    System.out.println(" ");
                    break;
                case 3:
                    HF3(Table, keys);
                    printHashTable(Table);
                    System.out.println(" ");
                    sumProbes(Table);
                    System.out.println(" ");
                    break;
                case 4:
                    HF4(Table, keys);
                    break;

                case 5:
                    loop = 1;
                    break;
            }

        } while (loop == 0);


    }


    public static void HF3(int[][] table, int[] keys) {
        int element = 0;
        int count = 0;
        boolean isFound = false;

        // SET ALL ELEMENTS OF TABLE TO NEGATIVE ONE
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 2; j++) {
                table[i][j] = -1;
            }
        }


        // CHECKS IF TABLE ELEMENT IS EMPTY OR NOT
        for (int i = 0; i < 50; i++) {
            element = keys[i] % 50;
//            element = H3Hash(keys[i]);
            isFound = false;
            int calcIndex = element;
            int key = keys[i];
            // IF EMPTY ADD KEY AND NUMBER OF PROBES TO TABLE
            if (table[element][0] == -1) {
                table[element][0] = keys[i];
                table[element][1] = count;
            } else {
                // STARTS PROBING

                while (!isFound) {
                    // IF EMPTY SPACE FOUND BREAK OUT OF LOOP TO NEXT KEY
                    if (table[calcIndex][0] == -1) {
                        table[calcIndex][0] = keys[i];
                        table[calcIndex][1] = count;
                        count = 0;// reset count
                        isFound = true;
                    }
                    // GOES TO THE NEXT ELEMENT
                    else {
                        count++;
                       // calcIndex = (element + (count * calcIndex)) % 50;
                        calcIndex = (key + (count * H3Hash(key))) % 50;
                        if (count > 50) {
                            count = 0;
                            System.out.println("Unable to hash key " + keys[i] + " to the table");
                            break;
                        }

//                        H2 (key) = 30 – key % 25;
                        // element = keys[i] + (count * (30 - keys[i] % 25));
//                        Increment is { key + j * H2 (key) } % 50 for j=1, 2, 3, 4,
                    }
                }

//                else {
//                    count++;
//                }
            }
        }

    }

    public static void HF2(int[][] table, int[] keys) {
        int element = 0;
        int count = 0;
        int k = 0;
        // SET ALL ELEMENTS OF TABLE TO NEGATIVE ONE
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 2; j++) {
                table[i][j] = -1;
            }
        }


        // CHECKS IF TABLE ELEMENT IS EMPTY OR NOT
        for (int i = 0; i < 50; i++) {
            element = keys[i] % 50;
            int calcIndex = element;
            // IF EMPTY ADD KEY AND NUMBER OF PROBES TO TABLE
            if (table[element][0] == -1) {
                table[element][0] = keys[i];
                table[element][1] = count;
                count = 0; //reset count
            } else {
                // STARTS PROBING

                for (int j = 0; j < 50; j++) {
                    // IF EMPTY SPACE FOUND BREAK OUT OF LOOP TO NEXT KEY
                    if (table[calcIndex][0] == -1) {
                        table[calcIndex][0] = keys[i];
                        table[calcIndex][1] = count;
                        count = 0;// reset count
                        break;
                    }
                    // GOES TO THE NEXT ELEMENT
                    else {
                        count++;
                        calcIndex = (int) ((element + Math.pow(count, 2)) % 50);
                    }
                }

//                else {
//                    count++;
//                }
            }
        }

    }


    public static void HF1(int[][] table, int[] keys) {
        int element = 0;
        int count = 0;
        int k = 0;
        // SET ALL ELEMENTS OF TABLE TO NEGATIVE ONE
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 2; j++) {
                table[i][j] = -1;
            }
        }
        // CHECKS IF TABLE ELEMENT IS EMPTY OR NOT
        for (int i = 0; i < 50; i++) {
            element = keys[i] % 50;
            // IF EMPTY ADD KEY AND NUMBER OF PROBES TO TABLE
            if (table[element][0] == -1) {
                table[element][0] = keys[i];
                table[element][1] = count;
                count = 0;
            } else {
                // STARTS PROBING
                for (int j = 0; j < 50; j++) {
                    // IF EMPTY SPACE FOUND BREAK OUT OF LOOP TO NEXT KEY
                    if (table[element][0] == -1) {
                        table[element][0] = keys[i];
                        table[element][1] = count;
                        count = 0;
                        break;
                    }
                    // GOES TO THE NEXT ELEMENT
                    else {
                        count++;
                        element = (element + 1) % 50;
                    }
                }

//                else {
//                    count++;
//                }
            }
        }

    }



    // SEPARATE CHAINING
    public static void HF4(int[][] table, int[] keys) {
        ArrayList<LinkedList<Integer>> cpTable = new ArrayList<>(keys.length);
        int element = 0;
        int key = 0;

        // ADDS 50 LINKED LIST TO ARRAYLIST
        for (int i = 0; i < keys.length; i++) {
            cpTable.add(new LinkedList<>());
        }
        // ADDS KEYS TO THEIR POSITION
        for (int i = 0; i < keys.length; i++) {
            element = customHash(keys[i]);
            key = keys[i];
            cpTable.get(element).add(key);

        }

        //PRINT TABLE
        System.out.println("Index   Key    probes");
        System.out.println("-----------------------");
        int sum = 0;
        int totalSum = 0;
        for (int m = 0; m < 50; m ++) {
            sum =  cpTable.get(m).size();
            if (sum >= 1) {
                sum -= 1; // size - 1 because first element does not count as probe
                totalSum += sum;
                //  System.out.println("(" + totalSum + ")");
            }
            if (cpTable.get(m).size() != 0) {
                if (m < 10){

                    System.out.println("  " +m + "    " +  cpTable.get(m).get(0)+ "      " +sum);
                }
                else {
                    System.out.println("  " +m + "   " +  cpTable.get(m).get(0)+ "      " +  sum );
                }
            }

        }
        // PRINT SUM OF PROBES
        System.out.println("The total number of probes is : " + totalSum);

    }
    // HASH METHOD FOR METHOD 4
    public static int customHash(int key) {
        return ((key * 2)+3) % 50;
    }
    // UNIQUE HASH METHOD FOR H4
    public static int H3Hash(int key) {
       //return  30 - (key % 25);
       return (int) Math.floor(50*(key * 0.348751) % 1);
       // h(k) = floor( n( kA mod 1 ) )
    }


// ADD ALL PROBES TOGETHER
    public static void sumProbes(int[][] table) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            if ( table[i][1] == -1) {
                continue;
            }
           count+= table[i][1];
        }
        System.out.println("Sum of Probe values = " + count + " probes");
    }

    // PRINTS THE HASH TABLE FOR H1, H2, H3
    public static void printHashTable(int[][] Table){
        System.out.println("Index   Key    probes");
        System.out.println("-----------------------");

        for (int i = 0; i < 50; i++) {
            if (Table[i][0] != -1) {
                if (i >= 10) {
                    System.out.println("  " +i + "   " + Table[i][0] + "     " + Table[i][1]);
                }
                else {
                    System.out.println("  " + i + "    " + Table[i][0] + "     " + Table[i][1]);
                }
            }

        }
    }



}

