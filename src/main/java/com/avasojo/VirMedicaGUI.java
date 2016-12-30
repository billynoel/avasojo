import java.awt.*;
import javax.swing.*;

// Main class for picking java engineering problems
//
// 1) Write a java program that calculates all prime numbers between 1 and N, with N specified on the command line. Output both the primes as they are produced and the number of primes at completion. You must implement the algorithm that produces primes and it cannot call external libraries or BigInteger.isProbablePrime().
// 2) Make the program from #1 multithreaded, with max number of threads specified on the command line.  Output both the primes as they are produced and the number of primes at completion.
// 3) Add a GUI to display the results as they are produced in #1 or #2. This GUI may be a Java Application or it may be a Web Application. Instructions for execution must be included.
// Optional:
// 4) Use java 8 lambda expressions to solve #1 or #2 above.
//
public class VirMedicaGUI {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    private static int optionIndex = 0;
    private static int endNum = 0;
    private static int numThreads = 0;
    private static JTextField stopField = new JTextField(25);
    private static JTextField numThreadsField = new JTextField(25);
    private static JTextArea outputArea = new JTextArea("Prime Numbers location");

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("VirMedicaGUI");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblPrimeCeiling = new JLabel("Prime Ceiling:");
        panel.add(lblPrimeCeiling);

        stopField = new JTextField();
        panel.add(stopField);
        stopField.setColumns(10);

        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"SingleThreaded", "MultiThreaded"});
        comboBox.setToolTipText("Please select Single or Multithreaded");
        panel.add(comboBox);

        JLabel lblThreadCount = new JLabel("Thread Count:");
        panel.add(lblThreadCount);

        numThreadsField = new JTextField();
        panel.add(numThreadsField);
        numThreadsField.setColumns(10);
        numThreadsField.setText("1");

        frame.getContentPane().add(outputArea, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        frame.getContentPane().add(submitButton, BorderLayout.SOUTH);
        // Use lambda expression to implement ActionListener
        submitButton.addActionListener(e -> {
            optionIndex = comboBox.getSelectedIndex();
            try {
                if (stopField != null && numThreadsField != null) {
                    endNum = Integer.parseInt(stopField.getText());
                    numThreads = Integer.parseInt(numThreadsField.getText());
                    validateAndExecuteOptions(optionIndex, endNum, numThreads);

                } else {
                    outputArea.setText("Please enter a valid number for boundary!");
                }
            } catch (Exception ex) {
                outputArea.setText("Please enter a valid number for boundary!");
            }
        });

        // Add output area
        outputArea.setLineWrap(true);

        //Size the frame.
        frame.pack();

        //Show it.
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void printMultiThreadedPrimeNumbers(Integer endNum, Integer numThreads) {
        // Let's make sure we really need multiple threads
        if (numThreads <= 1) {
            printSingleThreadedPrimeNumbers(endNum);
            return;
        }

        outputArea.setText("");
        //cleanUp();

        final PrimeWorkerThread[] pthreads = new PrimeWorkerThread[numThreads];

        if (endNum > 1) {
            outputArea.append("**2**");
        }
        for (int i = 0; i < numThreads; i++) {
            pthreads[i] = new PrimeWorkerThread(endNum, outputArea);
            pthreads[i].start();
        }
        try {
            for (int i = 0; i < numThreads; i++)
                pthreads[i].join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred " + e);
        }

        int total = PrimeWorkerThread.totalCount.get() + 1;
        outputArea.append("\n");
        outputArea.append("Total prime count: " + total); // output total count
        outputArea.append("\n");
        outputArea.append("[");
        for (int i = 0; i < total; i++) {
            outputArea.append("" + i + ": " + PrimeWorkerThread.primes[i] + ", ");
        }
        outputArea.append("]");
        System.out.println("Finished all threads");
        for (int i = 0; i < numThreads; i++) {
            pthreads[i].interrupt();
        }
    }

    private static void printSingleThreadedPrimeNumbers(int endNum) {

        outputArea.setText("");
        int totalCount = 1;
        outputArea.append("[");
        if (endNum > 1) {
            outputArea.append("2");
            // for each number up to max,
            //    if that number is prime,
            //        print that number
            for (int i = 3; i <= endNum; i++) {
                if (numDivisibleBy(i) == 2) {
                    // i is prime
                    outputArea.append(", " + i);
                    totalCount++;
                }
            }
        }
        outputArea.append("]");
        outputArea.append("\n");
        outputArea.append("The total number of primes are: " + totalCount);
        outputArea.append("\n");
    }

    private static int validateAndExecuteOptions(int option, int stopNum, int numThreads) {

        switch(option) {
            case 0: {
                printSingleThreadedPrimeNumbers(stopNum);
                break;
            }
            case 1: {
                printMultiThreadedPrimeNumbers(stopNum, numThreads);
                break;
            }
            default: {
                outputArea.setText("Something is up with the JComboBox with the 3 options");
            }
        }
        return 0;
    }

    public static int numDivisibleBy(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // i is a factor of the number
                count++;
            }
        }
        return count;
    }

    public static void cleanUp() {
        //PrimeWorkerThread.count = 0;
        PrimeWorkerThread.totalCount.set(0);
        PrimeWorkerThread.nextNumber.set(0L);

        int len = PrimeWorkerThread.primes.length;

        for (int i = 0; i < len; i++) {
            PrimeWorkerThread.primes[i] = 0;
        }
    }
}

