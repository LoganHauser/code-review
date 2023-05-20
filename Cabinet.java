import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Cabinet {

    public static void main(String args[]) throws IOException{


        //Directory Creation

        File Directory = new File(System.getProperty("user.home") + "/Desktop/Cabinet");  //Prepares a folder called Cabinet on the users desktop to store the information

        if(!Directory.exists()){  //Checks if the folder 'Cabinet' already exists
            Directory.mkdir();  //If the folder does not exist it creates it
            System.out.println("Directory succesfully created\n\n");
        }
        else{
            System.out.println("Failed to create directory. Folder 'Cabinet' already exists.\n\n");  //If the folder exists prints out a message
        }



        //Read or create file

        System.out.println("Would you like to create a new file or access an existing file?  (Enter '1' to create a new file, Enter '2' to access an existing file)");

        Scanner choice = new Scanner(System.in);
        String Choice = "";

        if(choice.hasNextLine() == true) Choice = choice.nextLine();  //Allows the user to choose between creating a new file or reading an existing file





        //File Creation

        if (Integer.valueOf(Choice) == 1){  //Runs this code if the user chooses to create a new file

            Scanner answer = new Scanner(System.in);
            String Name = "";
            String Age = "";
            String Gender = "";
            String HairColor = "";
            String EyeColor = "";
            String FavoriteMovie = "";

            System.out.println("\nAnswer these questions to add information to the file");


            System.out.println("\nWhat is the persons name? (First and last)");  //Asks for the name of the person who's information is being added
            if(answer.hasNextLine() == true) Name = answer.nextLine();
            Path txtFile = Path.of(System.getProperty("user.home") + "/Desktop/Cabinet/" + Name + ".txt");  //Creates a file titled the persons name in the directory
            Files.writeString(txtFile, "Name:  " + Name);  //Adds the persons name to the file


            System.out.println("\nHow old are they?");  //Asks for the age of the person who's information is being added
            if(answer.hasNextLine() == true) Age = answer.nextLine();
            Files.writeString(txtFile, "\nAge:  " + Age, StandardOpenOption.APPEND);  //Adds the person's age to the file

            System.out.println("\nAre they Male or Female?");  //Asks for the gender of the person who's information is being added
            if(answer.hasNextLine() == true) Gender = answer.nextLine();
            Files.writeString(txtFile, "\nGender:  " + Gender, StandardOpenOption.APPEND);  //Adds the person's gender to the file

            System.out.println("\nWhat color is their hair?");  //Asks for the hair color of the person who's information is being added
            if(answer.hasNextLine() == true) HairColor = answer.nextLine();
            Files.writeString(txtFile, "\nHair Color:  " + HairColor, StandardOpenOption.APPEND);  //Adds the person's hair color to the file

            System.out.println("\nWhat color are their eyes?");  //Asks for the eye color of the person who's information is being added
            if(answer.hasNextLine() == true) EyeColor = answer.nextLine();
            Files.writeString(txtFile, "\nEye Color:  " + EyeColor, StandardOpenOption.APPEND);  //Adds the person's eye color to the file

            System.out.println("\nWhat is their favorite movie?");  //Asks for the favorite movie of the person who's information is being added
            if(answer.hasNextLine() == true) FavoriteMovie = answer.nextLine();
            Files.writeString(txtFile, "\nFavorite Movie:  " + FavoriteMovie, StandardOpenOption.APPEND);  //Adds the person's favorite movie to the file

            System.out.println("\n\nFile has been succesfully created");

        }



        //File Reader

        else if(Integer.valueOf(Choice) == 2){  //Runs this code if the user chooses to access an existing file

            int fileChoice = 0;
            System.out.println("\nWhich file would you like to look at?");


        File[] folderContent = Directory.listFiles();  //Gets the names of all the existing files in the directory
        for(int i = 0; i < folderContent.length; i++){
            System.out.println("(" + i + ") " + folderContent[i].getName());  //Prints out the names of all the files in the directory and a numerical value for each
            
        }
        System.out.println("\n");  //Adds a gap in the output


        if(choice.hasNextLine() == true) fileChoice = Integer.valueOf(choice.nextLine());
        Path txtFile = Path.of(System.getProperty("user.home") + "/Desktop/Cabinet/" + folderContent[fileChoice].getName());  //Gets the path of the chosen file
        String fileContent = Files.readString(txtFile);  //Adds the content of the chosen file to a string
        System.out.println("\n\n" + fileContent + "\n");  //Prints out the information from the chosen file
        }


    }
    
}
