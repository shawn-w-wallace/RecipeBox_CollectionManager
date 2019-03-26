/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipebox;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author shawn
 */

public class Recipe {

//variables
    
    //arraylist for recipe ingredients
    private ArrayList<Ingredient> recipeIngredients = new ArrayList();
    //initialized empty string for recipe name
    private String recipeName;
    //whole number for servings of recipe
    private int servings;
    //whole number of totalRecipeCalories
    private int totalRecipeCalories;
    //upper limit of servings, whole number
    public final int MAX_SERVINGS = 50;

    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the totalRecipeCalories
     */
    public int getTotalRecipeCalories() {

        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(int totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     * default constructor
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
    }

    /**
     * constructor taking parameters
     * @param recipeName the name of the recipe
     * @param servings the number of servings
     * @param recipeIngredients array list of ingredients
     * @param totalRecipeCalories total number of calories in this recipe
     */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> 
            recipeIngredients, int totalRecipeCalories){
        
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     * prints the recipe to console
     */
    public void printRecipe() {

        /*
        * accessors totalRecipleCalories and servings are divided to 
        * assigned to singleServing Calories
        */
        int singleServingCalories = ((int)(getTotalRecipeCalories()) / getServings());

        //print recipe information
        System.out.println("Recipe: " + getRecipeName());
        System.out.println("Serves: " + getServings());
        System.out.println("Ingredients: ");

        //print each ingredient in the arrayList
        for (int i = 0; i < getRecipeIngredients().size(); i++) {

            //accessor of ingredient list at i
            Ingredient ingredientList = getRecipeIngredients().get(i);
            /*
            * printable list of the ingredients for formated printing, heavily
            * inspired by string formatting tips and examples on dzone.com 
            */
            String list = ingredientList.nameOfIngredient + "\t" + ingredientList.ingredientAmount +
                   "\t" + ingredientList.unitMeasurement + "\t" + ingredientList.numberCaloriesPerMeasurement +
                   " Cals \t" + ingredientList.totalCalories + " Total Calories";

            //prints the formatted list of ingredients
            System.out.println(list);
        }
        //accessors grab values for printing
        System.out.println("Each serving has " + singleServingCalories + 
        " Calories for a total of " + (int)getTotalRecipeCalories() + " Calories.");
    }

    /**
     *
     * @return returns instance of new recipe objects
     */
    public Recipe createNewRecipe() {

        //new instantiated ArrayList
        ArrayList <Ingredient> recipeIngredients = new ArrayList();
        //local servings
        int servings = 0;
        //bool ingreadient adding flow
        boolean addMoreIngredients = true;
        //used to validate servings entered
        boolean correct = false;

        Scanner scnr = new Scanner(System.in);

        //new object from the constructor
        Ingredient newIngredient = new Ingredient();

        //get user recipe name
        System.out.println("Please enter the recipe name: ");
        setRecipeName(scnr.nextLine());

        //get user servings
        System.out.println("Please enter the number of servings as a positive whole number: ");

        //check for int value
        if (scnr.hasNextInt()) {
            servings = scnr.nextInt();
            
            while (servings <= 0 || servings > MAX_SERVINGS){
                //get user servings
                System.out.println("Please enter the number of servings as a "
                + "positive whole number: ");
                servings = scnr.nextInt();
            }
            do {
                //confirm input
                System.out.println ("you entered " + servings + " servings."
                + " Is this correct? (y or n)");
                String reply = scnr.next().toLowerCase();
                
                if (null == reply) {
                    //program terminates
                    System.out.println ("Invalid input");
                    System.exit(0); //ends program due to invalid input
                }
                else
                    switch (reply) {
                        //input incorrect, get correct input
                        case "n":
                            System.out.println ("Enter the correct number of servings");
                            servings = scnr.nextInt();
                            break;
                        //input correct
                        case "y":
                            //mutator sets servings
                            setServings(servings);
                            correct = true;
                            break;
                        default:
                            //get y/n again
                            System.out.println ("Invalid input");
                            break;
                    }
            } while (correct == false);
        }
            //reset bool
            correct = false;
        
        //loop allows users to add ingredients by calling ingredient class
        do {
            System.out.println("Would you like to enter an ingredient? (y or n)");

            String reply = scnr.next().toLowerCase();

            switch (reply) {
                //user wants to add new ingredients from createIngredient method
                case "y":
                    recipeIngredients.add(newIngredient.createIngredient());
                    //mutator sets totalRecipeCalores by calling accesor to be multiplied by totalCalories
                    setTotalRecipeCalories(getTotalRecipeCalories() + newIngredient.totalCalories); // keep adding up the calories
                    //mutator sets recipeIngredients
                    setRecipeIngredients(recipeIngredients);
                    break;
                //user does not want to add more ingredients
                case "n":
                    addMoreIngredients = false;
                    break;
                //invalid input
                default:
                    System.out.println("Enter 'y' or 'n'");
                    break;
            }
        } while (addMoreIngredients);

        //create this instance of object
        Recipe newRecipe = new Recipe(getRecipeName(), getServings(), 
                recipeIngredients, getTotalRecipeCalories());

        //return newly created object
        return newRecipe;
    }
}