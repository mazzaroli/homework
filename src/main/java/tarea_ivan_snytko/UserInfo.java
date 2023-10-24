package tarea_ivan_snytko;
/*
Create a simple system.out app.
Print info about the user that should be passed to the main function as a parameter.
Compile and run the program from the command line using javac and java from JDK.
 */
public class UserInfo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No user information provided.");
            return;
        }

        // Prints each argument that was passed to the program.
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
