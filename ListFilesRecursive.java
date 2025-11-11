import java.io.File;

public class ListFilesRecursive {

    // Recursive method to list files and subdirectories
    public static void listFiles(File folder) {
        // Get all files and directories inside the folder
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                // Print file or directory name with its path
                System.out.println(file.getAbsolutePath());

                // If directory, call method recursively
                if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        // You can change the path as per your system
        File folder = new File("C:\\Users\\Public"); // Example path

        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Listing all files under: " + folder.getAbsolutePath());
            listFiles(folder);
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}