/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipebox;

import java.util.Scanner;

/**
 *
 * @author shawn
 */

public class RecipeBoxDriver {

    /**
     *
     * @param args main method, driver class
     */
    public static void main(String[] args) {

        RecipeBox newRecipeBox = new RecipeBox();
        Scanner menuScnr = new Scanner(System.in);

        //breaks menu loop
        boolean breakMenu = true;
        //breaks submenu loops
        boolean breakEditMenu = true;

        //menu
        do {
            //print menu
            System.out.println("Recipe Box Main Menu.");
            System.out.println(" ");
            System.out.println("1. Add Recipe.");
            System.out.println("2. Print details of a Recipe.");
            System.out.println("3. Edit Name or Servings of a Recipe.");
            System.out.println("4. List all Recipe Names.");
            System.out.println("5. Delete a Recipe.");
            System.out.println("6. End Program.");
            System.out.println(" ");
            System.out.println("Please make a selection.");
            
            //clear menu selection
            int menuNumber = -1;

            //user input corresponds with case and printed menu numbers
            if (menuScnr.hasNextInt()) {
                menuNumber = menuScnr.nextInt();

                //menu switch start
                switch (menuNumber) {
                    
                    //calls method to add a new recipe
                    case 1:
                        newRecipeBox.addNewRecipe();
                        break;
                    
                    //prints details of a recipe
                    case 2:
                            
                        //if there are recipes in array continue
                        if (newRecipeBox.listOfRecipes.size() >= 1) {

                            System.out.println("Which recipe would you like to see?");
                                
                            //prints list of recipe names another numbered menu
                            newRecipeBox.printAllRecipeNames();
                            
                            //clear menu selection
                            int subMenuNumber = -1;

                            if (menuScnr.hasNextInt()) {
                                subMenuNumber = menuScnr.nextInt();
                                
                                //check if input is with in the range of arraylist index length
                                if (subMenuNumber <= newRecipeBox.listOfRecipes.size() && subMenuNumber > 0) {
                                    /*
                                    * selected recipe displayed 
                                    * MUST subtract 1 from the menu number 
                                    * to get the correct index position of item
                                    * in the array
                                    */
                                    newRecipeBox.printAllRecipeDetails(
                                            newRecipeBox.listOfRecipes.get(subMenuNumber - 1));
                                } 
                                else {
                                    //incorrect input
                                    System.out.println("Invalid input!");
                                }
                            } 
                            else {
                                //incorrect input
                                System.out.println("Invalid input!");
                                menuScnr.next();
                            }
                        } 
                        else {
                            //arraylist is empty, back to main menu
                            System.out.println("There are no recipes.");
                            break;
                        }
                        break;
                        
                    //edit name or servings of a recipe
                    case 3:
                            
                        //if there are recipes in array continue
                        if (newRecipeBox.listOfRecipes.size() >= 1) {
                            
                            //prints the name of recipes in array list, numbered
                            System.out.println("Which Recipe would you like to edit?");
                            newRecipeBox.printAllRecipeNames();
                            
                            //clear menu selection
                            int subMenuNumber = -1;

                            if (menuScnr.hasNextInt()) {
                                subMenuNumber = menuScnr.nextInt();
                                
                                //check if input is with in the range of arraylist index length
                                if (subMenuNumber <= newRecipeBox.listOfRecipes.size() && subMenuNumber > 0) {
                                    breakEditMenu = true;
                                    
                                    //edit menu loop
                                    do {
                                        //print edit menu
                                        System.out.println("Select an option.");
                                        System.out.println("1. Name ");
                                        System.out.println("2. Servings ");
                                        System.out.println("3. Return to Main Menu ");

                                        //check for integer input
                                        if (menuScnr.hasNextInt()) {

                                            int editMenuNumber = menuScnr.nextInt();

                                            //Switch for edit menu
                                            switch (editMenuNumber) {
                                                
                                                //Edit name
                                                case 1:
                                                    System.out.println("Enter new name: ");
                                                    
                                                    //user enters new recipe name
                                                    menuScnr.nextLine();
                                                    String newName = menuScnr.nextLine();
                                                    /*
                                                    * mutator sets new recipe name 
                                                    * MUST subtract 1 from the menu number 
                                                    * to get the correct index position of item
                                                    * in the array
                                                    */
                                                    newRecipeBox.listOfRecipes.get(subMenuNumber - 1)
                                                                .setRecipeName(newName);
                                                    break;
                                                
                                                //Edit servings
                                                case 2:
                                                    System.out.println("Enter new serving amount: ");
                                                    
                                                    if (menuScnr.hasNextInt()) {

                                                        //mutator sets new servings
                                                        newRecipeBox.listOfRecipes.get(subMenuNumber - 1)
                                                                .setServings(menuScnr.nextInt());
                                                    }
                                                    //invalid input
                                                    else {
                                                        System.out.println("Enter a whole number.");
                                                    }
                                                    break;

                                                //returns to main menu
                                                case 3:
                                                    breakEditMenu = false;
                                                    break;

                                                //invalid input
                                                default:
                                                    System.out.println("Invalid input!");  // For all those non-numbers out there.
                                                    break;
                                            }
                                        }
                                    } while (breakEditMenu);
                                }
                            }
                        }
                    //list the names of all recipes in array list
                    case 4:
                        
                        //if there are recipes in array continue
                        if (newRecipeBox.listOfRecipes.size() >= 1) {
                            newRecipeBox.printAllRecipeNames();
                        } 
                        else {
                            //arraylist is empty, back to main menu
                            System.out.println("There are no recipes.");
                            break;
                        }
                        break;
                        
                    //delete recipe menu
                    case 5:
                        
                        //if there are recipes in array continue
                        if (newRecipeBox.listOfRecipes.size() >= 1) {
                            System.out.println("Which recipe would you like to delete?");
                            //prints the name of recipes in array list, numbered
                            newRecipeBox.printAllRecipeNames();
                            
                            int deleteMenuNumber;
                            
                            //checks for integer
                            if (menuScnr.hasNextInt()) {
                                deleteMenuNumber = menuScnr.nextInt();
                                
                                //check if input is with in the range of arraylist index length
                                if (deleteMenuNumber<= newRecipeBox.listOfRecipes.size() && deleteMenuNumber > 0) {
                                    /*
                                    * mutator called to delete recipe
                                    * MUST subtract 1 from the menu number 
                                    * to get the correct index position of item
                                    * in the array
                                    */
                                    newRecipeBox.removeRecipe(
                                            newRecipeBox.listOfRecipes.get(deleteMenuNumber - 1));
                                    break;
                                } 
                                else {
                                    //invalid input
                                    System.out.println("Invalid input!");
                                    break;
                                }
                            } 
                            else {
                                //invalid input
                                System.out.println("Invalid input!");
                                menuScnr.next();
                            }
                        } 
                        else {
                            //no recipies in array
                            System.out.println("There are no recipes.");
                            break;
                        }
                    //terminates program
                    case 6:
                        System.exit(0);
                        break;
                    //user input is invalid
                    default:
                        System.out.println("Invalid input!");  
                        break;
                }
            } 
            else {
                System.out.println("That is not a number.");
                menuScnr.next();
            }  // end of switch(menuNumber)
        } while (breakMenu);
    }
}