import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExamSystem system = new ExamSystem();

        // Java Questions
        Subject java = new Subject("Java");

        // EASY
        java.addQuestion(new Question<>("What is JVM?", "EASY", new String[]{"Java Virtual Machine", "Java Variable Method", "Joint Virtual Mode", "None"}, "A"));
        java.addQuestion(new Question<>("Which keyword is used to inherit a class?", "EASY", new String[]{"this", "super", "extends", "implements"}, "C"));
        java.addQuestion(new Question<>("Which method is entry point of Java program?", "EASY", new String[]{"start()", "main()", "run()", "init()"}, "B"));
        java.addQuestion(new Question<>("Which data type is used for decimals?", "EASY", new String[]{"int", "float", "char", "boolean"}, "B"));
        java.addQuestion(new Question<>("What is bytecode?", "EASY", new String[]{"Machine code", "Intermediate code", "Binary code", "None"}, "B"));

        // MEDIUM
        java.addQuestion(new Question<>("int + float = ?", "MEDIUM", new String[]{"int", "float", "double", "error"}, "B"));
        java.addQuestion(new Question<>("Which of these is not OOP principle?", "MEDIUM", new String[]{"Encapsulation", "Polymorphism", "Abstraction", "Compilation"}, "D"));
        java.addQuestion(new Question<>("What does static mean in Java?", "MEDIUM", new String[]{"Instance method", "Shared by all objects", "New object", "None"}, "B"));
        java.addQuestion(new Question<>("Which class is used for reading input?", "MEDIUM", new String[]{"Scanner", "InputReader", "Reader", "InputStream"}, "A"));
        java.addQuestion(new Question<>("Which operator is used for object comparison?", "MEDIUM", new String[]{"==", "equals()", "compareTo", "!equals"}, "B"));

        // HARD
        java.addQuestion(new Question<>("What is the output of: System.out.println(10 + 20 + \"30\")?", "HARD", new String[]{"102030", "3030", "3030", "3030"}, "B"));
        java.addQuestion(new Question<>("Which exception is thrown when array is out of bounds?", "HARD", new String[]{"NullPointerException", "IOException", "ArrayIndexOutOfBoundsException", "IndexError"}, "C"));
        java.addQuestion(new Question<>("What is method overloading?", "HARD", new String[]{"Same name, diff params", "Diff return type", "Same name, same params", "None"}, "A"));
        java.addQuestion(new Question<>("Which is not part of Java Collection?", "HARD", new String[]{"ArrayList", "Vector", "HashMap", "FileReader"}, "D"));
        java.addQuestion(new Question<>("Which method is used to start a thread?", "HARD", new String[]{"start()", "run()", "init()", "begin()"}, "A"));
        system.addSubject(java);

        // DBMS Questions
        Subject dbms = new Subject("DBMS");

        // EASY
        dbms.addQuestion(new Question<>("Normalization removes?", "EASY", new String[]{"Redundancy", "Security", "Data", "None"}, "A"));
        dbms.addQuestion(new Question<>("SQL stands for?", "EASY", new String[]{"Structured Query Language", "Strong Query Language", "Simple Query Language", "None"}, "A"));
        dbms.addQuestion(new Question<>("Which command retrieves data?", "EASY", new String[]{"SELECT", "DELETE", "UPDATE", "INSERT"}, "A"));
        dbms.addQuestion(new Question<>("Primary key is?", "EASY", new String[]{"Unique identifier", "Foreign key", "Nullable", "None"}, "A"));
        dbms.addQuestion(new Question<>("Which is not a DBMS?", "EASY", new String[]{"Oracle", "MySQL", "Windows", "MongoDB"}, "C"));

        // MEDIUM
        dbms.addQuestion(new Question<>("Which normal form removes transitive dependency?", "MEDIUM", new String[]{"1NF", "2NF", "3NF", "BCNF"}, "C"));
        dbms.addQuestion(new Question<>("Which of the following is DDL?", "MEDIUM", new String[]{"INSERT", "DELETE", "CREATE", "UPDATE"}, "C"));
        dbms.addQuestion(new Question<>("What is a foreign key?", "MEDIUM", new String[]{"Unique key", "Duplicate key", "Key from another table", "None"}, "C"));
        dbms.addQuestion(new Question<>("Which is used to remove table?", "MEDIUM", new String[]{"DROP", "DELETE", "REMOVE", "CLEAR"}, "A"));
        dbms.addQuestion(new Question<>("Which clause filters rows?", "MEDIUM", new String[]{"WHERE", "HAVING", "ORDER", "GROUP"}, "A"));

        // HARD
        dbms.addQuestion(new Question<>("What is ACID in DBMS?", "HARD", new String[]{"Atomicity, Consistency, Isolation, Durability", "Access, Control, Integrity, Data", "All Clear In Data", "None"}, "A"));
        dbms.addQuestion(new Question<>("Which join returns all records when there is a match?", "HARD", new String[]{"INNER", "OUTER", "CROSS", "LEFT"}, "B"));
        dbms.addQuestion(new Question<>("What is the result of Cartesian product?", "HARD", new String[]{"Matched rows", "Combined rows", "All possible pairs", "Null"}, "C"));
        dbms.addQuestion(new Question<>("Which command grants access?", "HARD", new String[]{"GRANT", "REVOKE", "CREATE", "INSERT"}, "A"));
        dbms.addQuestion(new Question<>("Which key uniquely identifies each record?", "HARD", new String[]{"Primary Key", "Foreign Key", "Unique Key", "Candidate Key"}, "A"));
        system.addSubject(dbms);

        // OS Questions
        Subject os = new Subject("OS");

        // EASY
        os.addQuestion(new Question<>("What is an OS?", "EASY", new String[]{"Operating System", "Output System", "Online Server", "None"}, "A"));
        os.addQuestion(new Question<>("Which is not an OS?", "EASY", new String[]{"Linux", "Windows", "Oracle", "Mac"}, "C"));
        os.addQuestion(new Question<>("Multitasking means?", "EASY", new String[]{"Single task", "Multi programs", "No tasks", "None"}, "B"));
        os.addQuestion(new Question<>("Which manages memory?", "EASY", new String[]{"Compiler", "OS", "Editor", "None"}, "B"));
        os.addQuestion(new Question<>("Which is an open source OS?", "EASY", new String[]{"Windows", "Linux", "Mac", "DOS"}, "B"));

        // MEDIUM
        os.addQuestion(new Question<>("Which is not a scheduling algorithm?", "MEDIUM", new String[]{"FIFO", "Round Robin", "Shortest Job", "Load Balancing"}, "D"));
        os.addQuestion(new Question<>("Context switching is related to?", "MEDIUM", new String[]{"Memory", "CPU", "I/O", "Bus"}, "B"));
        os.addQuestion(new Question<>("Deadlock involves?", "MEDIUM", new String[]{"No memory", "Blocked processes", "Low CPU", "No I/O"}, "B"));
        os.addQuestion(new Question<>("Which handles file management?", "MEDIUM", new String[]{"Compiler", "OS", "Linker", "Assembler"}, "B"));
        os.addQuestion(new Question<>("Process and thread difference?", "MEDIUM", new String[]{"Independent vs lightweight", "Same", "Both heavy", "None"}, "A"));

        // HARD
        os.addQuestion(new Question<>("What is a semaphore?", "HARD", new String[]{"Signal mechanism", "Memory type", "Hardware", "None"}, "A"));
        os.addQuestion(new Question<>("Thrashing relates to?", "HARD", new String[]{"Memory swapping", "CPU scheduling", "File system", "I/O"}, "A"));
        os.addQuestion(new Question<>("Page fault occurs when?", "HARD", new String[]{"Page not in memory", "I/O busy", "CPU idle", "File not found"}, "A"));
        os.addQuestion(new Question<>("What is the role of scheduler?", "HARD", new String[]{"Allocate CPU", "Manage memory", "Start programs", "End programs"}, "A"));
        os.addQuestion(new Question<>("Which of these is virtual memory?", "HARD", new String[]{"Disk space as RAM", "External drive", "Cache", "None"}, "A"));
        system.addSubject(os);

        // User Inputs
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your roll number: ");
        String roll = sc.nextLine();
        Student student = new Student(name, roll);
        system.registerStudent(student);

        System.out.print("Select Subject (Java / DBMS / OS): ");
        String subjectName = sc.nextLine().trim();
        Subject subject = system.getSubjectByName(subjectName);

        System.out.print("Select Difficulty (EASY / MEDIUM / HARD): ");
        String difficulty = sc.nextLine().trim().toUpperCase();

        if (subject != null) {
            List<Question<String>> selectedQuestions = subject.getQuestionsByDifficulty(difficulty);

            System.out.println("\n--- Starting " + difficulty + " Exam for " + subject.getName() + " ---");

            for (Question<String> q : selectedQuestions) {
                System.out.println("\nQ: " + q.getQuestionText());
                String[] options = q.getOptions();
                for (int i = 0; i < options.length; i++) {
                    System.out.println((char) ('A' + i) + ") " + options[i]);
                }
                System.out.print("Enter your answer (A/B/C/D): ");
                String answer = sc.nextLine().toUpperCase();
                student.submitAnswer(subject.getName(), answer);
            }

            int score = system.calculateScore(student, subject, difficulty);
            System.out.println("\nExam Over! Your Score: " + score + "/" + selectedQuestions.size());
        } else {
            System.out.println("Invalid subject selected!");
        }

        sc.close();
    }
}
